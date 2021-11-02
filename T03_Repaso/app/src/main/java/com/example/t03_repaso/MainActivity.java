package com.example.t03_repaso;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button boton1,boton2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Traigo botones
        instancias();
        acciones();


    }

    public void instancias(){
        boton1 = this.findViewById(R.id.pulsar);
        boton2 = this.findViewById(R.id.pulsar_dos);
    }

    public void acciones(){
        boton1.setOnClickListener(this);
        boton2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.pulsar:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje_toast)+ " b1 ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.pulsar_dos:
                Toast.makeText(getApplicationContext(),getResources().getString(R.string.mensaje_toast)+ " b2 ", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}