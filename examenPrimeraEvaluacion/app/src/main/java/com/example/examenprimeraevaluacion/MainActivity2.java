package com.example.examenprimeraevaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import com.example.examenprimeraevaluacion.adapters.AdaptadorListView;
import com.example.examenprimeraevaluacion.utils.Elementos;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    private Spinner spinner;
    private ArrayList<Elementos> listaElementos;
    private ArrayList listaCategorias;
    private ArrayAdapter arrayAdapter;
    private ArrayList<Elementos> listaSeleccionados;
    private ListView listView;
    private AdaptadorListView adaptadorListViewSeleccionados;
    private AdaptadorListView adaptadorListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        instanciar();
        inicializar();
        rellenar();
        setearAdaptador();
        acciones();

    }

    public void instanciar() {
        spinner = findViewById(R.id.spinner_categoria);
        listView = findViewById(R.id.listView_tipos);
    }

    public void inicializar() {
        listaElementos = new ArrayList<>();
        listaCategorias = new ArrayList();
        listaSeleccionados = new ArrayList();
        adaptadorListView = new AdaptadorListView(listaElementos, getApplicationContext());
        adaptadorListViewSeleccionados = new AdaptadorListView(listaSeleccionados, getApplicationContext());
    }

    public void rellenar() {
        listaElementos.add(new Elementos("Romario", "FC. Barcelona", R.drawable.romario, "Futbol"));
        listaElementos.add(new Elementos("Ronaldo", "Brasil", R.drawable.ronaldo, "Futbol"));
        listaElementos.add(new Elementos("Maradona", "Argentina", R.drawable.maradona, "Futbol"));
        listaElementos.add(new Elementos("Zidane", "Francia", R.drawable.zidane, "Futbol"));
        listaElementos.add(new Elementos("Metal Gear", "Sigilo", R.drawable.metal, "Juegos"));
        listaElementos.add(new Elementos("Gran Turismo", "Coches", R.drawable.gt, "Juegos"));
        listaElementos.add(new Elementos("God Of War", "Plataformas", R.drawable.god, "Juegos"));
        listaElementos.add(new Elementos("Final Fantasy X", "Rol", R.drawable.ffx, "Juegos"));
        listaElementos.add(new Elementos("Stranger Things", "Fantastica", R.drawable.stranger, "Series"));
        listaElementos.add(new Elementos("Juego de tronos", "Histórica", R.drawable.tronos, "Series"));
        listaElementos.add(new Elementos("Lost", "Fantastica", R.drawable.lost, "Series"));
        listaElementos.add(new Elementos("La casa de papel", "Accion", R.drawable.papel, "Series"));

        listaCategorias.add("Futbol");
        listaCategorias.add("Series");
        listaCategorias.add("Juegos");

    }

    public void setearAdaptador() {
        arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_spinner_item, listaCategorias);
        spinner.setAdapter(arrayAdapter);
        listView.setAdapter(adaptadorListViewSeleccionados);
        arrayAdapter.notifyDataSetChanged();

    }

    public void acciones() {
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                listaSeleccionados.clear();
                adaptadorListViewSeleccionados.notifyDataSetChanged();
                for (int i = 0; i < listaElementos.size(); i++) {
                    if (listaElementos.get(i).getCategoria().equals(spinner.getAdapter().getItem(position))){
                        listaSeleccionados.add(listaElementos.get(i));
                        adaptadorListViewSeleccionados.notifyDataSetChanged();
                    }else if (listaElementos.get(i).getCategoria().equals(spinner.getAdapter().getItem(position))){
                        listaSeleccionados.add(listaElementos.get(i));
                        adaptadorListViewSeleccionados.notifyDataSetChanged();
                    }else if (listaElementos.get(i).getCategoria().equals(spinner.getAdapter().getItem(position))){
                        listaSeleccionados.add(listaElementos.get(i));
                        adaptadorListViewSeleccionados.notifyDataSetChanged();
                    }
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), MainActivity3.class);
                intent.putExtra("Imagen", listaSeleccionados.get(position).getImagen());
                intent.putExtra("Nombre", listaSeleccionados.get(position).getNombre());

                startActivity(intent);
            }
        });
    }
}