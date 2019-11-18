package core.ds;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static java.lang.Thread.sleep;

/* Clase destinada a ejecutar las pruebas correspondientes
al funcionamiento del proyecto. */
public class Cliente {
    static final int SEGUNDOS = 2; // Duración de cada tick del reloj

    public static void main(final String[] args) throws InterruptedException {
        /*INICIO PRUEBA 1*/
        //test1();

        /*INICIO PRUEBA 2*/
        //test2();

        /*INICIO PRUEBA SERIALIZABLE*/
        //comprobacionSerializable((Proyecto)cargarSerializable());

        informeSimpleTXT();

    }

    private static void test1() throws InterruptedException {
        /*PRUEBA 1*/
        Proyecto proy1;
        Proyecto proy2;
        proy1 = new Proyecto("P1", null);
        Tarea tarea3 = new Tarea("T3", proy1);
        proy2 = new Proyecto("P2", proy1);

        proy1.anadir(tarea3);
        proy1.anadir(proy2);

        Tarea tarea1 = new Tarea("T1", proy2);
        Tarea tarea2 = new Tarea("T2", proy2);

        proy2.anadir(tarea1);
        proy2.anadir(tarea2);
        //guardarSerializable(proy1);

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

    private static void test2() throws InterruptedException {
        //PRUEBA 2
        Proyecto proy1;
        Proyecto proy2;
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

    private static void informeSimpleTXT() throws InterruptedException {
        Proyecto proy1;
        Proyecto proy2;
        Proyecto proy3;

        proy1 = new Proyecto("P1", null);
        Tarea tarea3 = new Tarea("T3", proy1);
        proy2 = new Proyecto("P2", proy1);

        proy3 = new Proyecto("P3", proy1);

        proy1.anadir(tarea3);
        proy1.anadir(proy2);
        proy1.anadir(proy3);

        Tarea tarea1 = new Tarea("T1", proy2);
        Tarea tarea2 = new Tarea("T2", proy2);
        Tarea tarea4 = new Tarea("T4", proy3);

        proy2.anadir(tarea1);
        proy2.anadir(tarea2);
        proy3.anadir(tarea4);
        //guardarSerializable(proy1);

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
        /*tarea4.iniciarTarea();
        sleep(2000);
        tarea3.detenerTarea();*/

        Reloj.pararReloj();

        Calendar fechaInicioInforme = Calendar.getInstance();
        fechaInicioInforme.add(Calendar.SECOND,-1000);

        Calendar fechaFinalInforme = Calendar.getInstance();
        fechaFinalInforme.add(Calendar.SECOND,+1000);


        Informe informeDeseado = new InformeBreve(fechaInicioInforme.getTime(), fechaFinalInforme.getTime());
        Formato formatoDeseado = new FormatoTextoPlano();

        informeDeseado.escribirInforme(proy1, formatoDeseado);







        /*Proyecto root;
        Proyecto proy1;
        Proyecto proy2;
        Proyecto proy3;


        root = new Proyecto(".", null);
        proy1 = new Proyecto("P1", root);
        Tarea tarea3 = new Tarea("T3", proy1);
        proy2 = new Proyecto("P2", proy1);
        proy3 = new Proyecto("P3", proy1);


        proy1.anadir(tarea3);
        proy1.anadir(proy2);
        proy1.anadir(proy3);

        Tarea tarea1 = new Tarea("T1", proy2);
        Tarea tarea2 = new Tarea("T2", proy2);
        Tarea tarea4 = new Tarea("T4", proy3);
        Tarea tarea5 = new Tarea("T5", proy3);
        Tarea tarea6 = new Tarea("T6", proy2);

        proy2.anadir(tarea1);
        proy2.anadir(tarea2);
        proy3.anadir(tarea3);
        proy3.anadir(tarea4);
        proy3.anadir(tarea5);
        proy2.anadir(tarea6);

        Reloj reloj = Reloj.getInstanciaReloj();
        reloj.comenzarPrintarArbol(proy1);

        tarea3.iniciarTarea();
        sleep(4000);
        tarea2.iniciarTarea();
        sleep(2000);
        tarea3.detenerTarea();
        sleep(2000);
        tarea4.iniciarTarea();
        tarea5.iniciarTarea();
        sleep(2000);
        tarea4.detenerTarea();
        tarea5.detenerTarea();
        tarea6.iniciarTarea();
        sleep(2000);
        tarea6.detenerTarea();
        /*sleep(2000);
        tarea1.iniciarTarea();
        sleep(4000);
        tarea1.detenerTarea();
        sleep(2000);
        tarea2.detenerTarea();
        sleep(4000);
        tarea3.iniciarTarea();
        sleep(2000);
        tarea3.detenerTarea();

        Reloj.pararReloj();*/


        //Date fechaInicioInforme = new GregorianCalendar(2019, 11, 15).getTime();
        //Date fechaFinalInforme = new GregorianCalendar(2019, 11, 18).getTime();
        /*Calendar fechaInicioInforme = Calendar.getInstance();
        fechaInicioInforme.add(Calendar.SECOND,-1000);

        Calendar fechaFinalInforme = Calendar.getInstance();
        fechaFinalInforme.add(Calendar.SECOND,+1000);



        Informe informeDeseado = new InformeBreve(fechaInicioInforme.getTime(), fechaFinalInforme.getTime());
        Formato formatoDeseado = new FormatoTextoPlano();

        informeDeseado.escribirInforme(proy1, formatoDeseado);*/
    }


    private static void comprobacionSerializable(final Proyecto raiz)
            throws InterruptedException {

        for (Actividad a: raiz.getActividades()) {
            System.out.println("Comprobación de la serialización "
                    + "de los hijos de la raíz");
            System.out.println("Nombre: " + a.getNombre());
        }
    }

    private static void guardarSerializable(final Actividad actividad) {

        try {
            ObjectOutputStream flujoSalida = new ObjectOutputStream(new FileOutputStream("C:/Users/danib/Desktop/Serializado.txt"));
            flujoSalida.writeObject(actividad);
            flujoSalida.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    } //guardarSerializable(proy1)

    private static Actividad cargarSerializable() {
        //DESERIALIZAR
        Actividad serializado = null;
        try {
            FileInputStream file
                    = new FileInputStream("C:/Users/danib/Desktop/Serializado.txt");
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