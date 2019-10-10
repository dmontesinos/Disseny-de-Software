package core.ds;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;

public class Intervalo implements PropertyChangeListener {
    private Date fechaInicio;
    private Date fechaFinal;


    public void propertyChange(PropertyChangeEvent evt) {
        //assert evt.getPropertyName().equals("last news");
        //String news = (String) evt.getNewValue();
        //System.out.println(news);
        //Hay que sobreescribir este metodo de la interficie, esta es la que se encarga de establecer los intervalos
        //que obtenemos de escuchar el temporizador
    }

    public void setInicio(Date valor){
        fechaInicio = valor;
    }

    public void setFechaFinal(Date valor){
        fechaFinal = valor;
    }

    public Date getFechaInicio(){
        return fechaInicio;
    }
    public Date getFechaFinal(){
        return fechaFinal;
    }

    public void crearIntervalo(){
        //Hacer aqui que el intervalo consulte al reloj para obtener tiempo
        //con la llamada a propertyChange();
    }






}
