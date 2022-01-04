package com.example.streetfighter.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.streetfighter.R;
import com.example.streetfighter.adapter.AdapterRecycler;
import com.example.streetfighter.utils.Personaje;


public class DialogoPersonalizado extends DialogFragment {
    private Context context;
    private View view;
    private ImageView imageView;
    private TextView textView1,textView2;
    private static String nombre,poder;
    private static int imagen;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        view = LayoutInflater.from(context).inflate(R.layout.image_character,null,false);
        alertDialog.setView(view);
        instancias();
        acciones();
        return alertDialog.create();
    }

    public void instancias(){
        imageView = view.findViewById(R.id.imagenViewCharacter);
        textView1 = view.findViewById(R.id.textViewNombreCharacter);
        textView2 = view.findViewById(R.id.textViewCaracteristicaCharacter);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        this.imagen= this.getArguments().getInt("Imagen");
        this.nombre = this.getArguments().getString("Nombre");
        this.poder = this.getArguments().getString("Poder");

    }

    public static DialogoPersonalizado newInstance(int imagen,String nombre,String poder) {
      DialogoPersonalizado dialogoPersonalizado = new DialogoPersonalizado();
      Bundle bundle = new Bundle();
      bundle.putInt("Imagen",imagen);
      bundle.putString("Nombre",nombre);
      bundle.putString("Poder",poder);
      dialogoPersonalizado.setArguments(bundle);
      return dialogoPersonalizado;
    }


    public void acciones(){
        imageView.setImageResource(imagen);
        textView1.setText(nombre);
        textView2.setText(poder);
    }

}
