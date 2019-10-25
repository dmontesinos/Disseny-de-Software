package core.ds;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

/* Clase abstracta con métodos destinados a actualizar recursivamente los tiempos finales e
iniciales. Algunos métodos están implementado en sus hijos, dado que se implementan de forma
 particular. */
public abstract class  Actividad implements Serializable {
    private String nombre;
    private Proyecto padre;
    private Date horaInicio;
    private Date horaFinal;
    protected long duracionTotal;
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

    public void printar(){} //Cada implementación está en su respectiva clase.

    public abstract long getDuracionTotal(); //Cada implementación estña en su clase.

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


    /* Recursivamente asignamos la hora inicial de los objetos padre con los que tratemos, siempre
    y cuando estos tiempos estén a null*/
    public void actualizarInicio(Date fecha) {
        if(horaInicio == null) {
            if(padre != null) {
                padre.actualizarInicio(fecha);
            }
            setHoraInicio(fecha);
        }
    }

    /* Recursivamente asignamos la hora final de los objetos padre con los que tratemos, en todas
    las situaciones (debido a que siempre será posterior a null o cualquier fecha)*/
    public void actualizarFinal(Date fecha) {
        if (padre != null) {
            padre.actualizarFinal(fecha);
        }
        setHoraFinal(fecha);
    }
}

