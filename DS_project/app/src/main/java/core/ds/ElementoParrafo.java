package core.ds;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Este elemento sirve para generar un párrafo dentro de los informes*/
public class ElementoParrafo extends Elemento {
    private String parrafo;
    private static final Logger Log =
            LoggerFactory.getLogger(ElementoParrafo.class);

    public ElementoParrafo(final String parrafoRecibido) {
        setElementoParrafo(parrafoRecibido);
        invariante();
        Log.info("Generando un ElementoParrafo");
    }

    public String getElementoParrafo() {
        invariante();
        return parrafo;
    }

    public void setElementoParrafo(final String parrafoRecibido) {
        parrafo = parrafoRecibido;
        invariante();
        Log.debug("Seteando el párrafo");
    }
    private void invariante() {
        if (parrafo == null) throw new AssertionError(
                "La variable párrafo no puede ser nula");
    }
}
