package core.ds;
/*Al igual que la clase Visitor, en esta clase se establecen
* los elementos a los cuales se podrá visitar mediante el pa-
* trón Visitor. En este caso nos permitirá guardar los elementos
* mediante diferentes formatos e informes.*/
public interface VisitorElementos {
    void visit(ElementoSeparador separador);
    void visit(ElementoTitulo titulo);
    void visit(ElementoSubTitulo subtitulo);
    void visit(ElementoTabla tabla);
    void visit(ElementoParrafo texto);
}