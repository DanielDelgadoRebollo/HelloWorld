package com.example.proyectofinalandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectofinalandroid.FragmentsFutbol.FragmentEquipos;
import com.google.android.material.navigation.NavigationView;

public class InicioSesion extends AppCompatActivity {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private TextView textView;
    private Spinner spinner;

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
        spinner = findViewById(R.id.spinner_header_nav);

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
                switch (item.getItemId()){
                    case R.id.menu_nav_espania:
                        Toast.makeText(getApplicationContext(),"España", Toast.LENGTH_LONG).show();
                        fragmentTransaction.replace(R.id.sitio_fragment,new FragmentEquipos());
                        fragmentTransaction.commit();
                        break;
                    case R.id.menu_nav_francia:
                        Toast.makeText(getApplicationContext(),"Francia", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.menu_nav_inglaterra:
                        Toast.makeText(getApplicationContext(),"Inglaterra", Toast.LENGTH_LONG).show();
                        break;
                }

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}