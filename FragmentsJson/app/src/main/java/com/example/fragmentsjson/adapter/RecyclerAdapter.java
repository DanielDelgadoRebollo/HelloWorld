package com.example.fragmentsjson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fragmentsjson.R;
import com.example.fragmentsjson.utils.Equipo;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myHolder> {
    private Context context;
    private List<Equipo> listaEquipos;

    public RecyclerAdapter(List listaEquipos, Context context) {
       this.context=context;
       this.listaEquipos = listaEquipos;

    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false);
        myHolder holder = new myHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
       Equipo equipo = listaEquipos.get(position);
       holder.textView1.setText(equipo.getTextoNombre());
       holder.textView2.setText(equipo.getTextoEstadio());

    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }


    class myHolder extends RecyclerView.ViewHolder {
          ImageView imageView;
          TextView textView1,textView2;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagenRecycler);
            textView1 = itemView.findViewById(R.id.textViewRecycler1);
            textView2 = itemView.findViewById(R.id.textViewRecycler2);

        }
    }
}
