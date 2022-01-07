package com.example.streetfighter.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.streetfighter.R;

public class DialogoPersonalizadoLucha extends DialogFragment {
    private Context context;
    private ImageView imageView1, imageView2;
    public static int imagen1, imagen2;
    private View view;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        view = LayoutInflater.from(context).inflate(R.layout.image_character_fight,null,false);
        alertDialog.setView(view);
        instancias();
        acciones();
        return alertDialog.create();
    }

    public static DialogoPersonalizadoLucha newInstance(int imagen1,int imagen2) {
        DialogoPersonalizadoLucha dialogoPersonalizadoLucha = new DialogoPersonalizadoLucha();
        Bundle bundle = new Bundle();
        bundle.putInt("Imagen1",imagen1);
        bundle.putInt("Imagen1",imagen2);
        dialogoPersonalizadoLucha.setArguments(bundle);
        return dialogoPersonalizadoLucha;
    }

    public void instancias(){
        imageView1 = view.findViewById(R.id.imageViewPlayer1);
        imageView2 = view.findViewById(R.id.imageViewPlayer2);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        this.imagen1 = this.getArguments().getInt("Imagen1");
        this.imagen2 = this.getArguments().getInt("Imagen2");
    }

    public void acciones(){
        imageView1.setImageAlpha(imagen1);
        imageView2.setImageAlpha(imagen2);
    }
}
