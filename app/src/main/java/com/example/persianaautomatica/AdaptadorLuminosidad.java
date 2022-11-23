package com.example.persianaautomatica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.persianaautomatica.Modelo.Luminosidad;


import java.util.ArrayList;

public class AdaptadorLuminosidad extends BaseAdapter {
    private Context contexto;
    private ArrayList<Luminosidad> listItems;

    public AdaptadorLuminosidad(Context contexto, ArrayList<Luminosidad> listItems) {
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
        view = LayoutInflater.from(contexto).inflate(R.layout.items_listviewluminosidad,null);
        TextView tvLuminosidadMayor = (TextView) view.findViewById(R.id.tvLuminosidadMayor);
        TextView tvLuminosidadMenor = (TextView) view.findViewById(R.id.tvLuminosidadMenor);
        Luminosidad l = (Luminosidad) getItem(i);
        tvLuminosidadMayor.setText(l.getLuminosidadSubida());
        tvLuminosidadMenor.setText(""+l.getLuminosidadBajada());
        return view;
    }
}
