package com.example.streetfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.streetfighter.adapter.AdapterRecycler;
import com.example.streetfighter.utils.Personaje;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements AdapterRecycler.OnPersonajeRecycler {
    private RecyclerView recyclerView;
    private ArrayList<Personaje> listaPersonajes;
    private AdapterRecycler adapterRecycler;
    private ImageView imageView1,imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        instancias();
        rellenarListas();
        asociarElementos();
    }

    public void instancias() {
        recyclerView = findViewById(R.id.recyclerView);
        imageView1 = findViewById(R.id.imageView1);
        imageView2 = findViewById(R.id.imageView2);
        listaPersonajes = new ArrayList<>();
        adapterRecycler = new AdapterRecycler(listaPersonajes, GameActivity.this);
    }

    public void rellenarListas() {
        listaPersonajes.add(new Personaje(R.drawable.vision, "Mr. Vision", "Psicopoderes",
                "Alemania", R.drawable.fondo_ryu, R.drawable.lose_vision));
        listaPersonajes.add(new Personaje(R.drawable.blanka, "Blanka", "Electricidad", "Brasil",
                R.drawable.fondo_blanka, R.drawable.lose_blanka));
        listaPersonajes.add(new Personaje(R.drawable.chunli, "Chun Li", "Karate", "China",
                R.drawable.fondo_chunly, R.drawable.lose_chun));
        listaPersonajes.add(new Personaje(R.drawable.dalsim, "Dalsim", "Elasticidad", "India",
                R.drawable.fondo_dalsim, R.drawable.lose_dalsim));
        listaPersonajes.add(new Personaje(R.drawable.guile, "Guille", "Boomerang", "EEUU",
                R.drawable.fondo_guille, R.drawable.lose_guile));
        listaPersonajes.add(new Personaje(R.drawable.honda, "Honda", "Sumo", "Japón",
                R.drawable.fondo_honda, R.drawable.lose_honda));
        listaPersonajes.add(new Personaje(R.drawable.ken, "Key", "Judo", "Japon",
                R.drawable.fondo_ken, R.drawable.lose_ken));
        listaPersonajes.add(new Personaje(R.drawable.ryu, "Ryu", "Karate", "Japón",
                R.drawable.fondo_ryu, R.drawable.lose_ryu));
        listaPersonajes.add(new Personaje(R.drawable.vega, "Vega", "Garras", "España",
                R.drawable.fondo_ryu, R.drawable.lose_vega));
        listaPersonajes.add(new Personaje(R.drawable.zang, "Zangief", "Fuerza", "Rusia",
                R.drawable.fondo_zang, R.drawable.lose_zan));
    }

    public void asociarElementos() {
        recyclerView.setAdapter(adapterRecycler);
        if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_LANDSCAPE) {
            recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,RecyclerView.VERTICAL));
        }


    }


    @Override
    public void onPersonajeSelected(Personaje personaje) {
    }

    @Override
    public void onPersonajeInformacion(Personaje perosnaje) {

    }
}