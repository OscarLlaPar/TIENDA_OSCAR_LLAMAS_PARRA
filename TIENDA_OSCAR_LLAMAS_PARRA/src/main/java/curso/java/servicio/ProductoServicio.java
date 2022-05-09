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
	
	/**
	 * 	Utiliza la clase ProductoDB para consultar los productos buscados en la base de datos
	 * y mostrarlos en el cat�logo. La consulta contiene una b�squeda por nombre, un filtro por categor�a
	 * y una ordenaci�n
	 * 
	 * @param busqueda	Cadena que se busca en el nombre de los productos de la base de datos. Si es "" muestra todos.
	 * @param categoria	ID de la categor�a de los productos que se desea mostrar en el cat�logo. Si es 0 muestra todas las categor�as.
	 * @param orden		0 para el orden por defecto, 1 para ordenarlos por m�s baratos, 2 para ordenaros por mejor valoraci�n.
	 * @return			LinkedHashMap que contiene los objetos Producto que se mostrar�n en el cat�logo.
	 */
	
	public static LinkedHashMap<Integer, Producto> mostrarCatalogo(String busqueda, int categoria, int orden){
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.mostrarCatalogo(busqueda, categoria,orden);
	}
	
	/**
	 * Utiiza la clase ProductoDB para recuperar de la base de datos un objetoProducto
	 * con la ID especificada.
	 * 
	 * @param id	ID del producto que se desea buscar.
	 * @return		Objeto Producto que tenga el ID introducido. Devuelve null si no hay ninguno.
	 */
	
	public static Producto obtenerProducto(int id) {
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.buscarProductoPorId(id);
	}
	
	/**
	 * Devuelve todos los productos existentes en la base dedatos
	 * mediante la clase ProductoDB.
	 * 
	 * @return	Una colecci�n LinkedHashMap con los objetos Producto resultantes.
	 */
	
	public static LinkedHashMap<Integer, Producto> mostrarTodosLosProductos(){
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.mostrarTodosLosProductos();
	}
	
	
	
	/**
	 * Devuelve todas las categor�as de producto existentes en la tabla "categorias"
	 * de la base de datos.
	 * Utiliza la clase CategoriaDB para realizar la consulta.
	 * 
	 * @return	Un HashSet de objetos Categoria con las categor�as de producto de la base de datos.
	 */
	
	public static HashSet<Categoria> mostrarTodasLasCategorias(){
		CategoriaDB modeloCategoria=new CategoriaDB();
		return modeloCategoria.mostrarTodasLasCategorias();
	}
	
	public static boolean actualizarStock(int idProducto, int stock) {
		ProductoDB modeloProducto=new ProductoDB();
		return modeloProducto.actualizarStock(idProducto, stock);
	}
	
	
}
