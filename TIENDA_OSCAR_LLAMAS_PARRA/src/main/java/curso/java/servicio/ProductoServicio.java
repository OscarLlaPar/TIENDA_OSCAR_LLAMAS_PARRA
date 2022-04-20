package curso.java.servicio;

import java.util.HashMap;
import java.util.Map;

import curso.java.modelo.Producto;

public class ProductoServicio {
	public static void anadirAlCarrito(HashMap<Integer,Producto> carrito, Producto p, int clave, int cantidad) {
		double precioUd=p.getPrecio();
		if(carrito.get(clave)!=null) {
			p=carrito.get(clave);
			p.setStock(p.getStock()+cantidad);
			p.setPrecio(precioUd*p.getStock());
			carrito.replace(clave,p);
		}
		else {
			carrito.put(clave, p);
			p.setStock(cantidad);
			p.setPrecio(precioUd*p.getStock());
		}
	}
	
	public static void eliminarDelCarrito(HashMap<Integer, Producto> carrito, Producto p, int clave, int cantidad) {
		double precioUd=p.getPrecio()/p.getStock();
		p.setStock(p.getStock()-cantidad);
		p.setPrecio(precioUd*p.getStock());
		carrito.replace(clave, p);
		if(p.getStock()<=0) {
			carrito.remove(clave);
		}
	}
	
	public static double totalCarrito(HashMap<Integer, Producto> carrito) {
		double total=0;
		for (Map.Entry<Integer, Producto> producto : carrito.entrySet()) {
			total+=producto.getValue().getPrecio();
		}
		return total;
	}
	
}
