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
	
}
