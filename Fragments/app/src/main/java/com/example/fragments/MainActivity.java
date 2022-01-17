package com.example.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.fragments.fragments.FragmentDos;
import com.example.fragments.fragments.FragmentUno;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, FragmentUno.OnFragmentUno {

    private Button botonF1, botonF2, botonComprobar;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        initFragments();
        acciones();
    }

    public void instancias() {
        botonF1 = findViewById(R.id.boton_fragment1);
        botonF2 = findViewById(R.id.boton_fragment2);
        botonComprobar = findViewById(R.id.boton_comprobar);
    }

    public void initFragments(){
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno());
        fragmentTransaction.addToBackStack("f1");
        fragmentTransaction.commit();
    }

    public void acciones() {
        botonF1.setOnClickListener(this);
        botonF2.setOnClickListener(this);
        botonComprobar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        Log.v("fragments", String.valueOf(fragmentManager.getBackStackEntryCount()));

        switch (v.getId()) {

            case R.id.boton_fragment1:
                FragmentUno fragment1 = (FragmentUno) fragmentManager.findFragmentByTag("f1");
                if(fragment1 != null){
                    Log.v("f1","fragment encontrado");
                    fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno(),"f1");
                }else{
                fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno(),"f1");
                fragmentTransaction.addToBackStack("f1");}
                break;

            case R.id.boton_fragment2:
                FragmentDos fragment2 = (FragmentDos) fragmentManager.findFragmentByTag("f2");
                if(fragment2 != null){
                    Log.v("f2","fragment encontrado");
                    fragmentTransaction.replace(R.id.sitio_fragments, new FragmentUno(),"f2");
                }else{
                fragmentTransaction.replace(R.id.sitio_fragments, new FragmentDos(),"f2");
                fragmentTransaction.addToBackStack("f2");}
                break;

            case R.id.boton_comprobar:
               FragmentUno f1 = (FragmentUno) fragmentManager.findFragmentByTag("f1");
               FragmentDos f2 = (FragmentDos) fragmentManager.findFragmentByTag("f2");

                if(f1 != null){
                    Log.v("f1","fragment encontrado");
                }
                if(f2 != null){
                    Log.v("f2","fragment encontrado");
                }


                break;
        }
        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (getSupportFragmentManager().getBackStackEntryCount() == 0){
            finish();
        }
        Log.v("fragments","pulsado atrás");

    }

    @Override
    public void onDataSelected(String dato) {
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out);
        fragmentTransaction.replace(R.id.sitio_fragments, FragmentDos.newInstance(dato),"f2");
        if (fragmentManager.findFragmentByTag("f2")==null){
            fragmentTransaction.addToBackStack("f2");
        }
        fragmentTransaction.commit();

    }
}