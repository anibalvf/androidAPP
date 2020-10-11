package com.example.anibalvallejo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.IllegalFormatCodePointException;

public class ej4 extends AppCompatActivity {
    long num = 0;
    Integer ids[] = new Integer[]{
            R.id.calb0,R.id.calb1,R.id.calb2,R.id.calb3,R.id.calb4,R.id.calb5,R.id.calb6,R.id.calb7,R.id.calb8,R.id.calb9,R.id.calbA,R.id.calbB,
            R.id.calbC,R.id.calbD,R.id.calbF
    };
    //ids pantalla
    Integer idsPantalla[]= new Integer[]{
            R.id.caltextBin,R.id.caltextOCT,R.id.caltextDec,R.id.caltextHex,
            R.id.calBin,R.id.calOCT,R.id.calDec,R.id.calHex
    };

    int base = 10;

    TextView pantallaHex,pantallaDec,pantallaOCT,pantallaBin;
    TextView nombrehex,nombredec,nombreoct,nombrebin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej4);
        pantallaOCT = (TextView) findViewById(R.id.calOCT);
        pantallaBin = (TextView) findViewById(R.id.calBin);
        pantallaDec = (TextView) findViewById(R.id.calDec);
        pantallaHex = (TextView) findViewById(R.id.calHex);

        nombrebin = (TextView) findViewById(R.id.caltextBin);
        nombrehex = (TextView) findViewById(R.id.caltextHex);
        nombredec = (TextView) findViewById(R.id.caltextDec);
        nombreoct = (TextView) findViewById(R.id.caltextOCT);

        actualizarPantalla();

        for (int i =0;i<ids.length;i++){
            Button b = (Button) findViewById(ids[i]);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pulsarTecla(v);
                }
            });

        }

        for(int i = 0; i<idsPantalla.length;i++){
            TextView t = (TextView) findViewById(idsPantalla[i]);
            t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cambiarBase(v);
                }
            });
        }

        actualizarPantallaSeleccionada(base,0);
        desactivarBotones();


    }

    public void actualizarPantalla(){
        nombrebin.setText(Long.toBinaryString(num));
        nombreoct.setText(Long.toOctalString(num));
        nombrehex.setText(Long.toHexString(num));
        nombredec.setText(Long.toString(num));
    }
    public void actualizarPantallaSeleccionada(int base, int antiguaBase){

        for (int i = 0;i<idsPantalla.length;i++){
            TextView tv = (TextView) findViewById(idsPantalla[i]);
            tv.setBackgroundResource(R.color.colorNoseleccionado);
           // tv.setPaintFlags();
        }

        if (base ==2){
            nombrebin.setBackgroundResource(R.color.colorseleccionado);
            pantallaBin.setPaintFlags(pantallaBin.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        }else if(base == 8){
            nombreoct.setBackgroundResource(R.color.colorseleccionado);
            pantallaOCT.setPaintFlags(pantallaOCT.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }else if (base == 10){
            nombredec.setBackgroundResource(R.color.colorseleccionado);
            pantallaDec.setPaintFlags(pantallaDec.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }else if (base == 16){
            nombrehex.setBackgroundResource(R.color.colorseleccionado);
            pantallaHex.setPaintFlags(pantallaHex.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        }




    }
    public void cambiarBase(View v){
        int id= v.getId();
        int antiguaBase = base;

        if (id == idsPantalla[0]|| id == idsPantalla[4]){
            base = 2;
        } else if (id == idsPantalla[1]|| id == idsPantalla[5]){
            base = 8;
        } else if (id == idsPantalla[2]|| id == idsPantalla[6]){
            base = 10;
        } else if (id == idsPantalla[3]|| id == idsPantalla[7]){
            base = 16;
        }
        actualizarPantallaSeleccionada(base,antiguaBase);

    }
    public void desactivarBotones(){

    }
    public void pulsarTecla(View v){

    }













}