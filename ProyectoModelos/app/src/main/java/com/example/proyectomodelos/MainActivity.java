package com.example.proyectomodelos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.proyectomodelos.adaptadores.AdaptadorMarcas;
import com.example.proyectomodelos.adaptadores.AdaptadorModelo;
import com.example.proyectomodelos.utils.Marca;
import com.example.proyectomodelos.utils.Modelo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private ListView listViewModelos;
    private AdaptadorMarcas adaptadorMarcas;
    private ArrayList<Marca> listaMarcas;
    private ArrayList<Modelo> listaModelo;
    private AdaptadorModelo adaptadorModelo;
    private ArrayList<Modelo> listaFiltrada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciar();
        iniciarListas();
        asociarElementos();
        acciones();
    }

    private void asociarElementos() {
      spinner.setAdapter(adaptadorMarcas);
      listViewModelos.setAdapter(adaptadorModelo);
    }

    private void iniciarListas() {
        listaMarcas.add(new Marca("BMW", R.drawable.bmw));
        listaMarcas.add(new Marca("Audi", R.drawable.audi));
        listaMarcas.add(new Marca("Vw", R.drawable.vw));
        listaMarcas.add(new Marca("Mercedes", R.drawable.mercedes2));
        listaModelo.add(new Modelo(new Marca("Mercedes"), "serie B", 150, R.drawable.mercedes2));
        listaModelo.add(new Modelo(new Marca("Audi"), "A3", 200, R.drawable.audi2));
        listaModelo.add(new Modelo(new Marca("Bmw"), "Bmw", 120, R.drawable.bmw2));
        listaModelo.add(new Modelo(new Marca("Volkswagen"), "Golf", 120, R.drawable.golf));
    }

    private void instanciar(){
        listaMarcas = new ArrayList<>();
        listaModelo = new ArrayList<>();
        listaFiltrada = new ArrayList<>();
        spinner = findViewById(R.id.spinner_marcas);
        listViewModelos = findViewById(R.id.lista_modelos);
        adaptadorMarcas = new AdaptadorMarcas(listaMarcas,getApplicationContext());
        adaptadorModelo = new AdaptadorModelo(listaFiltrada,getApplicationContext());
    }


    private void acciones(){
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Marca marca = (Marca) spinner.getAdapter().getItem(position);
                String marcaSeleccionada = marca.getMarca();
                listaFiltrada.clear();
                adaptadorModelo.notifyDataSetChanged();
                for (Modelo itemModelo:listaModelo) {
                    if (itemModelo.getMarca().getMarca().toLowerCase().equals(marcaSeleccionada.toLowerCase())){
                        listaFiltrada.add(itemModelo);
                        adaptadorModelo.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}