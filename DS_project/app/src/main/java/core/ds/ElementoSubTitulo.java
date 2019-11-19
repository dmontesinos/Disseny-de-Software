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
    }

    public void setSubTitulo(final String subtituloRecibido) {
        subtitulo = subtituloRecibido;
        subtitulo += "\r\n";
    }

    public String getElementoSubtitulo() {
        return subtitulo;
    }

    public void accept(final Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
}
