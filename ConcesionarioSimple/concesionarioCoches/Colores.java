package pgn.examenMarzo.concesionarioCoches;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 *
 */

public enum Colores {
	PLATA(1),
	ROJO(2),
	AZUL(3);
	
	private int codigo;
	
	Colores(int codigo){
		this.codigo=codigo;
	}

	public int getCodigo() {
		return codigo;
	}
	
	static String recorrerEnum(int codigo){
		for(Colores colores : Colores.values()){
			if(colores.getCodigo()==codigo)
				return colores.name();
		}
		return null;
	}
}
