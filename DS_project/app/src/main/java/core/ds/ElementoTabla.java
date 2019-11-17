package core.ds;

import java.util.ArrayList;

public class ElementoTabla extends Elemento {
    private int nFilas;
    private int nColumnas;
    private ArrayList tabla;



    public int getnFilas() {
        return nFilas;
    }

    public void setnFilas(int nFilasRecibido) {
        nFilas = nFilasRecibido;
    }

    public int getnColumnas() {
        return nColumnas;
    }

    public void setnColumnas(int nColumnasRecibido) {
        nColumnas = nColumnasRecibido;
    }


    public ArrayList getElementoTabla() {
        return tabla;
    }

    public void setElementoTabla(ArrayList<Elemento> tablaRecibida) {
        tabla = tablaRecibida;
    }

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
    }

    public void anadirFila() {
        int columnas = getnColumnas();
        ArrayList fila = new ArrayList();
        for (int j = 0; j < columnas; j++) {
            fila.add(null);
        }
        getElementoTabla().add(fila);
        setnFilas(getnFilas()+1);
    }

    public void anadirFila(final ArrayList listaRecibida) {
        getElementoTabla().add(listaRecibida);
        setnFilas(getnFilas() + 1);
        if (listaRecibida.size() > getnColumnas()) {
            setnColumnas(listaRecibida.size());
        }
    }

    public Object getPosicion(final int fila, final int columna) {
        return ((ArrayList) getElementoTabla().get(fila)).get(columna);
    }

    public void setValor(int fila, int columna, String texto) {
        ((ArrayList) getElementoTabla().get(fila)).set(columna,texto);
    }

    public void imprimir() {
        System.out.println(this.getElementoTabla());
    }

    public void accept(final Formato formatoRecibido) {
        formatoRecibido.visit(this);
    }
}