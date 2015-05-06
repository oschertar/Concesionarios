package pgn.examenMarzo.concesionarioCoches;

import java.util.ArrayList;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 */

public class ListaCoches {

	ArrayList<Coche> arrayCoches = new ArrayList<Coche>();

	public boolean annadir(String matricula, String color, String modelo) {
		Coche coche = Coche.instanciarCoche(matricula, color, modelo);
		if (coche == null
				| arrayCoches.contains(coche)) {
			return false;
		}
		return arrayCoches.add(coche);
	}

	public boolean eliminar(String matricula) {
		return arrayCoches.remove(Coche.instanciarCoche(matricula));
	}

	public Coche mostrarCoche(String matricula) {
		int indice;
		Coche coche = Coche.instanciarCoche(matricula);
		if (arrayCoches.contains(coche)) {
			indice = arrayCoches.indexOf(coche);
			return arrayCoches.get(indice);
		}
		return null;
	}

	public ArrayList<Coche> mostrarCochesPorColor(String color) {
		ArrayList<Coche> arrayCochesPorColor = new ArrayList<Coche>();
		Coche coche;
		for (int i = 0; i < arrayCoches.size(); i++) {
			coche = arrayCoches.get(i);
			if (coche.getColor() == color)
				arrayCochesPorColor.add(coche);
		}
		return arrayCochesPorColor;
	}

	@Override
	public String toString() {
		return "Concesionario IES Gran Capitan [almacen =\n " + arrayCoches
				+ "]";
	}

	public int getCantidad() {
		return arrayCoches.size();
	}
}
