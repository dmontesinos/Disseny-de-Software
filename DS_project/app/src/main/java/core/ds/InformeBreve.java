package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
/*Esta clase pretende recoger la impresión y estructura de un informe breve.
* El formato no se le da en esta clase. Es decir, solo se genera la
* estructura y el volcado a un fichero local.*/
public class InformeBreve extends Informe {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");
    private static final Logger Log = LoggerFactory.getLogger(InformeBreve.class);

    public InformeBreve(final Date fechaInicialInforme,
                        final Date fechaFinalInforme) {
        super(fechaInicialInforme, fechaFinalInforme);
        invariante();
        Log.info("Generando informe breve");
    }
    /*Esta función básicamente recoge los datos generados por la
    * función "prepararInforme()" y los guarda en un fichero local.*/
    public void escribirInforme(final Proyecto proyectoRecibido,
                                final Formato formatoRecibido) {
        FileWriter file = null;
        PrintWriter pw = null;
        try {
            if (formatoRecibido.getClass() == FormatoTextoPlano.class) {
                file = new FileWriter(
                        "C:/Users/danib/Desktop/ReporteBreve.txt"
                );
            } else {
                if (formatoRecibido.getClass() == FormatoHTML.class) {
                    file = new FileWriter(
                            "C:/Users/danib/Desktop/ReporteBreve.html"
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
            Log.info("Escribiendo informe generado en disco");
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
    /*Función cuyo objetivo es recibir una lista de actividades (generalmente
    * el proyecto Root) y preparar toda la estructura para generar un informe
    * breve. Este informe se va acumulando elemento a elemento en un array
    * que posteriormente es retornado. El tratado de este array se realiza
    * posteriormente para definir si será TXT o HTML.*/
    public ArrayList prepararInforme(
            final ArrayList<Actividad> actividadesRecibidas
    ) {
        invariante();
        ArrayList<Elemento> elementosInforme = new ArrayList<>();
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoTitulo("Informe breve"));
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoSubTitulo("Periodo"));

        ElementoTabla tablaDatos = new ElementoTabla(4, 2);

        tablaDatos.setValor(0, 1, "\t\t\t\t\t\t\tFecha");
        tablaDatos.setValor(1, 0, "Desde: ");
        tablaDatos.setValor(2, 0, "Hasta: ");
        tablaDatos.setValor(3, 0, "Fecha: ");

        Date horaInicial = getFechaInicial(); //La fecha del informe (Franja)
        Date horaFinal = getFechaFinal();
        Date horaActual = new Date();

        tablaDatos.setValor(1, 1, sdf.format(horaInicial));
        tablaDatos.setValor(2, 1, sdf.format(horaFinal));
        tablaDatos.setValor(3, 1, sdf.format(horaActual));

        elementosInforme.add(tablaDatos);
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoSubTitulo(
                "Proyectos de primer nivel"
        ));

        ElementoTabla tablaProyectos = new ElementoTabla(1, 4);

        tablaProyectos.setValor(0, 1, "\t\t\t\t\t\tFecha inicio");
        tablaProyectos.setValor(0, 2, "\t\t\t\tFecha final");
        tablaProyectos.setValor(0, 3, "\t\tTiempo Total");

        if (!actividadesRecibidas.isEmpty()) {
            for (Actividad actividad: actividadesRecibidas) {
                if (actividad.getClass() == Proyecto.class) {
                    int duracionFranja = actividad.getDuracionTotal(
                            getFechaInicial(), getFechaFinal()
                    );
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

        Log.info("Preparando el informe breve");
        return elementosInforme;
    }
}
