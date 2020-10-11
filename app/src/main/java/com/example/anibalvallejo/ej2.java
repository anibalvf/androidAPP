package com.example.anibalvallejo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class ej2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej2);
    }

    public void calcular(View elementoPulsado){
        Button b = (Button) elementoPulsado;
        int binarioInt,resultadoDecimal;
        String binario;

        TextView tv = (TextView)findViewById(R.id.textViewResultado);
        TextInputEditText ti = (TextInputEditText) findViewById(R.id.EntradaBinario);

        binario = ti.getText().toString();


        //si es binario entra si no else
        if (!binario.isEmpty()) {
            binarioInt = Integer.parseInt(binario);
            if (esBinario(binarioInt)) {

                resultadoDecimal = binarioAEntero(binarioInt);
                tv.setVisibility(View.VISIBLE);

                tv.setText("" + resultadoDecimal);

            } else {
                tv.setVisibility(View.VISIBLE);

                tv.setText("Introduce un numero binario");
            }
        }else{
            tv.setVisibility(View.VISIBLE);
            tv.setText("Introude algo para comprobar");
        }

    }

    //comprobar si es binario o no
    public boolean esBinario(int aux){
        boolean res = true;
        int digito;

        while (aux != 0) {
            digito = aux % 10;
            if (digito != 0 && digito != 1) {
                res = false;
            }
            aux = aux / 10;
        }

        return res;
    }

    //pasar de binario a entero
    public int binarioAEntero(int aux){
        int digito,decimal;
        int exponente = 0;
        decimal = 0;

        while (aux != 0) {
            //se toma la última cifra
            digito = aux % 10;
            //se multiplica por la potencia de 2 correspondiente y se suma al número
            decimal = decimal + digito * (int) Math.pow(2, exponente);
            //se aumenta el exponente
            exponente++;
            //se quita la última cifra para repetir el proceso
            aux = aux / 10;
        }

        return decimal;
    }

}