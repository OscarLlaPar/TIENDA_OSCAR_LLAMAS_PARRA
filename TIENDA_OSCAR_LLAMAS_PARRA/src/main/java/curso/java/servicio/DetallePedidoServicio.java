package curso.java.servicio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.DetallePedidoDB;
import curso.java.modelo.EstadoPedido;
import curso.java.modelo.Producto;

public class DetallePedidoServicio {
	/**
	 * A�ade un n�mero de unidades de un determinado producto al carrito
	 * especificado. El carrito es una colecci�n de objetos DetallePedido.
	 * Si el producto ya existe en el carrito, suma su cantidad y actualiza su precio total.
	 * 
	 * @param carrito	El carrito que contiene los productos que ha a�adido o puede a�adir el usuario.
	 * @param p			El producto que se desea a�adir al carrito.
	 * @param cantidad	Cu�ntos productos se desean a�adir al carrito.
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
			dp=new DetallePedido(0, p, (float)p.getPrecio(),cantidad,p.getImpuesto(),p.getPrecioConImpuesto()*cantidad, EstadoPedido.PE);
			carrito.put(p.getId(), dp);
		}
	}
	
	/**
	 * Resta del carrito el n�mero de unidades pasado por par�metro del producto
	 * especificado y actualiza su precio total.
	 * Si el n�mero e unidades llega a 0, se elimina del carrito.
	 * 
	 * @param carrito		El carrito que contiene los productos que ha a�adido el usuario
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
	
	public static DetallePedido obtenerDetalle(int idDetalle) {
		DetallePedidoDB modeloDetalle=new DetallePedidoDB();
		return modeloDetalle.obtenerDetalle(idDetalle);
	}
	
	public static boolean actualizarEstado(DetallePedido dp, EstadoPedido estado) {
		DetallePedidoDB modeloDetalle=new DetallePedidoDB();
		return modeloDetalle.actualizarEstado(dp, estado);
	}
	
	public static ArrayList<DetallePedido> buscarDetallesPorEstado(int idPedido, EstadoPedido estado){
		DetallePedidoDB modeloDetalle=new DetallePedidoDB();
		return modeloDetalle.buscarDetallesPorEstado(idPedido, estado);
	}
	
	
}
