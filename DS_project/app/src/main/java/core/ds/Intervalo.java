package DS.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import static DS.core.Cliente.SEGUNDOS;

public class Intervalo implements PropertyChangeListener{
    private Date horaInicio;
    private Date horaFinal;
    private Tarea tareaPadre;
    private long duracion;


    public Intervalo( Date horaInicio,Tarea padre){
        this.horaInicio = horaInicio;
        setTareaPadre(padre);
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

    public void setDuracion(long valor){
        duracion = valor;
    }

    public long getDuracion(){
        return duracion;
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        setHoraFinal((Date) evt.getNewValue());
        this.duracion += SEGUNDOS;
        /*duracion = this.horaFinal.getTime() - this.horaInicio.getTime() ;
        duracion = (int)Math.ceil(duracion/1000.0);*/
    }

}





