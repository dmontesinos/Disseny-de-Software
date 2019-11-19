package core.ds;
/*Todos los elementos que cuelgan de este, servirán para generar
* los formularios y utilizar el método accept para el funcionamiento
* del patrón de diseño del Visitor, permitiendo formatear los docu-
* mentos en distintos formatos.*/
public class Elemento {
    public void accept(final Formato formato) { };
}
