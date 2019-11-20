package core.ds;

import java.util.ArrayList;
/*Permite generar elemento tabla y gestionarlo eficientemente
* para la generación de los formularios.*/
public class ElementoTabla extends Elemento {
    private int nFilas;
    private int nColumnas;
    private ArrayList tabla;


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
    }
    /*Constructor con toda la estructura básica para una tabla por defecto.
    * Necesita de los parámetros de número de filas y columnas para crearlas
    * correctamente. Se trata de un Array bidimensional.*/
    public ElementoTabla(final int filas, final int columnas) {
        setnFilas(filas);
        setnColumnas(columnas);
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
    }
    /*Permite añadir una nueva fila a la tabla anteriormente creada
    * con el contenido que se le envíe por parámetro.*/
    public void anadirFila(final ArrayList listaRecibida) {
        getElementoTabla().add(listaRecibida);
        setnFilas(getnFilas() + 1);
        if (listaRecibida.size() > getnColumnas()) {
            setnColumnas(listaRecibida.size());
        }
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
    }

    public void accept(final Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
    private void invariante() {
        if (tabla == null) throw new AssertionError(
                "La variable tabla no puede ser nula");
    }
}