package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;


public class AleatorioActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioRango,radioSinRango;
    EditText editTextMinimo,editTextMaximo,editTextDecimales,editTextTotales;
    CheckBox checkBox;
    ToggleButton toggleButton;
    ImageButton imageButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);
        instanciar();
    }

    public void instanciar(){
        radioGroup = findViewById(R.id.radio_group);
        radioRango = findViewById(R.id.radio_con_especifico);
        radioSinRango = findViewById(R.id.radio_sin_especifico);
        checkBox = findViewById(R.id.checkbox);
        editTextMinimo = findViewById(R.id.editText_minimo);
        editTextMaximo = findViewById(R.id.editText_maximo);
        editTextDecimales = findViewById(R.id.editText_numeroDecimales);
        editTextTotales = findViewById(R.id.editText_numeroTotal);
        toggleButton = findViewById(R.id.toggle);
        imageButton = findViewById(R.id.imagen_cohete);
    }


}