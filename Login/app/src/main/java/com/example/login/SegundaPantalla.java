package com.example.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaPantalla extends AppCompatActivity {
    private Button button1,button2;
    private EditText txt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_pantalla);
        button1 = findViewById(R.id.foto);
        button2 = findViewById(R.id.volver);
        txt1 = findViewById(R.id.personaObtenida);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        String message = extra.getString("Usuario");
        txt1.setText(message);
    }

    public void volver(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
