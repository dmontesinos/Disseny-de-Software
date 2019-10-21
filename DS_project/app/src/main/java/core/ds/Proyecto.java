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
           /* SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
            SimpleDateFormat formatDay = new SimpleDateFormat("dd-MM-yy");
            System.out.print(" \t\t" + formatDay.format(getHoraInicio()) + " " + format.format(getHoraInicio()));
            System.out.print(" \t\t" + formatDay.format(getHoraFinal()) + " " + format.format(getHoraFinal()));*/
            System.out.print("\t\t" + sdf.format(getHoraInicio()) +"\t\t"+ sdf.format(getHoraFinal()));
            /*long time = getDuracionTotal();
            time=time/1000;
            int horas = ((int)time / 3600);
            int minutos = (((int)time - horas * 3600) / 60);
            int segundos = (int)time - (horas * 3600 + minutos * 60);
            System.out.print("\t\t\t" +horas+":"+minutos+":"+segundos+"\n");*/
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

    public void calcularTiempoTotal(){
        long total = 0;

        for(Actividad a: actividades){
            total += a.getDuracionTotal();
        }
        setDuracionTotal(total);
    }
}
