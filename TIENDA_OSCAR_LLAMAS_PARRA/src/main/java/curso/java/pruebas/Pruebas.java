package curso.java.pruebas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.ResourceBundle;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import curso.java.util.IdiomaUtil;
import curso.java.util.JsonUtil;

public class Pruebas {
	public static void main(String[] args) {
		String cadena=JsonUtil.leerUrl("https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&sort=provincia&facet=provincia");
		
		/*Provincia provincias = new Gson().fromJson(cadena, Provincia.class);
		System.out.println(provincias.getName());*/
		/*for (Provincia p : provincias) {
			String nombre = p.getName();
			System.out.println(nombre);
		}*/

		@SuppressWarnings("deprecation")
		JsonElement jelement = new JsonParser().parseString(cadena);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    JsonArray jarray = jobject.getAsJsonArray("facet_groups");
	    jobject = jarray.get(0).getAsJsonObject();
	    jarray = jobject.getAsJsonArray("facets");
	    Iterator it=jarray.iterator();
	    ArrayList<String> provincias=new ArrayList<>();
	    while(it.hasNext()) {
	    	JsonObject provincia=(JsonObject) it.next();
	    	System.out.println(provincia);
	    	provincias.add(provincia.get("name").getAsString());
	    }
	    
	    System.out.println(provincias);
	    /*JsonArray jarray = jobject.getAsJsonArray("facets");
	    jobject = jarray.get(0).getAsJsonObject();
	    String result = jobject.get("translatedText").getAsString();*/
	    
		
	}
}
