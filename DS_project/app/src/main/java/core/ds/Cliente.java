package core.ds;

import java.util.ArrayList;

public class Cliente {
    public static void main(String[] args) {

        ArrayList<Proyecto> listaProyectos = new ArrayList<>();

        Proyecto proyecto1, proyecto2;
        proyecto1 = new Proyecto("P1", null);
        proyecto2 = new Proyecto("P2", proyecto1);

        Tarea tarea1 = new Tarea("T1", proyecto1);
        Tarea tarea2 = new Tarea("T2", proyecto1);

        proyecto1.setTarea(tarea1);
        proyecto1.setTarea(tarea2);

        proyecto1.setTarea(proyecto2);

        listaProyectos.add(proyecto1);

        for (Proyecto pro: listaProyectos) {
            System.out.println("Nom  Temps inici      Temps final     Durada(hh:mm:ss)");
            System.out.println("----+----------------+---------------+----------------");
            pro.mostrar();
        }
    }
}
