package com.example.configuraciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnResultado, btnMasUno, btnMasDos, btnMenosUno, btnMenosDos, btnBorrar;
    private EditText text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();

        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            accionesHorizontal();
        }
    }

    private void instancias() {
        btnResultado = findViewById(R.id.botonResultado);
        btnMasUno = findViewById(R.id.botonMasUno);
        btnMenosUno = findViewById(R.id.botonMenosUno);
        btnMenosDos = findViewById(R.id.botonMenosDos);
        btnMasDos = findViewById(R.id.botonMasDos);
        btnBorrar = findViewById(R.id.botonBorrar);
        text = findViewById(R.id.textoResultado);
    }

    private void acciones() {

        btnResultado.setOnClickListener(this);
        btnMasUno.setOnClickListener(this);
        btnMasDos.setOnClickListener(this);
        btnMenosDos.setOnClickListener(this);
        btnMenosUno.setOnClickListener(this);
        text.setOnClickListener(this);
    }

    private void accionesHorizontal(){
        btnBorrar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}