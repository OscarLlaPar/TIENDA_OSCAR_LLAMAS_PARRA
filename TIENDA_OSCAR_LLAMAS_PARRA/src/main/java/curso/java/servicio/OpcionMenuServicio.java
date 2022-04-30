package curso.java.servicio;

import java.util.HashSet;

import curso.java.modelo.OpcionMenu;
import curso.java.modelo.OpcionMenuDB;
import curso.java.modelo.Rol;

public class OpcionMenuServicio {
	public static HashSet<OpcionMenu> mostrarOpciones(Rol rol){
		OpcionMenuDB modeloMenu=new OpcionMenuDB();
		return modeloMenu.mostrarOpciones(rol);
	}
}
