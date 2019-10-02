package poo;

public class coche {
    private int ruedas; //Encapsulamos el dato para no poder modificarlo desde fuera de la clase
    private final int largo; //Añadimos final para convertirlo en CONSTANTE y no permitir modificaciones posteriores
    int ancho; //Lo dejamos sin privado para poder modificarlo desde fuera
    private int motor;
    private int peso;
    private boolean asientosCuero;

    public coche(){
        ruedas = 4;
        largo = 250;
        ancho = 100;
        motor = 1600;
        peso = 1200;
        asientosCuero = false;
    }

    public int getLargo(){ //GETTER
        return largo;
    }

    public int getAncho(){ //GETTER
        return ancho;
    }

    public void setAncho(int valor){ //SETTER
        ancho = valor;
    }

    public boolean getAsientosCuero(){
        if(asientosCuero==true){
            return true;
        }else {
            return false;
        }
    }

    public void setAsientosCuero(boolean asientosCuero) {
        this.asientosCuero = asientosCuero; //Al llamarse igual el parametro y el valor de la clase, utilizamos this.
    }
}
