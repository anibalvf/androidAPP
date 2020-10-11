package com.example.anibalvallejo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ej3 extends AppCompatActivity {
    public String[][] matrizOP=new String[][]{{"opearionsumar","#"},{"operacionrestar","-"},{"opearionmultiplicar","x"},{"operaciondividir","/"}};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ej3);
    }

    public void recogerNumeros(View elementoPulsado){
        //para sacar el texto del id
        String resourceName = elementoPulsado.getResources().getResourceName(elementoPulsado.getId());
        //para quitar lo que no queremos del id
        String[] partesID = resourceName.split("/");
        // nos quedamos con el id final
        String idfinal = partesID[1];
        //le quitamos la primera letra al id y lo transformamos en int!!!!
        // int idSoloNumero = Integer.parseInt(idfinal.substring(6)); // por si hace falta el numero

        TextView tv = (TextView) findViewById(R.id.textView4);
        //String colocar =""+idSoloNumero;
        String nuevoTexto = idfinal.substring(6);
        String almacen = tv.getText().toString();

        if (almacen.equals("0")){
            tv.setText(nuevoTexto);

        }else {
            tv.setText(almacen + nuevoTexto);
        }

    }



    public void cdecero(View elementoPulsado){
        TextView tv =(TextView) findViewById(R.id.textView4);
        tv.setText("0");
    }

    public void borrarUltimo (View elementoPulsado){
        TextView tv =(TextView) findViewById(R.id.textView4);
        String borrar = tv.getText().toString();
        if (borrar.length()>1) {
            tv.setText(borrar.substring(0, borrar.length() - 1));
        }else{
            tv.setText("0");
        }
    }

    public void punto(View elementoPulsado){
        TextView tv =(TextView) findViewById(R.id.textView4);
        String almacen = tv.getText().toString();
        if (!almacen.contains(".")) {

            tv.setText(tv.getText().toString() + ".");
        }

    }

    public void operador(View elementoPulsado){
        TextView tv =(TextView) findViewById(R.id.textView4);
        String almacen = tv.getText().toString();
        if (!comprobar(almacen)){
           String res = quitarTag(elementoPulsado);
            tv.setText(almacen+res);
        }

    }

    public String quitarTag(View elementoPulsado){
        String res ="";
        String resourceName = elementoPulsado.getResources().getResourceName(elementoPulsado.getId());
        String[] partesID = resourceName.split("/");
        String  idFinal= partesID[1];

        for (int i=0;i<matrizOP.length;i++){
            if (idFinal.equals(matrizOP[i][0])){
                res= matrizOP[i][1];

            }
        }
        return res;
    }

    public boolean comprobar(String x){
        return x.contains("/")||x.contains("*")||x.contains("#")||x.contains("-");

    }

    public void igual(View elementoPulsado){
        TextView tv =(TextView) findViewById(R.id.textView4);
        String almacen = tv.getText().toString();
        boolean deci = false;
        int numero1 = 0;
        int numero2 = 0;
        int res = 0;
        double dnumero1 = 0;
        double dnumero2 = 0;
        double dres= 0;

        for (int i =0; i<matrizOP.length; i++ ){
            if (almacen.contains(matrizOP[i][1])){
                String[] almacenSplit= almacen.split(matrizOP[i][1]);
                if (almacenSplit[0].contains(".")||almacenSplit[1].contains(".")){
                     dnumero1 = Double.parseDouble(almacenSplit[0]);
                     dnumero2 = Double.parseDouble(almacenSplit[1]);
                     deci = true;
                }else{
                     numero1= Integer.parseInt(almacenSplit[0]);
                     numero2 = Integer.parseInt(almacenSplit[1]);
                }
                if (deci){
                    if (i==0){
                        dres=dnumero1+dnumero2;
                    }else if(i==1){
                        dres=dnumero1-dnumero2;
                    }else if(i==2){
                        dres=dnumero1*dnumero2;
                    }else if (i==3){
                        dres=dnumero1/dnumero2;
                    }
                    String x =""+dres;
                   tv.setText(x);

                }else{
                    if (i==0){
                        res=numero1+numero2;
                    }else if(i==1){
                        res=numero1-numero2;
                    }else if(i==2){
                        res=numero1*numero2;
                    }else if (i==3){
                        res=numero1/numero2;
                    }
                    String x =""+res;
                    tv.setText(x);
                }

            }
        }




    }



}