package curso.java.servicio;

import java.util.HashSet;

import curso.java.modelo.Valoracion;
import curso.java.modelo.ValoracionDB;

public class ValoracionServicio {
	/**
	 * Utiliza la clase ValoracionDB para insertar el objeto
	 * Valoración recibido en la base de datos.
	 * 
	 * @param v	El objeto Valoración que se desea introducir.
	 * @return	true si se ha introducido correctamente, false si no se ha introducido.
	 */
	
	public static boolean insertarValoracion(Valoracion v) {
		ValoracionDB modeloValoracion=new ValoracionDB();
		return modeloValoracion.insertarValoracion(v);
	}
	
	/**
	 * Utiliza la clase ValoracionDB para obtener todas las valoraciones de
	 * un producto cuya ID se haya pasado por parámetro.
	 * 
	 * @param idProducto	El ID del producto del que se desea obtener las valoraciones
	 * @return				Una colección HashSet de objetos Valoracion con las valoraciones obtenidas.
	 */
	
	public static HashSet<Valoracion> obtenerValoracionesProducto(int idProducto){
		ValoracionDB modeloValoracion=new ValoracionDB();
		return modeloValoracion.obtenerValoracionesProducto(idProducto);
	}
	
}
