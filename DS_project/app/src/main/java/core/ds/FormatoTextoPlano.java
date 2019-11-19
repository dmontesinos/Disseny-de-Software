package core.ds;
/*Clase destinada a la definición de todos los elementos que componen el
* formulario con la finalidad de imprimirlos cada uno de una forma deter-
* minada. Es necesaria esta clase para poder imprimir en formato TXT, al
* igual que tenemos definida la de HTML con otro formato específico.*/
public class FormatoTextoPlano extends Formato {
    private String contenido = null;
    public FormatoTextoPlano() {
        super();
    }

    public String getContenido() {
        return contenido;
    }

    public void visit(final ElementoSeparador separadorRecibido) {
        if (separadorRecibido != null) {
            contenido += separadorRecibido.getElementoSeparador();
        }
    }

    public void visit(final ElementoTitulo tituloRecibido) {
        if (tituloRecibido.getElementoTitulo() != null) {
            contenido += tituloRecibido.getElementoTitulo();
        }
    }

    public void visit(final ElementoSubTitulo subtituloRecibido) {
        if (subtituloRecibido.getElementoSubtitulo() != null) {
            contenido += subtituloRecibido.getElementoSubtitulo();
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
        }
    }

    public void visit(final ElementoParrafo parrafoRecibido) {
        if (parrafoRecibido.getElementoParrafo() != null) {
            contenido += parrafoRecibido.getElementoParrafo();
        }
    }
}
