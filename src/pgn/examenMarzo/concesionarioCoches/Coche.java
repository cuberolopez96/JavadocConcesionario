package pgn.examenMarzo.concesionarioCoches;

import java.util.regex.Pattern;
/**Clase que contiene los datos y el comportamiento de un coche 
 * @author Juan Antonio Cubero */
public class Coche {
	/** Matr&iacute;cula del coche*/
	private String matricula;
	/**Color del coche */
	private Color color;
	/** Modelo del coche*/
	private Modelo modelo;
	/** Patr&oacute;n que controla la la correcta introduccion de una matricula*/
	static final private Pattern patternMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");
/** Constructor de la clase coche
 * @param matr&iacute;cula
 * @param color
 * @param modelo*/
	private Coche(String matricula, Color color, Modelo modelo) {
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}
/**constructor de una matr&iacute;cula */
	private Coche(String matricula) {
		setMatricula(matricula);
	}
/** Controla la instanciaci&oacute;n de un coche para que no se introduzca ning&uacute;n dato incorrecto
 * @param matr&iacute;cula
 * @param color
 * @param modelo
 * @return Coche con los datoss introducidos si los datos son correctos, null si no son correctos */
	static Coche instanciarCoche(String matricula, Color color, Modelo modelo) {
		if (esValida(matricula) && color != null && modelo != null)
			return new Coche(matricula, color, modelo);
		return null;
	}
/** controla la instanciaci&oacute;n de un coche al que solo se le pasa la matr&iacute;cula
 * @param matr&iacute;cula;
 * @return coche si la matricula es valida, null si no es valida*/
	static Coche instanciarCoche(String matricula) {
		if (esValida(matricula))
			return new Coche(matricula);
		return null;
	}
/**compara la matr&iacute;cula con el patron 
 * @param matr&iacute;cula
 * @return true si coincide la matr&iacute;cula con el patr&oacute;n, false sino  */
	private static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}
/** inicializa la matr&iacute;cula del coche
 * @param matr&iacute;cula*/ 
	private void setMatricula(String matricula) {
		this.matricula = matricula;
	}
/** devuelve el color del coche
 * @return color del coche*/
	Color getColor() {
		return color;
	}
/** inicializa el color del coche
 * @param color*/
	private void setColor(Color color) {
		this.color = color;
	}
/** inicializa el modelo del coche 
 * @param modelo */
	private void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/*
	 * Compara el objeto con el coche
	 * 
	 * @param obj
	 * @return true si son iguales, false sino
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coche other = (Coche) obj;
		if (matricula == null) {
			if (other.matricula != null)
				return false;
		} else if (!matricula.equals(other.matricula))
			return false;
		return true;
	}

	/*
	 * Devuelve una cadena con los datos de un coche
	 * @return cadena con los datos de un coche
	 * 
	 * 
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

}
