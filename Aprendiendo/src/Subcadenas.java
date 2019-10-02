public class Subcadenas {
    public static void main(String[] args) {

        String cadena="Esto es una cadena";
        String cadena2="Esto"+"Tambien"+"ES"+"una"+"Cadena.";

        System.out.println(cadena+" y "+cadena2);

        System.out.println("La segunda letra de la cadena debería ser una 's' y es una: "+cadena.charAt(1));

        if(cadena.startsWith("S")){
            System.out.printf("Ha funcionado!");
        } else {
            System.out.println("No ha funcionado.");
        }

        System.out.println("La cadena1 tiene un total de: "+cadena.length()+" caracteres.");


        String cadenaInicial = "Cadena por defecto para practicar";
        String cadenaFinal = cadenaInicial.substring(0,8);

        System.out.println("El fragmento de la cadena es: "+cadenaFinal);

        //EQUAL

        String nombre1, nombre2, nombre3;
        nombre1="Daniel";
        nombre2="Tania";
        nombre3="daniel";

        System.out.println("Estos nombres son iguales? "+nombre1.equals(nombre2));
        System.out.println("Estos nombres son iguales? "+nombre1.equals(nombre3));

        //IGNORANDO MAYUSCULAS
        System.out.println("Estos nombres son iguales? "+nombre1.equalsIgnoreCase(nombre3));
    }
}
