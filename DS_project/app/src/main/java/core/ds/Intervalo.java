package core.ds;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Date;

import static core.ds.Cliente.SEGUNDOS;
/* Esta clase básicamente almacena los datos referentes a un intérvalo. Además implementa un
* Listener contra la clase reloj para actualizar sus tiempos. También implementa el Serializable
* para almacenar los intérvalos en un fichero externo. */
public class Intervalo implements PropertyChangeListener, Serializable {
    private Date horaInicio;
    private Date horaFinal;
    private Tarea tareaPadre;
    private long duracionTotal;


    public Intervalo( Date horaInicio,Tarea padre){
        this.horaInicio = horaInicio;
        setTareaPadre(padre);
        duracionTotal = 0;
        horaFinal = null;
    }

    public Date getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(Date horaFinal) {
        this.horaFinal = horaFinal;
    }

    public Tarea getTareaPadre() {
        return tareaPadre;
    }

    public void setTareaPadre(Tarea tareaPadre) {
        this.tareaPadre = tareaPadre;
    }

    public void setDuracionTotal(long valor){
        duracionTotal = valor;
    }

    public long getDuracionTotal(){
        return duracionTotal;
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) { //Permite recibir las actualizaciones del reloj
        assert evt.getPropertyName().equals("actualizacionHora"); //Debug
        Date nuevaHoraSistema = (Date) evt.getNewValue(); //Recoge la nueva hora del reloj actualizada
        duracionTotal += SEGUNDOS; //Por cada tick, aumentamos la duración total del intérvalo
        this.actualizarPadreRec(nuevaHoraSistema); //Actualizamos recursivamente la hora final del/los padres
    }

    public void actualizarPadreRec(Date nuevaHoraSistema){ //Subimos las fechas hasta la raíz
        tareaPadre.actualizarFinal(nuevaHoraSistema);
        setHoraFinal(nuevaHoraSistema);
    }
}





