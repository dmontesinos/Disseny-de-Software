package core.ds;

public class FormatoTextoPlano extends Formato {
    private String contenido;
    public FormatoTextoPlano() {
        super();
    }

    public String getContenido() {
        return contenido;
    }

    public void visit(ElementoSeparador separadorRecibido) {
        if (separadorRecibido != null) {
            contenido += "---------------------------------\n";
        }
    }

    public void visit(ElementoTitulo tituloRecibido) {
        if (tituloRecibido.getElementoTitulo() != null) {
            contenido += tituloRecibido.getElementoTitulo();
        }
    }

    public void visit(ElementoSubTitulo subtituloRecibido) {
        if (subtituloRecibido.getElementoSubtitulo() != null) {
            contenido += subtituloRecibido.getElementoSubtitulo();
        }
    }

    public void visit(ElementoTabla tablaRecibida) {
        int totalFilas = tablaRecibida.getnFilas();
        int totalColumnas = tablaRecibida.getnColumnas();

        for (int itFilas = 0; itFilas < totalFilas; itFilas++) {
            for (int itColumna = 0; itColumna < totalColumnas; itColumna++) {
                if (tablaRecibida.getPosicion(itFilas, itColumna) != null) {
                    //contenido += "     ";
                    contenido += tablaRecibida.getPosicion(itFilas, itColumna) + "\t\t\t\t";
                }
            }
            contenido += "\n";
        }
    }

    public void visit(ElementoParrafo parrafoRecibido) {
        if (parrafoRecibido.getElementoParrafo() != null) {
            contenido += parrafoRecibido.getElementoParrafo();
        }
    }
}
