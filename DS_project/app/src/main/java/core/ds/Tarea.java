package core.ds;

public class Tarea extends Actividad{
    private int id;

    public Tarea(String nombre, Proyecto proyecto){
        super(nombre,proyecto);
    }

    public void mostrar(){
        System.out.println(this.getNombre());
    }

    @Override
    public String toString(){
        String a = super.toString();
        return String.format("%s", a);
    }
}

