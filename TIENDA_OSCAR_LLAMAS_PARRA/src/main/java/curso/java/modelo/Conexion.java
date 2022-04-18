package curso.java.modelo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexion {
	static String bd = "tienda";
	static String login = "root";
	static String password = "";
	static String host = "127.0.0.1"; //localhost
	static String url = "jdbc:mysql://";
	static Connection conexion;
	
	public static boolean conectar() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conexion=DriverManager.getConnection(url + host + "/"+ bd, login, password);
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
			System.out.println("Error al cerrar la conexión");
		}
	}
	
	public static Connection getConexion() {
		if (conexion == null) {
	    	conectar();
	    }
	    return conexion;
	}
	
}
