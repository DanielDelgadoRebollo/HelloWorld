package com.example.t03_repaso;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.t03_repaso.utils.Persona;

public class MainActivity2 extends AppCompatActivity  implements View.OnClickListener {

    private EditText edit_nombre,edit_apellido,edit_telefono;
    private CheckBox check_experiencia;
    private Button boton_datos;
    private ImageView imagen_experiencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        instancias();
        acciones();
    }

    private void acciones() {
        boton_datos.setOnClickListener(this);
    }

    private void instancias(){
        edit_nombre = findViewById(R.id.edit_nombre);
        edit_apellido = findViewById(R.id.edit_apellido);
        edit_telefono = findViewById(R.id.edit_telefono);
        check_experiencia = findViewById(R.id.check_experiencia);
        boton_datos = findViewById(R.id.boton_datos);
        imagen_experiencia = findViewById(R.id.imagenExperiencia);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==0){
            Log.v("Test","Arrancado con experiencia");
        }else if(resultCode==1){
              imagen_experiencia.setImageResource(R.drawable.noex);
        }else{
            imagen_experiencia.setImageResource(R.drawable.siex);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton_datos:
                if (!edit_nombre.getText().toString().isEmpty() && !edit_apellido.getText().toString().isEmpty() && !edit_telefono.getText().toString().isEmpty()){
                    String nombre = edit_nombre.getText().toString();
                    String apellido = edit_apellido.getText().toString();
                    int telefono = Integer.parseInt(edit_telefono.getText().toString());
                    boolean experiencia = check_experiencia.isChecked();
                    Persona persona = new Persona(nombre,apellido,telefono,experiencia);
                    Toast.makeText(getApplicationContext(), nombre+apellido+telefono+experiencia, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(),MainActivity3.class);
                    intent.putExtra("persona",persona);
                    /*intent.putExtra("nombre",nombre);
                    intent.putExtra("apellido",apellido);
                    intent.putExtra("telefono",telefono);
                    intent.putExtra("experiencia",experiencia);
                    startActivity(intent);

                     */
                    if (experiencia) {
                        startActivityForResult(intent, 1);
                    } else{
                        startActivityForResult(intent, 2);
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "Faltan datos", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}