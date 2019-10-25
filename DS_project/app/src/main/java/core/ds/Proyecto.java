package core.ds;

import java.util.ArrayList;

/* Se encarga de almacenar más proyectos y tareas. También almacena el tiempo total de todos los
* objetos que le cuelgan. */
public class Proyecto extends Actividad {
    public ArrayList<Actividad> actividades;


    public Proyecto(String nombre, Proyecto padre){
        super(nombre,padre);
        actividades = new ArrayList<Actividad>();
    }


    public void anadir(Actividad act){
        actividades.add(act);
    }

    public ArrayList<Actividad> getActividades(){
        return actividades;
    }

    /* Función encargada de mostrar los objetos de la estructura del árbol de tipo proyecto. Además,
    como la raíz del árbol es un proyecto, en caso de situarnos en dicha raíz, mostramos una
    cabecera.*/
    public void printar(){
        if(getPadre()==null){
            System.out.println("\nNom          Temps inici           Temps final           Durada(hh:mm:ss)");
            System.out.println("----+------------------------+-------------------------+--------------------------");
        }
        System.out.print(this.getNombre());
        if(getHoraInicio()!=null && getHoraFinal()!=null) {
            System.out.print("\t\t" + sdf.format(getHoraInicio()) +"\t\t"+ sdf.format(getHoraFinal()));
            System.out.print("\t\t\t" + getDuracionTotal()+"\n");
        }
        else{
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t00:00:00");
        }
        for (Actividad a: actividades) {
            a.printar();
        }
    }

    public void setDuracionTotal(long duracion){
        this.duracionTotal = duracion;
    }

    /*Función recursiva encargada de calcular el tiempo total del proyecto. Para ello, coge las
    actividades que cuelgan del array de esta clase y suma recursivamente los tiempos de sus objetos.*/
    public long getDuracionTotal(){
        long total = 0;

        for(Actividad a: actividades){
            total += a.getDuracionTotal();
        }
        setDuracionTotal(total);
        return total;
    }
}
