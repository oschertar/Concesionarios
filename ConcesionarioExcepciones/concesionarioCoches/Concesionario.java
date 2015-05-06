package concesionarioCoches;

import java.util.ArrayList;

/*
 * No pueden existir dos coches con la misma matr�cula en el almac�n del concesinario
 * no puede a�adirse un coche al concecionario con alguno de sus atributos inv�lidos. Han de conocerse todas sus caracter�sticas 
 * Ninguno de los valores puede ser por defecto
 */
/**
 * El nombre del concesionario es "IES Gran Capit�n".
 * 
 * L�gicamente, no podr� a�adirse un coche inv�lido glmac�n del concesinario)
 * 
 * Han de conocerse todas sus caracter�sticas Ninguno de los valores puede ser
 * por defecto
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 */
public class Concesionario {
	/**
	 * colecci�n de coches. No puede tener null
	 */
	private ArrayList<Coche> almacen = new ArrayList<Coche>();
	private final String nombre = "IES Gran Capit�n";

	void annadir(String matricula, Color color, Modelo modelo)
			throws MatriculaNoValidaException, ColorNoValidoException,
			ModeloNoValidoException, CocheYaExisteException {
		Coche coche = new Coche(matricula, color, modelo);
		if (almacen.contains(coche))
			throw new CocheYaExisteException(
					"El coche ya esta en el concesionario");
		almacen.add(coche);
	}

	void eliminar(String matricula) throws MatriculaNoValidaException,
			CocheNoExisteException {
		Coche coche = new Coche(matricula);
		if (almacen.contains(coche))
			almacen.remove(coche);
		else
			throw new CocheNoExisteException(
					"El coche no esta en el concesionario");
	}

	int size() {
		return almacen.size();
	}

	/**
	 * Devuelve el Coche del almac�n indicado por la matr�cula
	 * 
	 * @param matricula
	 *            Matr�cula a buscar
	 * @return Coche contenido en el almac�n. null si no existe
	 */
	Coche get(String matricula) throws MatriculaNoValidaException,
			CocheNoExisteException {
		Coche coche = new Coche(matricula);
		if (almacen.contains(coche)) {
			int index = almacen.indexOf(coche);
			if (index != -1) {
				return almacen.get(index);
			}
		} else {
			throw new CocheNoExisteException(
					"El coche no esta en el concesionario");
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Concesionario " + nombre + "[almacen=" + almacen + "]";
	}

	public ArrayList<Coche> getCochesColor(Color color) {
		ArrayList<Coche> arrCochesColor = new ArrayList<Coche>();
		for (Coche coche : almacen) {
			if (coche.getColor() == color)
				arrCochesColor.add(coche);
		}
		return arrCochesColor;
	}

}
