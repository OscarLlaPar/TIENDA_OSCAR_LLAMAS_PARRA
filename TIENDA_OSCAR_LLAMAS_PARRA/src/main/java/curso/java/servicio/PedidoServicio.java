package curso.java.servicio;

import java.util.HashSet;

import curso.java.modelo.Pedido;
import curso.java.modelo.PedidoDB;

public class PedidoServicio {
	public static HashSet<Pedido> obtenerPedidos(String email){
		PedidoDB modeloPedido=new PedidoDB();
		return modeloPedido.mostrarPedidos(email);
	}
	
	public static Pedido obtenerPedido(int id) {
		PedidoDB modeloPedido=new PedidoDB();
		return modeloPedido.obtenerPedido(id);
	}
}
