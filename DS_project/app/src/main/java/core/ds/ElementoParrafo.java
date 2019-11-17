package core.ds;

public class ElementoParrafo extends Elemento {
    private String parrafo;

    public ElementoParrafo(final String parrafoRecibido) {
        setElementoParrafo(parrafoRecibido);
    }

    public String getElementoParrafo() {
        return parrafo;
    }

    public void setElementoParrafo(String parrafoRecibido) {
        parrafo = parrafoRecibido;
    }
}
