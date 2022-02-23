package com.example.proyectofinalandroid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button btnIniciarSesion, btnRegistrarUsuario;
    private EditText editTextUsuario, editTextPassword;
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


    }


    public void instancias() {
        firebaseDatabase = FirebaseDatabase.getInstance("https://proyectofinalandroid-e85b0-default-rtdb.firebaseio.com/");
        mAuth = FirebaseAuth.getInstance();
        btnIniciarSesion = findViewById(R.id.botonIniciarSesion);
        btnRegistrarUsuario = findViewById(R.id.botonRegistrarUsuario);
        editTextUsuario = findViewById(R.id.editTextUsuario);
        editTextPassword = findViewById(R.id.editTextPassword);

    }

    public void acciones() {
        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signInWithEmailAndPassword(editTextUsuario.getText().toString(), editTextPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            Toast.makeText(getApplicationContext(),"Bienvenido "+editTextUsuario.getText().toString(),Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), InicioSesion.class);
                            intent.putExtra("Usuario",editTextUsuario.getText().toString());
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuario no encontrado", Toast.LENGTH_LONG).show();
                        }
                    }
                });
            }

        });
        btnRegistrarUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.createUserWithEmailAndPassword(editTextUsuario.getText().toString(), editTextPassword.getText().toString())
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(getApplicationContext(), "usuario registrado", Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    //Toast.makeText(getApplicationContext(), user.getUid(), Toast.LENGTH_SHORT).show();
                                    Log.v("firebase_prueba", user.getUid());
                                    // DIALOGO ¿QUIERES INICIAR SESION?
                                    // SI
                                    //updateGUI(mAuth.getCurrentUser().getUid());



                                } else {
                                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_SHORT).show();
                                    Log.v("firebase_prueba", task.getException().getMessage());

                                }
                            }
                        });
            }
        });

    }

    public void updateGUI(String uuid) {
        // hago las acciones para un usuario logeado
    }


}