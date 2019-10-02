
public class claseMath {

	public static void main(String[] args) {
		double pi = Math.PI;
		
		double raiz=Math.sqrt(9);
		
		System.out.println("El número PI es: "+pi+" y la raíz cuadrada de 9 es: "+raiz);
		
		float numero = 5.85f;
		int resultado = Math.round(numero);
		
		System.out.println(resultado);
		
		//REFUNDICION
		
		//int raiz2=Math.sqrt(9); //Requiere de un double como variable y la salida es un double. Asi FALLA
		int raiz3=(int)Math.sqrt(9); //CASTEAMOS a int (con su respectiva perdida de decimales)
		
		System.out.println(raiz3);
		
		System.out.println((int)Math.pow(2,6)); //Imprimimos 2^6 casteado en INT
	}

}
