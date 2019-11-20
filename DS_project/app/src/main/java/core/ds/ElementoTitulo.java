package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Genera elementos de tipo título para los informes*/
public class ElementoTitulo extends Elemento {
    private String titulo;
    private static final Logger log =
            LoggerFactory.getLogger(ElementoTitulo.class);

    public ElementoTitulo() {
        titulo = null;
    }
    public ElementoTitulo(final String tituloRecibido) {
        titulo = tituloRecibido;
        titulo += "\n";
        invariante();
        log.info("Generando un ElementoTitulo");
    }

    public void setTitulo(final String tituloRecibido) {
        titulo = tituloRecibido;
        titulo += "\n";
        invariante();
        log.debug("Seteando el título");
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
