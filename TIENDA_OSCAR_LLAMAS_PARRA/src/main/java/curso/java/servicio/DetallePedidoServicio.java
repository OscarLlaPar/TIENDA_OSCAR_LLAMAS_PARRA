package curso.java.servicio;

import java.util.HashMap;
import java.util.Map;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.Producto;

public class DetallePedidoServicio {
	/**
	 * Añade un número de unidades de un determinado producto al carrito
	 * especificado. El carrito es una colección de objetos DetallePedido.
	 * Si el producto ya existe en el carrito, suma su cantidad y actualiza su precio total.
	 * 
	 * @param carrito	El carrito que contiene los productos que ha añadido o puede añadir el usuario.
	 * @param p			El producto que se desea añadir al carrito.
	 * @param cantidad	Cuántos productos se desean añadir al carrito.
	 */
	
	public static void anadirAlCarrito(HashMap<Integer,DetallePedido> carrito, Producto p, int cantidad) {
		DetallePedido dp;
		if(carrito.get(p.getId())!=null) {
			dp=carrito.get(p.getId());
			dp.setUnidades(dp.getUnidades() + cantidad);
			dp.setTotal(p.getPrecioConImpuesto()*dp.getUnidades());
			carrito.replace(p.getId(), dp);
		}
		else {
			dp=new DetallePedido(p, (float)p.getPrecio(),cantidad,p.getImpuesto(),p.getPrecioConImpuesto()*cantidad);
			carrito.put(p.getId(), dp);
		}
	}
	
	/**
	 * Resta del carrito el número de unidades pasado por parámetro del producto
	 * especificado y actualiza su precio total.
	 * Si el número e unidades llega a 0, se elimina del carrito.
	 * 
	 * @param carrito		El carrito que contiene los productos que ha añadido el usuario
	 * @param idProducto	El id del producto que se desea eliminar del carrito	
	 * @param cantidad		La cantidad de productos que se desean eliminar del carrito
	 */
	
	public static void eliminarDelCarrito(HashMap<Integer, DetallePedido> carrito, int idProducto, int cantidad) {
		DetallePedido dp=carrito.get(idProducto);
		Producto p = ProductoServicio.obtenerProducto(idProducto);
		dp.setUnidades(dp.getUnidades() - cantidad);
		dp.setTotal(p.getPrecioConImpuesto()*dp.getUnidades());
		carrito.replace(idProducto, dp);
		if(dp.getUnidades()<=0) {
			carrito.remove(idProducto);
		}
	}
	
	/**
	 * Recibe un carrito que tiene almacenados objetos DetallePedido y lo recorre calculando
	 * la suma de sus precios totales.
	 * 
	 * @param carrito	El carrito cuyo total se quiere calcular.
	 * @return			El total en euros del contenido del carrito.
	 */
	
	public static double totalCarrito(HashMap<Integer, DetallePedido> carrito) {
		double total=0;
		for (Map.Entry<Integer, DetallePedido> dp : carrito.entrySet()) {
			total+=dp.getValue().getTotal();
		}
		return total;
	}
}
