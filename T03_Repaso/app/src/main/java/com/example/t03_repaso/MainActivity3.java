package com.example.t03_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.t03_repaso.utils.Persona;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    private Persona personaRecuperar;

    TextView textNombre,textApellido,textTelefono;
    CheckBox checkExperiencia;
    Button botonContestar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        instancias();
        if (getIntent().getExtras()!=null){
            recuperarDatos();
            setearDatos();
        }
        acciones();
    }

    private void acciones(){
        botonContestar.setOnClickListener(this);
    }

    private void setearDatos(){
        textNombre.setText(personaRecuperar.getNombre());
        textApellido.setText(personaRecuperar.getApellido());
        textTelefono.setText(String.valueOf(personaRecuperar.getTelefono()));
        checkExperiencia.setChecked(personaRecuperar.isExperiencia());
    }

    private void instancias(){
        textNombre = findViewById(R.id.nombreRecibir);
        textApellido = findViewById(R.id.apellidoRecibir);
        textTelefono = findViewById(R.id.telefonoRecibir);
        checkExperiencia = findViewById(R.id.experienciaRecibir);
        botonContestar = findViewById(R.id.botonContestar);

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
       personaRecuperar =  (Persona) getIntent().getExtras().getSerializable("persona");


    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        personaRecuperar.setExperiencia(checkExperiencia.isChecked());

        if (!checkExperiencia.isChecked()){
            setResult(0,intent);
        }else{
            setResult(1,intent);
        }
        finish();
    }
}