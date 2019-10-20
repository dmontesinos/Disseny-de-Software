package DS.core;

import java.util.ArrayList;

import static java.lang.Thread.sleep;

public class Cliente {
    static final int SEGUNDOS = 2; // Milliseconds

    public static void main(String[] args) throws InterruptedException{
        //Creacion del reloj
        //Creacion del arbol de proyectos



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

        tarea3.iniciarTarea(Reloj.getInstanciaReloj());

        sleep(3000);
        tarea3.detenerTarea(Reloj.getInstanciaReloj());
        //imprimirActividades(proy1);

        sleep(7000);
        tarea2.iniciarTarea(Reloj.getInstanciaReloj());
        sleep(10000);
        tarea2.detenerTarea(Reloj.getInstanciaReloj());
        tarea3.iniciarTarea(Reloj.getInstanciaReloj());
        sleep(2000);
        tarea3.detenerTarea(Reloj.getInstanciaReloj());

    }
}