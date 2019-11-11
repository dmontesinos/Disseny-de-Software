package core.ds;

import java.text.SimpleDateFormat;

public class Impresor implements Visitor {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
    private static Impresor uniqueInstance = null;

    private Impresor() { }

    public static synchronized Impresor getInstance() {
        if (uniqueInstance == null) {
            uniqueInstance = new Impresor();
            return uniqueInstance;
        } else {
            return uniqueInstance;
        }
    }

    public void visit(final Proyecto proyecto) {
        System.out.print(proyecto.getNombre());
        if (proyecto.getHoraInicio() != null && proyecto.getHoraFinal() != null) {
            System.out.print("\t\t" + sdf.format(proyecto.getHoraInicio()) + "\t\t"
                    + sdf.format(proyecto.getHoraFinal()));
            System.out.print("\t\t\t" + proyecto.getDuracionTotal() + "\n");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
        proyecto.printar();
    }

    public void visit(final Tarea tarea) {
        System.out.print(tarea.getNombre());
        if (tarea.getHoraInicio() != null && tarea.getHoraFinal() != null) {
            System.out.print("\t\t" + sdf.format(tarea.getHoraInicio())
                    + "\t\t" + sdf.format(tarea.getHoraFinal()));
            System.out.print("\t\t\t" + tarea.getDuracionTotal() + "\n");
        } else {
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
    }
}
