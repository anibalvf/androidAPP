package com.example.anibalvallejo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class ej10 extends AppCompatActivity {

    int[][] tableroID = new int[][]{
            {R.id.pos0, R.id.pos1, R.id.pos2, R.id.pos3, R.id.pos4, R.id.pos5},
            {R.id.pos6, R.id.pos7, R.id.pos8, R.id.pos9, R.id.pos10, R.id.pos11},
            {R.id.pos12, R.id.pos13, R.id.pos14, R.id.pos15, R.id.pos16, R.id.pos17},
            {R.id.pos18, R.id.pos19, R.id.pos20, R.id.pos21, R.id.pos22, R.id.pos23},
            {R.id.pos24, R.id.pos25, R.id.pos26, R.id.pos27, R.id.pos28, R.id.pos29},
            {R.id.pos30, R.id.pos31, R.id.pos32, R.id.pos33, R.id.pos34, R.id.pos35},
            {R.id.pos36, R.id.pos37, R.id.pos38, R.id.pos39, R.id.pos40, R.id.pos41},
            {R.id.pos42, R.id.pos43, R.id.pos44, R.id.pos45, R.id.pos46, R.id.pos47},
            {R.id.pos48, R.id.pos49, R.id.pos50, R.id.pos51, R.id.pos52, R.id.pos53},
            {R.id.pos54, R.id.pos55, R.id.pos56, R.id.pos57, R.id.pos58, R.id.pos59},
    };
    int[][] tablero = new int[tableroID.length][tableroID[0].length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej10);
        iniciarTablero();
    }

        // el agua sera la 0, los barcos la 1, los barcos tocados la 2
    public void iniciarTablero() {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length;j++) {
                tablero[i][j] = 0;
            }
        }
        ponerBarcos();
    }

    public void ponerBarcos(){
        //1 barco de 4
        ponerBarcosxd(4,1);
        //2 barcos de 3
        ponerBarcosxd(3,2);
        ponerBarcosxd(3,2);
        //3 barcos de 2
        ponerBarcosxd(2,3);
        ponerBarcosxd(2,3);
        ponerBarcosxd(2,3);
        //4 barcos de 1
        ponerBarcosxd(1,4);
        ponerBarcosxd(1,4);
        ponerBarcosxd(1,4);
        ponerBarcosxd(1,4);



    }

    public void ponerBarcosxd(int largura, int id){
        Random r = new Random();
        //alea hace referencia a si va a estar puesto de manera vertical 1 u horizontal 2
        int alea;
        //posiciones de la matriz que sacare aleatorias
        int x =0;
        int j = 0;
        //para saber cuando ha finalizado la busqueda de ponerlo aleatorio
        boolean fin = false;
        //genero si sera horizontal o vertical
        alea = r.nextInt(2);
        // si es vertical
        if (alea== 1){
            //bucle para buscar posiciones hasta que sea posible colocarlo
            while(!fin){
                //genero una posicion de x que hace referencia a la fila de la matriz y una j que hace referencia a la columna
                x= r.nextInt(tablero.length);
                j= r.nextInt(tablero[0].length);

                //contador para comprobar que al menos el espacio es de 4 para poder colocarse de manera vertical
                int contador = 0;
                //contador que comprueba las posiciones si estan ya ocupadas o si no (si esta a 0 no se encontraron conflictos)
                int cont =0;
                int ve = 0;
                //el bucle empieza en la fila que he generado anterior mente aleatoriamente
                int cn =0;
                int i =x;
                while(cn<4 && i<tablero.length){
                    //hago que la columna no se mueva y solo se mueva la altura
                    if (tablero[i][j]==0){
                        //si encuentra posicion no servira
                    }else{
                        cont++;
                    }
                    cn++;
                    //aqui el contador cuenta las veces que se mueve la altura y al menos tendran que ser 4
                    contador++;
                    i++;
                }
                //compruebo que se ha movido al menos 4 veces y que no esta ocupado
                if(contador >= largura && cont==0){
                    int veces =largura;
                    while(veces>0){
                        tablero[x][j]=id;
                        x++;
                        veces--;
                    }
                    fin=true;
                }


            }
            //si es horizontal es igual solo que intercambiando la condicion de x por y
        }else{
            while(!fin){
                x= r.nextInt(tablero.length);
                j= r.nextInt(tablero[0].length);

                int contador = 0;
                int cont =0;

                int cn =0;
                int i =j;
                while(cn<4 && i<tablero[0].length){
                    //hago que la columna no se mueva y solo se mueva la altura
                    if (tablero[x][i]==0){
                        //si encuentra posicion no servira
                    }else{
                        cont++;
                    }
                    cn++;
                    //aqui el contador cuenta las veces que se mueve la altura y al menos tendran que ser 4
                    contador++;
                    i++;
                }
                if(contador >= largura && cont==0){
                    int veces =largura;
                    while(veces>0){
                        tablero[x][j]=id;
                        j++;
                        veces--;
                    }
                    fin=true;
                }
            }
        }
    }



    public void pulsarBoton(View elementoPulsado) {
        Button b = (Button) elementoPulsado;
        int ipos=0;
        int jpos=0;

        for (int i = 0; i < tableroID.length; i++) {
            for (int j = 0; j < tableroID[i].length; j++) {
                if (b.getId() == tableroID[i][j]) {
                    ipos = i;
                    jpos = j;
                }
            }
        }

        if (tablero[ipos][jpos]==0){
            b.setBackgroundResource(R.drawable.ocean);
            b.setText("");

        }else if(tablero[ipos][jpos]==1){
            b.setText("4");
        }
        else if(tablero[ipos][jpos]==2){
            b.setText("3");
        }
        else if(tablero[ipos][jpos]==3){
            b.setText("2");
        }
        else if(tablero[ipos][jpos]==4){
            b.setText("1");
        }



    }





}