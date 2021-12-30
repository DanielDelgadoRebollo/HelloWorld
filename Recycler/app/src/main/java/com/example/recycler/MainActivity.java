package com.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import com.example.recycler.utils.Modelo;

public class MainActivity extends AppCompatActivity implements AdapterRecycler.OnModeloRecycler {
    private RecyclerView recyclerView;
    private ArrayList<Modelo> listaModelos;
    private AdapterRecycler adapterRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciar();
        rellenarListas();
        asociarElementos();
    }

    public void asociarElementos(){
        recyclerView.setAdapter(adapterRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),RecyclerView.VERTICAL,false));
    }

    public void instanciar() {
        listaModelos = new ArrayList<Modelo>();
        recyclerView = findViewById(R.id.recyclerView);
        adapterRecycler = new AdapterRecycler(listaModelos,MainActivity.this);

    }
    public void rellenarListas(){
        listaModelos.add(new Modelo(R.drawable.a5,"Audi","A5",300));
        listaModelos.add(new Modelo(R.drawable.eqc,"eqc","A5",300));
        listaModelos.add(new Modelo(R.drawable.arteon,"Arteon","A5",300));
        listaModelos.add(new Modelo(R.drawable.i8,"I8","A5",300));
    }

    @Override
    public void onModeloSelected(Modelo modelo) {
        Toast.makeText(getApplicationContext(), modelo.getMarca(), Toast.LENGTH_SHORT).show();
    }
}