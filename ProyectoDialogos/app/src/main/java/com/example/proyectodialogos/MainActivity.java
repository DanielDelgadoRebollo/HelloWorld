package com.example.proyectodialogos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.proyectodialogos.dialog.DialogoConfirmacion;
import com.example.proyectodialogos.dialog.DialogoInformacion;
import com.example.proyectodialogos.dialog.DialogoListas;
import com.example.proyectodialogos.dialog.DialogoPersonalizado;
import com.example.proyectodialogos.utils.Persona;

public class MainActivity extends AppCompatActivity implements DialogoPersonalizado.OnDialogoPersoListener {

    private TextView textNombre,textApellido;
    private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instancias();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return true;
    }

    public void instancias(){
        textNombre = findViewById(R.id.text_nombre);
        textApellido = findViewById(R.id.text_pass);
        editText = findViewById(R.id.editText);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_op1:
               // Toast.makeText(getApplicationContext(), "Opcion1", Toast.LENGTH_SHORT).show();
                DialogoInformacion dialogoInformacion = new DialogoInformacion();
                dialogoInformacion.show(getSupportFragmentManager(),"informacion");
                break;
            case R.id.menu_op2:
               // Toast.makeText(getApplicationContext(), "Opcion2", Toast.LENGTH_SHORT).show();
                DialogoConfirmacion dialogoConfirmacion = new DialogoConfirmacion();
                dialogoConfirmacion.show(getSupportFragmentManager(),"confirmacion");
                break;
            case R.id.menu_op3:
               // Toast.makeText(getApplicationContext(), "Opcion3", Toast.LENGTH_SHORT).show();DialogoListas dialogoListas = new DialogoListas();dialogoListas.show(getSupportFragmentManager(),"listas");
               // DialogoPersonalizado dialogoPersonalizado = new DialogoPersonalizado();
                DialogoPersonalizado dialogoPersonalizado = DialogoPersonalizado.newInstance(editText.getText().toString());
                dialogoPersonalizado.show(getSupportFragmentManager(),"personalizado");
                // String dato = editText.getText().toString();

                break;

        }
        return true;
    }

    @Override
    public void onPersonaSelected(Persona persona) {
        textNombre.setText(persona.getNombre());
        textApellido.setText(persona.getContrasenia());
    }
}