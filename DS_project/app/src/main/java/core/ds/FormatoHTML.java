package core.ds;
import java.util.Date;

import j2html.tags.ContainerTag;
import j2html.tags.Tag;
import static j2html.TagCreator.*;

public class FormatoHTML extends Formato {
    ContainerTag htmlPagina;
    Tag cabecera = head();
    ContainerTag cuerpo = body();

    public FormatoHTML() {
        htmlPagina = html();
        cabecera.withTitle("Reporte");
        htmlPagina.with(cabecera);
        htmlPagina.with(cuerpo);
    }

    @Override
    public void visit(ElementoSeparador separador) {
        cuerpo.with(hr());
    }

    @Override
    public void visit(ElementoTitulo titulo) {
        cuerpo.with(h1(titulo.getElementoTitulo()));
        cabecera.withTitle(titulo.getElementoTitulo());
    }

    @Override
    public void visit(ElementoSubTitulo subTitulo) {
        cuerpo.with(h2(subTitulo.getElementoSubtitulo()));
    }

    @Override
    public void visit(ElementoTabla tablaRecibida) {
        ContainerTag tablaHTML = table();
        int totalFilas = tablaRecibida.getnFilas();
        int totalColumnas = tablaRecibida.getnColumnas();


        for (int itTitulos = 0; itTitulos < totalColumnas; itTitulos++) {
            if (tablaRecibida.getPosicion(0, itTitulos) == null) {
                tablaHTML.with(th());
            } else {
                tablaHTML.with(th((String) tablaRecibida.getPosicion(0, itTitulos)));
            }
        }

        for (int itFilas = 1; itFilas < totalFilas; itFilas++) {
            ContainerTag tr = tr();
            tablaHTML.with(tr);
            for (int itColumna = 0; itColumna < totalColumnas; itColumna++) {
                if (tablaRecibida.getPosicion(itFilas, itColumna) != null) {
                    //contenido += "     ";
                    //tablaHTML.with(tr(td((String)tablaRecibida.getPosicion(itFilas, itColumna))));
                    if (tablaRecibida.getPosicion(itFilas, itColumna).getClass() == Date.class ||
                            tablaRecibida.getPosicion(itFilas, itColumna).getClass() == Integer.class
                            || tablaRecibida.getPosicion(itFilas, itColumna).getClass() == Long.class) {
                        String cadena = String.valueOf(tablaRecibida.getPosicion(itFilas, itColumna));
                        tablaHTML.with(td(cadena));
                    } else {
                        tablaHTML.with(td((String)tablaRecibida.getPosicion(itFilas, itColumna)));
                    }
                } else {
                    tablaHTML.with(td());
                }
            }
        }
        tablaHTML.attr("border",1);
        cuerpo.with(tablaHTML);
    }

    @Override
    public void visit(ElementoParrafo parrafo) {

    }

    @Override
    public String getContenido() {
        return htmlPagina.renderFormatted();
    }
}
