package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProveedorDB {
private static Connection conexion=Conexion.getConexion();
	
	public ProveedorDB() {
		Conexion.conectar();
	}
	
	public Proveedor obtenerProveedor(int id) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				
				Proveedor p=null;
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM proveedores WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					p=new Proveedor(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8));
				}
				
				return p;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
}