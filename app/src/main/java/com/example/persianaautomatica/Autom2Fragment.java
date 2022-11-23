package com.example.persianaautomatica;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.persianaautomatica.Modelo.Luminosidad;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Autom2Fragment extends Fragment {
    Button btnAutom1;
    EditText etLuminosidad1,etLuminosidad2;
    TextView tvMostrarLumSubida, tvMostrarLumBajada;
    FirebaseDatabase database;
    ArrayList<Luminosidad> listado;
    ArrayAdapter<Luminosidad> adaptadorListado;
    ListView lvLuminosidad;
    DatabaseReference luminosidadRef;

    public Autom2Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_autom2, container, false);
        //lvLuminosidad = (ListView) v.findViewById(R.id.lvLuminosidad);
        cargarDatos();
        tvMostrarLumSubida = (TextView) v.findViewById(R.id.tvMostrarLumSubida);
        tvMostrarLumBajada = (TextView) v.findViewById(R.id.tvMostrarLumBajada);
        //insertar valores
        etLuminosidad1 = (EditText) v.findViewById(R.id.etLuminosidad1);
        etLuminosidad2 = (EditText) v.findViewById(R.id.etLuminosidad2);
        btnAutom1 = (Button) v.findViewById(R.id.btnAutom1);
        btnAutom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "otro", Toast.LENGTH_SHORT).show();
                insertar();
            }
        });
        return v;
        //
    }

    public ArrayList<Luminosidad> cargarDatos() {
        database = FirebaseDatabase.getInstance();
        luminosidadRef = database.getReference("Luminosidad");
        ValueEventListener luminosidadListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listado = new ArrayList<>();
                System.out.println("LUMINOSIDAD "+snapshot);
                String MostrarLumSubida = snapshot.child("luminosidadSubida").getValue().toString();
                String MostrarLumBajada = snapshot.child("luminosidadBajada").getValue().toString();
                tvMostrarLumSubida.setText(MostrarLumSubida);
                tvMostrarLumBajada.setText(MostrarLumBajada);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Hubo un error");
            }
        };
        luminosidadRef.addValueEventListener(luminosidadListener);
        return listado;
    }

    public void insertar(){
        // Write a message to the database
        int luminosidadSub = Integer.parseInt(etLuminosidad1.getText().toString());
        int luminosidadBaj = Integer.parseInt(etLuminosidad2.getText().toString());
        Luminosidad l = new Luminosidad(luminosidadSub,luminosidadBaj);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Luminosidad");
        myRef.setValue(l);
    }
}