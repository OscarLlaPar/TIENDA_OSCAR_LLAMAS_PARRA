package curso.java.servicio;

import java.util.HashMap;
import java.util.Map;

import curso.java.modelo.Producto;
import curso.java.modelo.ProductoDB;

public class ProductoServicio {
	public static Producto obtenerProducto(int id) {
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.buscarProductoPorId(id);
	}
	
	public static HashMap<Integer, Producto> mostrarTodosLosProductos(){
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.mostrarTodosLosProductos();
	}
	
	public static boolean bajaProducto(int id) {
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.bajaProducto(id);
	}
	
	public static boolean editarProducto(int id, String nombre, String descripcion, int stock, double precio, float impuesto) {
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.editarProducto(id, nombre, descripcion, stock, precio, impuesto);
	}
	
}
