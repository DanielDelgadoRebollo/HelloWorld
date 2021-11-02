package com.example.myapplication;

import static com.example.myapplication.MainActivity.MENSAJE;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SegundaActividad extends AppCompatActivity {
    private Button button2;
    private EditText txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_activity);
        button2 = findViewById(R.id.button2);
        txt2 = findViewById(R.id.texto2);
        Intent intent = getIntent();
        Bundle extra = intent.getExtras();
        String message = extra.getString(MENSAJE);
        txt2.setText(message);
    }

    public void volver(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
