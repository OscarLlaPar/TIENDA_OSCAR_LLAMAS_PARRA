package curso.java.servicio;

import java.util.HashSet;

import curso.java.modelo.OpcionMenu;
import curso.java.modelo.OpcionMenuDB;
import curso.java.modelo.Rol;

public class OpcionMenuServicio {
	
	/**
	 * Muestra las opciones para el menú de un usuario con el objeto Rol especificado.
	 * Las opciones son objetos del tipo OpcionMenu, recogidas en un HashSet.
	 * Utiliza la clase OpcionMenuDB para realizar la consulta sobre la base de datos.
	 * 
	 * @param rol	El rol del usuario para el que estén asignadas las opcioenes las opciones.
	 * @return		Una colección HashSet de objetos OpcionMenu con las opciones resultantes.
	 */
	
	public static HashSet<OpcionMenu> mostrarOpciones(Rol rol){
		OpcionMenuDB modeloMenu=new OpcionMenuDB();
		return modeloMenu.mostrarOpciones(rol);
	}
}
