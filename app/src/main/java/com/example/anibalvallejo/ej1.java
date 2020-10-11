package com.example.anibalvallejo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class ej1 extends AppCompatActivity {
    public int contador = 0;
    public int numeroPintado = 0;
    public int[] tablero = new int[]{
            0, 0, 0,
            0, 0, 0,
            0, 0, 0
    };
    int[] listaID = new int[]{
            R.id.b0,R.id.b1,R.id.b2,R.id.b3,R.id.b4,R.id.b5,R.id.b6,R.id.b7,R.id.b8
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej1);
    }

    public boolean hayTresEnRaya() {
        boolean res = false;
        if (busquedaHorizontal(1) || busquedaVertical(1) || busquedaCruzada(1)) {
            res = true;
            TextView ganar = (TextView) findViewById(R.id.comprobacion);

            ganar.setText("HAS GANADO");
        }else if(busquedaHorizontal(-1) || busquedaVertical(-1) || busquedaCruzada(-1)){
            TextView ganar = (TextView) findViewById(R.id.comprobacion);
            ganar.setText("HAS PERDIDO");
            res= true;

        }else if (numeroPintado==9){
            TextView ganar = (TextView) findViewById(R.id.comprobacion);

            ganar.setText("EMPATE");
        }

        return res;
    }


    public boolean busquedaHorizontal(int x) {

        boolean res = false;
        for (int i = 0; i < 9; i = i + 3) {
            if (tablero[i] + tablero[i + 1] + tablero[i + 2] == 3*x) {
                int [] pos= new int[]{i,i+1,i+2};
                res = true;
                Button b;
                if (3*x == 3){
                    imangenVerdeRojo(pos, true);
                }else{
                    imangenVerdeRojo(pos, false);
                }
            }
        }

        return res;
    }

    public boolean busquedaVertical(int x) {
        boolean res = false;
        for (int i = 0; i < 3; i++) {
            if (tablero[i] + tablero[i + 3] + tablero[i + 6] == 3*x) {
                res = true;
                Button b;
                int [] pos= new int[]{i,i+3,i+6};
                if (3*x == 3){

                    imangenVerdeRojo(pos, true);

                }
                else{
                    imangenVerdeRojo(pos, false);

                }

            }
        }


        return res;
    }

    public boolean busquedaCruzada(int x) {
        boolean res = false;
        int [] pos;
        if (tablero[0] + tablero[4] + tablero[8] == 3*x) {
            res = true;
            Button b;
            pos = new int[]{0,4,8};
            if (3*x == 3){
                imangenVerdeRojo(pos, true);
            }else{
                imangenVerdeRojo(pos, false);
            }
        } else if (tablero[2] + tablero[4] + tablero[6] == 3*x) {
            res = true;
            Button b;
            pos = new int[]{2,4,6};
            if (3*x == 3){
                imangenVerdeRojo(pos, true);
            }
            else{
                imangenVerdeRojo(pos, false);
            }
        }

        return res;
    }
    // metodo para que pinte en verde o en rojo la linea de 3 que ha ganado
    public void imangenVerdeRojo(int[] x, boolean quien){
       Button b;
        if (quien){
            for(int i = 0; i<x.length; i++){
                b=(Button)findViewById(listaID[x[i]]);
                b.setBackgroundResource(R.drawable.cruzganadora);
            }
        }else{
            for(int i = 0; i<x.length; i++){
                b=(Button)findViewById(listaID[x[i]]);
                b.setBackgroundResource(R.drawable.circuloganadorrojo);
            }
        }
    }


    public void dibujarX(View elementoPulsado) {
        Button b = (Button) elementoPulsado;

        //para sacar el texto del id
        String resourceName = elementoPulsado.getResources().getResourceName(elementoPulsado.getId());
        //para quitar lo que no queremos del id
        String[] partesID = resourceName.split("/");
        // nos quedamos con el id final
        String idfinal = partesID[1];
        //le quitamos la primera letra al id y lo transformamos en int!!!!
        int idSoloNumero = Integer.parseInt(idfinal.substring(1));

        //comprobamos que no este ya cogida la posicion
        if (!hayTresEnRaya()) {
            if (tablero[idSoloNumero] == 0) {
                tablero[idSoloNumero] = 1;


                b.setBackgroundResource(R.drawable.cruz1);
                numeroPintado++;
                if (numeroPintado < 9 && !hayTresEnRaya()) {
                    dibujarIa();
                }
            }
        }

        hayTresEnRaya();

    }


    public void dibujarIa() {
        // hago que la ia coloque aleatoriamente donde no haya ya una x
        Random r = new Random();
        numeroPintado++;
        int valorDado = 0;
        while (tablero[valorDado] != 0) {
            valorDado = r.nextInt(9);
        };

        tablero[valorDado] = -1;
        Button b= (Button) findViewById(listaID[valorDado]);
        b.setBackgroundResource(R.drawable.circulo1);

    }

    public void reiniciarPartida(View elementoPulsado) {
        //reinicio el array del tablero
        Button bx = (Button) findViewById(R.id.button23);
        for (int i = 0; i <= 8; i++) {
            tablero[i] = 0;
        }
        //reinicio de los botones
        Button resetButton1;
        for (int i=0; i<listaID.length;i++){
            resetButton1=(Button)findViewById(listaID[i]);
            resetButton1.setBackgroundResource(android.R.drawable.btn_default);
        }
        //reinicio los contadores y sumo el numero de partidas
        contador += 1;
        numeroPintado = 0;
        TextView sumar = (TextView) findViewById(R.id.contadorPartidas);
        String contadorString = "" + contador;
        sumar.setText(contadorString);
        TextView ganar = (TextView) findViewById(R.id.comprobacion);
        ganar.setText("");
    }



}