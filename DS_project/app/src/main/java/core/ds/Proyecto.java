package core.ds;

import java.util.ArrayList;

public class Proyecto extends Actividad {
    public ArrayList<Actividad> actividades;

    public Proyecto(String nombre, Proyecto padre){
        super(nombre,padre);
        actividades = new ArrayList<Actividad>();
    }

    public void mostrar(){
        System.out.println(this.getNombre()+"\t Temps inici\t"+"  Temps Final\t"+"  Durada");
        for (Actividad act: actividades) {
            act.mostrar();
        }
    }

    public void setTarea(Actividad act){
        actividades.add(act);
    }

    public ArrayList<Actividad> getProyectos(){
        return actividades;
    }
}
