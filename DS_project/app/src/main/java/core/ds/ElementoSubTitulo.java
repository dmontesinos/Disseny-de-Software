package core.ds;
/*Este elemento permite generar un subtitulo en los informes*/
public class ElementoSubTitulo extends Elemento {
    private String subtitulo;

    public ElementoSubTitulo() {
        subtitulo = null;
    }
    public ElementoSubTitulo(final String subtituloRecibido) {
        subtitulo = subtituloRecibido;
        subtitulo += "\r\n";
        invariante();
    }

    public void setSubTitulo(final String subtituloRecibido) {
        subtitulo = subtituloRecibido;
        subtitulo += "\r\n";
        invariante();
    }

    public String getElementoSubtitulo() {
        invariante();
        return subtitulo;
    }

    public void accept(final Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
    private void invariante() {
        if (subtitulo == null) throw new AssertionError(
                "La variable separador no puede ser nula");
    }
}
