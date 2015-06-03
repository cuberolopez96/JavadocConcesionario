package pgn.examenMarzo.concesionarioCoches;

//import pgn.examenMarzo.utiles.Menu;

/**
 * Enumeraci&oacute;n de los colores de un coche
 * @author Juan Antonio Cubero
 * @version 1.0.0
 * 
 */
public enum Color {
	PLATA, ROJO, AZUL;
/** Array dde colores para la posterior creacion de un men&uacute;*/
	private static final Color[] VALUES = Color.values();
/** Devuelve un array de cadenas con los nombres de los colores y la palabra salir
 * @return Array de cadenas con los nombres de los colores y la palabra salir*/
	public static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[getValues().length + 1];
		int i = 0;
		for (Color color : getValues()) {
			opcionesMenu[i++] = color.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
/**Devuelve un array de colores
 * 
 *  @return array de colores*/
	public static Color[] getValues() {
		return VALUES;
	}

}
