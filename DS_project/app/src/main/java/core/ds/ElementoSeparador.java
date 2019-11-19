package core.ds;

public final class ElementoSeparador extends Elemento {
    private String separador;
    public ElementoSeparador() {
        separador = "----------------------------------------------------------------"
                + "--------------------------------------------------------------------"
                + "---------------------------------------\r\n";
    }
    public String getElementoSeparador() {
        return separador;
    }

    public void accept(final Formato formato) {
        formato.visit(this);
    }
}
