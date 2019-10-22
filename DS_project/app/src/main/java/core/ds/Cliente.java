package core.ds;


import static java.lang.Thread.sleep;

public class Cliente {
    static final int SEGUNDOS = 2; // Duración de cada tick del reloj

    public static void main(String[] args) throws InterruptedException{

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

        Reloj reloj = Reloj.getInstanciaReloj();
        reloj.printarArbol(proy1);

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

        Reloj.stopReloj();
        /*FIN PRUEBA 1*/

        /*PRUEBA 2
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
        reloj.printarArbol(proy1);

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