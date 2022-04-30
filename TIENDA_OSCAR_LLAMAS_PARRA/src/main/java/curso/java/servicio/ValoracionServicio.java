package curso.java.servicio;

import java.util.HashSet;

import curso.java.modelo.Valoracion;
import curso.java.modelo.ValoracionDB;

public class ValoracionServicio {
	public static boolean insertarValoracion(Valoracion v) {
		ValoracionDB modeloValoracion=new ValoracionDB();
		return modeloValoracion.insertarValoracion(v);
	}
	
	public static HashSet<Valoracion> obtenerValoracionesProducto(int idProducto){
		ValoracionDB modeloValoracion=new ValoracionDB();
		return modeloValoracion.obtenerValoracionesProducto(idProducto);
	}
	
}
