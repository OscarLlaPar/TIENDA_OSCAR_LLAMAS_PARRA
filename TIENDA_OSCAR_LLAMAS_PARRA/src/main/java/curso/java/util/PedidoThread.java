package curso.java.util;

import curso.java.modelo.EstadoPedido;
import curso.java.modelo.Pedido;
import curso.java.servicio.PedidoServicio;

public class PedidoThread extends Thread {
	public volatile static int id;
	public volatile static Pedido pedidoEnCurso;
	
	public void run() {
		//Pedido p=PedidoServicio.obtenerPedido(idPedido);
		System.out.println("Hilo corre");
		int idPedido=id;
		System.out.println(idPedido);
		
		try {
			sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Pedido p =PedidoServicio.obtenerPedido(idPedido);
		if(p.getEstado()!=EstadoPedido.PC) {
			System.out.println("Accion!");
			PedidoServicio.actualizarEstado(idPedido, EstadoPedido.E);
			PedidoServicio.asignarNumFactura(idPedido);
		}
		
	}
	
	public static void lanzarPedidoThread(int idPedido) {
			System.out.println("Entra en hilo");
			PedidoThread h1=new PedidoThread();
			id=idPedido;
			h1.setDaemon(true);
			
			h1.start();
	}
	
}
