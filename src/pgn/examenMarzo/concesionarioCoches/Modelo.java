package pgn.examenMarzo.concesionarioCoches;
/** Enumeracion de modelos
 * @author Juan Antonio Cubero
 * @version 1.0.0*/
public enum Modelo {
/**modelo del coche */
	SERIE1(Marca.BMW),
	/**modelo del coche */

	SERIE2(Marca.BMW),
	/**modelo del coche */

	SERIE3(Marca.BMW),
	/**modelo del coche */

	SERIE5(Marca.BMW),
	/**modelo del coche */

	CORDOBA(Marca.SEAT),
	/**modelo del coche */

	IBIZA(Marca.SEAT),
	/**modelo del coche */

	TOLEDO(Marca.SEAT);
	/**Marca del modelo*/
	private Marca marca;
	/**Constructor del modelo 
	 * @param Marca marca */
	private Modelo(Marca marca) {
		this.marca = marca;
	}
/**devuelve la marca del modelo
 * @return marca */
	public Marca getMarca() {
		return marca;
	}
/**Devuelve una cadena de caracteres con el nombre del modelo y su respectiva marca 
 * @return una cadena de caracteres con el nombre del modelo y su respectiva marca*/
	public String toString() {
		return name() + ", " + getMarca();

	}

	// Para el menú-------------------------------------------------
	/**Array de modelos */
	private static final Modelo[] VALUES = Modelo.values();
/** genera las opciones para la posterior creacion de un menu
 * @return Array de cadenas que contiene todos los nombres de modelos mas la palabra salir*/
	static String[] generarOpcionesMenu() {
		String[] opcionesMenu = new String[VALUES.length + 1];
		int i = 0;
		for (Modelo modelo : VALUES) {
			opcionesMenu[i++] = modelo.name();
		}
		opcionesMenu[i] = "Salir";
		return opcionesMenu;
	}
/** Devuelve un array de modelos 
 * @return Array de modelos*/
	public static Modelo[] getValues() {
		return VALUES;
	}
	// -------------------------------------------------

}
