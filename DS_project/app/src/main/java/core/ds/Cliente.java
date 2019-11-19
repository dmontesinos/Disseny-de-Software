package core.ds;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

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

        Scanner objeto = new Scanner(System.in);
        System.out.println("Introduce que clase de informe quieres: [1]Breve [2]Detallado");
        String selecInforme = objeto.nextLine();
        System.out.println("En que formato lo deseas? [1]TXT [2]HTML");
        String selecFormato = objeto.nextLine();

        generarInforme(selecInforme, selecFormato);

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

    private static void generarInforme(String selecInforme, String selecFormato) throws InterruptedException {
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

        Proyecto proy4 = new Proyecto("P4", proy2);

        proy2.anadir(proy4);
        proy2.anadir(tarea1);
        proy2.anadir(tarea2);

        Tarea tarea5 = new Tarea("T5", proy4);

        Proyecto proy12 = new Proyecto("P12", proy3);
        Tarea tarea12 = new Tarea("T12", proy12);

        proy12.anadir(tarea12);
        proy3.anadir(proy12);

        proy4.anadir(tarea5);
        proy3.anadir(tarea4);
        //guardarSerializable(proy1);

        Reloj reloj = Reloj.getInstanciaReloj();
        reloj.comenzarPrintarArbol(proy1);


        tarea3.iniciarTarea();
        tarea12.iniciarTarea();
        sleep(3000);
        tarea12.detenerTarea();
        tarea3.detenerTarea();


        tarea5.iniciarTarea();
        sleep(7000);
        tarea5.detenerTarea();
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


        if (selecInforme.equals("1")) {
            if (selecFormato.equals("1")) {
                Informe informeDeseado = new InformeBreve(fechaInicioInforme.getTime(), fechaFinalInforme.getTime());
                Formato formatoDeseado = new FormatoTextoPlano();
                informeDeseado.escribirInforme(proy1, formatoDeseado);

            } else {
                if (selecFormato.equals("2")) {
                    Informe informeDeseado = new InformeBreve(fechaInicioInforme.getTime(), fechaFinalInforme.getTime());
                    Formato formatoDeseado = new FormatoHTML();
                    informeDeseado.escribirInforme(proy1, formatoDeseado);
                }
            }
        } else {
            if (selecInforme.equals("2")) {
                if (selecFormato.equals("1")) {
                    Informe informeDeseado = new InformeDetallado(fechaInicioInforme.getTime(), fechaFinalInforme.getTime());
                    Formato formatoDeseado = new FormatoTextoPlano();
                    informeDeseado.escribirInforme(proy1, formatoDeseado);
                } else {
                    if (selecFormato.equals("2")) {
                        Informe informeDeseado = new InformeDetallado(fechaInicioInforme.getTime(), fechaFinalInforme.getTime());
                        Formato formatoDeseado = new FormatoHTML();
                        informeDeseado.escribirInforme(proy1, formatoDeseado);
                    }
                }
            }
        }












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