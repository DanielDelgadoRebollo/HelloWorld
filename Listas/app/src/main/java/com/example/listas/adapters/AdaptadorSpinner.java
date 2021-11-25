package com.example.listas.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listas.R;
import com.example.listas.utils.Coche;

import java.util.List;

public class AdaptadorSpinner extends BaseAdapter {
    private List<Coche> listaDatos;
    private Context context;

    @Override
    public int getCount() {
        return listaDatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaDatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public AdaptadorSpinner(List<Coche> listaDatos,Context context){
        this.listaDatos = listaDatos;
        this.context = context;
    }

    public void aniadirCoche(Coche coche){
        listaDatos.add(coche);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.spinner_layout,parent,false);
        ImageView imagen = convertView.findViewById(R.id.imagen_fila_spinner);
        TextView textMarca = convertView.findViewById(R.id.modelo_fila_spinner);
        TextView textCv = convertView.findViewById(R.id.modelo_cv_spinner);

        Coche itemCoche = listaDatos.get(position);
        imagen.setImageResource(itemCoche.getImagen());
        textMarca.setText(itemCoche.getMarca());
        textCv.setText(String.valueOf(itemCoche.getCv()));


        return convertView;
    }

    public List<Coche> getListaDatos() {
        return listaDatos;
    }
}
