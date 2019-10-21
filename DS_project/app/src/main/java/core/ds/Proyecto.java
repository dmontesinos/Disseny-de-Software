package core.ds;
import java.sql.Time;
import java.util.ArrayList;

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

    /*public void calcularTiempoTotal(){
        long total = 0;

        for(Actividad a: actividades){
            total += a.getDuracionTotal();
        }
        setDuracionTotal(total);
    }*/

    public long getDuracionTotal(){
        long total = 0;

        for(Actividad a: actividades){
            total += a.getDuracionTotal();
        }
        return total;
    }

    public Proyecto obtenerRaiz(Proyecto valor){
        if(valor.getPadre() != null){
            obtenerRaiz(valor);
        } else {
            return valor;
        }
        return this;
    }
}
