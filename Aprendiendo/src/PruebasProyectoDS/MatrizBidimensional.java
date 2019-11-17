package PruebasProyectoDS;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MatrizBidimensional {
    public static void main(String[] args) {


        ArrayList nuevaTabla = new ArrayList();

        for (int i = 0; i < 6; i++) {
            ArrayList fila = new ArrayList<>();
            for (int j = 0; j < 6; j++) {
                //fila.add("["+i+"]"+"["+j+"]");
                fila.add(i+","+j);
            }
            nuevaTabla.add(fila);
        }


        System.out.println(nuevaTabla);

        ((ArrayList) nuevaTabla.get(1)).set(1, "HOLA");

        System.out.println(nuevaTabla);


    }
}
