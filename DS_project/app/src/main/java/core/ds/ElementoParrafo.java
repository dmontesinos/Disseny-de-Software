package core.ds;
/*Este elemento sirve para generar un párrafo dentro de los informes*/
public class ElementoParrafo extends Elemento {
    private String parrafo;

    public ElementoParrafo(final String parrafoRecibido) {
        setElementoParrafo(parrafoRecibido);
        invariante();
    }

    public String getElementoParrafo() {
        invariante();
        return parrafo;
    }

    public void setElementoParrafo(final String parrafoRecibido) {
        parrafo = parrafoRecibido;
        invariante();
    }
    private void invariante() {
        if (parrafo == null) throw new AssertionError(
                "La variable párrafo no puede ser nula");
    }
}
