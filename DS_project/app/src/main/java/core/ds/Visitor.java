package core.ds;

interface Visitor {
    void visit(Proyecto proyecto);
    void visit(Tarea tarea);
}
