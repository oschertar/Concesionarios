
package concesionarioCoches;

import java.io.Serializable;
/**
 * Importación de la clase Pattern
 */
import java.util.regex.Pattern;

/**
 * Clase que contiene toda la información y las acciones de los coches
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 *
 */
public class Coche implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Cadena donde se guardara la matricula
	 */
	private String matricula;
	/**
	 * Variable donde se guarda el color del coche
	 */
	private Color color;
	/**
	 * Variable donde se guarda el tipo de modelo del coche
	 */
	private Modelo modelo;
	/**
	 * Patron que verifica si la matricula introducida es valida o no
	 */
	static final private Pattern patternMatricula = Pattern
			.compile("^(\\d){4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	/**
	 * Constructor coche completo
	 * 
	 * @param matricula
	 *            matricula introducida por teclado
	 * @param color
	 *            color seleccionado del menu
	 * @param modelo
	 *            modelo seleccionado del menu
	 * @throws MatriculaNoValidaException
	 * @throws ColorNoValidoException
	 * @throws ModeloNoValidoException
	 */
	Coche(String matricula, Color color, Modelo modelo)
			throws MatriculaNoValidaException, ColorNoValidoException,
			ModeloNoValidoException {
		super();
		setMatricula(matricula);
		setColor(color);
		setModelo(modelo);
	}

	/**
	 * Constructor coche , solo matricula
	 * 
	 * @param matricula
	 *            matricula introducida por teclado
	 * @throws MatriculaNoValidaException
	 */
	public Coche(String matricula) throws MatriculaNoValidaException {
		setMatricula(matricula);
	}

	/**
	 * Metodo que valida una matricula introducida
	 * 
	 * @param matricula
	 *            matricula introducida por teclado
	 * @return devuelve true si es válida la matricula o false si no es válida
	 */
	public static boolean esValida(String matricula) {
		return patternMatricula.matcher(matricula).matches();
	}

	/**
	 * Metodo set de la matrícula
	 * 
	 * @param matricula
	 *            matrícula del coche
	 * @throws MatriculaNoValidaException
	 *             excepción que salta cuando la matrícula no sea válida
	 *             siguiendo el patrón
	 */
	private void setMatricula(String matricula)
			throws MatriculaNoValidaException {
		if (esValida(matricula))
			this.matricula = matricula;
		else
			throw new MatriculaNoValidaException("La matrícula no es válida");

	}
	
	/**
	 * Devuelve la matricula del vehiculo
	 * @return matricula
	 */
	public String getMatricula(){
		return matricula;
	}

	/**
	 * Metodo get del campo color
	 * 
	 * @return devuelve un color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Metodo set del campo color
	 * 
	 * @param color
	 *            color del coche
	 * @throws ColorNoValidoException
	 *             Excepción que salta cuando el color para asignar sea null
	 */
	private void setColor(Color color) throws ColorNoValidoException {
		if (color != null)
			this.color = color;
		else
			throw new ColorNoValidoException("El color no es válido");

	}

	/**
	 * Metodo set del campo modelo
	 * 
	 * @param modelo
	 *            modelo del coche
	 * @throws ModeloNoValidoException
	 *             Excepción que salta cuando el modelo para asignar sea null
	 */
	private void setModelo(Modelo modelo) throws ModeloNoValidoException {
		if (modelo != null)
			this.modelo = modelo;
		else
			throw new ModeloNoValidoException("El modelo no es válido");

	}
	
	/**
	 * Devuelve el modelo del coche
	 * @return modelo
	 */
	public Modelo getModelo(){
		return modelo;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
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
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "\nCoche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

}
