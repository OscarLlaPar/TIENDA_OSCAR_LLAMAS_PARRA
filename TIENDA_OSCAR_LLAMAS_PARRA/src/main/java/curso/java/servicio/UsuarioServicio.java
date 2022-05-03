package curso.java.servicio;

import curso.java.modelo.Rol;
import curso.java.modelo.RolDB;
import curso.java.modelo.Usuario;
import curso.java.modelo.UsuarioDB;
import curso.java.util.UsuarioUtil;

public class UsuarioServicio {
	public static Usuario verificarUsuario(String email, String password) {
		UsuarioDB modeloUsuario=new UsuarioDB();
		Usuario u=modeloUsuario.buscarUsuarioPorEmail(email);
		
		if (u!=null && u.getClave().equals(UsuarioUtil.obtenerSha2(password))) {
			return u;
		}
		else {
			return null;
		}
	}
	public static boolean editarUsuario(Usuario usuarioActual, Usuario usuarioNuevo) {
		UsuarioDB modeloUsuario=new UsuarioDB();
		if(!usuarioActual.getEmail().equals(usuarioNuevo.getEmail()) && modeloUsuario.buscarUsuarioPorEmail(usuarioNuevo.getEmail())!=null) {
			return false;
		}
		else {
			return modeloUsuario.editarUsuario(usuarioActual, usuarioNuevo);
		}
	}
	public static boolean cambiarPassword(String email, String password) {
		UsuarioDB modeloUsuario=new UsuarioDB();
		return modeloUsuario.cambiarPassword(email, password);
	}
	
	public static Rol obtenerRol(int id) {
		RolDB modeloRol=new RolDB();
		return modeloRol.obtenerRol(id);
	}
	
	public static boolean altaUsuario(Usuario u) {
		UsuarioDB modeloUsuario=new UsuarioDB();
		return modeloUsuario.altaUsuario(u);
	}
	
	public static boolean existeEmail(String email) {
		UsuarioDB modeloUsuario=new UsuarioDB();
		if(modeloUsuario.buscarUsuarioPorEmail(email)!=null) {
			return true;
		}
		else {
			return false;
		}
	}
	
}
