package core.ds;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
/*Permite generar elemento tabla y gestionarlo eficientemente
* para la generación de los formularios.*/
public class ElementoTabla extends Elemento {
    private int nFilas;
    private int nColumnas;
    private ArrayList tabla;
    private static final Logger log =
            LoggerFactory.getLogger(ElementoTabla.class);

    /*Constructor con toda la estructura básica para una tabla por defecto.
     * Necesita de los parámetros de número de filas y columnas para crearlas
     * correctamente. Se trata de un Array bidimensional.*/
    public ElementoTabla(final int filas, final int columnas) {
        setnFilas(filas);
        setnColumnas(columnas);
        /*Pre-condición que determina que mínimamente hay 1
         * fila y 1 columna.*/
        if (!esValido()) {
            throw new IllegalStateException();
        }
        ArrayList nuevaTabla = new ArrayList();

        for (int i = 0; i < filas; i++) {
            ArrayList fila = new ArrayList<>();
            for (int j = 0; j < columnas; j++) {
                fila.add(null);
            }
            nuevaTabla.add(fila);
        }
        setElementoTabla(nuevaTabla);
        invariante();
        log.info("Generando un ElementoTabla");
    }

    public int getnFilas() {
        return nFilas;
    }

    public void setnFilas(final int nFilasRecibido) {
        nFilas = nFilasRecibido;
    }

    public int getnColumnas() {
        return nColumnas;
    }

    public void setnColumnas(final int nColumnasRecibido) {
        nColumnas = nColumnasRecibido;
    }


    public ArrayList getElementoTabla() {
        invariante();
        return tabla;
    }

    public void setElementoTabla(final ArrayList<Elemento> tablaRecibida) {
        tabla = tablaRecibida;
        invariante();
        log.debug("Seteando valores en la tabla");
    }

    public void anadirFila() {
        int columnas = getnColumnas();
        ArrayList fila = new ArrayList();
        for (int j = 0; j < columnas; j++) {
            fila.add(null);
        }
        getElementoTabla().add(fila);
        setnFilas(getnFilas() + 1);
        invariante();
        log.debug("Añadiendo una fila a la tabla");
    }
    /*Permite añadir una nueva fila a la tabla anteriormente creada
    * con el contenido que se le envíe por parámetro.*/
    public void anadirFila(final ArrayList listaRecibida) {
        getElementoTabla().add(listaRecibida);
        setnFilas(getnFilas() + 1);
        if (listaRecibida.size() > getnColumnas()) {
            setnColumnas(listaRecibida.size());
        }
        log.debug("Añadiendo una fila a la tabla");
    }
    /*Devuelve el contenido de una posición concreta de la tabla
    solo indicando la fila y columna que se requiere.
     */
    public Object getPosicion(final int fila, final int columna) {
        return ((ArrayList) getElementoTabla().get(fila)).get(columna);
    }
    /*Setea un valor pasado por parámetro en una posición concreta
    * de la matríz bidimensional.*/
    public void setValor(final int fila,
                         final int columna, final String texto) {
        invariante();
        ((ArrayList) getElementoTabla().get(fila)).set(columna, texto);
        log.debug("Añadiendo el valor: " + texto + " en la tabla en "
                + "la posición: " + fila + ", " + columna);
    }

    public void accept(final Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
    private void invariante() {
        if (tabla == null) throw new AssertionError(
                "La variable tabla no puede ser nula");
    }
    private boolean esValido() {
        if (nFilas > 0 && nColumnas > 0) {
            return true;
        }
        return false;
    }
}