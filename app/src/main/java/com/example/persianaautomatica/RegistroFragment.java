package com.example.persianaautomatica;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.persianaautomatica.Modelo.Registro;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class RegistroFragment extends Fragment {
    FirebaseDatabase database;
    ArrayList<Registro> listado;
    ArrayAdapter<Registro> adaptadorListado;
    ListView lvRegistro;
    DatabaseReference registroRef;

    public RegistroFragment() {
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
        View v = inflater.inflate(R.layout.fragment_registro, container, false);
        lvRegistro = (ListView) v.findViewById(R.id.lvRegistro);
        cargarDatos();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }



    public ArrayList<Registro> cargarDatos() {
        database = FirebaseDatabase.getInstance();
        registroRef = database.getReference("Registro");

        ValueEventListener registroListener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listado = new ArrayList<>();
                System.out.println("REGISTROS "+snapshot);
                try {

                for (DataSnapshot d: snapshot.getChildren()) {
                    System.out.println("REGISTRO"+d);
                    String id = d.child("Id").getValue().toString();
                    int voltaje = Integer.parseInt(d.child("Voltaje").getValue().toString());
                    String hora = d.child("Hora").getValue().toString();
                    String fecha = d.child("Fecha").getValue().toString();
                    Registro r = new Registro(id, voltaje, hora, fecha);
                    listado.add(r);
                    //System.out.println(r);
                }
                }catch (Exception e){
                    System.out.println("error");
                }
                Adaptador adaptador = new Adaptador(getContext(),listado);
                lvRegistro.setAdapter(adaptador);

            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                System.out.println("Hubo un error");
            }
        };
        registroRef.addValueEventListener(registroListener);
        return listado;
    }


}