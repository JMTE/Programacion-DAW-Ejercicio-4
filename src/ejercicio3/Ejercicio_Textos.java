package ejercicio3;

import java.util.Scanner;//Importamos el paquete de la clase Scanner
import java.util.StringTokenizer;//Importamos el paquete de la clase StringTokenizer

public class Ejercicio_Textos {

	public static void main(String[] args) {
		/*
		 * Creamos un objeto StringBuilder con el cual iremos almacenando las
		 * palabras que le vamos excribiendo. Se almacena como una gran cadena.
		 */
		StringBuilder resultado = new StringBuilder();
		/*
		 * Vamos a realizar los las operaciones pedidas en procedimientos
		 * separados
		 */
		Devuelve_Logitud_Textomayus(resultado);
		Devuelve_separados(resultado);

	}

	/*
	 * En este procedimiento calcularemos la longitud de cada palabra que le
	 * vamos introduciendo por consola, la cambiaremos a mayusculas y la
	 * añadiremos al Stringbuilder para tenerla en memoria
	 */
	public static void Devuelve_Logitud_Textomayus(StringBuilder res) {
		String palabra;
		boolean fin = false;/*
							 * Definimos una variable booleana que usararemos en
							 * un bucle do-while para salir de el cuando por
							 * teclado le introduzcamos la palabra fin
							 */
		Scanner sc = new Scanner(System.in);/*
											 * Declaramos el objeto Scanner para
											 * que lea las palabras que le vamos
											 * a introducir por consola
											 */

		do {
			/*
			 * Con este bucle do-while escribimos pedimos la primera vez por
			 * teclado una palabra, si esta fuera fin, saldria del bucle despues
			 * de leerla.
			 */
			System.out.println("Escribe un texto: ");
			palabra = sc.nextLine();// Lee la palabra introducida por consola
			if (palabra.equalsIgnoreCase("FIN")) {
				/*
				 * Con este tipo de equalsIgnoreCase, saldria del bucle aunque
				 * el texto introducido fuera en minusculas
				 */
				fin = true;// Ponemos la salida a true para salir del bucle
			} else {
				/*
				 * Si la palabra introducida no es FIN, entrará en esta parte
				 * del bucle todo el rato, calculara la longitud de la ultima
				 * palabra introducida y la imprimira en pantalla. Pasará la
				 * palabra a mayusculas y tambien la imprime y despues la
				 * añadirá al objeto StringBuilder con un punto y coma, que será
				 * necesario para  fragmentar esta supercadena. S
				 */
				int longitud = palabra.length();
				System.out.println("Longitud :" + longitud);
				palabra = palabra.toUpperCase();
				System.out.println(palabra);

				res.append(palabra + ";");

			}
		} while (!fin);
		sc.close();
	}

	public static void Devuelve_separados(StringBuilder res) {
		/*Con este procedimiento, vamos a fragmentar el objeto StringBuilder 
		 * mediante el objeto creado a continuacion de tipo StringTokenizer.
		 * Le pasamos por parametro nuestro objeto StringBuilder
		 */
		StringTokenizer ruptura = new StringTokenizer(res.toString(), ";");
		/*Creamos el objeto StringTokenizer y le pasamos por parametros, nuestro
		 * objeto StringBuilder con el metodo toString para que lo reconozca 
		 * y como otro parametro, le decimos el corte viene al encontrar el punto 
		 * y coma que añadimos anteriormente al añadir cada elemento al objeto
		 * StringBuilder
		 */
		while (ruptura.hasMoreTokens()) {
			/*Con este bucle while, le decimos que imprima en pantalla con un salto
			 * de linea, los objetos resultantes de partir el objeto StringBuilder
			 * Cuando ya no queden mas objetos, sale del bucle.
			 */
			System.out.println(ruptura.nextToken());

		}

	}

}
