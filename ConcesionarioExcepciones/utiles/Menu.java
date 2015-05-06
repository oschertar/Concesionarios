package utiles;

/**
 * Clase utilizada para la gesti�n de un men�. Se dedica a:
 * 
 * <li>Mostrar las opciones del men�
 * 
 * <li>Recoger y devolver las opciones de un men�
 * 
 * @author Daniel Lozano Torrico
 * 
 */
public class Menu {
	String titulo = null;
	String opciones[] = null;
	int numOpciones = 2;

	/**
	 * 
	 * @param titulo
	 *            título del menú
	 * @param opciones
	 *            opciones del menú
	 */
	public Menu(String titulo, String[] opciones) {
		this.titulo = titulo;
		this.opciones = opciones;
		this.numOpciones = this.opciones.length;
	}

	/**
	 * Gestiona el menu. Consiste en mostrar las opcines y recoger la opcion
	 * seleccionada por el usuario
	 * 
	 * @return opcion valida del menu
	 */
	public int gestionar() {
		mostrar();
		return recogerOpcion();
	}

	/**
	 * Muestra las opciones del menu
	 */
	private void mostrar() {
		int i = 1;
		System.out.println("**" + titulo);
		for (String elemento : opciones)
			System.out.println("(" + (i++) + ") " + elemento);
	}

	/**
	 * Recoge la opcion valida del menu
	 * 
	 * @return opcion valida
	 */
	private int recogerOpcion() {
		int opcion;
		do {
			opcion = Teclado.leerEntero();
		} while (opcion < 1 || opcion > numOpciones);
		return opcion;
	}

}
