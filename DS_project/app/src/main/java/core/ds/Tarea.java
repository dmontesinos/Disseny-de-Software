package core.ds;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.SQLOutput;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import static core.ds.Cliente.SEGUNDOS;

public class Tarea extends Actividad{
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
        reloj.anadirObservador(intervalo);

        if(this.getHoraInicio() == null)
            this.setHoraInicio(new Date());
        this.setHoraFinal(null);
    }

    public void detenerTarea(Reloj reloj){
        Intervalo intervalo = this.intervalos.get(this.intervalos.size() - 1);
        Proyecto proyecto = getPadre();
        reloj.borrarObservador(intervalo);
        this.setHoraFinal(intervalo.getHoraFinal());

        //reloj.borrarObservador(this);

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
        if(getHoraInicio() != null && getHoraFinal() != null) {
            System.out.print("\t\t" + sdf.format(getHoraInicio()) +"\t\t"+ sdf.format(getHoraFinal()));
            //long time = getDuracionTotal();

            System.out.print("\t\t\t" + getDuracionTotal()+"\n");
        }
        else{
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
    }

    /*@Override
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
        }
    }*/

    public void calcularTiempoTotal(){
        long total = 0;
        if(this.getPadre() != null) {

            for (Intervalo i:intervalos){
                total += i.getDuracionTotal();
            }
        }
        this.setDuracionTotal(total);
    }


    /*public void actualizarDuracion(long duracion) {
        if (this.getPadre() != null) {
            this.getPadre().setDuracionTotal(duracion);
        }
        this.setDuracionTotal(duracion);
    }*/
}
