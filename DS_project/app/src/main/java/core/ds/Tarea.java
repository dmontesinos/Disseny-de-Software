package core.ds;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import static core.ds.Cliente.SEGUNDOS;

public class Tarea extends Actividad{
    public LinkedList<Intervalo> intervalos;

    public Tarea(String nombre, Proyecto proyecto){
        super(nombre,proyecto);
        intervalos = new LinkedList<Intervalo>();
    }

    /* Iniciamos creando una fecha nueva actual.
    Actualizamos la fecha inicial si es necesario.
    Creamos un nuevo intervalo.
    Añadimos el intervalo al array.
    Añadimos al array de Listeners del reloj ya creado la tarea, ya escuchando.
     */
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

    public void detenerTarea(){
        Reloj reloj = Reloj.getInstanciaReloj();
        Intervalo intervalo = intervalos.getLast();
        this.setHoraFinal(intervalo.getHoraFinal());
        reloj.borrarObservador(intervalo);

        /*Proyecto proyecto = getPadre();
        reloj.printarArbol(proyecto);*/

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
            System.out.print("\t\t\t" + getDuracionTotal()+"\n");
        }
        else{
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
    }

    /*public void calcularTiempoTotal(){
        long total = 0;

        for (Intervalo i: intervalos){
            total += i.getDuracionTotal();
        }

        this.setDuracionTotal(total);
    }*/

    public long getDuracionTotal(){
        long total = 0;

        for (Intervalo i: intervalos){
            total += i.getDuracionTotal();
        }

        return total;
    }

}
