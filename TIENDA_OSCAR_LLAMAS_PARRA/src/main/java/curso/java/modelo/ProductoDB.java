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
	
	public HashMap<Integer, Producto> mostrarCatalogo(String busqueda, int categoria){
		String busquedaCategoria;
		if(categoria==0) {
			busquedaCategoria="";
		}
		else {
			busquedaCategoria=" AND id_categoria="+categoria;
		}
		
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				CategoriaDB modeloCategoria=new CategoriaDB();
				ProveedorDB modeloProveedor=new ProveedorDB();
				HashMap<Integer, Producto> catalogo=new HashMap<>();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM productos WHERE fecha_baja IS NULL AND nombre LIKE CONCAT('%',?,'%')"+busquedaCategoria);
				ps.setString(1,busqueda);;
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					catalogo.put(rs.getInt(1), new Producto(rs.getInt(1),modeloCategoria.obtenerCategoria(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getTimestamp(7),rs.getTimestamp(8),rs.getFloat(9),rs.getString(10),rs.getString(11),modeloProveedor.obtenerProveedor(rs.getInt(12)) ));
				}
				
				
				return catalogo;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public HashMap<Integer, Producto> mostrarTodosLosProductos(){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				CategoriaDB modeloCategoria=new CategoriaDB();
				ProveedorDB modeloProveedor=new ProveedorDB();
				HashMap<Integer, Producto> catalogo=new HashMap<>();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM productos");
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					catalogo.put(rs.getInt(1), new Producto(rs.getInt(1),modeloCategoria.obtenerCategoria(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getTimestamp(7),rs.getTimestamp(8),rs.getFloat(9),rs.getString(10),rs.getString(11),modeloProveedor.obtenerProveedor(rs.getInt(12))));
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
				ProveedorDB modeloProveedor=new ProveedorDB();
				Producto p=null;
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM productos WHERE id=?");
				ps.setInt(1, id);
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					p=new Producto(rs.getInt(1), modeloCategoria.obtenerCategoria(rs.getInt(2)),rs.getString(3),rs.getString(4),rs.getDouble(5),rs.getInt(6),rs.getTimestamp(7),rs.getTimestamp(8),rs.getFloat(9),rs.getString(10),rs.getString(11),modeloProveedor.obtenerProveedor(rs.getInt(12)));
				}
				
				return p;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean bajaProducto(int id) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				CategoriaDB modeloCategoria=new CategoriaDB();
				Producto p=null;
				PreparedStatement ps = conexion.prepareStatement("UPDATE productos SET fecha_baja=CURRENT_TIMESTAMP() WHERE id=?");
				ps.setInt(1, id);
				
				ps.execute();
				
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean editarProducto(int id, String nombre, String descripcion, int stock, double precio, float impuesto) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				CategoriaDB modeloCategoria=new CategoriaDB();
				Producto p=null;
				PreparedStatement ps = conexion.prepareStatement("UPDATE productos SET nombre=?, descripcion=?, stock=?, precio=?, impuesto=? WHERE id=?");
				ps.setString(1, nombre);
				ps.setString(2, descripcion);
				ps.setInt(3, stock);
				ps.setDouble(4, precio);
				ps.setFloat(5, impuesto);
				ps.setInt(6, id);
				
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
