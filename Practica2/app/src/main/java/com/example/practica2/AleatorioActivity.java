package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ToggleButton;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class AleatorioActivity extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioRango, radioSinRango;
    EditText editTextMinimo, editTextMaximo, editTextDecimales, editTextTotales;
    CheckBox checkBox;
    ToggleButton toggleButton;
    ImageButton imageButton;
    List listaDecimales;
    ListView listView;
    ArrayAdapter arrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aleatorio);
        instanciar();
        inicializar();
        acciones();
    }


    public void instanciar() {
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
        listView = findViewById(R.id.listView);

    }

    public void inicializar() {
        listaDecimales = new ArrayList<>();
        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, listaDecimales);
        listView.setAdapter(arrayAdapter);
    }

    public void acciones() {
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listaDecimales.clear();
                arrayAdapter.notifyDataSetChanged();
                if (radioSinRango.isChecked()) {
                    if (checkBox.isChecked()) {
                        int contador = 0, totales = 0;
                        do {


                            double random = (double) (Math.random() * 20);

                            totales = Integer.valueOf(String.valueOf(editTextTotales.getText()));
                            BigDecimal bigDecimal = new BigDecimal(random);
                            bigDecimal = bigDecimal.setScale(Integer.valueOf(String.valueOf(editTextDecimales.getText())),BigDecimal.ROUND_CEILING);

                            listaDecimales.add(bigDecimal.doubleValue());
                            arrayAdapter.notifyDataSetChanged();
                            contador++;
                        } while (contador != totales);
                    }else{
                        int contador = 0,totales=0;
                        do {
                            int random = (int) (Math.random()*20);
                            totales = Integer.valueOf(String.valueOf(editTextTotales.getText()));
                            listaDecimales.add(random);
                            arrayAdapter.notifyDataSetChanged();



                           contador++;
                        }while (contador !=totales);

                    }
                }else if (radioRango.isChecked()) {
                    if (checkBox.isChecked()) {
                        int contador = 0, totales = 0;
                        do {


                            double random = (double) (Math.random() * Integer.valueOf(String.valueOf(editTextMaximo.getText())) + Integer.valueOf(String.valueOf(editTextMinimo.getText()))-1);

                            totales = Integer.valueOf(String.valueOf(editTextTotales.getText()));
                            BigDecimal bigDecimal = new BigDecimal(random);
                            bigDecimal = bigDecimal.setScale(Integer.valueOf(String.valueOf(editTextDecimales.getText())), BigDecimal.ROUND_UP);

                            listaDecimales.add(bigDecimal.doubleValue());
                            arrayAdapter.notifyDataSetChanged();
                            contador++;
                        } while (contador != totales);
                    } else {
                        int contador = 0, totales = 0;
                        do {
                            int random = (int) (Math.random() * Integer.valueOf(String.valueOf(editTextMaximo.getText())) + Integer.valueOf(String.valueOf(editTextMinimo.getText()))-1);
                            totales = Integer.valueOf(String.valueOf(editTextTotales.getText()));
                            listaDecimales.add(random);
                            arrayAdapter.notifyDataSetChanged();


                            contador++;
                        } while (contador != totales);

                    }
                }
            }
        });
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radio_sin_especifico:
                        editTextMaximo.setEnabled(false);
                        editTextMinimo.setEnabled(false);
                        break;
                    case R.id.radio_con_especifico:
                        editTextMaximo.setEnabled(true);
                        editTextMinimo.setEnabled(true);
                        break;
                }


            }
        });
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (!isChecked) {
                    editTextDecimales.setEnabled(false);
                } else {
                    editTextDecimales.setEnabled(true);
                }
            }
        });

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Set set = new HashSet<>(listaDecimales);
                    listaDecimales.clear();
                    listaDecimales.addAll(set);

                }
            }
        });
    }
}