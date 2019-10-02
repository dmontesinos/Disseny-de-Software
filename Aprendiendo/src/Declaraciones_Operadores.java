
public class Declaraciones_Operadores {

	public static void main(String[] args) {
		
		
		float numero=5.7777f; //Hemos de poner la f para decirle al sistema que es un float.
		numero = numero-3;
		
		System.out.printf("%.4f->El valor mostrado debe ser de 2.7777 %n", numero);
		//Mediante %n con printf creamos un salto de línea.
		
		numero++;
		System.out.printf(numero+"->Ahora debe de ser de 3.7777 %n");
		
		String mensaje = "para Daniel";
		System.out.println("Mediante println realizamos después de mostrar el texto, un salto de línea.");
		System.out.printf("Esto es un mensaje de prueba %s!", mensaje);

	}

}
