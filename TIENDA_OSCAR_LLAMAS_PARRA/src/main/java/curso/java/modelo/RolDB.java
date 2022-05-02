package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

import curso.java.util.LogUtil;
import curso.java.util.TipoLog;

public class RolDB {
	private static Connection conexion=Conexion.getConexion();
	
	public RolDB() {
		Conexion.conectar();
	}
	
	public Rol obtenerRol(int id) {
		try {
			Statement statement=conexion.createStatement();
			Rol rol=null;
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM roles WHERE id =?");
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					rol=new Rol(rs.getInt(1),rs.getString(2));
				}
				return rol;
				
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(RolDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
}
