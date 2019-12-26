package core.ds;
/*Mediante esta clase podemos realizar los visit correspondientes
* para cada formato y tipo de elemento y así poder aplicar el pa-
* trón de diseño Visitor.*/
public abstract class Formato implements VisitorElementos {
    public abstract void visit(ElementoSeparador separador);
    public abstract void visit(ElementoTitulo titulo);
    public abstract void visit(ElementoSubTitulo subTitulo);
    public abstract void visit(ElementoTabla tabla);
    public abstract void visit(ElementoParrafo parrafo);
    public abstract String getContenido();
}
