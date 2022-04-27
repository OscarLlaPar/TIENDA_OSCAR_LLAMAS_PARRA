package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConfiguracionDB {
private static Connection conexion=Conexion.getConexion();
	
	public ConfiguracionDB() {
		Conexion.conectar();
	}
	
	public Configuracion obtenerConfiguracion(String clave) {
		try {
			Statement statement=conexion.createStatement();
			Configuracion conf=null;
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM configuracion WHERE clave =?");
				ps.setString(1, clave);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					conf=new Configuracion(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4));
				}
				return conf;
				
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean actualizarNumFacturas() {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				int nuevoValor=Integer.parseInt(obtenerConfiguracion("numFacturas").getValor())+1;
				PreparedStatement ps = conexion.prepareStatement("UPDATE configuracion SET valor = ? WHERE clave ='numFacturas'");
				ps.setString(1, String.valueOf(nuevoValor));
				
				ps.execute();
				return true;
				
			}
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
