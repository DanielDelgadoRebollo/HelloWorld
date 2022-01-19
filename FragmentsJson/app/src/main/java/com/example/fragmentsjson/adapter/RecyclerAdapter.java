package com.example.fragmentsjson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fragmentsjson.R;
import com.example.fragmentsjson.utils.Equipo;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.myHolder> {
    private Context context;
    private List<Equipo> listaEquipos;
    private OnEquipoListener listener;

    public RecyclerAdapter(Context context) {
       this.context=context;
       this.listaEquipos = new ArrayList<>();
       this.listener = (OnEquipoListener) context;
    }

    @NonNull
    @Override
    public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_view,parent,false);
        myHolder holder = new myHolder(view);
        return holder;
    }

    public void agregarEquipo(Equipo equipo){
        this.listaEquipos.add(equipo);
        this.notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull myHolder holder, int position) {
       Equipo equipo = listaEquipos.get(position);
       holder.textView1.setText(equipo.getTextoNombre());
       holder.textView2.setText(equipo.getTextoEstadio());
       Glide.with(context).load(equipo.getImagen()).into(holder.imageView);
       holder.linearLayout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               listener.onEquipoSelected(equipo);
           }
       });

    }

    @Override
    public int getItemCount() {
        return listaEquipos.size();
    }

    public interface OnEquipoListener{
        void onEquipoSelected(Equipo equipo);
    }


    class myHolder extends RecyclerView.ViewHolder {
          ImageView imageView;
          TextView textView1,textView2;
          LinearLayout linearLayout;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imagenRecycler);
            textView1 = itemView.findViewById(R.id.textViewRecycler1);
            textView2 = itemView.findViewById(R.id.textViewRecycler2);
            linearLayout = itemView.findViewById(R.id.fila_item);

        }
    }
}
