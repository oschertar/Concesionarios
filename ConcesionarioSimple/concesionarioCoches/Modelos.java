package pgn.examenMarzo.concesionarioCoches;

/**
 * 
 * @author Daniel Lozano Torrico
 * @version 1.0
 *
 */

public enum Modelos {
	SERIE1(1, "BMW"),
	SERIE2(2, "BMW"),
	SERIE3(3, "BMW"),
	SERIE5(4, "BMW"),
	CORDOBA(5, "SEAT"),
	IBIZA(6, "SEAT"),
	TOLEDO(7, "SEAT");
	
	private int codigo;
	private String marca;
	
	Modelos(int codigo, String marca){
		this.codigo=codigo;
		this.marca=marca;
	}

	public int getCodigo() {
		return codigo;
	}
	
	public String getMarca() {
		return marca;
	}
	
	 static String recorrerEnum(int codigo){
		for(Modelos modelos : Modelos.values()){
			if(modelos.getCodigo()==codigo)
				return modelos.name()+", "+modelos.getMarca();
		}
		return null;
	}
	
}
