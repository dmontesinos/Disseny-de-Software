package DS.core;

import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class  Actividad {

    private String nombre;
    private Proyecto padre;
    private Date horaInicio;
    private Date horaFinal;
    private long duracionTotal;
    protected SimpleDateFormat sdf = new SimpleDateFormat("dd-M-yyyy HH:mm:ss");

    public Actividad(String nombre,Proyecto padre){
        this.setNombre(nombre);
        this.setPadre(padre);
    }

    public Proyecto getPadre(){ return padre;}

    @Override
    public String toString(){
        return String.format("%s", getNombre());
    }

    public void printar(){


    }

    public long getDuracionTotal() {
        return duracionTotal;
    }

    public void setDuracionTotal(long valor){
        duracionTotal = valor;
    }

    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPadre(Proyecto padre) {
        this.padre = padre;
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

    //RE
    public void actualizarInicio(Date fecha) {
        if(horaInicio == null)
        {
            if(padre != null)
            {
                padre.actualizarInicio(fecha);
            }
            setHoraInicio(fecha);
        }
    }

    //RE
    public void actualizarFinal(Date fecha) {
        if (padre != null) {
            padre.actualizarFinal(fecha);
        }
        setHoraFinal(fecha);
    }
}
