package core.ds;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static core.ds.Cliente.SEGUNDOS;

public class Reloj extends TimerTask {

    //private static final int SEGUNDOS = 2;
    private static final long MILISEGUNDOS = 1000;
    private static Reloj instanciaReloj = null;
    private Reloj.Notificador notificador = new Reloj.Notificador();
    private static Timer reloj = null;
    Proyecto proyectoRaiz;


    //RE
    private Reloj() { //Esto es una clase Bean
        reloj = new Timer();//Daemon para que el thread corra de fondo
        reloj.scheduleAtFixedRate(this, 0, SEGUNDOS * MILISEGUNDOS);
    }

    public static Reloj getInstanciaReloj(){ //Singleton, solo una instancia de un reloj, si existe no lo crea
        if (instanciaReloj  == null){
            instanciaReloj  = new Reloj();
        }
        return instanciaReloj;
    }

    public static void stopReloj(){
        if( reloj != null) {
            reloj.cancel();
        }
    }

    public void printarArbol(Proyecto proyecto){
        proyectoRaiz = proyecto;
    }

    @Override
    public void run() {
        notificador.informarNuevaFecha(new Date());
        if(proyectoRaiz != null){
            proyectoRaiz.printar();
        }
    }

    public void anadirObservador(Intervalo intervalo){
        notificador.addPropertyChangeListener(intervalo);
    }
    /*public void anadirObservador(Tarea tarea){
        notificador.addPropertyChangeListener(tarea);
    }*/

    public void borrarObservador(Intervalo intervalo){
        notificador.removePropertyChangeListener(intervalo);
    }
    /*public void borrarObservador(Tarea tarea){
        notificador.removePropertyChangeListener(tarea);
    }*/

    public Timer getReloj() {
        return reloj;
    }

    public void setReloj(Timer reloj) {
        this.reloj = reloj;
    }


    private class Notificador{

        PropertyChangeSupport providerChangeSupport =  new PropertyChangeSupport(this);
        private Date fecha = new Date();

        public void addPropertyChangeListener(PropertyChangeListener l){
            providerChangeSupport.addPropertyChangeListener(l);
        }

        public void removePropertyChangeListener(PropertyChangeListener l){
            providerChangeSupport.removePropertyChangeListener(l);
        }

        public void informarNuevaFecha(Date nuevaFecha) {
            providerChangeSupport.firePropertyChange("actualizacionHora", fecha, nuevaFecha);
            fecha = nuevaFecha;
        }

    }
}







