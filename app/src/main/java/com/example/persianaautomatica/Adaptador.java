package com.example.persianaautomatica;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import androidx.constraintlayout.helper.widget.Layer;

import com.example.persianaautomatica.Modelo.Registro;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Adaptador extends BaseAdapter {
    private Context contexto;
    private ArrayList<Registro> listItems;

    public Adaptador(Context contexto, ArrayList<Registro> listItems) {
        this.contexto = contexto;
        this.listItems = listItems;
    }

    @Override
    public int getCount() { //cuantas veces se debe replicar un item para un lv
        return listItems.size();
    }

    @Override
    public Object getItem(int i) { //permite recuperar un item especifico en el lv
        return listItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = LayoutInflater.from(contexto).inflate(R.layout.items_listview,null);
        TextView tvId = (TextView) view.findViewById(R.id.tvId);
        TextView tvVoltaje = (TextView) view.findViewById(R.id.tvVoltaje);
        TextView tvHora = (TextView) view.findViewById(R.id.tvHora);
        TextView tvFecha = (TextView) view.findViewById(R.id.tvFecha);
        Registro r = (Registro) getItem(i);
        tvId.setText(r.getId());
        tvVoltaje.setText(""+r.getVoltaje());
        tvHora.setText(""+r.getHora());
        tvFecha.setText(""+r.getFecha());
        System.out.println("HOLA");
        return view;

    }
}
