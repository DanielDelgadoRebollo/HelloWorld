package com.example.streetfighter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.streetfighter.R;
import com.example.streetfighter.utils.Personaje;

import java.util.List;

public class AdapterRecycler extends RecyclerView.Adapter<AdapterRecycler.myHolder> {
     private List<Personaje> listaPersonaje;
     private Context context;
     private OnPersonajeRecycler listener;

     public AdapterRecycler(List listaPersonaje,Context context){
         this.listaPersonaje = listaPersonaje;
         this.context = context;
         this.listener = (OnPersonajeRecycler) context;
     }

     @NonNull
     @Override
     public myHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
         View view = LayoutInflater.from(context).inflate(R.layout.item_recycler,parent,false);
         myHolder holder = new myHolder(view);
         return holder;
     }

     @Override
     public void onBindViewHolder(@NonNull myHolder holder, int position) {
         Personaje personaje = listaPersonaje.get(position);
         holder.imageButton.setImageResource(personaje.getImagen());
         holder.button.setText(personaje.getNombre());
         holder.imageButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 listener.onPersonajeInformacion(personaje);
             }
         });
         holder.button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 listener.onPersonajeSelected(personaje);
             }
         });
     }

     @Override
     public int getItemCount() {
         return listaPersonaje.size();
     }

     class myHolder extends RecyclerView.ViewHolder{

         ImageButton imageButton;
         Button button;

        public myHolder(@NonNull View itemView) {
            super(itemView);
            imageButton = itemView.findViewById(R.id.imagenButton);
            button = itemView.findViewById(R.id.botonImagen);
        }




    }

    public interface OnPersonajeRecycler{
         public void onPersonajeSelected(Personaje personaje);
         public void onPersonajeInformacion(Personaje personaje);
    }
}
