package ejercicio1;

import java.util.Random;

public class Ejercicio_Empleado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Definimos un array de Strings para darle nombre a los empleados y que
		 * a la hora de imprimirlo podamos verlo un poco mas "personalizado"
		 */
		String[] Empleados = new String[] { "Juan", "Maria", "Antonio",
				"Vicente", "Begoña", "Gutierrez", "Jose", "Ariadna", "Miguel" };
		/*
		 * Definimos un array de enteros.Los primeros dos valores, los hago
		 * aleatorios para probar la funcion random. El resto de los sueldos los
		 * pongo inventados.(Intentamos abarcar todos los casos posibles para
		 * verlo en las operaciones).
		 */
		/* El sueldo aleatorio lo hago entre 5000 y 60000 € */
		Random aleatorio = new Random();
		int[] Sueldos = new int[] { aleatorio.nextInt(60000 - 5000 + 1) + 5000,
				aleatorio.nextInt(60000 - 5000 + 1) + 5000, 14000, 34000,
				28000, 45000, 29000, 10000, 50000 };
		/*
		 * Igual que el caso anterior, las dos primeras comisiones utilizo la
		 * funcion random y despues introduzco valores inventados para probar
		 * todas las opciones.(Intentamos abarcar todos los casos posibles para
		 * verlo en las operaciones)
		 */
		int[] Comisiones = new int[] { aleatorio.nextInt(18000),
				aleatorio.nextInt(18000), 0, 0, 10000, 1900, 0, 6400, 2400 };
		/*
		 * Definimos un array double (por los porcentajes en decimales) vacio de
		 * nueve elementos, el cual rellenaremos despues con los valores de los
		 * sueldos nuevos luego de aplicarle la subida correspondiente
		 */
		double[] Sueldos_Nuevos = new double[9];
		/*
		 * Ahora recorremos los array Sueldos y Comisiones para ver que
		 * condiciones del enunciado se cumplen
		 */

		for (int i = 0; i < Sueldos.length; i++) {
			/*
			 * Si las comisiones son cero, entonces nos fijamos en el sueldo
			 * para aplicar el porcentaje de subida haciendo otro bucle if
			 * anidado para cada condicion. En la condicion que se cumpla, ahi
			 * rellenamos el array que creamos vacio con el sueldo nuevo mas el
			 * porcentaje de subida indicado en el enunciado.
			 */
			if (Comisiones[i] == 0) {
				if (Sueldos[i] < 15000) {
					Sueldos_Nuevos[i] = (Sueldos[i] + (Sueldos[i] * 0.10));
				} else if (Sueldos[i] >= 15000 && Sueldos[i] < 30000) {
					Sueldos_Nuevos[i] = (Sueldos[i] + (Sueldos[i] * 0.08));

				} else if (Sueldos[i] >= 30000 && Sueldos[i] < 45000) {
					Sueldos_Nuevos[i] = (Sueldos[i] + (Sueldos[i] * 0.04));
				} else {
					Sueldos_Nuevos[i] = Sueldos[i];

				}
				/*
				 * Si la comision es mayor de cero, entonces aqui tenemos que
				 * analizar el importe de la comision para saber que porcentaje
				 * de sueldo le tendremos que aplicar. Utilizaremos otros bucles
				 * if y else if anidados para estudiar estas condiciones. Según
				 * el caso que se cumpla, rellenaremos nuestro nuevo array vacio
				 * Sueldos_Nuevos con los valores correspondientes segun el
				 * porcentaje aplicado.
				 */

			} else if (Comisiones[i] > 0) {
				if (Comisiones[i] < 2000) {
					Sueldos_Nuevos[i] = (Sueldos[i] + (Sueldos[i] * 0.12));
				} else if (Comisiones[i] >= 2000 && Comisiones[i] <= 10000) {
					Sueldos_Nuevos[i] = (Sueldos[i] + (Sueldos[i] * 0.06));
				} else {
					Sueldos_Nuevos[i] = Sueldos[i];
				}
			}

		}
		/*
		 * Ahora para presentarlos en pantalla los ordeno por orden alfabetico
		 * mediante el metodo de la burbuja
		 */

		boolean ordenado = false;
		while (!ordenado) {
			ordenado = true;
			for (int i = 0; i < Empleados.length - 1; i++) {
				if (Empleados[i].compareTo(Empleados[i + 1]) > 0) {
					String temporal = Empleados[i];
					Empleados[i] = Empleados[i + 1];
					Empleados[i + 1] = temporal;
					ordenado = false;
				}
			}
		}
		/*
		 * A continuacion, para presentar todos los datos en pantalla,
		 * utilizaremos un bucle for con el que recorreremos todos los array e
		 * iremos imprimiendo sus datos correspondientes.
		 */
		for (int i = 0; i < Empleados.length; i++) {
			float porcentaje = (float) (100 * (Sueldos_Nuevos[i] - Sueldos[i]) / Sueldos[i]);

			/*
			 * Aquí definimos la variable porcentaje para calcular la subida de
			 * sueldo practicada y lo multiplicamos por 100 para presentarlo en
			 * pantalla en %
			 */
			System.out
					.println(Empleados[i]
							+ " ganaba al principio un sueldo de: "
							+ Sueldos[i] + " €");
			System.out.println("La comisión de " + Empleados[i] + " es de: "
					+ Comisiones[i] + " € ");
			System.out.println("El salario total de " + Empleados[i]
					+ " (Sueldo+Comisiones) era: "
					+ (Sueldos[i] + Comisiones[i]) + " €");
			System.out.println("Al empleado " + Empleados[i]
					+ " le corresponde una subida de: " + porcentaje + " %");
			System.out.println("Esto le supone a " + Empleados[i]
					+ " un incremento de salario base de : "
					+ ((int) (Sueldos_Nuevos[i] - Sueldos[i]) + " €"));
			System.out.println("El salario nuevo total de " + Empleados[i]
					+ " será igual a " + (Sueldos_Nuevos[i] + Comisiones[i])
					+ " €");
			System.out
					.println("########################################################################");
		}

	}
}
