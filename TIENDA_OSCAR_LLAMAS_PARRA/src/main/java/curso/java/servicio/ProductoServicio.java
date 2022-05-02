package curso.java.servicio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;

import curso.java.modelo.Categoria;
import curso.java.modelo.CategoriaDB;
import curso.java.modelo.Producto;
import curso.java.modelo.ProductoDB;

public class ProductoServicio {
	
	public static LinkedHashMap<Integer, Producto> mostrarCatalogo(String busqueda, int categoria, int orden){
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.mostrarCatalogo(busqueda, categoria,orden);
	}
	
	public static Producto obtenerProducto(int id) {
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.buscarProductoPorId(id);
	}
	
	public static LinkedHashMap<Integer, Producto> mostrarTodosLosProductos(){
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
	
	public static HashSet<Categoria> mostrarTodasLasCategorias(){
		CategoriaDB modeloCategoria=new CategoriaDB();
		return modeloCategoria.mostrarTodasLasCategorias();
	}
}
