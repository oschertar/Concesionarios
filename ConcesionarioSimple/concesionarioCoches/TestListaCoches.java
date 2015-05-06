package pgn.examenMarzo.concesionarioCoches;

import java.util.ArrayList;

import pgn.examenMarzo.utiles.Menu;
import pgn.examenMarzo.utiles.Teclado;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 *
 */

public class TestListaCoches {

	private static Menu menu;

	public static void main(String[] args) {
		menu = new Menu("Concesionario", new String[] { "Alta coche",
				"Baja coche", "Mostrar Coche", "Mostrar concesionario",
				"Contar coches del concesionario",
				"Mostrar coches de un color", "Salir" });

		ListaCoches lista = new ListaCoches();

		int opcion;
		do {
			opcion = menu.gestionar();
			switch (opcion) {
			case 1: //Alta coche
				annadirCoche(lista);
				break;
			case 2: //Baja coche
				eliminarCoche(lista);
				break;
			case 3: //Mostrar Coche
				mostrarCoche(lista);
				break;
			case 4: //Mostrar concesionario
				System.out.println(lista);
				break;
			case 5: //Contar coches del concesionario
				System.out.println("Hay " + lista.getCantidad() + " coches");
				break;
			case 6: //Mostrar coches de un color
				mostrarCochesPorColor(lista);
				break;
			case 7: //Salir
				System.out.println("Hasta la vista!");
			}
		} while (opcion < 1 || opcion > 7);
	}

	private static void mostrarCochesPorColor(ListaCoches lista) {
		ArrayList<Coche> arrayPorColor = lista.mostrarCochesPorColor(Coche
				.pedirColor());
		if (arrayPorColor.size() == 0)
			System.out.println("No existen coches con este color");
		else
			System.out.println(arrayPorColor);
	}

	private static void mostrarCoche(ListaCoches lista) {
		Coche coche = lista.mostrarCoche(Teclado
				.leerCadena("Introducir matricula (0000-BBB/0000BBB)"));
		if (coche == null)
			System.out.println("No existe el coche");
		else
			System.out.println(coche);
	}

	private static void eliminarCoche(ListaCoches lista) {
		if (lista.eliminar(Teclado.leerCadena("Introducir matricula")))
			System.out.println("Eliminado con exito");
		else
			System.out.println("No se ha podido eliminar");
	}

	private static void annadirCoche(ListaCoches lista) {
		if (lista.annadir(Teclado.leerCadena("Introduce matricula:"),
				Coche.pedirColor(), Coche.pedirModelo()))
			System.out.println("Coche añadido con exito");
		else
			System.out.println("No se ha podido añadir");
	}

}
