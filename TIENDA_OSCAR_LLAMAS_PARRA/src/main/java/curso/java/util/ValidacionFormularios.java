package curso.java.util;

import java.util.HashMap;
import java.util.Iterator;

public class ValidacionFormularios {
	public static boolean hayErrores(HashMap<String, String> errores) {
		boolean hayErrores= false;
		Iterator<String> it = errores.keySet().iterator();
		while(it.hasNext() && !hayErrores) {
			if(it.next()!=null) {
				hayErrores=true;
			}
		}
		return hayErrores;
	}
}
