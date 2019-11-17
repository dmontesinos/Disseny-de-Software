package core.ds;

public class ElementoSubTitulo extends Elemento {
    private String subtitulo;

    public ElementoSubTitulo() {
        subtitulo = null;
    }
    public ElementoSubTitulo(String subtituloRecibido) {
        subtitulo = subtituloRecibido;
        subtitulo += "\r\n";
    }

    public void setSubTitulo(String subtituloRecibido) {
        subtitulo = subtituloRecibido;
        subtitulo += "\r\n";
    }

    public String getElementoSubtitulo() {
        return subtitulo;
    }

    public void accept(Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
}
