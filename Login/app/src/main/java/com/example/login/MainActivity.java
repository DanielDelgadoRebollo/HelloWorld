package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button login;
    private EditText user,pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        user = findViewById(R.id.user);
        pass = findViewById(R.id.password);
        login = findViewById(R.id.login);
    }

    public void logearse(View view) {
        Intent intent = new Intent(this,SegundaPantalla.class);
        String usuario = String.valueOf(user.getText());
        String password = String.valueOf(pass.getText());
        Context context = getApplicationContext();
        intent.putExtra("Usuario",usuario);
        intent.putExtra("Contraseña",password);
        if (password.equals("1234")) {
            startActivity(intent);
        }else{
            Toast.makeText(context, "CONTRASEÑA NO VALIDA", Toast.LENGTH_SHORT).show();
        }
    }
}