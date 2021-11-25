package com.example.cartas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button inicio;
    private TextView textView;
    private CheckBox checkBox;
    private int recordTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciar();
        acciones();
    }

    private void instanciar() {
        inicio = findViewById(R.id.botonInicio);
        checkBox = findViewById(R.id.check_practica);
        textView = findViewById(R.id.texto_record);
    }

    private void acciones() {
        inicio.setOnClickListener(this);
        textView.setText(String.valueOf(recordTotal));
    }

    @Override
    public void onClick(View v) {
        //Si estoy practicando --> arranco con request 0.
        //Si no estoy practicando --> arranco con request 1
        Intent intent = new Intent(getApplicationContext(), Game.class);
        if (checkBox.isChecked()) {
            startActivityForResult(intent, 0);
        } else {
            startActivityForResult(intent, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //Si el request es 1 , estoy jugando
        if (requestCode == 1) {
            //Recupero el record
            int record = data.getExtras().getInt("Record");
            if(record >= recordTotal) {
                recordTotal = record;
                textView.setText(String.valueOf(recordTotal));
            }
        }
    }
}