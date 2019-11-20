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
        invariante();
    }

    public void setTitulo(final String tituloRecibido) {
        titulo = tituloRecibido;
        titulo += "\n";
        invariante();
    }

    public String getElementoTitulo() {
        invariante();
        return titulo;
    }

    public void accept(final Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
    private void invariante() {
        if (titulo == null) throw new AssertionError(
                "La variable titulo no puede ser nula");
    }
}
