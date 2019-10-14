package core.ds;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Reloj extends TimerTask {
    private int segundos;
    private Timer temporizador;
    private PropertyChangeSupport support;

    public Reloj(int segundos){
        this.segundos = segundos;
        this.support = new PropertyChangeSupport(this);
        this.temporizador = new Timer(true); //Daemon
        this.temporizador.schedule(this, 0, this.segundos); //tarea + retraso + tiempo
    }

    @Override
    public void run(){
        while(true){
            this.support.firePropertyChange("tick_reloj", null, new Date());
        }
    }

    public void addTimePropertyChangeListener(PropertyChangeListener pcl){
        this.support.addPropertyChangeListener(pcl);
    }

    public void removeTimePropertyChangeListener(PropertyChangeListener pcl){
        this.support.removePropertyChangeListener(pcl);
    }


}