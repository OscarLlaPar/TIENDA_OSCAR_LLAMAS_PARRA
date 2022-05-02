package curso.java.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonUtil {
	public static String leerUrl(String sUrl) {
		String output = "";
		try {
			URL url = new URL(sUrl);

			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			// conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			
			StringBuilder sb = new StringBuilder();
			int cp;
			while ((cp = br.read()) != -1) {
				sb.append((char) cp);
			}
			
			output = sb.toString();
			// System.out.println(output);

			conn.disconnect();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return output;
	}
	
	@SuppressWarnings("deprecation")
	public static ArrayList<String> obtenerProvincias(){
		String cadena=leerUrl("https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&sort=provincia&facet=provincia");
		JsonElement jelement = new JsonParser().parseString(cadena);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    JsonArray jarray = jobject.getAsJsonArray("facet_groups");
	    jobject = jarray.get(0).getAsJsonObject();
	    jarray = jobject.getAsJsonArray("facets");
	    Iterator it=jarray.iterator();
	    ArrayList<String> provincias=new ArrayList<>();
	    while(it.hasNext()) {
	    	JsonObject provincia=(JsonObject) it.next();
	    	provincias.add(provincia.get("name").getAsString());
	    }
	    return provincias;
	}
	
}
