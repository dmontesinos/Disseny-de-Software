package core.ds;


import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Date;


public class GenerarReloj extends Thread {
    int segundos = 0;
    private Reloj reloj;

    private String transcurso;
    private PropertyChangeSupport support;


    public GenerarReloj(int segundos){
        support = new PropertyChangeSupport(this); //Observable
        this.segundos = segundos;
        reloj  = new Reloj();
        reloj = reloj.getInstanciaReloj(); //Te crea el reloj si no existe, si existe te devuelve el que existe
        this.start();//Una vez generado el reloj activar el thread que correra el run
    }

    ////////////////////FUNCIONES OBSERVABLE//////////////////////////
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        support.removePropertyChangeListener(pcl);
    }

    public void setTranscurso(String value) {
        support.firePropertyChange("transcurso", this.transcurso, value);
        this.transcurso = value;
    }

    //////////////////////////////////////////////////////////////////


    @Override
    public void run() {
        while(true){
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reloj.tick(); //Cada 2 segundos llamamos a tick
        }
    }


    public class Reloj{
        private Date fecha;
        private Reloj instanciaReloj = null;

        private Reloj( ) {//Esto es una clase Bean
            this.fecha = new Date();
        }


        public Reloj getInstanciaReloj(){ //Comprobacion de si existe reloj, si no existe se crea.
            if(instanciaReloj == null){
                instanciaReloj = new Reloj();
            }
            return instanciaReloj;
        }

        public void tick(){
            //Cada dos segundos, que queremos que haga el reloj?
            //Avisar al intervalo de que ha pasado 2 segundos para actualizarse
            //Hacer lo del java beans
            System.out.println(reloj.fecha);

        }
    }
}
