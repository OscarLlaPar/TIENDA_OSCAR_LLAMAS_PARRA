package curso.java.pruebas;

import curso.java.modelo.MetodoPago;
import curso.java.modelo.UsuarioDB;

public class Pruebas {
	public static void main(String[] args) {
		UsuarioDB mu=new UsuarioDB();
		
		System.out.println(mu.buscarUsuarioPorEmail("aaaaaa"));
	}
}
