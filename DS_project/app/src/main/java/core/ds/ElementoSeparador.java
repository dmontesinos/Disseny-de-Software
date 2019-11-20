package core.ds;
/*Este elemento genera un separador (linea horizontal) en los informes*/
public final class ElementoSeparador extends Elemento {
    private String separador;
    public ElementoSeparador() {
        separador = "--------------------------------------------------"
                + "------------------------------------------------------"
                + "------------------------------------------------------"
                + "-------------\r\n";
        invariante();
    }
    public String getElementoSeparador() {
        invariante();
        return separador;
    }

    public void accept(final Formato formato) {
        formato.visit(this);
    }
    private void invariante() {
        if (separador == null) throw new AssertionError(
                "La variable separador no puede ser nula");
    }
}
