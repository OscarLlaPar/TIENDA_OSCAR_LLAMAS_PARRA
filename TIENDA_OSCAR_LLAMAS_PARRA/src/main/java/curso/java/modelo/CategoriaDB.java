package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CategoriaDB {
	private static Connection conexion=Conexion.getConexion();
	private static Statement statement;
	
	public CategoriaDB() {
		Conexion.conectar();
	}
	
	public Categoria obtenerCategoria(int id) {
		try {
			Statement statement=conexion.createStatement();
			Categoria categoria=null;
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM categorias WHERE id =?");
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					categoria=new Categoria(rs.getInt(1),rs.getString(2),rs.getString(3));
				}
				return categoria;
				
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
