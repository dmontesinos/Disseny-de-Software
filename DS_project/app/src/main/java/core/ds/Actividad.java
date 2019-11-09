package core.ds;

import java.io.Serializable;
import java.util.Date;

/* Clase abstracta con métodos destinados a actualizar recursivamente
los tiempos finales e iniciales. Algunos métodos están implementado en
sus hijos, dado que se implementan de forma particular. */
public abstract class  Actividad implements Serializable {
    private String nombre;
    private Proyecto padre;
    private Date horaInicio;
    private Date horaFinal;
    private long duracionTotal;

    public Actividad(final String nombreRecibido,
                     final Proyecto padreRecibido) {
        this.setNombre(nombreRecibido);
        this.setPadre(padreRecibido);
    }

    public final Proyecto getPadre() {
        return padre;
    }

    @Override
    public final String toString() {
        return String.format("%s", getNombre());
    }

    public void printar() {

    } //Cada implementación está en su respectiva clase.

    //Cada implementación estña en su clase.
    public abstract long getDuracionTotal();

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
}

