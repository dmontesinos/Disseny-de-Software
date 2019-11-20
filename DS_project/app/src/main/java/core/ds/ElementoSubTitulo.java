package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Este elemento permite generar un subtitulo en los informes*/
public class ElementoSubTitulo extends Elemento {
    private String subtitulo;
    private static final Logger log =
            LoggerFactory.getLogger(ElementoSubTitulo.class);

    public ElementoSubTitulo() {
        subtitulo = null;
    }
    public ElementoSubTitulo(final String subtituloRecibido) {
        subtitulo = subtituloRecibido;
        subtitulo += "\r\n";
        invariante();
        log.info("Generando un ElementoSubtitulo");
    }

    public void setSubTitulo(final String subtituloRecibido) {
        subtitulo = subtituloRecibido;
        subtitulo += "\r\n";
        invariante();
        log.debug("Seteando el subtítulo");
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
