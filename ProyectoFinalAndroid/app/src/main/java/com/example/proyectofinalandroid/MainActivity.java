package com.example.proyectofinalandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button btnIniciarSesion,btnRegistrarUsuario;
    FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
        acciones();
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
    }


    public void instancias(){
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase = FirebaseDatabase.getInstance("https://proyectofinalandroid-e85b0-default-rtdb.firebaseio.com/");
        btnIniciarSesion = findViewById(R.id.botonIniciarSesion);
        btnRegistrarUsuario = findViewById(R.id.botonRegistrarUsuario);
    }

    public void acciones(){
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}