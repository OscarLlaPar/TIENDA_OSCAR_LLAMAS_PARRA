package curso.java.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	
	static Connection conexion;
	
	public static boolean conectar() {
		try {
			Properties p=new Properties();
			
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			URL appResourceURL = loader.getResource("bd.properties");
			String fichero = appResourceURL.getPath();
			
			p.load(new FileInputStream(new File(fichero)));
			
			Class.forName(p.getProperty("DRIVER"));
			conexion=DriverManager.getConnection(p.getProperty("URL") + p.getProperty("HOST") + "/"+ p.getProperty("DB"), p.getProperty("LOGIN"),"");
			
		} catch(SQLException e) {
			return false;
		} catch (Exception e) {
	    	return false;
	    }
		return true;
	}
	
	public static void desconectar() {
		try {
			conexion.close();
			conexion=null;
		} catch(SQLException e){
			System.out.println("Error al cerrar la conexi�n");
		}
	}
	
	public static Connection getConexion() {
		if (conexion == null) {
	    	conectar();
	    }
	    return conexion;
	}
	
}
