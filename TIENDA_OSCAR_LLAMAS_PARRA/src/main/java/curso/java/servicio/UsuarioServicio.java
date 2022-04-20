package curso.java.servicio;

import curso.java.modelo.Usuario;
import curso.java.modelo.UsuarioDB;
import curso.java.util.UsuarioUtil;

public class UsuarioServicio {
	public static Usuario verificarUsuario(String email, String password) {
		UsuarioDB modeloUsuario=new UsuarioDB();
		Usuario u=modeloUsuario.buscarUsuarioPorEmail(email);
		
		if (u!=null && u.getClave().equals(UsuarioUtil.obtenerSha2(u.getNombre()+password))) {
			return u;
		}
		else {
			return null;
		}
	}
}
