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
import java.util.LinkedHashSet;
import java.util.Map;

import curso.java.util.LogUtil;
import curso.java.util.PedidoThread;
import curso.java.util.TipoLog;

public class PedidoDB {
	private static Connection conexion=Conexion.getConexion();
	
	
	
	public PedidoDB() {
		Conexion.conectar();
	}
	
	public boolean insertarPedido(Pedido pedido) {
		String[] queryDescuento={"",""};
		if(pedido.getDescuento()!=null) {
			queryDescuento[0]=",id_descuento";
			queryDescuento[1]=",?";
		}
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO pedidos (id,id_usuario,metodo_pago,estado,total"+queryDescuento[0]+") VALUES (?,?,?,?,?"+queryDescuento[1]+")");
				int idPedido=contarPedidos()+1;
				ps.setInt(1, idPedido);
				ps.setInt(2, pedido.getUsuario().getId());
				ps.setString(3, pedido.getMetodoPago().getMetodoPago());
				ps.setString(4, pedido.getEstado().toString());
				ps.setDouble(5, pedido.getTotal());
				if(pedido.getDescuento()!=null) {
					ps.setInt(6, pedido.getDescuento().getId());
				}
				
				
				ps.execute();
				
				DetallePedidoDB modeloDP=new DetallePedidoDB();
				HashMap<Integer,DetallePedido> detallesPedido=pedido.getDetallesPedido();
				for (Map.Entry<Integer, DetallePedido> detalle : detallesPedido.entrySet()) {
					System.out.println(detalle.getValue().toString());
					modeloDP.insertarDetallePedido(detalle.getValue(), idPedido);
				}
				
				PedidoThread.lanzarPedidoThread(idPedido);
				
				return true;
				
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(PedidoDB.class, TipoLog.ERROR, e.getMessage());
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
			LogUtil.registrarInfo(PedidoDB.class, TipoLog.ERROR, e.getMessage());
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
				
				
				Pedido pedido=obtenerPedido(id);
				DetallePedidoDB modeloDP=new DetallePedidoDB();
				HashMap<Integer,DetallePedido> detallesPedido=pedido.getDetallesPedido();
				for (Map.Entry<Integer, DetallePedido> detalle : detallesPedido.entrySet()) {
					System.out.println(detalle.getValue().toString());
					if(estado.equals(EstadoPedido.E) && detalle.getValue().getEstado().equals(EstadoPedido.PE)){
						modeloDP.actualizarEstado(detalle.getValue(), estado);
					}
					
				}
				
				
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(PedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public LinkedHashSet<Pedido> mostrarPedidos(int idUsuario){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				UsuarioDB modeloUsuario=new UsuarioDB();
				MetodoPagoDB modeloMP=new MetodoPagoDB();
				DetallePedidoDB modeloDP=new DetallePedidoDB();
				DescuentoDB modeloDescuento=new DescuentoDB();
				LinkedHashSet<Pedido> pedidos=new LinkedHashSet<>();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM pedidos WHERE id_usuario = ? ORDER BY fecha DESC");
				ps.setInt(1, idUsuario);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					Pedido p=new Pedido(rs.getInt(1),modeloUsuario.buscarUsuarioPorEmail(rs.getString(2)),rs.getTimestamp(3),modeloMP.obtenerMetodoPago(rs.getString(4)),EstadoPedido.valueOf(rs.getString(5)),rs.getString(6),rs.getDouble(7),modeloDescuento.obtenerPorId(rs.getInt(8)));
					p.setDetallesPedido(modeloDP.obtenerDetallesPedido(rs.getInt(1)));
					pedidos.add(p);
				}
				
				
				return pedidos;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(PedidoDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
	
	public LinkedHashSet<Pedido> mostrarPedidos(EstadoPedido estado){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				UsuarioDB modeloUsuario=new UsuarioDB();
				MetodoPagoDB modeloMP=new MetodoPagoDB();
				DetallePedidoDB modeloDP=new DetallePedidoDB();
				DescuentoDB modeloDescuento=new DescuentoDB();
				LinkedHashSet<Pedido> pedidos=new LinkedHashSet<>();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM pedidos WHERE estado = ?");
				ps.setString(1, estado.name());
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					Pedido p=new Pedido(rs.getInt(1),modeloUsuario.buscarUsuarioPorEmail(rs.getString(2)),rs.getTimestamp(3),modeloMP.obtenerMetodoPago(rs.getString(4)),EstadoPedido.valueOf(rs.getString(5)),rs.getString(6),rs.getDouble(7), modeloDescuento.obtenerPorId(rs.getInt(8)));
					p.setDetallesPedido(modeloDP.obtenerDetallesPedido(rs.getInt(1)));
					pedidos.add(p);
				}
				
				
				return pedidos;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(PedidoDB.class, TipoLog.ERROR, e.getMessage());
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
				DescuentoDB modeloDescuento=new DescuentoDB();
				Pedido p=null;
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM pedidos WHERE id = ?");
				ps.setInt(1, id);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					p=new Pedido(rs.getInt(1),modeloUsuario.buscarUsuarioPorEmail(rs.getString(2)),rs.getTimestamp(3),modeloMP.obtenerMetodoPago(rs.getString(4)),EstadoPedido.valueOf(rs.getString(5)),rs.getString(6),rs.getDouble(7), modeloDescuento.obtenerPorId(rs.getInt(8)));
					p.setDetallesPedido(modeloDP.obtenerDetallesPedido(rs.getInt(1)));
				}
				
				
				return p;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(PedidoDB.class, TipoLog.ERROR, e.getMessage());
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
			LogUtil.registrarInfo(PedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public boolean actualizarTotal(int id, double total) {
		try {
			Statement statement=conexion.createStatement();
			
			
			if(conexion!=null) {
				ConfiguracionDB modeloConf=new ConfiguracionDB();
				Configuracion conf=modeloConf.obtenerConfiguracion("numFacturas");
				String anyoActual=String.valueOf(LocalDate.now().getYear());
				
				PreparedStatement ps = conexion.prepareStatement("UPDATE pedidos SET total=? WHERE id=?");
				
				ps.setDouble(1, total);
				ps.setInt(2, id);
				
				ps.execute();
				
				modeloConf.actualizarNumFacturas();
				
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(PedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
}
