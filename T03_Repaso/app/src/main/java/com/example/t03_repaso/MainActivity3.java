package com.example.t03_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.t03_repaso.utils.Persona;

public class MainActivity3 extends AppCompatActivity {

    private String nombre, apellido;
    private int telefono;
    private boolean experiencia;
    private Persona personaRecuperar = (Persona) getIntent().getExtras().getSerializable("persona");

    TextView textNombre,textApellido,textTelefono;
    CheckBox checkExperiencia;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        if (getIntent().getExtras()!=null){
            recuperarDatos();
            setearDatos();
        }
    }

    private void setearDatos(){
        textNombre.setText(personaRecuperar.getNombre());
        textApellido.setText(personaRecuperar.getApellido());
        textTelefono.setText(personaRecuperar.getTelefono());
        checkExperiencia.setChecked(personaRecuperar.isExperiencia());
    }

    private void instancias(){
        textNombre = findViewById(R.id.nombreRecibir);
        textApellido = findViewById(R.id.apellidoRecibir);
        textTelefono = findViewById(R.id.telefonoRecibir);
        checkExperiencia = findViewById(R.id.experienciaRecibir);
    }

    private void recuperarDatos() {
       /* nombre = getIntent().getExtras().getString("nombre");
        apellido = getIntent().getExtras().getString("apellido");
        telefono = getIntent().getExtras().getInt("telefono");
        experiencia = getIntent().getExtras().getBoolean("experiencia");
        Log.v("test",nombre);
        Log.v("test",apellido);
        Log.v("test", String.valueOf(telefono));
        Log.v("test", String.valueOf(experiencia));
        */



    }
}