package core.ds;

public class ElementoTitulo extends Elemento {
    private String titulo;

    public ElementoTitulo() {
        titulo = null;
    }
    public ElementoTitulo(String tituloRecibido) {
        titulo = tituloRecibido;
        titulo += "\n";
    }

    public void setTitulo(String tituloRecibido) {
        titulo = tituloRecibido;
        titulo += "\n";
    }

    public String getElementoTitulo() {
        return titulo;
    }

    public void accept(Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
}
