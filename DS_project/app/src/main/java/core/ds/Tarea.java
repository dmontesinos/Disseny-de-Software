package core.ds;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

/* Clase encargada de almacenar todos los intérvalos de cada tarea.
También se encarga de calcular el tiempo total en base a la suma
de tiempos totales de los intérvalos. Se encarga de iniciar y
detener las tareas y sus respectivos cronómetros. */
public class Tarea extends Actividad  {
    private LinkedList<Intervalo> intervalos;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");

    public Tarea(final String nombre, final Proyecto proyecto) {
        super(nombre, proyecto);
        intervalos = new LinkedList<>();
    }
    /* Función encargada de iniciar el crono de una tarea y,
    por tanto, crear, iniciar y añadir los observers necesarios.*/
    public void iniciarTarea() {
        Reloj reloj = Reloj.getInstanciaReloj();
        Date fecha = new Date();
        actualizarInicio(fecha);
        Intervalo intervalo = new Intervalo(fecha, this);
        intervalos.add(intervalo);
        reloj.anadirObservador(intervalo);

        if (this.getHoraInicio() == null) {
            this.setHoraInicio(new Date());
        }
    }
    /*Función encargada cerrar los intérvalos. De misma forma,
    se asigna la fecha final del intérvalo y es borrado del array
    de observadores, ya que no queremos más actualizaciones.*/
    public void detenerTarea() {
        Reloj reloj = Reloj.getInstanciaReloj();
        Intervalo intervalo = intervalos.getLast();
        this.setHoraFinal(intervalo.getHoraFinal());
        reloj.borrarObservador(intervalo);
    }
    /* Función encargada de mostrar los objetos de la estructura
    del árbol de tipo Tarea. */
    public void printar() {
        System.out.print(this.getNombre());
        if (getHoraInicio() != null && getHoraFinal() != null) {
            System.out.print("\t\t" + sdf.format(getHoraInicio())
                    + "\t\t" + sdf.format(getHoraFinal()));
            System.out.print("\t\t\t" + getDuracionTotal() + "\n");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
    }

    /*Función recursiva encargada de calcular el tiempo total de la tarea.
    Para ello, coge todos los intérvalos pertenecientes al array de intérvalos
    y los suma*/
    public final long getDuracionTotal() {
        long total = 0;

        for (Intervalo i: intervalos) {
            total += i.getDuracionTotal();
        }
        setDuracionTotal(total);
        return total;
    }
}
