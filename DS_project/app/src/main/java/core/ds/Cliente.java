package core.ds;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Cliente {
    static final int SEGUNDOS = 2; // Milliseconds

    public static void main(String[] args) throws InterruptedException{

        Proyecto raiz;

        /*PRUEBA 1
        Proyecto proy1;
        raiz = new Proyecto("P1", null);
        Tarea tarea3 = new Tarea("T3", raiz);
        proy1 = new Proyecto("P2", raiz);

        raiz.anadir(tarea3);
        raiz.anadir(proy1);

        Tarea tarea1 = new Tarea("T1", proy1);
        Tarea tarea2 = new Tarea("T2", proy1);

        proy1.anadir(tarea1);
        proy1.anadir(tarea2);

        Reloj reloj = Reloj.getInstanciaReloj();
        reloj.printarArbol(raiz);

        tarea3.iniciarTarea();
        sleep(3000);
        tarea3.detenerTarea();
        Thread.sleep(3000);

        tarea3.iniciarTarea();
        sleep(2000);
        tarea3.detenerTarea();

        sleep(7000);
        tarea3.iniciarTarea();
        sleep(2000);
        tarea3.detenerTarea();
        tarea2.iniciarTarea();
        sleep(10000);
        tarea2.detenerTarea();
        tarea2.iniciarTarea();
        sleep(2000);
        tarea2.detenerTarea();
        tarea1.iniciarTarea();
        sleep(2000);
        tarea1.detenerTarea();

        tarea3.iniciarTarea();
        sleep(3000);
        tarea3.detenerTarea();
        tarea3.iniciarTarea();
        sleep(3000);
        tarea3.detenerTarea();
        tarea3.iniciarTarea();
        sleep(3000);
        tarea3.detenerTarea();
        tarea3.iniciarTarea();
        sleep(3000);
        tarea3.detenerTarea();
        tarea3.iniciarTarea();
        sleep(3000);
        tarea3.detenerTarea();
        tarea2.iniciarTarea();
        sleep(2000);
        tarea2.detenerTarea();

        Reloj.stopReloj();
        FIN PRUEBA 1*/

        /*PRUEBA 2*/
        Proyecto proy1;
        raiz = new Proyecto("P1", null);
        Tarea tarea3 = new Tarea("T3", raiz);
        proy1 = new Proyecto("P2", raiz);

        raiz.anadir(tarea3);
        raiz.anadir(proy1);

        Tarea tarea1 = new Tarea("T1", proy1);
        Tarea tarea2 = new Tarea("T2", proy1);

        proy1.anadir(tarea1);
        proy1.anadir(tarea2);

        Reloj reloj = Reloj.getInstanciaReloj();
        reloj.printarArbol(raiz);

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

        Reloj.stopReloj();
        /*FIN PRUEBA 2*/
    }
}