package curso.java.servicio;

import java.util.HashSet;
import java.util.LinkedHashSet;

import curso.java.modelo.EstadoPedido;
import curso.java.modelo.MetodoPago;
import curso.java.modelo.MetodoPagoDB;
import curso.java.modelo.Pedido;
import curso.java.modelo.PedidoDB;

public class PedidoServicio {
	public static LinkedHashSet<Pedido> obtenerPedidos(int idUsuario){
		PedidoDB modeloPedido=new PedidoDB();
		return modeloPedido.mostrarPedidos(idUsuario);
	}
	
	public static LinkedHashSet<Pedido> obtenerPedidos(EstadoPedido estado){
		PedidoDB modeloPedido=new PedidoDB();
		return modeloPedido.mostrarPedidos(estado);
	}
	
	
	public static Pedido obtenerPedido(int id) {
		PedidoDB modeloPedido=new PedidoDB();
		return modeloPedido.obtenerPedido(id);
	}
	
	public static boolean actualizarEstado(int id, EstadoPedido estado) {
		PedidoDB modeloPedido=new PedidoDB();
		return modeloPedido.actualizarEstado(id, estado);
	}
	
	public static boolean asignarNumFactura(int id) {
		PedidoDB modeloPedido=new PedidoDB();
		return modeloPedido.asignarNumFactura(id);
	}
	
	public static MetodoPago obtenerMetodoPago(int id) {
		MetodoPagoDB modeloMP = new MetodoPagoDB();
		return modeloMP.obtenerMetodoPago(id);
	}
	
	public static void insertarPedido(Pedido pedido) {
		PedidoDB modeloPedido=new PedidoDB();
		modeloPedido.insertarPedido(pedido);
	}
	
}
