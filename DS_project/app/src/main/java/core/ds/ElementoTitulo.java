package core.ds;
/*Genera elementos de tipo título para los informes*/
public class ElementoTitulo extends Elemento {
    private String titulo;

    public ElementoTitulo() {
        titulo = null;
    }
    public ElementoTitulo(final String tituloRecibido) {
        titulo = tituloRecibido;
        titulo += "\n";
    }

    public void setTitulo(final String tituloRecibido) {
        titulo = tituloRecibido;
        titulo += "\n";
    }

    public String getElementoTitulo() {
        return titulo;
    }

    public void accept(final Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
}
