package pgn.examenMarzo.concesionarioCoches;

import java.util.regex.Pattern;

import pgn.examenMarzo.utiles.Menu;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 */

public class Coche {

	private static final Pattern patronMatricula = Pattern
			.compile("^\\d{4}[ -]?[[B-Z]&&[^QEIOU]]{3}$");

	private static Menu menuColores;
	private static Menu menuModelos;

	private String matricula;
	private String color;
	private String modelo;

	private Coche(String matricula, String color, String modelo) {
		this.matricula = matricula;
		this.color = color;
		this.modelo = modelo;
	}

	private Coche(String matricula) {
		this.matricula = matricula;
	}

	public static Coche instanciarCoche(String matricula, String color,
			String modelo) {
		if (esValidaMatricula(matricula) && color != null && modelo != null) {
			//El coche no se creara si no hemos especificado un color valido, es decir, si seleccionamos "Salir" en el menu Color o Modelo
			return new Coche(matricula, color, modelo);
		}
		return null;
	}

	public static Coche instanciarCoche(String matricula) {
		if (esValidaMatricula(matricula)) {
			return new Coche(matricula);
		}
		return null;
	}

	static boolean esValidaMatricula(String matricula) {
		return patronMatricula.matcher(matricula).matches();
	}

	static String pedirColor() {
		menuColores = new Menu("Lista de colores", new String[] { "PLATA",
				"ROJO", "AZUL", "Salir" });

		int opcion;
		do {
			opcion = menuColores.gestionar();
			switch (opcion) {
			case 1:
				return Colores.recorrerEnum(opcion);
			case 2:
				return Colores.recorrerEnum(opcion);
			case 3:
				return Colores.recorrerEnum(opcion);
			case 4:
				break; // null
			default:
			}
		} while (opcion < 1 || opcion > 4);
		return null;
	}

	static String pedirModelo() {
		menuModelos = new Menu("Lista de modelos", new String[] { "SERIE1",
				"SERIE2", "SERIE3", "SERIE5", "CORDOBA", "IBIZA", "TOLEDO",
				"SALIR" });

		int opcion;
		do {
			opcion = menuModelos.gestionar();
			switch (opcion) {
			case 1:
				return Modelos.recorrerEnum(opcion);
			case 2:
				return Modelos.recorrerEnum(opcion);
			case 3:
				return Modelos.recorrerEnum(opcion);
			case 4:
				return Modelos.recorrerEnum(opcion);
			case 5:
				return Modelos.recorrerEnum(opcion);
			case 6:
				return Modelos.recorrerEnum(opcion);
			case 7:
				return Modelos.recorrerEnum(opcion);
			case 8:
				break; // null
			default:
			}
		} while (opcion < 1 || opcion > 8);
		return null;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((matricula == null) ? 0 : matricula.hashCode());
		return result;
	}

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

	@Override
	public String toString() {
		return "Coche [matricula=" + matricula + ", color=" + color
				+ ", modelo=" + modelo + "]";
	}

	public String getColor() {
		return color;
	}
}
