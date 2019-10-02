package poo;

public class furgoneta extends coche {
    private int capacidadCarga;
    private int plazasExtra;

    public furgoneta(int capacidadCarga, int plazasExtra){
        super(); //llamar al constructor de la clase padre, es decir "coche()"
        // A super podemos ponerle parametros para enviar al constructor por defecto, buscará automáticamente que constructor usar
        // en caso de que este exista. Si no existe, dara error. super(ruedas) es lo mismo que coche(ruedas) aunque no tenemos
        // constructor para el ejemplo ruedas y no funcionaría.

        this.capacidadCarga = capacidadCarga;
        this.plazasExtra = plazasExtra;
    }

    public String dimeDatosFurgoneta(){
        return "La capacidad de carga es: " + capacidadCarga + " y las plazas disponibles son: "+ plazasExtra;
    }
}
