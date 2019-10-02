import javax.swing.*;

public class Arrays {
    public static void main(String[] args) {

        //EJEMPLO 1
        /*
        int[] matriz = new int[10];

        for (int i=0; i<10;i++){
            matriz[i] = i;
        }

        for (int i=0; i<10; i++){
            System.out.println(matriz[i]);
        }
        */

        //EJEMPLO 2
        /*
        String[] mispaises = new String[5];

        for (int i = 0; i < 5; i++) {
            mispaises[i] = JOptionPane.showInputDialog("Introduce un pais");
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(mispaises[i]);
        }
        */

        //EJEMPLO 3 - BIDIMENSIONAL

        String[][] matrizB = new String[10][10];

        for(int i = 0; i<10; i++){
            for(int j=0; j<10; j++){
                matrizB[i][j] = "["+i+","+j+"]";
            }
        }

        for(int i = 0; i<10; i++){
            for(int j=0; j<10; j++){
                System.out.print(matrizB[i][j]);
            }
            System.out.printf("%n");
        }
    }

}
