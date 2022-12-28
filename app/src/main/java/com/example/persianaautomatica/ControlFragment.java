package com.example.persianaautomatica;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.persianaautomatica.Modelo.Horario;
import com.example.persianaautomatica.Modelo.Subida;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ControlFragment extends Fragment{
    FirebaseDatabase database;
    ImageButton btnUp, btnStop, btnDown;

    public ControlFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_control, container, false);

        btnUp = (ImageButton) v.findViewById(R.id.btnUp);
        btnStop = (ImageButton) v.findViewById(R.id.btnStop);
        btnDown = (ImageButton) v.findViewById(R.id.btnDown);
        btnUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Toast.makeText(getContext(),"Subir",Toast.LENGTH_SHORT).show();
                    insertarSubida();
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Detener",Toast.LENGTH_SHORT).show();
                insertarDetener();

            }
        });
        btnDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(),"Bajar",Toast.LENGTH_SHORT).show();
                insertarBajada();
            }
        });


        return v;
    }
    private void insertarSubida() {
        int Subir = 1;
        int Detener = 0;
        int Bajar = 0;
        Subida s = new Subida(Subir,Detener,Bajar);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Control");
        myRef.setValue(s);
    }
    private void insertarDetener() {
        int Subir = 0;
        int Detener = 1;
        int Bajar = 0;
        Subida s = new Subida(Subir,Detener,Bajar);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Control");
        myRef.setValue(s);
    }
    private void insertarBajada() {
        int Subir = 0;
        int Detener = 0;
        int Bajar = 1;
        Subida s = new Subida(Subir,Detener,Bajar);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Control");
        myRef.setValue(s);
    }
}