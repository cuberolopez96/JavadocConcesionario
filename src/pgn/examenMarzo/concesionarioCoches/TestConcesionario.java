package pgn.examenMarzo.concesionarioCoches;

import pgn.examenMarzo.utiles.Menu;
import pgn.examenMarzo.utiles.Teclado;
import pgn.examenMarzo.concesionarioCoches.Color;
import pgn.examenMarzo.concesionarioCoches.Modelo;

/**
 * Se Presenta un concesionario de coches que cumple las siguientes funciones: dar de alta a un coche,
 * dar de baja a un coche , mostrar un coche , mostrar
 * mostrar todos los coches del concesionario 
 * @author Juan Antonio Cubero Lopez
 * @version 1.0.0
 * 
 */
public class TestConcesionario{
	/** menu del concesionario de coches que contiene todas las opciones del concesionario*/
	static Menu menu = new Menu("Concesionario de coches", new String[] {
			"Alta Coche", "Baja Coche", "Mostrar Coche",
			"Mostrar concesionario", "Contar coches del concesionario",
			"Mostrar coches de un color", "Salir" });
	/** menu de elecci&oacute;n del color del coche*/
	private static Menu menuColores = new Menu("Colores de los coches",
			Color.generarOpcionesMenu());
	/** menu de elecci&oacute;n del modelo del coche*/
	private static Menu menuModelos = new Menu("Modelos de los coches",
			Modelo.generarOpcionesMenu());
	/** instanciaci&oacute;n del concesionario*/
	static Concesionario concesionario = new Concesionario();

	public static void main(String[] args) {
		do {
			switch (menu.gestionar()) {
			case 1:// "Añadir Coche
				annadirCoche();
				break;
			case 2:// Eliminar Coche
				eliminarCoche();
				break;
			case 3:// Obtener Coche
				getCoche();
				break;
			case 4:// Mostrar lista
				System.out.println(concesionario);
				break;
			case 5:// Contar coches
				System.out.println("Número de coches en el concesionario: "
						+ concesionario.size());
				break;
			case 6:// Mostrar coches de un color
				System.out.println(concesionario.getCochesColor(pedirColor()));
				break;

			default:// Salir
				System.out.println("Aaaaaaaaaaaaaaaaaaaaadios");
				return;
			}
		} while (true);
	}
/**Imprime por pantalla los datos del coche que coincide con la matricula introducida por teclado, si no cocincide imprime un mensaje al usuario */
	private static void getCoche() {
		Coche coche = concesionario.get(Teclado
				.leerCadena("Introduce la matrícula"));
		if (coche == null)
			System.out.println("No existe el coche en el concesionario.");
		else
			System.out.println(coche);
	}
/**Da de baja a un coche que coincide con la matricula introducida por teclado e imprime por pantalla un mensaje de confirmaci&oacute;n, si no coincide la matricula imprime por pantalla un mensaje de error */
	private static void eliminarCoche() {
		if (concesionario
				.eliminar(Teclado.leerCadena("Introduce la matrícula")))
			System.out.println("Coche eliminado");
		else
			System.out.println("No se ha podido eliminar");
	}
/**a&ntilde;ade al concesionario un coche con los datos introducidos por el usuario entre los que est&aacute; : 
 * <li>la matricula
 * <li>el color
 * <li>elmodelo */
	private static void annadirCoche() {
		if (concesionario.annadir(Teclado.leerCadena("Introduce la matrícula"),
				pedirColor(), pedirModelo()))
			System.out.println("Coche añadido con éxito");
		else
			System.out.println("No se ha podido añadir");
	}
/**Devuelve un modelo elegido por el usuario mediante men&uacute;
 * @return arrModelos, null si se introduce una opci&oacute;n incorrecta */
	private static Modelo pedirModelo() {
		int opcion = menuModelos.gestionar();
		Modelo[] arrModelos = Modelo.getValues();
		if (opcion == arrModelos.length + 1)
			return null;
		return arrModelos[opcion - 1];
	}
/**Devuelve un color elegido por el usuario mediante un men&uacute;
 * @return arrcolor, null si se elige una opci&oacute;n incorrecta*/
	private static Color pedirColor() {
		int opcion = menuColores.gestionar();
		Color[] arrColores = Color.getValues();
		if (opcion == arrColores.length + 1)
			return null;
		return arrColores[opcion - 1];
	}
}
