package pgn.examenMarzo.concesionarioCoches;

import java.util.ArrayList;

/*
 * No pueden existir dos coches con la misma matrícula en el almacén del concesinario
 * no puede añadirse un coche al concecionario con alguno de sus atributos inválidos. Han de conocerse todas sus características 
 * Ninguno de los valores puede ser por defecto
 */
/**
 * Clase donde se define los campos, y comportamientos del concesionario desde su nombre(IES Gran Capi&aacute;n) hasta la lista de coches 
 * 
 * 
 * 
 * 
 * 
 * @author Juan Antonio Cubero Lopez
 * 
 */
public class Concesionario {
	/**
	 * Lista De coches que no puede tener valores nulos
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	/**Nombre del concesionario */
	private final String nombre = "IES Gran Capitán";
/**a&ntilde;ade un coche a la lista de coches
 * @param  matricula
 * @param  color
 * @param  modelo 
 * @return true si ha a&ntilde;adido  el coche , false si no ha podido*/
	boolean annadir(String matricula, Color color, Modelo modelo) {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null || almacen.contains(coche))
			return false;
		return almacen.add(coche);
	}
	/**elimina un coche de la lista que coincida con la matricula pasada por parametro
	 * @param matricula 
	 * @return si lo ha eliminado, false si no */
	boolean eliminar(String matricula) {
		return almacen.remove(Coche.instanciarCoche(matricula));
	}

	/**Devuelve el tamaño de la lista
	 * @return el tamaño de la lista */
	int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el coche de la lista que coincide con la matricula
	 * 
	 * @param matricula
	 *            Matrícula a buscar
	 * @return coche de la lista que coincide con la matricula, null si no coincide con ninguno
	 */
	Coche get(String matricula) {
		Coche coche = Coche.instanciarCoche(matricula);
		int index = almacen.indexOf(coche);
		if (index != -1) {
			return almacen.get(index);
		}
		return null;
	}

	/*
	 * Devuelve una cadena con los datos del concesionario incluidos los coches que tiene en la lista
	 * @return cadena con los datos del concesionario.
	 * 
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}
/** devuelve una lista con los coches que coinciden con el color indicado
 * @param color
 * @return lista de coches que coincide con el color indicado */
	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if(coche.getColor()== color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}
