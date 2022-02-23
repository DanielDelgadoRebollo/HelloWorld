package com.example.proyectofinalandroid.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectofinalandroid.R;
import com.example.proyectofinalandroid.utils.Equipo;

import java.util.ArrayList;

public class AdaptadorEquipos extends RecyclerView.Adapter<AdaptadorEquipos.MyHolder>{
    private ArrayList<Equipo> listaEquipos;
    private Context context;

    public AdaptadorEquipos(Context context){
        this.listaEquipos = new ArrayList<>();
        this.context= context;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapter_teams,parent,false);
        return new MyHolder(view);
    }

    public void agregarEquipo(Equipo equipo){
        this.listaEquipos.add(equipo);
        Log.v("equipos", String.valueOf(listaEquipos.size()));
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        Equipo equipoActual = listaEquipos.get(position);
        holder.textView.setText(equipoActual.getNombreEquipo());


    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();

    }

    class  MyHolder extends RecyclerView.ViewHolder {
        TextView textView;
        ImageView imageView;


        public MyHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewRecyclerView);
            imageView = itemView.findViewById(R.id.imagenRecyclerView);
        }
    }
}

