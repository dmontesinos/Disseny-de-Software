package core.ds;

import java.util.ArrayList;

public abstract class Formato implements VisitorElementos {
    public abstract void visit(ElementoSeparador separador);
    public abstract void visit(ElementoTitulo titulo);
    public abstract void visit(ElementoSubTitulo subTitulo);
    public abstract void visit(ElementoTabla tabla);
    public abstract void visit(ElementoParrafo parrafo);
    public abstract String getContenido();
}
