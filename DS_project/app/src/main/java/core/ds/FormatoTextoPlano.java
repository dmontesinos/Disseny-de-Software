package core.ds;

public class FormatoTextoPlano extends Formato {
    private String contenido;
    public FormatoTextoPlano() {
        super();
    }

    public String getContenido() {
        return contenido;
    }

    public void visit(ElementoSeparador separadorRecibido) {
        //contenido += separadorRecibido.getElementoSeparador();
        contenido += "---------------------------------\n";
    }

    public void visit(ElementoTitulo tituloRecibido) {
        contenido += tituloRecibido.getElementoTitulo();
    }

    public void visit(ElementoSubTitulo subtituloRecibido) {
        contenido += subtituloRecibido.getElementoSubtitulo();
    }

    public void visit(ElementoTabla tablaRecibida) {
        contenido += tablaRecibida.getElementoTabla();
    }

    public void visit(ElementoParrafo parrafoRecibido) {
        contenido += parrafoRecibido.getElementoParrafo();
    }
}
