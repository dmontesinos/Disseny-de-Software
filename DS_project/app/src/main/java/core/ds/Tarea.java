package DS.core;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLOutput;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static DS.core.Cliente.SEGUNDOS;

public class Tarea extends Actividad implements PropertyChangeListener {
    public ArrayList<Intervalo> intervalos;

    public Tarea(String nombre, Proyecto proyecto){
        super(nombre,proyecto);
        intervalos = new ArrayList<Intervalo>();
    }

    /* Iniciamos creando una fecha nueva actual.
    Actualizamos la fecha inicial si es necesario.
    Creamos un nuevo intervalo.
    Añadimos el intervalo al array.
    Añadimos al array de Listeners del reloj ya creado la tarea, ya escuchando.
     */
    public void iniciarTarea(Reloj reloj) {
        Date fecha = new Date(); //Cogemos hora del sistema. Deberiamos cogerla del reloj?
        actualizarInicio(fecha);
        Intervalo intervalo = new Intervalo(fecha,this);
        intervalos.add(intervalo);
        reloj.anadirObservador(this);

        if(this.getHoraInicio() == null)
            this.setHoraInicio(new Date());
        this.setHoraFinal(null);
    }

    public void detenerTarea(Reloj reloj){
        Intervalo intervalo = this.intervalos.get(this.intervalos.size() - 1);
        Proyecto proyecto = getPadre();
        reloj.borrarObservador(intervalo);
        reloj.borrarObservador(this);
        this.setHoraFinal(intervalo.getHoraFinal());

        /*long calculoDuracion = getDuracionTotal();
        calculoDuracion += SEGUNDOS;
        this.setDuracionTotal(calculoDuracion);

        if(this.getPadre() != null)
        {
            calculoDuracion += this.getPadre().getDuracionTotal();
            this.getPadre().setDuracionTotal(calculoDuracion);
        }*/
        reloj.printarArbol(proyecto);
    }


    @Override
    public String toString(){
        String a = super.toString();
        return String.format("%s", a);
    }
    public void printar(){
        System.out.print(this.getNombre());
        if(getHoraInicio()!=null && getHoraFinal()!=null) {

           /* SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat formatDay = new SimpleDateFormat("dd-MM-yy");
            System.out.println();
            System.out.print(" \t\t" + formatDay.format(getHoraInicio()) + " " + format.format(getHoraInicio()));
            System.out.print(" \t\t" + formatDay.format(getHoraFinal()) + " " + format.format(getHoraFinal()));*/
            System.out.print("\t\t" + sdf.format(getHoraInicio()) +"\t\t"+ sdf.format(getHoraFinal()));
            //System.out.println(this.getNombre() + "    " + getHoraInicio() + "    " + getHoraFinal() + "     ");
            long time = getDuracionTotal();
            /*time=time/1000;
            int horas = ((int)time / 3600);
            int minutos = (((int)time - horas * 3600) / 60);
            int segundos = (int)time - (horas * 3600 + minutos * 60);
            System.out.print("\t\t\t" +horas+":"+minutos+":"+segundos+"\n");*/
            System.out.print("\t\t\t" + getDuracionTotal()+"\n");
        }
        else{
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        assert evt.getPropertyName().equals("actualizacionHora");
        Date nuevaHoraSistema = (Date) evt.getNewValue(); //Recoge la nueva hora del reloj actualizada
        //Intervalo ultimoIntervalo = intervalos.get(); //Comprobar si realmente coge el ultimo. size()-1 si no.
        Intervalo ultimoIntervalo = intervalos.get(intervalos.size()-1); //Comprobar si realmente coge el ultimo. size()-1 si no.
        ultimoIntervalo.setHoraFinal(nuevaHoraSistema);
        actualizarFinal(nuevaHoraSistema);

        long calculoDuracion = getDuracionTotal();
        calculoDuracion += SEGUNDOS;

        this.actualizarDuracion(calculoDuracion);

        /*if(this.getPadre() != null)
        {
            calculoDuracion += this.getPadre().getDuracionTotal();
            this.getPadre().setDuracionTotal(calculoDuracion);
        }*/
    }

    public void actualizarDuracion(long duracion) {
        if (this.getPadre() != null) {
            this.getPadre().setDuracionTotal(duracion);
        }
        this.setDuracionTotal(duracion);
    }
}
