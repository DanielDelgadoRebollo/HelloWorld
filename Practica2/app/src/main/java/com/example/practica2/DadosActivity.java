package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DadosActivity extends AppCompatActivity {
    Button btnAleatorio;
    ImageView imagen;
    int[] dados;
    int numeroActual;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        instanciar();
        acciones();
    }

    public void instanciar(){
        btnAleatorio = findViewById(R.id.btnTirar);
        imagen = findViewById(R.id.imagen_dados);

        dados = new int[]{R.drawable.dado_uno,R.drawable.dado_dos,R.drawable.dado_tres,R.drawable.dado_cuatro,R.drawable.dado_cinco,R.drawable.dado_seis};
        numeroActual = (int) (Math.random()*6);
        imagen.setImageResource(dados[numeroActual]);
    }

    public void acciones(){
        btnAleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numeroNuevo = (int) (Math.random()*6);
                imagen.setImageResource(dados[numeroNuevo]);
            }
        });
    }
}