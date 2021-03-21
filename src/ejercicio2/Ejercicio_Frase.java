package ejercicio2;

import java.util.Scanner;//Importamos el paquete de la clase Scanner

import javax.swing.JOptionPane;//Importamos el paquete de la clase JOptionPane

public class Ejercicio_Frase {

	public static void main(String[] args) {
		/*
		 * Creamos el objeto scanner mediante el cual introduciremos las cadenas
		 * por consola
		 */
		Scanner sc = new Scanner(System.in);
		/*
		 * Vamos a definir el numero de elementos del array mediante un
		 * JoptionPane, el numero que introduzcamos sera el numero de elementos
		 * del array
		 */
		int elementos = Integer
				.parseInt(JOptionPane
						.showInputDialog("Cuantos elementos tiene el array \n (Numero de frases a escribir)"));
		/*
		 * Definimos el array de las frases y le decimos que el numero de
		 * elementos que contiene se lo introducimos en la variable elementos
		 * descrita anteriormente
		 */
		String[] array_Frases = new String[elementos];
		/*
		 * Ahora recorremos el array para rellenarlo con las frases que le
		 * introduzcamos por consola. El bucle se acaba al introducir el ultimo
		 * elemento de la cadena y sigue con las operaciones
		 */
		for (int i = 0; i < array_Frases.length; i++) {
			System.out.println("Escribe un texto: ");
			array_Frases[i] = sc.nextLine();

		}

		/*
		 * Ahora vamos a ordenar el array mediante el metodo de la burbuja en
		 * orden ascendente de menor a mayor.
		 */

		boolean ordenado = false;
		while (!ordenado) {
			ordenado = true;
			for (int i = 0; i < array_Frases.length - 1; i++) {
				if (array_Frases[i].compareTo(array_Frases[i + 1]) > 0) {
					String temporal = array_Frases[i];
					array_Frases[i] = array_Frases[i + 1];
					array_Frases[i + 1] = temporal;
					ordenado = false;

				}
			}
		}
		/*
		 * Cuando ya tenemos ordenado el array para presentarlo en pantalla, lo
		 * recorremos para realizar las diferentes operaciones, las cuales he
		 * dividido en procedimientos separados para no tener todo el codigo
		 * mezclado. Cada elemento del array, lo pasamos como parametro al
		 * procedimiento.
		 */
		for (int i = 0; i < array_Frases.length; i++) {

			Devuelve_Frase_Longitud(array_Frases[i]);
			Devuelve_Mayusculas(array_Frases[i]);
			Palabra_Palabra(array_Frases[i]);
			Contar_Minusculas(array_Frases[i]);
			Borrar_Ultima(array_Frases[i]);
		}

		sc.close(); // Aqui cerramos el Scanner para ahorrar recursos

	}

	public static void Devuelve_Frase_Longitud(String Frase) {
		/*
		 * Con este procedimiento, calculamos la longitud de cada elemento del
		 * array y lo imprimimos en pantalla
		 */
		int longitud = Frase.length();
		System.out.println("Longitud : " + longitud);

	}

	public static void Devuelve_Mayusculas(String Frase) {
		/*
		 * Con este procedimiento cambiamos las letras del texto de minusculas a
		 * mayusculas y lo imprimimos en pantalla
		 */
		System.out.print("Mayúscula: ");
		System.out.println(Frase.toUpperCase());

	}

	public static void Palabra_Palabra(String Frase) {
		System.out.println("Palabra a Palabra");
		/*
		 * Con este procedimiento, dividimos la frase en trozos y creamos un
		 * array de string nuevo mediante el metodo split.
		 */

		String[] trozos = Frase.split(" ");/*
											 * Con el metodo split, le decimos
											 * que asi que encuentre un
											 * caracter, corte ahi la cadena, en
											 * este caso, como queremos cortar
											 * palabras, será cuando encuentre
											 * un espacio
											 */

		for (int i = 0; i < trozos.length; i++) {
			System.out.println(" " + trozos[i]);
			/*
			 * Con un bucle for recorremos este nuevo array e imprimimos en
			 * pantalla con un salto de linea cada palabra
			 */
		}

	}

	public static void Contar_Minusculas(String Frase) {
		int minuscula = 0;
		/*
		 * Con este procedimiento, contamos las minusculas de la frase,
		 * recorremos la frase con un bucle for y con un bucle if, le decimos
		 * que si algun caracter de la frase es minuscula pues aumente el
		 * contador de minusculas.
		 */

		for (int i = 0; i < Frase.length(); i++) {
			if (Character.isLowerCase(Frase.charAt(i)) == true) {
				minuscula++;

			}

		}
		// Ahora imprimimos el numero de minusculas que hemos contabilizado
		System.out.println("Hay " + minuscula + " letras minúsculas");

	}

	public static void Borrar_Ultima(String Frase) {
		/*
		 * Con este procedimiento, vamos a ir imprimiendo la frase con un salto
		 * de linea y cada vez esa frase tendrá una letra menos.
		 */
		System.out.println("El TRIÁNGULO:");
		/*
		 * Para ello usamos un bucle for para recorrer la frase y el metodo
		 * substring con el cual definimos que parte del string queremos
		 * conservar. Para eso en sus parametros le ponemos que queremos empezar
		 * en el caracter 0 y acabar en cada frase con el numero de caracteres
		 * menos el valor que tiene i en ese momento,asi a cada paso de i, le
		 * recortamos un caracter.
		 */
		for (int i = 0; i < Frase.length(); i++) {
			String cadena = Frase.substring(0, (Frase.length() - i));

			System.out.println(cadena);

		}

	}

}
