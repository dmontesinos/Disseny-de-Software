package core.ds;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Cliente {
    static final int SEGUNDOS = 2; // Milliseconds

    public static void main(String[] args) throws InterruptedException{

        Proyecto raiz, proy2;
        raiz = new Proyecto("P1", null);
        Tarea tarea3 = new Tarea("T3", raiz);
        proy2 = new Proyecto("P2", raiz);

        raiz.anadir(tarea3);
        raiz.anadir(proy2);

        Tarea tarea1 = new Tarea("T1", proy2);
        Tarea tarea2 = new Tarea("T2", proy2);

        proy2.anadir(tarea1);
        proy2.anadir(tarea2);

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
    }
}