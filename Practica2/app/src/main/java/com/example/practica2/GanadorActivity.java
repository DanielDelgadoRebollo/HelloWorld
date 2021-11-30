package com.example.practica2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.practica2.utils.Persona;

import java.util.ArrayList;
import java.util.Observable;

public class GanadorActivity extends AppCompatActivity {

    private Button botonGanador, botonAñadir;
    private TextView textViewGanador;
    private ListView listView;
    private EditText editText;
    private ArrayList<Persona> listaParticipantes;
    private ArrayAdapter<Persona> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganador);
        instancias();
        iniciarListas();
        acciones();
    }

    private void iniciarListas() {
        listaParticipantes = new ArrayList<>();
        listaParticipantes.add(new Persona("Antonio"));
        listaParticipantes.add(new Persona("Jesus"));
        listaParticipantes.add(new Persona("Borja"));
        listaParticipantes.add(new Persona("Isaac"));
        arrayAdapter = new ArrayAdapter<Persona>(getApplicationContext(), android.R.layout.simple_list_item_1, listaParticipantes);
        listView.setAdapter(arrayAdapter);
        arrayAdapter.notifyDataSetChanged();

    }


    private void acciones() {
        botonAñadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText != null) {
                    listaParticipantes.add(new Persona(String.valueOf(editText.getText())));
                    arrayAdapter.notifyDataSetChanged();
                }

            }
        });
        botonGanador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int aleatorio = (int) (Math.random() * listaParticipantes.size());
                textViewGanador.setText(String.valueOf(listaParticipantes.get(aleatorio)));

            }
        });

    }

    private void instancias() {
        listView = findViewById(R.id.texto_participantes);
        botonGanador = findViewById(R.id.boton_ganador);
        botonAñadir = findViewById(R.id.boton_participante);
        textViewGanador = findViewById(R.id.texto_ganador);
        editText = findViewById(R.id.introducir_nombre);

    }
}