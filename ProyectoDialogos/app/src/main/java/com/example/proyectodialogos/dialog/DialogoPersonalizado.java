package com.example.proyectodialogos.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

import com.example.proyectodialogos.R;
import com.example.proyectodialogos.utils.Persona;

public class DialogoPersonalizado extends DialogFragment {
    private Context context;
    private View view;
    private Button botonLogin;
    private EditText editTextUser,editTextPass;
    private CheckBox checkBox;
    private OnDialogoPersoListener onDialogoPersoListener;
    private static String nombre;

    public static DialogoPersonalizado newInstance(String nombre){
        DialogoPersonalizado dialogoPersonalizado = new DialogoPersonalizado();
        Bundle bundle = new Bundle();
        bundle.putString("Nombre",nombre);
        dialogoPersonalizado.setArguments(bundle);
        return dialogoPersonalizado;
    }

    public void recuperarDatos(){
        editTextUser.setText(nombre);
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getActivity());
        view = LayoutInflater.from(context).inflate(R.layout.dialogo_login,null,false);
        alertDialog.setView(view);
        instancias();
        recuperarDatos();
        acciones();
        return alertDialog.create();
    }

    private void instancias() {
        botonLogin = view.findViewById(R.id.boton_login);
        editTextUser = view.findViewById(R.id.texto_usuario);
        editTextPass = view.findViewById(R.id.texto_contrasenia);
        checkBox = view.findViewById(R.id.checkbox);
    }

    public void acciones(){
        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDialogoPersoListener.onPersonaSelected(new Persona(editTextUser.getText().toString(),editTextPass.getText().toString()));
                //Toast.makeText(context, "Pulsado login", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
    }
   /* @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.from(context).inflate(R.layout.dialogo_login,container,false);
        return view;
    }
*/

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context=context;
        this.onDialogoPersoListener = (OnDialogoPersoListener) context;
        if (this.getArguments()!=null){
            this.nombre = this.getArguments().getString("Nombre");
        }
    }

    public interface OnDialogoPersoListener{
        void onPersonaSelected(Persona persona);
    }
}
