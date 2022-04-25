package curso.java.servicio;

import java.util.HashMap;
import java.util.Map;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.Producto;

public class DetallePedidoServicio {
	public static void anadirAlCarrito(HashMap<Integer,DetallePedido> carrito, Producto p, int cantidad) {
		DetallePedido dp;
		if(carrito.get(p.getId())!=null) {
			dp=carrito.get(p.getId());
			dp.setUnidades(dp.getUnidades() + cantidad);
			dp.setTotal(dp.getPrecioUnidad()*dp.getUnidades());
			carrito.replace(p.getId(), dp);
		}
		else {
			dp=new DetallePedido(p, (float)p.getPrecio(),cantidad,p.getImpuesto(),p.getPrecio()*cantidad);
			carrito.put(p.getId(), dp);
		}
	}
	
	public static void eliminarDelCarrito(HashMap<Integer, DetallePedido> carrito, int idProducto, int cantidad) {
		DetallePedido dp=carrito.get(idProducto);
		dp.setUnidades(dp.getUnidades() - cantidad);
		dp.setTotal(dp.getPrecioUnidad()*dp.getUnidades());
		carrito.replace(idProducto, dp);
		if(dp.getUnidades()<=0) {
			carrito.remove(idProducto);
		}
	}
	
	public static double totalCarrito(HashMap<Integer, DetallePedido> carrito) {
		double total=0;
		for (Map.Entry<Integer, DetallePedido> dp : carrito.entrySet()) {
			total+=dp.getValue().getTotal();
		}
		return total;
	}
}
