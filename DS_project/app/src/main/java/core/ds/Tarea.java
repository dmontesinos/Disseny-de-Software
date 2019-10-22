package core.ds;

import java.util.Date;
import java.util.LinkedList;


public class Tarea extends Actividad{
    public LinkedList<Intervalo> intervalos;

    public Tarea(String nombre, Proyecto proyecto){
        super(nombre,proyecto);
        intervalos = new LinkedList<>();
    }

    /* Función encargada de iniciar el crono de una tarea y, por tanto, crear, iniciar y añadir los
    observers necesarios.*/
    public void iniciarTarea() {
        Reloj reloj = Reloj.getInstanciaReloj();
        Date fecha = new Date();
        actualizarInicio(fecha);
        Intervalo intervalo = new Intervalo(fecha,this);
        intervalos.add(intervalo);
        reloj.anadirObservador(intervalo);

        if(this.getHoraInicio() == null)
            this.setHoraInicio(new Date());
        this.setHoraFinal(null);
    }

    /* Función encargada cerrar los intérvalos. De misma forma, se asigna la fecha final del
    intérvalo y es borrado del array de observadores, ya que no queremos más actualizaciones.*/
    public void detenerTarea(){
        Reloj reloj = Reloj.getInstanciaReloj();
        Intervalo intervalo = intervalos.getLast();
        this.setHoraFinal(intervalo.getHoraFinal());
        reloj.borrarObservador(intervalo);
    }


    @Override
    public String toString(){
        String a = super.toString();
        return String.format("%s", a);
    }

    /* Función encargada de mostrar los objetos de la estructura del árbol de tipo Tarea. */
    public void printar(){
        System.out.print(this.getNombre());
        if(getHoraInicio() != null && getHoraFinal() != null) {
            System.out.print("\t\t" + sdf.format(getHoraInicio()) +"\t\t"+ sdf.format(getHoraFinal()));
            System.out.print("\t\t\t" + getDuracionTotal()+"\n");
        }
        else{
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
    }

    /*Función recursiva encargada de calcular el tiempo total de la tarea. Para ello, coge todos los
    intérvalos pertenecientes al array de intérvalos y los suma*/
    public long getDuracionTotal(){
        long total = 0;

        for (Intervalo i: intervalos){
            total += i.getDuracionTotal();
        }

        return total;
    }

}
