package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MetodoPagoDB {
	private static Connection conexion=Conexion.getConexion();
	
	public MetodoPagoDB() {
		Conexion.conectar();
	}
	
	public MetodoPago obtenerMetodoPago(int id) {
		try {
			Statement statement=conexion.createStatement();
			MetodoPago metodoPago=null;
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM metodos_pago WHERE id =?");
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					metodoPago=new MetodoPago(rs.getInt(1),rs.getString(2));
				}
				return metodoPago;
				
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
