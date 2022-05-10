package curso.java.servicio;

import curso.java.modelo.Descuento;
import curso.java.modelo.DescuentoDB;

public class DescuentoServicio {
	
	public static Descuento obtenerPorCodigo(String codigo) {
		DescuentoDB modeloDescuento = new DescuentoDB();
		return modeloDescuento.obtenerPorCodigo(codigo);
	}
	
}
