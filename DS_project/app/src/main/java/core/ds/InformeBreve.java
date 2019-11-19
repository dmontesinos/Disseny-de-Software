package core.ds;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InformeBreve extends Informe {
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");

    /*public InformeBreve(Proyecto proyecto, Formato formato, Date fechaInicialRecibida, Date fechaFinalRecibida) {
        super(proyecto, formato, fechaInicialRecibida, fechaFinalRecibida);
    }*/

    public InformeBreve(Date fechaInicialInforme, Date fechaFinalInforme) {
        super(fechaInicialInforme, fechaFinalInforme);
    }

    public void escribirInforme(final Proyecto proyectoRecibido, final Formato formatoRecibido) { //Guardarlo en fichero
        FileWriter file = null;
        PrintWriter pw = null;
        try {
            if (formatoRecibido.getClass() == FormatoTextoPlano.class) {
                file = new FileWriter("C:/Users/danib/Desktop/ReporteBreve.txt");
            } else {
                if (formatoRecibido.getClass() == FormatoHTML.class) {
                    file = new FileWriter("C:/Users/danib/Desktop/ReporteBreve.html");
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
    public ArrayList prepararInforme(final ArrayList<Actividad> actividadesRecibidas) {
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

        tablaDatos.setValor(1,1, sdf.format(horaInicial));
        tablaDatos.setValor(2,1, sdf.format(horaFinal));
        tablaDatos.setValor(3, 1, sdf.format(horaActual));

        elementosInforme.add(tablaDatos);
        elementosInforme.add(new ElementoSeparador());
        elementosInforme.add(new ElementoSubTitulo("Proyectos de primer nivel"));

        ElementoTabla tablaProyectos = new ElementoTabla(1, 4);

        tablaProyectos.setValor(0, 1, "\t\t\t\t\t\tFecha inicio");
        tablaProyectos.setValor(0, 2, "\t\t\tFecha final");
        tablaProyectos.setValor(0, 3, "\t\t\t\tTiempo Total");


        //Date horaInicialProyecto = null;
        //Date horaFinalProyecto = null;

        if(!actividadesRecibidas.isEmpty()) {
            /*horaInicialProyecto = actividadesRecibidas.get(0).getHoraInicio();
            horaFinalProyecto = actividadesRecibidas.get(0).getHoraFinal();*/

            for (Actividad actividad: actividadesRecibidas) {
                if (actividad.getClass() == Proyecto.class) {
                    /*if(horaInicialProyecto.compareTo(act.getHoraInicio()) > 0) {
                        horaInicialProyecto = act.getHoraInicio();
                    }
                    //horaFinal antes act (horaFinal es más viejo)
                    //Date1(horaFinal) esta despues Date2(act)
                    if(act.getHoraFinal().compareTo(horaFinalProyecto) > 0) {
                        horaFinalProyecto = act.getHoraFinal();
                    }*/

                    int duracionFranja = (int)actividad.getDuracionTotal(getFechaInicial(), getFechaFinal());
                    if (duracionFranja > 1000 ) {
                        ArrayList fila = new ArrayList();
                        fila.add(actividad.getNombre());
                        fila.add(actividad.getPadre().getHoraInicio());
                        fila.add(actividad.getPadre().getHoraFinal());

                        fila.add(duracionFranja);

                        tablaProyectos.anadirFila(fila);
                    }

                }
                //horaInicial despues act (horaInicio es mas viejo)
                //Date1(horaInicial) esta despues Date2(act)
            }
        }

        elementosInforme.add(tablaProyectos);
        elementosInforme.add(new ElementoSeparador());

        return elementosInforme;
    }
}
