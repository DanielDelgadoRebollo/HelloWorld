package com.example.streetfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.Person;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.streetfighter.adapter.AdapterRecycler;
import com.example.streetfighter.dialog.DialogoPersonalizado;
import com.example.streetfighter.dialog.DialogoPersonalizadoLucha;
import com.example.streetfighter.utils.Personaje;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GameActivity extends AppCompatActivity implements AdapterRecycler.OnPersonajeRecycler {
    private RecyclerView recyclerView;
    private ArrayList<Personaje> listaPersonajes;
    private AdapterRecycler adapterRecycler;
    private ImageView imageView1,imageView2;
    private Drawable imagenAux;
    private Button boton1;
    private ArrayList<Personaje> listaPersonajesLucha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        instancias();
        rellenarListas();
        asociarElementos();
        acciones();
    }

    public void instancias() {
        recyclerView = findViewById(R.id.recyclerView);
        imageView1 = findViewById(R.id.imageViewPlayer1);
        imageView2 = findViewById(R.id.imageViewPlayer2);
        boton1 = findViewById(R.id.botonJugar);
        listaPersonajes = new ArrayList<>();
        listaPersonajesLucha = new ArrayList<>();
        adapterRecycler = new AdapterRecycler(listaPersonajes, GameActivity.this);
        imageView2.setScaleX(-1);
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

        if (imageView1.getDrawable()==null) {
            imageView1.setImageResource(personaje.getImagen());
            listaPersonajesLucha.add(personaje);
        } else if (imageView2.getDrawable()==null){
            imageView2.setImageResource(personaje.getImagen());
            listaPersonajesLucha.add(personaje);
        } else if(imageView1.getDrawable()!=null && imageView2.getDrawable()!=null){
            imagenAux = imageView1.getDrawable();
            imageView1.setImageResource(personaje.getImagen());
            imageView2.setImageDrawable(imagenAux);
            listaPersonajesLucha.remove(1);
            listaPersonajesLucha.add(0,personaje);
        }







    }

    @Override
    public void onPersonajeInformacion(Personaje personaje) {
        DialogoPersonalizado dialogoPersonalizado = DialogoPersonalizado.newInstance(personaje.getImagen(),personaje.getNombre(),personaje.getPoder());
        dialogoPersonalizado.show(getSupportFragmentManager(),"personalizado");
    }

    public void acciones() {
        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogoPersonalizadoLucha dialogoPersonalizadoLucha = DialogoPersonalizadoLucha.newInstance(listaPersonajesLucha.get(0).getImagen(), listaPersonajesLucha.get(1).getImagen());
                dialogoPersonalizadoLucha.show(getSupportFragmentManager(), "personalizado2");
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(getApplicationContext(), FightActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("Personaje",listaPersonajesLucha.get(0));
                        startActivity(intent);
                        finish();
                    }
                }, 2000);

            }
        });
    }




}