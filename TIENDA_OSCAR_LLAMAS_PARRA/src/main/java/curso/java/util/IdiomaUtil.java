package curso.java.util;

import java.util.HashMap;
import java.util.Locale;
import java.util.ResourceBundle;

public class IdiomaUtil {
	public static String[] contenidoIdioma(Locale local) {
		 
		
		 ResourceBundle rb = ResourceBundle.getBundle("inicio", local);
		 String[] contenido= {
				 rb.getString("cabecera"),  
				 rb.getString("buscar"), 
				 rb.getString("ordenarph"), 
				 rb.getString("categoriasph"), 
				 rb.getString("buscarBoton"), 
				 rb.getString("anadir")
		 };
		 
		 return contenido;
	}
}
