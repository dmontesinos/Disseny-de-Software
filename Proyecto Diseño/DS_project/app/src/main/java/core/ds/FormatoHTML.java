package core.ds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

import j2html.tags.ContainerTag;
import j2html.tags.Tag;
import static j2html.TagCreator.*;
/*Mediante esta función se formatea de forma concreta los elementos que
* contiene el array de elementos. Es decir, están definidos todos los
* elementos y la forma en la que deben imprimirse. Para ello, se utiliza
* una librería externa(j2html) que facilita la implementación del código.*/
public class FormatoHTML extends Formato {
    private ContainerTag htmlPagina;
    private Tag cabecera = head();
    private ContainerTag cuerpo = body();
    private static final Logger Log =
            LoggerFactory.getLogger(FormatoHTML.class);

    public FormatoHTML() {
        htmlPagina = html();
        cabecera.withTitle("Reporte");
        htmlPagina.with(cabecera);
        htmlPagina.with(cuerpo);
        invariante();
        Log.debug("Inicializando el documento HTML");
    }

    @Override
    public void visit(final ElementoSeparador separador) {
        cuerpo.with(hr());
        Log.debug("Añadiendo separador al HTML");
    }

    @Override
    public void visit(final ElementoTitulo titulo) {
        cuerpo.with(h1(titulo.getElementoTitulo()));
        cabecera.withTitle(titulo.getElementoTitulo());
        invariante();
        Log.debug("Añadiendo título al HTML");
    }

    @Override
    public void visit(final ElementoSubTitulo subTitulo) {
        cuerpo.with(h2(subTitulo.getElementoSubtitulo()));
        invariante();
        Log.debug("Añadiendo subtitulo al HTML");
    }
    /*En esta función se define como debe imprimirse una tabla siguiendo
    * las herramientas proporcionadas por la extension j2html. El sistema
    * es muy similar a la versión txt, salvo por la encapsulación de los
    * contenidos en variables de tipo concreto de la extensión. Esto
    * permite que automáticamente se imprima con un diseño HTML correcto.*/
    @Override
    public void visit(final ElementoTabla tablaRecibida) {
        ContainerTag tablaHTML = table();
        int totalFilas = tablaRecibida.getnFilas();
        int totalColumnas = tablaRecibida.getnColumnas();


        for (int itTitulos = 0; itTitulos < totalColumnas; itTitulos++) {
            if (tablaRecibida.getPosicion(0, itTitulos) == null) {
                tablaHTML.with(th());
            } else {
                tablaHTML.with(th((String)
                        tablaRecibida.getPosicion(0, itTitulos)));
            }
        }

        for (int itFilas = 1; itFilas < totalFilas; itFilas++) {
            ContainerTag tr = tr();
            tablaHTML.with(tr);
            for (int itColumna = 0; itColumna < totalColumnas; itColumna++) {
                if (tablaRecibida.getPosicion(itFilas, itColumna) != null) {
                    if (tablaRecibida.getPosicion(itFilas, itColumna).getClass()
                            == Date.class || tablaRecibida.getPosicion(itFilas,
                            itColumna).getClass() == Integer.class
                            || tablaRecibida.getPosicion(itFilas,
                            itColumna).getClass()
                            == Long.class) {
                        String cadena =
                                String.valueOf(
                                        tablaRecibida.getPosicion(
                                                itFilas, itColumna));
                        tablaHTML.with(td(cadena));
                    } else {
                        tablaHTML.with(
                                td((String) tablaRecibida.getPosicion(
                                        itFilas, itColumna)));
                    }
                } else {
                    tablaHTML.with(td());
                }
            }
        }
        tablaHTML.attr("border", 1);
        cuerpo.with(tablaHTML);
        invariante();
        Log.debug("Añadiendo tabla al HTML");
    }

    @Override
    public void visit(final ElementoParrafo parrafo) {
        cuerpo.with(p(parrafo.getElementoParrafo()));
        Log.debug("Añadiendo párrafo al HTML");
    }
    /*Es necesario realizar el renderFormatted para devolver el contenido
    * del plugin en formato String. Mediante ese comando se realiza la con-
    * versión y se retorna en formato cadena.*/
    @Override
    public String getContenido() {
        Log.info("Transformando contenido formateado en HTML");
        return htmlPagina.renderFormatted();
    }
    private void invariante() {
        if (htmlPagina == null) throw new AssertionError(
                "La variable htmlPagina no puede ser nula");
        if (cabecera == null) throw new AssertionError(
                "La variable cabecera no puede ser nula");
        if (cuerpo == null) throw new AssertionError(
                "La variable cuerpo no puede ser nula");
    }
}
