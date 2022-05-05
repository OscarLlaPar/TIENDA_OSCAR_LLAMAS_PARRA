package curso.java.util;

import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import curso.java.servicio.UsuarioServicio;

public class ValidacionFormularios {
	
	/**
	 * 
	 * @param mail
	 * @param obligatorio
	 * @return
	 */
	
	public static String validarEmail(String mail, boolean obligatorio) {
		String mensajeError="";
		if(obligatorio) {
			mensajeError=comprobarObligatorio(mail);
		}
		if(mensajeError.equals("")) {
			mensajeError=comprobarEmailExiste(mail);
		}
		if(mensajeError.equals("")) {
			Pattern pattern = Pattern
	                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
			Matcher matcher=pattern.matcher(mail);
			if(!matcher.find()) {
				mensajeError="El email introducido no es v�lido";
			}
		}
		
		return mensajeError;
	}
	
	/**
	 * 
	 * @param email
	 * @return
	 */
	
	public static String comprobarEmailExiste(String email) {
		if(UsuarioServicio.existeEmail(email)) {
			return "El email introducido ya existe";
		}
		else {
			return "";
		}
		
	}
	
	/**
	 * 
	 * @param dni
	 * @param obligatorio
	 * @return
	 */
	
	public static String validarDni(String dni, boolean obligatorio) {
		String mensajeError="";
		if(obligatorio) {
			mensajeError=comprobarObligatorio(dni);
		}
		if(mensajeError.equals("")) {
			Pattern pattern = Pattern
	                .compile("[0-9]{7,8}[A-Za-z]");
			Matcher matcher=pattern.matcher(dni);
			if(!matcher.find()) {
				mensajeError="El DNI introducido no es v�lido";
			}
		}
		
		return mensajeError;
	}
	
	/**
	 * 
	 * @param telefono
	 * @param obligatorio
	 * @return
	 */
	
	public static String validarTelefono(String telefono, boolean obligatorio) {
		String mensajeError="";
		if(obligatorio) {
			mensajeError=comprobarObligatorio(telefono);
		}
		if(mensajeError.equals("")) {
			Pattern pattern = Pattern
	                .compile("^[6789][0-9]{8}$");
			Matcher matcher=pattern.matcher(telefono);
			if(!matcher.find()) {
				mensajeError="El tel�fono introducido no es v�lido";
			}
		}
		
		return mensajeError;
	}
	
	/**
	 * 
	 * @param entrada
	 * @param obligatorio
	 * @return
	 */
	
	public static String comprobarAlfabetico(String entrada, boolean obligatorio) {
		String mensajeError="";
		if(obligatorio) {
			mensajeError=comprobarObligatorio(entrada);
		}
		if(mensajeError.equals("")) {
			Pattern pattern = Pattern
	                .compile(".*\\d.*");
			Matcher matcher=pattern.matcher(entrada);
			if(matcher.find()) {
				mensajeError="Solo se admiten caracteres alfab�ticos";
			}
		}
		
		return mensajeError;
	}
	
	/**
	 * 
	 * @param entrada
	 * @return
	 */
	
	public static String comprobarObligatorio(String entrada) {
		String mensajeError="";
		if(entrada.equals("")||entrada==null) {
			mensajeError="Campo vac�o";
		}
		return mensajeError;
	}
	
	/**
	 * 
	 * @param errores
	 * @return
	 */
	
	public static boolean hayErrores(HashMap<String, String> errores) {
		boolean hayErrores= false;
		Iterator<String> it = errores.keySet().iterator();
		while(it.hasNext() && !hayErrores) {
			String clave=it.next();
			String valor=errores.get(clave);
			if(!valor.equals("")) {
				hayErrores=true;
			}
		}
		return hayErrores;
	}
}
