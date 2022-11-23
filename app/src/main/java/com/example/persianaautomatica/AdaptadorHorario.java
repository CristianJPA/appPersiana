package com.example.persianaautomatica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.persianaautomatica.Modelo.Horario;

import java.util.ArrayList;

public class AdaptadorHorario extends BaseAdapter {
    private Context contexto;
    private ArrayList<Horario> listItems;

    public AdaptadorHorario(Context contexto, ArrayList<Horario> listItems) {
        this.contexto = contexto;
        this.listItems = listItems;
    }

    @Override
    public int getCount() {
        return listItems.size();
    }

    @Override
    public Object getItem(int i) {
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(contexto).inflate(R.layout.items_listviewhorario,null);
        TextView tvHorarioSubida = (TextView) view.findViewById(R.id.tvHorarioSubida);
        TextView tvHorariobajada = (TextView) view.findViewById(R.id.tvHorarioBajada);
        Horario h = (Horario) getItem(i);
        tvHorarioSubida.setText(h.getHorarioSubida());
        tvHorariobajada.setText(""+h.getHorarioBajada());
        System.out.println("HOLA");
        return view;
    }
}
