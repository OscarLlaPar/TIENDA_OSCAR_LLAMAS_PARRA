package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UsuarioDB {
private static Connection conexion=Conexion.getConexion();
	
	public UsuarioDB() {
		Conexion.conectar();
	}
	
	public Usuario buscarUsuarioPorId(int id) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				RolDB modeloRol=new RolDB();
				Usuario u=null;
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					u=new Usuario(rs.getInt(1),modeloRol.obtenerRol(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11),rs.getString(12));
				}
				
				return u;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
