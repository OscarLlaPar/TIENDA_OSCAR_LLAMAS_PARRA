package curso.java.servicio;

import curso.java.modelo.Configuracion;
import curso.java.modelo.ConfiguracionDB;

public class ConfiguracionServicio {
	/**
	 * Devuelve un objeto Configuracion sacado de la base de datos
	 * cuya clave sea la misma que se le pasa por parámetro.
	 * El método utiiza la clase ConfiguracionDB para realizar la consulta
	 * con la base de datos.
	 * 
	 * @param clave La clave de la configuración que se desea obtener.
	 * @return		El objeto Configuracion que contenga esa clave. Devuelve null si no existe.
	 */
	
	public static Configuracion obtenerConfiguracion(String clave) {
		ConfiguracionDB modeloConfiguracion=new ConfiguracionDB();
		return modeloConfiguracion.obtenerConfiguracion(clave);
	}
}
