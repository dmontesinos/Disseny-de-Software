package core.ds;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.Date;

public class Tarea extends Actividad implements PropertyChangeListener {
    private int id;
    private ArrayList<Intervalo> intervalos;

    public Tarea(String nombre, Proyecto proyecto){
        super(nombre,proyecto);
        intervalos = new ArrayList<Intervalo>();
    }

    public void mostrar(){
        System.out.println(this.getNombre());
        for (Intervalo inter: intervalos) {
            inter.mostrar();
        }
    }

    @Override
    public String toString(){
        String a = super.toString();
        return String.format("%s", a);
    }




    @Override
    public void propertyChange(PropertyChangeEvent evt){
        if(evt.getPropertyName().equals("tick_reloj")) {
            Date fecha = (Date) evt.getNewValue();
            System.out.println(fecha);
        }
    }

    public void iniciarTemporizador(Reloj reloj){
        Intervalo nuevoIntervalo = new Intervalo();
        Date fechaInicio = new Date();
        nuevoIntervalo.setInicio(fechaInicio);
        intervalos.add(nuevoIntervalo);
        reloj.addTimePropertyChangeListener(this);
    }
}

