package core.ds;
/*Este elemento sirve para generar un párrafo dentro de los informes*/
public class ElementoParrafo extends Elemento {
    private String parrafo;

    public ElementoParrafo(final String parrafoRecibido) {
        setElementoParrafo(parrafoRecibido);
    }

    public String getElementoParrafo() {
        return parrafo;
    }

    public void setElementoParrafo(final String parrafoRecibido) {
        parrafo = parrafoRecibido;
    }
}
