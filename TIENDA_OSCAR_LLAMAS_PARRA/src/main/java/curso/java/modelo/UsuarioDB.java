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
	
	public Usuario buscarUsuarioPorEmail(String email) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				RolDB modeloRol=new RolDB();
				Usuario u=null;
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM usuarios WHERE email=?");
				ps.setString(1, email);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					u=new Usuario(rs.getString(1),modeloRol.obtenerRol(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getString(11));
				}
				
				return u;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean altaUsuario(Usuario u) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO usuarios VALUES (?,1,?,?,?,?,?,?,?,?,?)");
				
				ps.setString(1, u.getEmail());
				ps.setString(2, u.getClave());
				ps.setString(3, u.getNombre());
				ps.setString(4, u.getApellido1());
				ps.setString(5, u.getApellido2());
				ps.setString(6, u.getDireccion());
				ps.setString(7, u.getProvincia());
				ps.setString(8, u.getLocalidad());
				ps.setString(9, u.getTelefono());
				ps.setString(10, u.getDni());
				
				return ps.execute();
				
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
