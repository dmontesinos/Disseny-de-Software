package core.ds;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
/*Esta clase pretende recoger la impresión y estructura de un informe
 * detallado. El formato no se le da en esta clase. Es decir, solo
 * se genera la estructura y el volcado a un fichero local.*/
public class InformeDetallado extends Informe {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");


    public InformeDetallado(final Date fechaInicialInforme,
                            final Date fechaFinalInforme) {
        super(fechaInicialInforme, fechaFinalInforme);
    }

    /*Se necesita recorrer toda la estructura en forma de árbol y
    * conseguir una lista con todas las tareas que hay. Esta función
    * recorre toda la estructura y busca todos los objetos que sean
    * de la clase Tarea, para posteriormente retornarlos. Es una función
    * recursiva y, por tanto, se apoya en otra función llamada
    * getActividadesRecursivo().*/
    public ArrayList<Actividad> getActividades(
            final ArrayList<Actividad> listaActividades) {
        ArrayList<Actividad> rActividades = new ArrayList<>();
        Iterator<Actividad> iteradorActividades = listaActividades.iterator();
        Actividad actividad;

        while (iteradorActividades.hasNext()) {
            actividad = iteradorActividades.next();
            if (actividad.getClass() == Tarea.class) {
                rActividades.add(actividad);
            } else {
                rActividades = getActividadesRecursivo(
                        actividad.getActividades().iterator(), rActividades);
            }
        }
        return rActividades;
    }
    /*Esta función complementa a la otra para poder realizar la búsqueda
    * de todas las actividades de tipo Tarea y retornarlas en forma de
    * Array.*/
    public ArrayList<Actividad> getActividadesRecursivo(
            final Iterator<Actividad> listaActividades,
            ArrayList<Actividad> activitatsResultat) {
        Iterator<Actividad> iteradorActividades = listaActividades;
        Actividad actividad;
        while (iteradorActividades.hasNext()) {
            actividad = iteradorActividades.next();
            if (actividad.getClass() == Tarea.class) {
                activitatsResultat.add(actividad);
            } else {
                activitatsResultat = getActividadesRecursivo(
                        actividad.getActividades().iterator(),
                        activitatsResultat);
            }
        }
        return activitatsResultat;
    }
    /*Imprime el informe preparado por la función prepararInforme()
    * llamada dentro. Utiliza la misma metodología que en la clase
    * InformeBreve.*/
    public void escribirInforme(final Proyecto proyectoRecibido,
                                final Formato formatoRecibido) {
        FileWriter file = null;
        PrintWriter pw = null;
        try {
            if (formatoRecibido.getClass() == FormatoTextoPlano.class) {
                file = new FileWriter(
                        "C:/Users/danib/Desktop/ReporteDetallado.txt"
                );
            } else {
                if (formatoRecibido.getClass() == FormatoHTML.class) {
                    file = new FileWriter(
                            "C:/Users/danib/Desktop/ReporteDetallado.html"
                    );
                }
            }
            pw = new PrintWriter(file);
            ArrayList<Elemento> elementos = new ArrayList<>();
            elementos = prepararInforme(proyectoRecibido.getActividades());
            for (Elemento elemento: elementos) {
                elemento.accept(formatoRecibido);
            }
            pw.write(formatoRecibido.getContenido());
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (file != null) {
                    file.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
    /*Prepara el informe como en el caso breve, pero en este caso con
    * información adicional. Se almacenan además del informe breve,
    * los subproyectos, las tareas y los intérvalos de la estructura.*/
    public ArrayList prepararInforme(
            final ArrayList<Actividad> actividadesRecibidas) {
        ArrayList<Elemento> elementosInforme = new ArrayList<>();
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoTitulo("Informe detallado"));
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoSubTitulo("Periodo"));

        ElementoTabla tablaDatos = new ElementoTabla(4, 2);

        tablaDatos.setValor(0, 1, "\t\t\t\t\t\t\tFecha");
        tablaDatos.setValor(1, 0, "Desde: ");
        tablaDatos.setValor(2, 0, "Hasta: ");
        tablaDatos.setValor(3, 0, "Fecha: ");

        Date horaActual = new Date();

        tablaDatos.setValor(1, 1, sdf.format(getFechaInicial()));
        tablaDatos.setValor(2, 1, sdf.format(getFechaFinal()));
        tablaDatos.setValor(3, 1, sdf.format(horaActual));

        elementosInforme.add(tablaDatos);
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoSubTitulo(
                "Proyectos de primer nivel"));

        ElementoTabla tablaProyectos = new ElementoTabla(1, 4);

        tablaProyectos.setValor(0, 1, "\t\t\t\t\t\tFecha inicio");
        tablaProyectos.setValor(0, 2, "\t\t\t\tFecha final");
        tablaProyectos.setValor(0, 3, "\t\tTiempo Total");

        if (!actividadesRecibidas.isEmpty()) {

            for (Actividad actividad: actividadesRecibidas) {
                if (actividad.getClass() == Proyecto.class) {
                    int duracionFranja = actividad.getDuracionTotal(
                            getFechaInicial(), getFechaFinal());
                    if (duracionFranja > 1000) {
                        ArrayList fila = new ArrayList();
                        fila.add(actividad.getNombre());
                        fila.add(actividad.getPadre().getHoraInicio());
                        fila.add(actividad.getPadre().getHoraFinal());

                        fila.add(duracionFranja);

                        tablaProyectos.anadirFila(fila);
                    }
                }
            }
        }

        elementosInforme.add(tablaProyectos);
        elementosInforme.add(new ElementoSeparador());

        elementosInforme.add(new ElementoSubTitulo("Subproyectos"));
        elementosInforme.add(new ElementoParrafo(
                "Se incluyen en la siguiente tabla "
                + "solo los subproyectos que tengan alguna tarea con "
                        + "algun intervalo dentro del periodo.\n"));

        ElementoTabla tablaDatosSubproyecto = new ElementoTabla(1, 5);

        tablaDatosSubproyecto.setValor(0, 1, "\t\t\tDentro de");
        tablaDatosSubproyecto.setValor(0, 2, "\tFecha inicio");
        tablaDatosSubproyecto.setValor(0, 3, "\t\t\t\tFecha final");
        tablaDatosSubproyecto.setValor(0, 4, "\t\tTiempo total");

        if (!actividadesRecibidas.isEmpty()) {
            for (Actividad actividad: actividadesRecibidas) {
                if (actividad.getClass() == Proyecto.class) {

                    Proyecto proy = (Proyecto) actividad;
                    for (Actividad proyecto: proy.getActividades()) {
                        if (proyecto.getClass() == Proyecto.class) {
                            if (proyecto.getDuracionTotal(
                                    getFechaInicial(), getFechaFinal()) > 1000) {
                                ArrayList fila = new ArrayList();
                                fila.add(proyecto.getNombre());
                                fila.add(proyecto.getPadre().getNombre());
                                fila.add(proyecto.getHoraInicio());
                                fila.add(proyecto.getHoraFinal());

                                fila.add(proyecto.getDuracionTotal(
                                        getFechaInicial(), getFechaFinal()));

                                tablaDatosSubproyecto.anadirFila(fila);
                            }
                        }
                    }
                }
            }
        }
        elementosInforme.add(tablaDatosSubproyecto);
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoSubTitulo("Tareas"));
        elementosInforme.add(new ElementoParrafo("Se incluyen en la siguiente "
                + "tabla la duración de todas las tareas y el proyecto "
                + "al cual pertenecen"));


        ElementoTabla tablaDatosTareas = new ElementoTabla(1, 5);

        tablaDatosTareas.setValor(0, 1, "\t\t\tProyecto");
        tablaDatosTareas.setValor(0, 2, "\tFecha inicio");
        tablaDatosTareas.setValor(0, 3, "\t\t\t\tFecha final");
        tablaDatosTareas.setValor(0, 4, "\t\tTiempo total");

        if (!actividadesRecibidas.isEmpty()) {
            ArrayList todasLasActividades =
                    getActividades(actividadesRecibidas);

            for (Object t: todasLasActividades) {
                Tarea tarea = (Tarea) t;
                if (tarea.getDuracionTotal(getFechaInicial(),
                        getFechaFinal()) > 1000) {
                    ArrayList fila = new ArrayList();
                    fila.add(tarea.getNombre());
                    fila.add(tarea.getPadre().getNombre());
                    fila.add(tarea.getHoraInicio());
                    fila.add(tarea.getHoraFinal());
                    fila.add(tarea.getDuracionTotal(getFechaInicial(),
                            getFechaFinal()));

                    tablaDatosTareas.anadirFila(fila);
                }
            }
        }
        elementosInforme.add(tablaDatosTareas);
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoSubTitulo("Intérvalos"));
        elementosInforme.add(new ElementoParrafo(
                "Se incluyen en la siguiente tabla "
                + "el tiempo de inicio, final y durada de todos los "
                        + "intervalos entre la fecha inicial"
                + "y final especificadas, y su tarea y proyecto al "
                        + "cual pertenecen"));

        ElementoTabla tablaDatosIntervalos = new ElementoTabla(1, 6);
        tablaDatosIntervalos.setValor(0, 0, "Tarea");
        tablaDatosIntervalos.setValor(0, 1, "Proyecto");
        tablaDatosIntervalos.setValor(0, 2, "Número");
        tablaDatosIntervalos.setValor(0, 3, "\tFecha inicio");
        tablaDatosIntervalos.setValor(0, 4, "\t\t\t\tFecha final");
        tablaDatosIntervalos.setValor(0, 5, "\t\tTiempo total");

        if (!actividadesRecibidas.isEmpty()) {
            ArrayList todasLasActividades =
                    getActividades(actividadesRecibidas);

            for (Object t: todasLasActividades) {
                int contador = 1;
                Tarea tarea = (Tarea) t;
                if (tarea.getDuracionTotal(getFechaInicial(),
                        getFechaFinal()) > 1000) {
                    for (Object intervalo: tarea.getIntervalos()) {
                        Intervalo inter = (Intervalo) intervalo;

                        ArrayList fila = new ArrayList();
                        fila.add(inter.getTareaPadre().getNombre());
                        fila.add("\t"
                                + inter.getTareaPadre().getPadre().getNombre());
                        fila.add("\t\t" + contador);
                        contador++;
                        fila.add(inter.getHoraInicio());
                        fila.add(inter.getHoraFinal());
                        fila.add(inter.getDuracionTotal() * 1000);

                        tablaDatosIntervalos.anadirFila(fila);
                    }
                }
            }
        }
        elementosInforme.add(tablaDatosIntervalos);

        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoParrafo("TimeTracker v0.1"));
        return elementosInforme;
    }







}
