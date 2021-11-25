package com.example.cartas;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Game extends AppCompatActivity implements View.OnClickListener {

    private ImageButton btn_up, btn_down;
    private ImageView imagen;
    private int[] cartas;
    private int numeroActual, numeroFuturo,aciertos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        instanciar();
        acciones();
    }

    private void acciones(){
        btn_up.setOnClickListener(this);
        btn_down.setOnClickListener(this);

    }

    private void instanciar() {
        btn_up = findViewById(R.id.btn_up);
        btn_down = findViewById(R.id.btn_down);
        imagen = findViewById(R.id.imagenCarta);
        cartas = new int[]{
                R.drawable.c1, R.drawable.c2, R.drawable.c3, R.drawable.c4, R.drawable.c5, R.drawable.c6, R.drawable.c7, R.drawable.c8,
                R.drawable.c9, R.drawable.c10, R.drawable.c11, R.drawable.c12, R.drawable.c12, R.drawable.c13};

        numeroActual = (int) (Math.random()*13);
        imagen.setImageResource(cartas[numeroActual]);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_down:
                numeroFuturo = (int) (Math.random()*13);
                if (numeroActual>numeroFuturo){
                    aciertos++;
                    numeroActual = numeroFuturo;
                    imagen.setImageResource(cartas[numeroActual]);
                }else if(numeroActual==numeroFuturo){
                    Toast.makeText(getApplicationContext(), "Carta Igual", Toast.LENGTH_SHORT).show();
                    imagen.setImageResource(cartas[numeroActual]);
                }else{
                    Intent intent = new Intent();
                   // Log.v("error", String.valueOf(aciertos));
                    intent.putExtra("Record",aciertos);
                    setResult(1,intent);
                    finish();
                }
                break;
            case R.id.btn_up:
                numeroFuturo = (int) (Math.random()*13);
                if (numeroActual<numeroFuturo){
                    aciertos++;
                    numeroActual = numeroFuturo;
                    imagen.setImageResource(cartas[numeroActual]);
                } else if(numeroActual==numeroFuturo){
                    Toast.makeText(getApplicationContext(), "Carta Igual", Toast.LENGTH_SHORT).show();
                    imagen.setImageResource(cartas[numeroActual]);
                }else{
                    Intent intent = new Intent();
                   // Log.v("error",String.valueOf(aciertos));
                    intent.putExtra("Record",aciertos);
                    setResult(1,intent);
                    finish();
                }
                break;



        }
    }


}
