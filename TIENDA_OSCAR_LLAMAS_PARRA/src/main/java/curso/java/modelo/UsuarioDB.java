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
				
				ps.execute();
				
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean editarUsuario(Usuario usuarioActual, Usuario usuarioNuevo) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("UPDATE usuarios SET email = ?, nombre = ?, apellido1 = ?, apellido2 = ?, direccion = ?, provincia = ?, localidad = ?, telefono = ?, dni = ? WHERE email = ?");
				ps.setString(1, usuarioNuevo.getEmail());
				ps.setString(2, usuarioNuevo.getNombre());
				ps.setString(3, usuarioNuevo.getApellido1());
				ps.setString(4, usuarioNuevo.getApellido2());
				ps.setString(5, usuarioNuevo.getDireccion());
				ps.setString(6, usuarioNuevo.getProvincia());
				ps.setString(7, usuarioNuevo.getLocalidad());
				ps.setString(8, usuarioNuevo.getTelefono());
				ps.setString(9, usuarioNuevo.getDni());
				ps.setString(10, usuarioActual.getEmail());
				
				ps.execute();
				
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean cambiarPassword(String email, String password) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("UPDATE usuarios SET clave = ? WHERE email = ?");
				ps.setString(1, password);
				ps.setString(2, email);
				
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
