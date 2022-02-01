package com.example.elementosmaterial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.elementosmaterial.Fragments.FragmentDos;
import com.example.elementosmaterial.Fragments.FragmentUno;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity  {
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ImageView imageView;
    private Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_pref,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menupref_1:
                break;
            case R.id.menupref_2:
                break;
        }
        return true;
    }

    public void configurarToolbar(){

        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Nuevo titulo");
    }

    public void instancias(){
      toolbar = findViewById(R.id.toolbar);
      configurarToolbar();
      navigationView = findViewById(R.id.navigation_view);
      drawerLayout = findViewById(R.id.drawer_layout);
      imageView = navigationView.getHeaderView(0).findViewById(R.id.imageviewLetra);
      spinner = navigationView.getHeaderView(0).findViewById(R.id.spinnerNombre);
      ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,0,0);
      drawerLayout.addDrawerListener(actionBarDrawerToggle);
      actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        if (drawerLayout.isOpen()){
            drawerLayout.closeDrawer(GravityCompat.START);
        } else{
            if (getSupportFragmentManager().getBackStackEntryCount()==0){
                finish();
            }else{
                super.onBackPressed();
            }
        }
    }

    public void acciones(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                switch (item.getItemId()){
                    case R.id.menu_nav_op1:
                        Toast.makeText(getApplicationContext(), "Opcionpulsada", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.menu_nav_op2:
                        break;
                    case R.id.menu_nav_op3:
                        break;
                    case R.id.menu_nav_fragment1:
                        fragmentTransaction.replace(R.id.sitioFragment, new FragmentUno());
                        fragmentTransaction.commit();
                        break;
                    case R.id.menu_nav_fragment2:
                        fragmentTransaction.replace(R.id.sitioFragment, new FragmentDos());
                        fragmentTransaction.commit();
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }

        });
    }
}