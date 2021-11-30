package com.example.examenprimeraevaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    ImageView imageView;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        instanciar();
        acciones();
    }

    public void instanciar(){
        imageView = findViewById(R.id.imagen_recibida);
        textView = findViewById(R.id.texto_recibido);
    }

    public void acciones(){
        Intent intent = getIntent();

        imageView.setImageResource(intent.getExtras().getInt("Imagen"));
        textView.setText(intent.getExtras().getString("Nombre"));


    }
}