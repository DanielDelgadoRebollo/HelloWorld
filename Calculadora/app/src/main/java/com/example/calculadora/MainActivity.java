package com.example.calculadora;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView;
    Button btnCero, btnUno, btnDos, btnTres, btnCuatro, btnCinco, btnSeis, btnSiete, btnOcho, btnNueve, btnSuma, btnResta, btnDivision, btnMultiplicacion, btnIgual, btnBorrar, btnPorcentaje, btnMasMenos, btnComa
            ,btnSin,btnCos,btnTan,btnLn;
    int valorUno = 0, valorDos = 0;
    char c = 'a';
    private Double varAux, resultadoDouble;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        instanciar();
        accion();

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            accionesHorizontal();
        }
    }


        public void accionesHorizontal() {
            btnSin.setOnClickListener(this);
            btnCos.setOnClickListener(this);
            btnTan.setOnClickListener(this);
            btnLn.setOnClickListener(this);
    }

    public void instanciar() {
        textView = findViewById(R.id.textView);
        btnCero = findViewById(R.id.btnCero);
        btnUno = findViewById(R.id.btnUno);
        btnDos = findViewById(R.id.btnDos);
        btnTres = findViewById(R.id.btnTres);
        btnCuatro = findViewById(R.id.btnCuatro);
        btnCinco = findViewById(R.id.btnCinco);
        btnSeis = findViewById(R.id.btnSeis);
        btnSiete = findViewById(R.id.btnSiete);
        btnOcho = findViewById(R.id.btnOcho);
        btnNueve = findViewById(R.id.btnNueve);
        btnSuma = findViewById(R.id.btnSuma);
        btnResta = findViewById(R.id.btnResta);
        btnMultiplicacion = findViewById(R.id.btnMultiplicar);
        btnDivision = findViewById(R.id.btnDividir);
        btnComa = findViewById(R.id.btnComa);
        btnPorcentaje = findViewById(R.id.btnPorcentaje);
        btnBorrar = findViewById(R.id.btnBorrar);
        btnMasMenos = findViewById(R.id.btnMasMenos);
        btnIgual = findViewById(R.id.btnIgual);
        btnSin = findViewById(R.id.btnSin);
        btnCos = findViewById(R.id.btnCos);
        btnTan = findViewById(R.id.btnTan);
        btnLn = findViewById(R.id.btnLn);

    }

    public void accion() {
        btnCero.setOnClickListener(this);
        btnUno.setOnClickListener(this);
        btnDos.setOnClickListener(this);
        btnTres.setOnClickListener(this);
        btnCuatro.setOnClickListener(this);
        btnCinco.setOnClickListener(this);
        btnSeis.setOnClickListener(this);
        btnSiete.setOnClickListener(this);
        btnOcho.setOnClickListener(this);
        btnNueve.setOnClickListener(this);
        btnSuma.setOnClickListener(this);
        btnResta.setOnClickListener(this);
        btnMultiplicacion.setOnClickListener(this);
        btnDivision.setOnClickListener(this);
        btnBorrar.setOnClickListener(this);
        btnIgual.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnUno:
                textView.setText(textView.getText() + "1");
                break;
            case R.id.btnDos:
                textView.setText(textView.getText() + "2");
                break;
            case R.id.btnTres:
                textView.setText(textView.getText() + "3");
                break;
            case R.id.btnCuatro:
                textView.setText(textView.getText() + "4");
                break;
            case R.id.btnCinco:
                textView.setText(textView.getText() + "5");
                break;
            case R.id.btnSeis:
                textView.setText(textView.getText() + "6");
                break;
            case R.id.btnSiete:
                textView.setText(textView.getText() + "7");
                break;
            case R.id.btnOcho:
                textView.setText(textView.getText() + "8");
                break;
            case R.id.btnNueve:
                textView.setText(textView.getText() + "9");
                break;
            case R.id.btnCero:
                textView.setText(textView.getText() + "0");
                break;
            case R.id.btnSuma:
                valorUno = Integer.parseInt(String.valueOf(textView.getText()));
                textView.setText("");
                c = '+';
                break;
            case R.id.btnResta:
                valorUno = Integer.parseInt(String.valueOf(textView.getText()));
                textView.setText("");
                c = '-';
                break;
            case R.id.btnMultiplicar:
                valorUno = Integer.parseInt(String.valueOf(textView.getText()));
                textView.setText("");
                c = '*';
                break;
            case R.id.btnDividir:
                valorUno = Integer.parseInt(String.valueOf(textView.getText()));
                textView.setText("");
                c = '/';
                break;
            case R.id.btnBorrar:
                textView.setText("");
                break;
            case R.id.btnIgual:

                    if (c == '+') {
                        valorDos = Integer.parseInt(String.valueOf(textView.getText()));
                        textView.setText(String.valueOf(valorUno + valorDos));
                    } else if (c == '-') {
                        valorDos = Integer.parseInt(String.valueOf(textView.getText()));
                        textView.setText(String.valueOf(valorUno - valorDos));
                    } else if (c == '*') {
                        valorDos = Integer.parseInt(String.valueOf(textView.getText()));
                        textView.setText(String.valueOf(valorUno * valorDos));
                    } else if (c == '/') {
                        valorDos = Integer.parseInt(String.valueOf(textView.getText()));
                        textView.setText(String.valueOf(valorUno / valorDos));
                    }
                    break;
            case R.id.btnSin:
                varAux = Double.parseDouble(textView.getText().toString());
                resultadoDouble = Math.sin(varAux);
                double redondear = Math.round(resultadoDouble * 1000.0) / 1000.0;
                textView.setText(redondear + "");
                break;
            case R.id.btnCos:
                varAux = Double.parseDouble(textView.getText().toString());
                resultadoDouble = Math.cos(varAux);
               redondear = Math.round(resultadoDouble * 1000.0) / 1000.0;
                textView.setText(redondear + "");
                break;
            case R.id.btnLn:
                varAux = Double.parseDouble(textView.getText().toString());
                resultadoDouble = Math.log(varAux);
                redondear = Math.round(resultadoDouble * 1000.0) / 1000.0;
                textView.setText(redondear + "");
                break;
            case R.id.btnTan:
                varAux = Double.parseDouble(textView.getText().toString());
                resultadoDouble = Math.tan(varAux);
                redondear = Math.round(resultadoDouble * 1000.0) / 1000.0;
                textView.setText(redondear + "");

                break;
        }
    }
}
