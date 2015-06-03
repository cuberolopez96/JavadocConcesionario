package pgn.examenMarzo.utiles;



/**
 * Clase que gestion los menus que se hagan creen 
 * @author Juan Antonio Cubero Lopez
 * 
 */
public class Menu {
	/** titulo del menu*/
	String titulo = null;
	/** array de cadenas que contienen las opciones*/
	String opciones[] = null;
	/** numeros de opciones*/
	int numOpciones = 2;
	

	/**
	 * Constructor del menu 
	 * 
	 * @param titulo
	 *            
	 * @param opciones
	 *            
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	/**
	 * muestra la opciones del menu y devuelve el n&uacute;mero de opci&oacute;n
	 * @return opci&oacute;n valida del menu creado;
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del men&uacute;
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opci&oacute;n v&aacute;lida del men&uacute;
	 * 
	 * @return opci&oacute;n v&aacute;lida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

}
