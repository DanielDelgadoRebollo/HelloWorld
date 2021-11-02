package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button button1;
    private EditText txt1;
    public static final String MENSAJE = "texto del saludo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.button);
        txt1 = findViewById(R.id.texto1);
    }

    public void saludar(View view) {
        Intent intent = new Intent(this,SegundaActividad.class);
        String mensaje = String.valueOf(txt1.getText());
        intent.putExtra(MENSAJE,mensaje);
        startActivity(intent);
    }

}