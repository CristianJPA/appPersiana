package com.example.persianaautomatica;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.persianaautomatica.Modelo.Horario;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AutomFragment extends Fragment{
    Button btnAutom2;
    EditText etTHoraSubida,etTHoraBajada,etMostrarSubida,etMostrarBajada;
    TextView tvMostrarSubida,tvMostrarBajada;
    FirebaseDatabase database;
    ArrayList<Horario> listado;
    ArrayAdapter<Horario> adaptadorListado;
    ListView lvHorario;
    DatabaseReference horarioRef;

    public AutomFragment() {
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
        View v =  inflater.inflate(R.layout.fragment_autom, container, false);
        //lvHorario = (ListView) v.findViewById(R.id.lvHorario);
        cargarDatos();
        tvMostrarSubida = (TextView) v.findViewById(R.id.tvMostrarSubida);
        tvMostrarBajada = (TextView) v.findViewById(R.id.tvMostrarBajada);
        etTHoraBajada = (EditText) v.findViewById(R.id.etTHoraBajada);
        etTHoraSubida = (EditText) v.findViewById(R.id.etTHoraSubida);
        btnAutom2 = (Button) v.findViewById(R.id.btnAutom2);

        btnAutom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "otro", Toast.LENGTH_SHORT).show();
                insertar();
              //  etMostrarSubida.setText("");
               // etMostrarBajada.setText("");
            }
        });
        return v;
    }


    public ArrayList<Horario> cargarDatos() {
        System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAA");
        database = FirebaseDatabase.getInstance();
        horarioRef = database.getReference("Horario");
        ValueEventListener horarioListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listado = new ArrayList<>();
                try {
                System.out.println("HORARIO "+snapshot);
                String mostrarSubida = snapshot.child("horarioSubida").getValue().toString();
                String mostrarBajada = snapshot.child("horarioBajada").getValue().toString();
                tvMostrarSubida.setText(mostrarSubida);
                tvMostrarBajada.setText(mostrarBajada);

                }catch (Exception e){
                    System.out.println("no hay datos");
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Hubo un error");
            }
        };
        horarioRef.addValueEventListener(horarioListener);
        return listado;
    }

    private void insertar() {
        String horaSubida = etTHoraSubida.getText().toString();
        String horaBajada = etTHoraBajada.getText().toString();
        Horario h = new Horario(horaSubida,horaBajada);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Horario");
        myRef.setValue(h);
    }
}