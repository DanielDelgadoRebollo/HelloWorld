package com.example.recycler;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler.utils.Modelo;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.myHolder> {

    private List<Modelo>listaElementos;
    private Context context;
    private OnModeloRecycler listener;
    public AdapterRecycler(List listaElementos, Context context) {
        this.listaElementos = listaElementos;
        this.context = context;
        this.listener = (OnModeloRecycler) context;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler, parent, false);
        myHolder holder = new myHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
       Modelo modeloActual = listaElementos.get(position);
       holder.imageView.setImageResource(modeloActual.getImagen());
       holder.titulo.setText(modeloActual.getModelo());
       holder.subtitulo.setText(modeloActual.getMarca());
       holder.imageView.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               listener.onModeloSelected(modeloActual);
           }
       });


    }

    @Override
    public int getItemCount() {
        return listaElementos.size();
    }

    class myHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView titulo,subtitulo;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagen_item_recycler);
            titulo = itemView.findViewById(R.id.textview_titulo);
            subtitulo = itemView.findViewById(R.id.textView_subtitulo);

        }

    }

    public interface OnModeloRecycler{
        public void onModeloSelected(Modelo modelo);
    }
}
