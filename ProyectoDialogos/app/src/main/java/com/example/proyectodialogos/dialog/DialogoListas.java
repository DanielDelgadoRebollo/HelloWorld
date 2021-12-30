package com.example.proyectodialogos.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class DialogoListas extends DialogFragment {
    private Context context;
    private String opcionSeleccionada;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        alertDialog.setTitle("Dialogo de listas");
        CharSequence[] opciones = new CharSequence[]{"Opcion  1", "Opcion2", "Opcion3"};
    /*    alertDialog.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,opciones[which], Toast.LENGTH_SHORT).show();
            }
        });

     */
        alertDialog.setSingleChoiceItems(opciones, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(context,opciones[which], Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setPositiveButton("Seleccionar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                opcionSeleccionada = (String) opciones[which];
                Toast.makeText(context,opcionSeleccionada, Toast.LENGTH_SHORT).show();
            }
        });
        return alertDialog.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }
}
