package core.ds;

import java.util.ArrayList;
import java.util.Date;

public abstract class Informe {
    //protected Proyecto proyectoInforme;
    protected Date fechaInicial;
    protected Date fechaFinal;
    protected Formato formatoDeseado;
    protected ArrayList<Elemento> elementosInforme2;


    /*public Informe(Proyecto proyecto, Formato formato, Date fechaInicialRecibida, Date fechaFinalRecibida) {
        proyectoInforme = proyecto;
        formatoDeseado = formato;
        fechaInicial = fechaInicialRecibida;
        fechaFinal = fechaFinalRecibida;
    }*/
    public Informe(Date fechaInicialInforme, Date fechaFinalInforme) {
        fechaInicial = fechaInicialInforme;
        fechaFinal = fechaFinalInforme;
    }
    public abstract ArrayList prepararInforme(final ArrayList<Actividad> actividadesRecibidas);
    public abstract void escribirInforme(Proyecto proyectoRecibido, Formato formatoRecibido);
}
