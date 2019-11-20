package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Este elemento genera un separador (linea horizontal) en los informes*/
public final class ElementoSeparador extends Elemento {
    private String separador;
    private static final Logger Log = LoggerFactory.getLogger(ElementoSeparador.class);

    public ElementoSeparador() {
        separador = "--------------------------------------------------"
                + "------------------------------------------------------"
                + "------------------------------------------------------"
                + "-------------\r\n";
        invariante();
        Log.info("Generando un ElementoSeparador");
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
