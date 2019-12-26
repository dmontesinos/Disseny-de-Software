package core.ds;

import java.util.ArrayList;
import java.util.Date;
/*Clase padre de la que colgarán los distintos tipos de informes
* que tendrá el programa. En este caso, Breve y Detallado.*/
public abstract class Informe {
    protected Date fechaInicial;
    protected Date fechaFinal;
    protected Formato formatoDeseado;


    public Informe(final Date fechaInicialInforme,
                   final Date fechaFinalInforme) {
        fechaInicial = fechaInicialInforme;
        fechaFinal = fechaFinalInforme;
        invariante();
    }
    public abstract ArrayList prepararInforme(
            ArrayList<Actividad> actividadesRecibidas);
    public abstract void escribirInforme(
            Proyecto proyectoRecibido, Formato formatoRecibido);
    public Date getFechaInicial() {
        return fechaInicial;
    }
    public Date getFechaFinal() {
        return fechaFinal;
    }
    protected void invariante() {
        if (fechaInicial == null) throw new AssertionError(
                "La variable fechaInicial no puede ser nula");
        if (fechaFinal == null) throw new AssertionError(
                "La variable fechaFinal no puede ser nula");
    }
}
