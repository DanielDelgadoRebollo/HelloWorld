package com.example.nuevoproyecto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{

    private ToggleButton toggle;
    private TextView textoToggle,textoCheckbox,textoGroup;
    private CheckBox checkBox;
    private RadioGroup radioGroup;
    private EditText editText;
    private Button btnComprobar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciar();
        iniciarElementos();
        acciones();
    }

    private void acciones() {
        toggle.setOnCheckedChangeListener(this);
        checkBox.setOnCheckedChangeListener(this);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
               /* switch (checkedId){
                    case R.id.radioUno:
                        textoGroup.setText("Radio Uno");
                        break;
                    case R.id.radioDos:
                        textoGroup.setText("Radio dos");
                        break;
                    case R.id.radioTres:
                        textoGroup.setText("Radio Tres");
                        break;
                }

                */

                RadioButton bAux = findViewById(checkedId);
                textoGroup.setText(bAux.getText());
            }
        });

        btnComprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }

    private void instanciar() {
        toggle = findViewById(R.id.toggle_button);
        textoToggle = findViewById(R.id.texto_toggle);
        checkBox = findViewById(R.id.checkbox_text);
        textoCheckbox = findViewById(R.id.texto_checkbox);
        radioGroup = findViewById(R.id.radiogroup);
        textoGroup = findViewById(R.id.textoGrupoRadio);
        editText = findViewById(R.id.editTexto);
        btnComprobar = findViewById(R.id.btnComprobar);
    }

    private void iniciarElementos(){
        toggle.setChecked(true);
        checkBox.setChecked(true);
        textoToggle.setText("Pulsado");
        textoCheckbox.setText("Pulsado");
    }



    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case R.id.checkbox_text:
                if (isChecked){
                    textoCheckbox.setText("CheckBox" + getResources().getString(R.string.seleccionar));
                }else{
                    textoCheckbox.setText("Checkbox" + getResources().getString(R.string.deseleccionado));
                }
                break;
            case R.id.toggle_button:
                if (isChecked){
                    textoToggle.setText("Toggle"+ getResources().getString(R.string.seleccionar));
                }else{
                    textoToggle.setText("Toggle " +getResources().getString(R.string.deseleccionado));

                }
                checkBox.setEnabled(isChecked);
                break;
        }
    }


}