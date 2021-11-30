package com.example.examenprimeraevaluacion.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examenprimeraevaluacion.R;
import com.example.examenprimeraevaluacion.utils.Elementos;

import java.util.List;

public class AdaptadorListView extends BaseAdapter {
    List<Elementos> listaElementos;
    Context context;

    public AdaptadorListView(List<Elementos> listaElementos,Context context){
        this.listaElementos = listaElementos;
        this.context = context;
    }
    @Override
    public int getCount() {
        return listaElementos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaElementos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = LayoutInflater.from(context).inflate(R.layout.listview_layout,parent,false);

        ImageView imageView = convertView.findViewById(R.id.listview_imagen);
        TextView textView = convertView.findViewById(R.id.textView_nombre);
        TextView textViewDos = convertView.findViewById(R.id.textView_categoria);

        Elementos itemElemento = listaElementos.get(position);
        imageView.setImageResource(itemElemento.getImagen());
        textView.setText(itemElemento.getNombre());
        textViewDos.setText(itemElemento.getCategoria());




        return convertView;
    }
}
