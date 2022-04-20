package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class ProductoDB {
	private static Connection conexion=Conexion.getConexion();
	
	public ProductoDB() {
		Conexion.conectar();
	}
	
	public HashMap<Integer, Producto> mostrarCatalogo(){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				CategoriaDB modeloCategoria=new CategoriaDB();
				HashMap<Integer, Producto> catalogo=new HashMap<>();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM productos");
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					catalogo.put(rs.getInt(1), new Producto(rs.getInt(1),modeloCategoria.obtenerCategoria(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getTimestamp(7),rs.getTimestamp(8),rs.getFloat(9),rs.getString(10)));
				}
				
				
				return catalogo;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Producto buscarProductoPorId(int id) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				CategoriaDB modeloCategoria=new CategoriaDB();
				Producto p=null;
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM productos WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					p=new Producto(rs.getInt(1), modeloCategoria.obtenerCategoria(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getTimestamp(7),rs.getTimestamp(8),rs.getFloat(9),rs.getString(10));
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
