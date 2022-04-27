package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
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
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO pedidos (id,email_usuario,metodo_pago,estado,total) VALUES (?,?,?,?,?)");
				int idPedido=contarPedidos()+1;
				ps.setInt(1, idPedido);
				ps.setString(2, pedido.getUsuario().getEmail());
				ps.setString(3, pedido.getMetodoPago().getMetodoPago());
				ps.setString(4, pedido.getEstado().toString());
				ps.setDouble(5, pedido.getTotal());
				
				ps.execute();
				
				DetallePedidoDB modeloDP=new DetallePedidoDB();
				HashMap<Integer,DetallePedido> detallesPedido=pedido.getDetallesPedido();
				for (Map.Entry<Integer, DetallePedido> detalle : detallesPedido.entrySet()) {
					System.out.println(detalle.getValue().toString());
					modeloDP.insertarDetallePedido(detalle.getValue(), idPedido);
				}
				return true;
				
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public int contarPedidos() {
		try {
			Statement statement=conexion.createStatement();
			int numPedidos=-1;
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT COUNT(*) AS num FROM pedidos");
				
				ResultSet rs=ps.executeQuery();
				
				if(rs.next()) {
					numPedidos=rs.getInt("num");
				}
				
			}
			
			return numPedidos;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return -1;
		}
	}
	
	public boolean actualizarEstado(int id, EstadoPedido estado) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("UPDATE pedidos SET estado=? WHERE id=?");
				ps.setString(1, estado.toString());
				ps.setInt(2, id);
				
				ps.execute();
				
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
	public HashSet<Pedido> mostrarPedidos(String emailUsuario){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				UsuarioDB modeloUsuario=new UsuarioDB();
				MetodoPagoDB modeloMP=new MetodoPagoDB();
				DetallePedidoDB modeloDP=new DetallePedidoDB();
				HashSet<Pedido> pedidos=new HashSet<>();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM pedidos WHERE email_usuario = ?");
				ps.setString(1, emailUsuario);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					Pedido p=new Pedido(rs.getInt(1),modeloUsuario.buscarUsuarioPorEmail(rs.getString(2)),rs.getTimestamp(3),modeloMP.obtenerMetodoPago(rs.getString(4)),EstadoPedido.valueOf(rs.getString(5)),rs.getString(6),rs.getDouble(7));
					p.setDetallesPedido(modeloDP.obtenerDetallesPedido(rs.getInt(1)));
					pedidos.add(p);
				}
				
				
				return pedidos;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public HashSet<Pedido> mostrarPedidos(EstadoPedido estado){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				UsuarioDB modeloUsuario=new UsuarioDB();
				MetodoPagoDB modeloMP=new MetodoPagoDB();
				DetallePedidoDB modeloDP=new DetallePedidoDB();
				HashSet<Pedido> pedidos=new HashSet<>();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM pedidos WHERE estado = ?");
				ps.setString(1, estado.name());
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					Pedido p=new Pedido(rs.getInt(1),modeloUsuario.buscarUsuarioPorEmail(rs.getString(2)),rs.getTimestamp(3),modeloMP.obtenerMetodoPago(rs.getString(4)),EstadoPedido.valueOf(rs.getString(5)),rs.getString(6),rs.getDouble(7));
					p.setDetallesPedido(modeloDP.obtenerDetallesPedido(rs.getInt(1)));
					pedidos.add(p);
				}
				
				
				return pedidos;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public Pedido obtenerPedido(int id) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				UsuarioDB modeloUsuario=new UsuarioDB();
				MetodoPagoDB modeloMP=new MetodoPagoDB();
				DetallePedidoDB modeloDP=new DetallePedidoDB();
				Pedido p=null;
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM pedidos WHERE id = ?");
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					p=new Pedido(rs.getInt(1),modeloUsuario.buscarUsuarioPorEmail(rs.getString(2)),rs.getTimestamp(3),modeloMP.obtenerMetodoPago(rs.getString(4)),EstadoPedido.valueOf(rs.getString(5)),rs.getString(6),rs.getDouble(7));
					p.setDetallesPedido(modeloDP.obtenerDetallesPedido(rs.getInt(1)));
				}
				
				
				return p;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public boolean asignarNumFactura(int id) {
		try {
			Statement statement=conexion.createStatement();
			
			
			if(conexion!=null) {
				ConfiguracionDB modeloConf=new ConfiguracionDB();
				Configuracion conf=modeloConf.obtenerConfiguracion("numFacturas");
				String anyoActual=String.valueOf(LocalDate.now().getYear());
				
				PreparedStatement ps = conexion.prepareStatement("UPDATE pedidos SET num_factura=? WHERE id=?");
				
				ps.setString(1, anyoActual+conf.getValor());
				ps.setInt(2, id);
				
				ps.execute();
				
				modeloConf.actualizarNumFacturas();
				
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	
}
