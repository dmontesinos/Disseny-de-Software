import javax.swing.*;
import java.util.Scanner;


public class EntradaDatos {
    public static void main(String[] args) {
        //Lectura de entradas manuales
/*
        Scanner entrada = new Scanner(System.in);

        System.out.println("Introduce tu nombre");

        String entradaNombre = entrada.nextLine();
        System.out.println("Tu nombre es: "+entradaNombre);
*/
        //EJEMPLO 2
/*
        String nombreUsuario= JOptionPane.showInputDialog("Introduce tu nombre");
        //El objeto para la edad debe ser de tipo String (mirar API de showInputDialog) y se debe CASTEAR posteriormente
        //para convertirlo en INT y poder operar con el.
        String edadUsuario = JOptionPane.showInputDialog("Introduce tu edad");


        System.out.println("Tu nombre es: "+nombreUsuario+" y tu edad el año que viene será de: "+(Integer.parseInt(edadUsuario)+1));
*/

        //EJEMPLO 3 -> FORMATEAR NUMEROS
/*
        double n=10000;
        System.out.printf("%.2f",n/3); // Utilizando printF para formatear el resultado con dos decimales
*/
        //EJEMPLO 4 -> INTRODUCIR UN NÚMERO Y HACER SU RAÍZ CUADRADA

        String numero_raiz = JOptionPane.showInputDialog("Introduce un número");

        double raiz = Math.sqrt(Double.parseDouble(numero_raiz));

        System.out.printf("La raíz de %s es %1.2f",numero_raiz,raiz);
    }
}
