package curso.java.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * 
 * @author Oscar
 *
 */

public class LogUtil {
	private static Logger log = Logger.getLogger(LogUtil.class);

	@SuppressWarnings("rawtypes")
	public static void registrarInfo(Class clase, TipoLog tipo, String mensaje)
	{
	 log = LogManager.getLogger(clase);
	 
	 switch (tipo) 
	 {
	  case DEBUG:
	   log.debug(mensaje);
	   break;
	  case ERROR:
	   log.error(mensaje);
	   break;
	  case FATAL:
	   log.fatal(mensaje);
	   break;
	  case INFO:
	   log.info(mensaje);
	   break;
	  case WARNING:
	   log.warn(mensaje);
	 }
	}
}
