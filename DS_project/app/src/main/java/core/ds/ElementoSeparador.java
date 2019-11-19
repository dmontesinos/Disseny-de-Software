package core.ds;
/*Este elemento genera un separador (linea horizontal) en los informes*/
public final class ElementoSeparador extends Elemento {
    private String separador;
    public ElementoSeparador() {
        separador = "--------------------------------------------------"
                + "------------------------------------------------------"
                + "------------------------------------------------------"
                + "-------------\r\n";
    }
    public String getElementoSeparador() {
        return separador;
    }

    public void accept(final Formato formato) {
        formato.visit(this);
    }
}
