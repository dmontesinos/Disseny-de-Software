package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

import static core.ds.Cliente.SEGUNDOS;
/* Esta clase básicamente almacena los datos referentes a un intérvalo.
Además implementa un Listener contra la clase reloj para actualizar sus
tiempos. También implementa el Serializable para almacenar los
intérvalos en un fichero externo. */

public class Intervalo implements PropertyChangeListener, Serializable {
    private Date horaInicio;
    private Date horaFinal;
    private Tarea tareaPadre;
    private long duracionTotal;
    private static final Logger Log = LoggerFactory.getLogger(Intervalo.class);


    public Intervalo(final Date horaInicial, final Tarea padre) {
        horaInicio = horaInicial;
        setTareaPadre(padre);
        duracionTotal = 0;
        horaFinal = null;
        invariantePadre();
        invarianteInicio();
        Log.debug("Creando un nuevo intervalo");
    }

    public final Date getHoraInicio() {
        invarianteInicio();
        return horaInicio;
    }

    public void setHoraInicio(final Date horaInicial) {
        horaInicio = horaInicial;
    }

    public final Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(final Date hFinal) {
        horaFinal = hFinal;
        invarianteFinal();
    }

    public final Tarea getTareaPadre() {
        invariantePadre();
        return tareaPadre;
    }

    public void setTareaPadre(final Tarea tPadre) {
        tareaPadre = tPadre;
        invariantePadre();
    }

    public void setDuracionTotal(final long valor) {
        duracionTotal = valor;
    }

    public final long getDuracionTotal() {
        return duracionTotal;
    }
    @Override
    //Permite recibir las actualizaciones del reloj
    public void propertyChange(final PropertyChangeEvent evt) {
        //assert evt.getPropertyName().equals("actualizacionHora"); //Debug
        //Recoge la nueva hora del reloj actualizada
        Date nuevaHoraSistema = (Date) evt.getNewValue();
        //Por cada tick, aumentamos la duración total del intérvalo
        duracionTotal += SEGUNDOS;
        //Actualizamos recursivamente la hora final del/los padres
        this.actualizarPadreRec(nuevaHoraSistema);
    }

    //Subimos las fechas hasta la raíz
    public void actualizarPadreRec(final Date nuevaHoraSistema) {
        tareaPadre.actualizarFinal(nuevaHoraSistema);
        setHoraFinal(nuevaHoraSistema);
    }
    private void invariantePadre() {
        if (tareaPadre == null) throw new AssertionError(
                "La variable tareaPadre no puede ser nula");
    }
    private void invarianteInicio() {
        if (horaInicio == null) throw new AssertionError(
                "La variable horaInicio no puede ser nula");
    }
    private void invarianteFinal() {
        if (horaFinal == null) throw new AssertionError(
                "La variable horaFinal no puede ser nula");
    }
}





