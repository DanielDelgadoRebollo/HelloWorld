package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    ImageButton btnSuffle, btnRanking,btnDados;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    public void instancias(){
        btnSuffle = findViewById(R.id.boton_aleatorio);
        btnDados = findViewById(R.id.boton_dados);
        btnRanking = findViewById(R.id.boton_copa);

    }

    public void acciones(){
        btnDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent = new Intent(getApplicationContext(),DadosActivity.class);
               startActivity(intent);
            }
        });
        btnRanking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),GanadorActivity.class);
                startActivity(intent);
            }
        });
        btnSuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AleatorioActivity.class);
                startActivity(intent);
            }
        });
    }
}