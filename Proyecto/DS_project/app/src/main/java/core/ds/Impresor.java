package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
/*El impressor se encarga de imprimir por consola el proceso que
se va realizando. Para ello se apoya en el Visitor y define como
debe imprimir un Proyecto o una Actividad de forma específica.*/
final class Impresor implements Visitor {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
    private static Impresor uniqueInstance = null;
    private static final Logger log = LoggerFactory.getLogger(Impresor.class);

    private Impresor() { }

    public static synchronized Impresor getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Impresor();
            log.debug("Generando nueva instancia de Impresor");
            return uniqueInstance;
        } else {
            invariante();
            log.debug("Recuperando instancia de Impresor");
            return uniqueInstance;
        }
    }
    /*Define la forma de imprimir por consola el contenido de un proyecto
    * y sus parámetros principales.*/
    public void visit(final Proyecto proyecto) {
        System.out.print(proyecto.getNombre());
        if (proyecto.getHoraInicio() != null
                && proyecto.getHoraFinal() != null) {
            System.out.print("\t\t"
                    + sdf.format(proyecto.getHoraInicio()) + "\t\t"
                    + sdf.format(proyecto.getHoraFinal()));
            System.out.print("\t\t\t" + proyecto.getDuracionTotal() + "\n");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
        proyecto.printar();
        invariante();
        log.debug("Imprimiendo proyecto con impresor");
    }
    /*Define la forma de imprimir por consola el contenido de una tarea
     * y sus parámetros principales.*/
    public void visit(final Tarea tarea) {
        System.out.print(tarea.getNombre());
        if (tarea.getHoraInicio() != null && tarea.getHoraFinal() != null) {
            System.out.print("\t\t" + sdf.format(tarea.getHoraInicio())
                    + "\t\t" + sdf.format(tarea.getHoraFinal()));
            System.out.print("\t\t\t" + tarea.getDuracionTotal() + "\n");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
        invariante();
        log.debug("Imprimiendo tarea con impresor");
    }
    /*Función necesaria para dar un formato más bonito a la cabecera y
    * adaptarla al máxaimo al contenido que se imprime posteriormente.
    * Podría adaptarse dentro del propio proyecto, pero el resultado así
    * es más preciso.*/
    public void visitCabecera(final Proyecto proyecto) {
        System.out.println("\nNom\t\t\tTemps inici\t\t\t\t"
                + "Temps final\t\t\t\tDurada(hh:mm:ss)");
        System.out.println("----+---------------------"
                + "---+-------------------------+--"
                + "------------------------");
        System.out.print(proyecto.getNombre());
        if (proyecto.getHoraInicio() != null
                && proyecto.getHoraFinal() != null) {
            System.out.print("\t\t"
                    + sdf.format(proyecto.getHoraInicio()) + "\t\t"
                    + sdf.format(proyecto.getHoraFinal()));
            System.out.print("\t\t\t" + proyecto.getDuracionTotal() + "\n");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
        invariante();
        log.debug("Imprimiendo cabecera con impresor");
    }
    private static void invariante() {
        if (uniqueInstance == null) throw new AssertionError(
                "La variable uniqueInstance no puede ser nula");
    }
}
