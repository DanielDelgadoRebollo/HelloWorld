package com.example.proyectofinalandroid;

import androidx.annotation.NonNull;
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

import org.json.JSONObject;

import java.util.ArrayList;

public class InicioSesion extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView textView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);
        instancias();
        configurarToolbar();
        acciones();


    }

    private void instancias() {
        toolbar = findViewById(R.id.toolbar);
        textView = findViewById(R.id.textview_letra_header_nav);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);

    }

    private void configurarToolbar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("THEDBSPORTS");
    }

    public void acciones(){
        String valor = getIntent().getExtras().getString("Usuario");
        //textView.setText(String.valueOf(valor.charAt(0)));
        //Log.v("valor", String.valueOf(valor.charAt(0)));
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                String urlSpain ="https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=Spain";
                String urlFrance ="https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=France";
                String urlEngland ="https://www.thesportsdb.com/api/v1/json/2/search_all_teams.php?s=Soccer&c=England";
                switch (item.getItemId()){
                    case R.id.menu_nav_espania:
                        Toast.makeText(getApplicationContext(),"España", Toast.LENGTH_LONG).show();
                        fragmentTransaction.replace(R.id.sitio_fragment,FragmentEquipos.newInstance(urlSpain));
                        fragmentTransaction.commit();
                        break;
                    case R.id.menu_nav_francia:
                        Toast.makeText(getApplicationContext(),"Francia", Toast.LENGTH_LONG).show();
                        fragmentTransaction.replace(R.id.sitio_fragment,FragmentEquipos.newInstance(urlFrance));
                        fragmentTransaction.commit();
                        break;
                    case R.id.menu_nav_inglaterra:
                        Toast.makeText(getApplicationContext(),"Inglaterra", Toast.LENGTH_LONG).show();
                        fragmentTransaction.replace(R.id.sitio_fragment,FragmentEquipos.newInstance(urlEngland));
                        fragmentTransaction.commit();
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }


}