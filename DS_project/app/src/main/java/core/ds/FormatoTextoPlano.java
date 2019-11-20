package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*Clase destinada a la definición de todos los elementos que componen el
* formulario con la finalidad de imprimirlos cada uno de una forma deter-
* minada. Es necesaria esta clase para poder imprimir en formato TXT, al
* igual que tenemos definida la de HTML con otro formato específico.*/
public class FormatoTextoPlano extends Formato {
    private String contenido = null;
    private static final Logger Log = LoggerFactory.getLogger(FormatoTextoPlano.class);
    public FormatoTextoPlano() {
        super();
    }

    public String getContenido() {
        invariante();
        Log.info("Transformando contenido formateado en formato TXT");
        return contenido;
    }

    public void visit(final ElementoSeparador separadorRecibido) {
        if (separadorRecibido != null) {
            contenido += separadorRecibido.getElementoSeparador();
            invariante();
            Log.debug("Generando separador en formato TXT");
        }
    }

    public void visit(final ElementoTitulo tituloRecibido) {
        if (tituloRecibido.getElementoTitulo() != null) {
            contenido += tituloRecibido.getElementoTitulo();
            invariante();
            Log.debug("Generando título en formato TXT");
        }
    }

    public void visit(final ElementoSubTitulo subtituloRecibido) {
        if (subtituloRecibido.getElementoSubtitulo() != null) {
            contenido += subtituloRecibido.getElementoSubtitulo();
            invariante();
            Log.debug("Generando subtítulo en formato TXT");
        }
    }
    /*Se rellena el contenido de forma ordenada para posteriormente
    * poder imprimir el contenido en un orden determinado. Es decir,
    * se escribe de izquierda a derecha para que el documento quede
    * correctamente formateado. La forma de realizarlo es como la de
    * cualquier Array bidimensional.*/
    public void visit(final ElementoTabla tablaRecibida) {
        int totalFilas = tablaRecibida.getnFilas();
        int totalColumnas = tablaRecibida.getnColumnas();

        for (int itFilas = 0; itFilas < totalFilas; itFilas++) {
            for (int itColumna = 0; itColumna < totalColumnas; itColumna++) {
                if (tablaRecibida.getPosicion(itFilas, itColumna) != null) {
                    //contenido += "     ";
                    contenido += tablaRecibida.getPosicion(
                            itFilas, itColumna) + "\t\t\t\t";
                }
            }
            contenido += "\n";
            invariante();
            Log.debug("Generando tabla en formato TXT");
        }
    }

    public void visit(final ElementoParrafo parrafoRecibido) {
        if (parrafoRecibido.getElementoParrafo() != null) {
            contenido += parrafoRecibido.getElementoParrafo();
            invariante();
            Log.debug("Generando párrafo en formato TXT");
        }
    }
    private void invariante() {
        if (contenido == null) throw new AssertionError(
                "La variable contenido no puede ser nula");
    }
}
