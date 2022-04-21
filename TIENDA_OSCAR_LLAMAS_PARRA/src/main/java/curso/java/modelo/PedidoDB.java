package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class PedidoDB {
	private static Connection conexion=Conexion.getConexion();
	
	public PedidoDB() {
		Conexion.conectar();
	}
	
	public boolean insertarPedido(Pedido pedido) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO pedidos (id,email_usuario,metodo_pago,estado,num_factura,total) VALUES (?,?,?,?,?,?)");
				ps.setInt(1, pedido.getId());
				ps.setString(2, pedido.getUsuario().getEmail());
				ps.setString(3, pedido.getMetodoPago().getMetodoPago());
				ps.setString(4, pedido.getEstado().toString());
				ps.setString(5, pedido.getNumFactura());
				ps.setDouble(6, pedido.getTotal());
				
				if(ps.execute()) {
					DetallePedidoDB modeloDP=new DetallePedidoDB();
					HashMap<Integer,DetallePedido> detallesPedido=pedido.getDetallesPedido();
					for (Map.Entry<Integer, DetallePedido> detalle : detallesPedido.entrySet()) {
						modeloDP.insertarDetallePedido(detalle.getValue());
					}
					return true;
				}
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public boolean actualizarEstado(int id, EstadoPedido estado) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("UPDATE pedidos SET estado=? WHERE id=?");
				ps.setString(1, estado.toString());
				ps.setInt(2, id);
				
				return ps.execute();
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
