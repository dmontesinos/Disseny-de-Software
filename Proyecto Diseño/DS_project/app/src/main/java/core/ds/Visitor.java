package core.ds;
/*Clase que contiene las funciones necesarias para saber a quién
* visitar en caso de aplicar el patrón Visitor. En este caso, nos
* permite printar mediante el impresor cada Actividad concreta
* de forma particular.*/
interface Visitor {
    void visit(Proyecto proyecto);
    void visit(Tarea tarea);
    void visitCabecera(Proyecto proyecto);
}
