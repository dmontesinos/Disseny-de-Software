import javax.swing.*;
import java.util.Scanner;

public class Bucles {
    public static void main(String[] args) {
        //WHILE
/*
        int contador = 0;
        while(contador <= 10){
            System.out.println(contador);
            contador++;
        }
        System.out.println("Programa terminado");
*/
        //WHILE 2
        String password = "";

        while(!password.equals("pepito")){
            password = JOptionPane.showInputDialog("Introduce la contraseña");
        }

        System.out.println("La contraseña es correcta");
    }
}
