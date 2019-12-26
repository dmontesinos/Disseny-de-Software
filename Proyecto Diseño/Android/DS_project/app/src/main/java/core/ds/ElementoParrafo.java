package core.ds;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Este elemento sirve para generar un párrafo dentro de los informes*/
public class ElementoParrafo extends Elemento {
    private String parrafo;
    private static final Logger log =
            LoggerFactory.getLogger(ElementoParrafo.class);

    public ElementoParrafo(final String parrafoRecibido) {
        setElementoParrafo(parrafoRecibido);
        invariante();
        log.info("Generando un ElementoParrafo");
    }

    public String getElementoParrafo() {
        invariante();
        return parrafo;
    }

    public void setElementoParrafo(final String parrafoRecibido) {
        parrafo = parrafoRecibido;
        /*Post-condición que determina que el valor es
         * distinto a null después del set.*/
        if (!esValido()) {
            throw new IllegalStateException();
        }
        log.debug("Seteando el párrafo");
    }
    private void invariante() {
        if (parrafo == null) throw new AssertionError(
                "La variable párrafo no puede ser nula");
    }
    private boolean esValido() {
        return parrafo != null;
    }
}
