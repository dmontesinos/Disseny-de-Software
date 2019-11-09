package core.ds;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static core.ds.Cliente.SEGUNDOS;

/* Clase encargada de crear un relój con una sola instancia
y notificar a los intervalos que se encuentran en el array
de objetos a notificar. Implementa un Singleton para la única
instancia. */
public final class Reloj extends TimerTask {
    //Para posteriores conversiones de tiempo
    private static final long MILISEGUNDOS = 1000;
    //Instancia única del reloj
    private static Reloj instanciaReloj = null;
    private Reloj.Notificador notificador = new Reloj.Notificador();
    private static Timer reloj = null;
    private Proyecto proyectoRaiz;

    private Reloj() { //Esto es una clase Bean
        //Daemon para que el thread corra de fondo
        reloj = new Timer();
        reloj.scheduleAtFixedRate(this, 0, SEGUNDOS * MILISEGUNDOS);
    }
    //Singleton, solo una instancia de un reloj, si existe no lo crea
    public static Reloj getInstanciaReloj() {
        if (instanciaReloj  == null) {
            instanciaReloj  = new Reloj();
        }
        return instanciaReloj;
    }

    public static void pararReloj() {
        if (reloj != null) {
            reloj.cancel();
        }
    }

    public void comenzarPrintarArbol(final Proyecto proyecto) {
        proyectoRaiz = proyecto;
    }

    @Override
    //Encargado de notificar la nueva fecha y printar el árbol
    public void run() {
        notificador.informarNuevaFecha(new Date());
        if (proyectoRaiz != null) {
            proyectoRaiz.printar();
        }
    }

    public void anadirObservador(final Intervalo intervalo) {
        notificador.addPropertyChangeListener(intervalo);
    }

    public void borrarObservador(final Intervalo intervalo) {
        notificador.removePChangeListener(intervalo);
    }

    public Timer getReloj() {
        return reloj;
    }

    public void setReloj(final Timer tReloj) {
        reloj = tReloj;
    }

    /*Esta clase encapsula los métodos típicos de la implemetación
    del observer/observable, con la intención de cambiar los nombres
    a las funciones y hacer más sencilla su utilización. No es
    necesaria.*/
    private class Notificador {
        private PropertyChangeSupport providerChangeSupport
                = new PropertyChangeSupport(this);
        private Date fecha = new Date();

        private void addPropertyChangeListener(final PropertyChangeListener l) {
            providerChangeSupport.addPropertyChangeListener(l);
        }

        private void removePChangeListener(final PropertyChangeListener l) {
            providerChangeSupport.removePropertyChangeListener(l);
        }

        private void informarNuevaFecha(final Date nuevaFecha) {
            providerChangeSupport.firePropertyChange("actualizacionHora",
                    fecha, nuevaFecha);
        }
    }
}







