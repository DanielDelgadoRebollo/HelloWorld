package com.example.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.listas.adapters.AdaptadorSpinner;
import com.example.listas.utils.Coche;
import com.example.listas.utils.Marca;
import com.google.android.material.slider.Slider;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Spinner spinner;
    //private TextView textoCoches;
    private Button btnPulsar, btnPulsarDos;
    private ArrayAdapter adaptadorSpinner;
    private ArrayList<Marca> listaMarcas;
    private ImageView imageCoche;
    private AdaptadorSpinner adaptadorSpinnerAvanzado;
    private ArrayList<Coche> listaCoches;
    private TextView textoCoches;
    private EditText editTextMarca, editTextModelo, editTextCv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciar();
        acciones();
        iniciarLista();
        iniciarElementos();

    }

    private void iniciarElementos() {

        spinner.setAdapter(adaptadorSpinnerAvanzado);
    }


    private void instanciar() {
        spinner = findViewById(R.id.spinner_coches);
        //textoCoches = findViewById(R.id.texto_coche);
        imageCoche = findViewById(R.id.imagen_coche);
        btnPulsar = findViewById(R.id.boton_coches);
        btnPulsarDos = findViewById(R.id.boton_cochesDos);
        listaMarcas = new ArrayList();
        listaCoches = new ArrayList<>();
        adaptadorSpinner = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaMarcas);
        adaptadorSpinnerAvanzado = new AdaptadorSpinner(listaCoches, this);
        textoCoches = findViewById(R.id.texto_coche);
        editTextMarca = findViewById(R.id.editText_Marca);
        editTextModelo = findViewById(R.id.editText_Modelo);
        editTextCv = findViewById(R.id.editText_Cv);
    }

    private void iniciarLista() {
        listaCoches.add(new Coche("Volvo", "C132", R.drawable.mercedes, 100));
        listaCoches.add(new Coche("A6", "C132", R.drawable.audi, 100));
        listaCoches.add(new Coche("Seat", "C132", R.drawable.ibiza, 100));
    }

    public void acciones() {

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Coche marcaSeleccionadaUno = (Coche) adaptadorSpinnerAvanzado.getItem(spinner.getSelectedItemPosition());
                imageCoche.setImageResource(marcaSeleccionadaUno.getImagen());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnPulsar.setOnClickListener(this);
        btnPulsarDos.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.boton_coches:
                Coche coche = new Coche(editTextModelo.getText().toString(), editTextMarca.getText().toString(), R.drawable.mercedes,
                        Integer.valueOf(editTextCv.getText().toString()));

                adaptadorSpinnerAvanzado.aniadirCoche(coche);
                //adaptadorSpinnerAvanzado.notifyDataSetChanged();

                break;
            case R.id.boton_cochesDos:


                break;
        }

    }
}
