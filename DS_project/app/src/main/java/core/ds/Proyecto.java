package core.ds;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/*Se encarga de almacenar más proyectos y tareas. También
almacena el tiempo total de todos los objetos que le cuelgan.*/
public class Proyecto extends Actividad {
    private ArrayList<Actividad> actividades;
    private final Impresor impresor;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");


    public Proyecto(final String nombreRecibido, final Proyecto padreRecibido) {
        super(nombreRecibido, padreRecibido);
        actividades = new ArrayList<Actividad>();
        impresor = Impresor.getInstance();
    }


    public void anadir(final Actividad act) {
        actividades.add(act);
    }

    public final ArrayList<Actividad> getActividades() {
        return actividades;
    }
    /* Función encargada de mostrar los objetos de la estructura
    del árbol. Recorre el vector y utiliza el patrón Visitor
    para ir imprimiendo por pantalla*/
    public void printar() {
        for (Actividad a: actividades) {
            a.accept(impresor);
        }
    }

    public void printarCabecera() {
        this.acceptCabecera(impresor);
    }

    /*Función recursiva encargada de calcular el tiempo total del proyecto.
    Para ello, coge las actividades que cuelgan del array de esta clase y
    suma recursivamente los tiempos de sus objetos.*/
    public final long getDuracionTotal() {
        long total = 0;

        for (Actividad a: actividades) {
            total += a.getDuracionTotal();
        }
        setDuracionTotal(total);
        return total;
    }

    public void accept(final Visitor visitor) {
        visitor.visit(this);
    }

    public void acceptCabecera(final Visitor visitor) {
        visitor.visitCabecera(this);
    }
}
