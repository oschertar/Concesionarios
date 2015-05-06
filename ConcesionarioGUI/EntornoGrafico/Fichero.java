package EntornoGrafico;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import concesionarioCoches.Concesionario;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 *
 */

public class Fichero implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void guardar(File file, Concesionario concesionario)
			throws IOException {
		file = annadirExtension(file);
		try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file, false)))) {
			objectOutputStream.writeObject(concesionario);
		}
	}

	public static Object abrir(File archivo) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		archivo = annadirExtension(archivo);
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				archivo))) {
			return (Object) ois.readObject();
		}
	}

	public static File annadirExtension(File fichero) {
		String nombre = General.archivo.getPath();
		if (!nombre.endsWith(".obj"))
			return new File(General.archivo + ".obj");
		return General.archivo;
	}

}
