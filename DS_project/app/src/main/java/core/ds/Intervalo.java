package core.ds;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

import static core.ds.Cliente.SEGUNDOS;

public class Intervalo implements PropertyChangeListener{
    private Date horaInicio;
    private Date horaFinal;
    private Tarea tareaPadre;
    private long duracionTotal;


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

    public void setDuracionTotal(long valor){
        duracionTotal = valor;
    }

    public long getDuracionTotal(){
        return duracionTotal;
    }

    /*@Override
    public void propertyChange(PropertyChangeEvent evt) {
        setHoraFinal((Date) evt.getNewValue());
        this.duracion += SEGUNDOS;
        /*duracion = this.horaFinal.getTime() - this.horaInicio.getTime() ;
        duracion = (int)Math.ceil(duracion/1000.0);
    }*/

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        assert evt.getPropertyName().equals("actualizacionHora");
        Date nuevaHoraSistema = (Date) evt.getNewValue(); //Recoge la nueva hora del reloj actualizada
        setHoraFinal(nuevaHoraSistema);
        //long duracion = (long)(getHoraFinal().getTime() - getHoraInicio().getTime());
        duracionTotal += SEGUNDOS;

        this.actualizarPadreRec(nuevaHoraSistema);
        // this.getTareaPadre().setHoraFinal(nuevaHoraSistema);
    }

    public void actualizarPadreRec(Date nuevaHoraSistema){
        if(this.getTareaPadre() != null){
            tareaPadre.actualizarFinal(nuevaHoraSistema);
        }
        setHoraFinal(nuevaHoraSistema);
    }
}





