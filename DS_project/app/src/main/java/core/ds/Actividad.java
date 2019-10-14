package core.ds;

public class Actividad {

    protected String nombre;
    protected String descripcion;
    protected Proyecto padre;

    public Actividad(String nombre, Proyecto padre) {
        this.nombre = nombre;
        this.padre = padre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion(){
        return descripcion;
    }

    public Proyecto getPadre(){
        return padre;
    }

    /*@Override
    public String toString(){

        return String.format("%s", getNombre());
    }*/

    public void mostrar(){}
}
