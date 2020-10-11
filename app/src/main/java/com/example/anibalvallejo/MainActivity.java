package com.example.anibalvallejo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void irEjercicio(View elementoPulsado){
        int idPulsado = elementoPulsado.getId();
        Intent intent = null;

        if (idPulsado == R.id.b_ej1) {
            intent = new Intent(this, ej1.class);
        }else if(idPulsado == R.id.b_ej2){
            intent = new Intent(this, ej2.class);
        }
        else if(idPulsado == R.id.b_ej3){
            intent = new Intent(this, ej3.class);
        }
        else if(idPulsado == R.id.b_ej4){
            intent = new Intent(this, ej4.class);
        }
        else if(idPulsado == R.id.b_ej5){
            intent = new Intent(this, ej5.class);
        }
        else if(idPulsado == R.id.b_ej6){
            intent = new Intent(this, ej6.class);
        }
        else if(idPulsado == R.id.b_ej7){
            intent = new Intent(this, ej7.class);
        }
        else if(idPulsado == R.id.b_ej8){
            intent = new Intent(this, ej8.class);
        }
        else if(idPulsado == R.id.b_ej9){
            intent = new Intent(this, ej9.class);
        }
        else if(idPulsado == R.id.b_ej10){
            intent = new Intent(this, ej10.class);
        }
        startActivity(intent);


    }
}