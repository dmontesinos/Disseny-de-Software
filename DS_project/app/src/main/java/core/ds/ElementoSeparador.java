package core.ds;

public class ElementoSeparador extends Elemento {
    public String separador;
    public ElementoSeparador() {
        separador = "---------------------------------\r\n";
    }
    public String getElementoSeparador() {
        return separador;
    }

    public void accept(Formato formato) {
        formato.visit(this);
    }
}
