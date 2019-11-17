package core.ds;

public interface VisitorElementos {
    void visit(ElementoSeparador separador);
    void visit(ElementoTitulo titulo);
    void visit(ElementoSubTitulo subtitulo);
    void visit(ElementoTabla tabla);
    void visit(ElementoParrafo texto);
}