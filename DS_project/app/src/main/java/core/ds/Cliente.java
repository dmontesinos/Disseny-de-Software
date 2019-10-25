package core.ds;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static java.lang.Thread.sleep;

/* Clase destinada a ejecutar las pruebas correspondientes al funcionamiento del proyecto. */
public class Cliente {
    static final int SEGUNDOS = 2; // Duración de cada tick del reloj

    public static void main(String[] args) throws InterruptedException{
         /*INICIO PRUEBA 1*/
        //test1();
        /*FIN PRUEBA 1*/
        //test2();
        /*FIN PRUEBA 2*/

        comprobacionSerializable((Proyecto)cargarSerializable());
    }

    public static void test1() throws InterruptedException {
        /*PRUEBA 1*/
        Proyecto proy1, proy2;
        proy1 = new Proyecto("P1", null);
        Tarea tarea3 = new Tarea("T3", proy1);
        proy2 = new Proyecto("P2", proy1);

        proy1.anadir(tarea3);
        proy1.anadir(proy2);

        Tarea tarea1 = new Tarea("T1", proy2);
        Tarea tarea2 = new Tarea("T2", proy2);

        proy2.anadir(tarea1);
        proy2.anadir(tarea2);
        guardarSerializable(proy1);

        Reloj reloj = Reloj.getInstanciaReloj();
        reloj.comenzarPrintarArbol(proy1);


        tarea3.iniciarTarea();
        sleep(3000);
        tarea3.detenerTarea();


        sleep(7000);
        tarea2.iniciarTarea();
        sleep(10000);
        tarea2.detenerTarea();
        tarea3.iniciarTarea();
        sleep(2000);
        tarea3.detenerTarea();

        Reloj.pararReloj();
    }

    public static void test2() throws InterruptedException {
        //PRUEBA 2
        Proyecto proy1, proy2;
        proy1 = new Proyecto("P1", null);
        Tarea tarea3 = new Tarea("T3", proy1);
        proy2 = new Proyecto("P2", proy1);

        proy1.anadir(tarea3);
        proy1.anadir(proy2);

        Tarea tarea1 = new Tarea("T1", proy2);
        Tarea tarea2 = new Tarea("T2", proy2);

        proy2.anadir(tarea1);
        proy2.anadir(tarea2);

        Reloj reloj = Reloj.getInstanciaReloj();
        reloj.comenzarPrintarArbol(proy1);

        tarea3.iniciarTarea();
        sleep(4000);
        tarea2.iniciarTarea();
        sleep(2000);
        tarea3.detenerTarea();
        sleep(2000);
        tarea1.iniciarTarea();
        sleep(4000);
        tarea1.detenerTarea();
        sleep(2000);
        tarea2.detenerTarea();
        sleep(4000);
        tarea3.iniciarTarea();
        sleep(2000);
        tarea3.detenerTarea();


        Reloj.pararReloj();
    }

    public static void comprobacionSerializable(Proyecto raiz) throws InterruptedException {

        for(Actividad a: raiz.getActividades()){
            System.out.println("Comprobación de la serialización de los hijos de la raíz");
            System.out.println("Nombre: "+a.getNombre());
        }
    }

    public static void guardarSerializable(Actividad actividad){

        try {
            ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("C:/Users/danib/Desktop/Serializado.txt"));
            flujoSalida.writeObject(actividad);
            flujoSalida.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//guardarSerializable(proy1)

    public static Actividad cargarSerializable() {
        //DESERIALIZAR
        Actividad serializado = null;
        try {
            FileInputStream file = new FileInputStream("C:/Users/danib/DesktopSerializado.txt");
            ObjectInputStream in = new ObjectInputStream(file);

            serializado = (Actividad) in.readObject();

            in.close();
            file.close();


        } catch (Exception e) {
            e.printStackTrace();
        }
        return serializado;
    }
    //Proyecto proy1 = (Proyecto)cargarSerializable();
}