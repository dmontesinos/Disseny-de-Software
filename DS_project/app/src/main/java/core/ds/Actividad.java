package core.ds;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* Clase abstracta con métodos destinados a actualizar recursivamente
los tiempos finales e iniciales. Algunos métodos están implementado en
sus hijos, dado que se implementan de forma particular. */
public abstract class  Actividad implements Serializable {
    private String nombre;
    private Proyecto padre;
    private Date horaInicio;
    private Date horaFinal;
    private long duracionTotal;
    /*Esta variable nos da la posibilidad de utilizar el log*/
    private static final Logger Log = LoggerFactory.getLogger(Actividad.class);

    public Actividad(final String nombreRecibido,
                     final Proyecto padreRecibido) {
        this.setNombre(nombreRecibido);
        this.setPadre(padreRecibido);

        Log.info("Se ha creado la actividad con nombre: "
                + this.getClass().getSimpleName() + " " + nombreRecibido);
    }

    public final Proyecto getPadre() {
        invariante();
        return padre;
    }

    @Override
    public final String toString() {
        return String.format("%s", getNombre());
    }

    public void printar() {

    } //Cada implementación está en su respectiva clase.
    public void printarCabecera() {

    }


    //Cada implementación está en su clase.
    public abstract long getDuracionTotal();
    public abstract int getDuracionTotal(Date inicioFranja, Date finalFranja);

    public void setDuracionTotal(final long valor) {
        duracionTotal = valor;
    }

    public final String getNombre() {
        return nombre;
    }

    public void setNombre(final String nombreRecibido) {
        nombre = nombreRecibido;
    }

    public void setPadre(final Proyecto padreRecibido) {
        padre = padreRecibido;
    }

    public final Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(final Date horaInicioRecibida) {
        horaInicio = horaInicioRecibida;
    }

    public final Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(final Date horaFinalRecibida) {
        horaFinal = horaFinalRecibida;
    }

    /* Recursivamente asignamos la hora inicial de los objetos
    padre con los que tratemos, siempre y cuando estos tiempos
    estén a null*/
    public void actualizarInicio(final Date fecha) {
        if (horaInicio == null) {
            if (padre != null) {
                padre.actualizarInicio(fecha);
            }
            setHoraInicio(fecha);
        }
    }

    /* Recursivamente asignamos la hora final de los objetos
    padre con los que tratemos, en todas las situaciones (debido
    a que siempre será posterior a null o cualquier fecha)*/
    public void actualizarFinal(final Date fecha) {
        if (padre != null) {
            padre.actualizarFinal(fecha);
        }
        setHoraFinal(fecha);
    }
    /*Implementación para el patrón visitor*/
    protected abstract void accept(Visitor visitor);

    /*Necesario para redefinirla en la herencia*/
    public ArrayList<Actividad> getActividades() {
        return null;
    }
    private void invariante() {
        if (padre == null) throw new AssertionError(
                "La variable padre no puede ser nula");
        if (nombre == null) throw new AssertionError(
                "La variable nombre no puede ser nula");
    }
}

