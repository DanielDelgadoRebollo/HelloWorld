package com.example.proyectofinalandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofinalandroid.FragmentsFutbol.FragmentEquipos;
import com.example.proyectofinalandroid.utils.Equipo;
import com.google.android.material.navigation.NavigationView;
import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Locale;

public class InicioSesion extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView imageView;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private TextView textView,textView2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        instancias();
        configurarToolbar();
        configurarBarra();
        acciones();


    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        imageView = navigationView.getHeaderView(0).findViewById(R.id.imageViewCabecera);
        textView = navigationView.getHeaderView(0).findViewById(R.id.textViewCabecera);
        textView2 = navigationView.getHeaderView(0).findViewById(R.id.textViewUsuarioCabecera);

    }

    private void configurarToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("THEDBSPORTS");
    }

    public void acciones(){
        String valor = getIntent().getExtras().getString("Usuario");

        textView.setText(String.valueOf(valor.charAt(0)).toUpperCase(Locale.ROOT));
        textView2.setText(valor);

        //Log.v("valor", String.valueOf(valor.charAt(0)));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                String urlSpain ="https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";
                String urlFrance ="https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=France";
                String urlEngland ="https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=England";
                switch (item.getItemId()){
                    case R.id.menu_nav_espania:
                        Toast.makeText(getApplicationContext(),"España", Toast.LENGTH_LONG).show();
                        fragmentTransaction.replace(R.id.sitio_fragment,FragmentEquipos.newInstance(urlSpain));
                        imageView.setImageDrawable(getDrawable(R.drawable.spain));
                        break;
                    case R.id.menu_nav_francia:
                        Toast.makeText(getApplicationContext(),"Francia", Toast.LENGTH_LONG).show();
                        fragmentTransaction.replace(R.id.sitio_fragment,FragmentEquipos.newInstance(urlFrance));
                        imageView.setImageDrawable(getDrawable(R.drawable.france));
                        break;
                    case R.id.menu_nav_inglaterra:
                        Toast.makeText(getApplicationContext(),"Inglaterra", Toast.LENGTH_LONG).show();
                        fragmentTransaction.replace(R.id.sitio_fragment,FragmentEquipos.newInstance(urlEngland));
                        imageView.setImageDrawable(getDrawable(R.drawable.england));
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);

                fragmentTransaction.commit();
                return true;
            }
        });
    }
    private void configurarBarra() {
        this.setSupportActionBar(toolbar);
        actionBarDrawerToggle = new ActionBarDrawerToggle(InicioSesion.this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

    }

}