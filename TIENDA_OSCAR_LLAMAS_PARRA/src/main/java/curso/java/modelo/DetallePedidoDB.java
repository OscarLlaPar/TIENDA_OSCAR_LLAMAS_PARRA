package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import curso.java.util.LogUtil;
import curso.java.util.TipoLog;

public class DetallePedidoDB {
	private static Connection conexion=Conexion.getConexion();
	
	public DetallePedidoDB() {
		Conexion.conectar();
	}
	
	public boolean insertarDetallePedido(DetallePedido dp, int idPedido) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO detalles_pedido (id_pedido, id_producto, precio_unidad, unidades, impuesto, total, estado) VALUES (?,?,?,?,?,?,?)");
					
				ps.setInt(1, idPedido);
				ps.setInt(2, dp.getProducto().getId());
				ps.setFloat(3, dp.getPrecioUnidad());
				ps.setInt(4, dp.getUnidades());
				ps.setFloat(5, dp.getImpuesto());
				ps.setDouble(6, dp.getTotal());
				ps.setString(7, dp.getEstado().toString());
				
				ps.execute();
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public HashMap<Integer, DetallePedido> obtenerDetallesPedido(int idPedido){
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM detalles_pedido WHERE id_pedido = ?");
				HashMap<Integer, DetallePedido> detalles=new HashMap<>();	
				ps.setInt(1, idPedido);
				ProductoDB modeloProducto=new ProductoDB();
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					DetallePedido dp=new DetallePedido(rs.getInt(1), modeloProducto.buscarProductoPorId(rs.getInt(3)),rs.getFloat(4),rs.getInt(5),rs.getFloat(6),rs.getDouble(7),EstadoPedido.valueOf(rs.getString(8)));
					detalles.put(rs.getInt(3),dp);
				}
				
				return detalles;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
	
	public boolean actualizarEstado(DetallePedido dp, EstadoPedido estado) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("UPDATE detalles_pedido SET estado = ? WHERE id = ?");
					
				ps.setString(1, estado.toString());
				ps.setInt(2, dp.getId());
				
				ps.execute();
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public DetallePedido obtenerDetalle(int idDetalle) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM detalles_pedido WHERE id = ?");
				DetallePedido detalle=null;
				ps.setInt(1, idDetalle);
				ProductoDB modeloProducto=new ProductoDB();
				PedidoDB modeloPedido=new PedidoDB();
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					
					detalle=new DetallePedido(rs.getInt(1),modeloPedido.obtenerPedido(rs.getInt(2)),  modeloProducto.buscarProductoPorId(rs.getInt(3)),rs.getFloat(4),rs.getInt(5),rs.getFloat(6),rs.getDouble(7),EstadoPedido.valueOf(rs.getString(8)));
					
				}
				
				return detalle;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
	
	public ArrayList<DetallePedido> buscarDetallesPorEstado(int idPedido, EstadoPedido estado){
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM detalles_pedido WHERE estado = ? AND id_pedido = ?");
				ArrayList<DetallePedido> detalles=new ArrayList<>();	
				ps.setString(1, estado.toString());
				ps.setInt(2, idPedido);
				ProductoDB modeloProducto=new ProductoDB();
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					DetallePedido dp=new DetallePedido(rs.getInt(1), modeloProducto.buscarProductoPorId(rs.getInt(3)),rs.getFloat(4),rs.getInt(5),rs.getFloat(6),rs.getDouble(7),EstadoPedido.valueOf(rs.getString(8)));
					detalles.add(dp);
				}
				
				return detalles;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
	
	public boolean anadirAlCarrito(int idProducto, int idUsuario, int cantidad) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO productos_carritos VALUES (?,?,?)");
					
				ps.setInt(1, idProducto);
				ps.setInt(2, idUsuario);
				ps.setInt(3, cantidad);
				
				ps.execute();
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public boolean actualizarCantidadCarrito(int idProducto, int idUsuario, int cantidad) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("UPDATE productos_carritos SET cantidad=cantidad+? WHERE id_producto=? AND id_usuario=?");
				
				ps.setInt(1, cantidad);
				ps.setInt(2, idProducto);
				ps.setInt(3, idUsuario);
				
				
				ps.execute();
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public boolean eliminarDelCarrito(int idProducto, int idUsuario) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("DELETE FROM productos_carritos WHERE id_producto=? AND id_usuario=?");
					
				ps.setInt(1, idProducto);
				ps.setInt(2, idUsuario);
				
				ps.execute();
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public boolean comprobarCarrito(int idProducto) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT id_producto FROM productos_carritos WHERE id_producto=? AND (SELECT SUM(cantidad) FROM productos_carritos WHERE id_producto=?) > (SELECT stock FROM productos WHERE id=?) ");
					
				ps.setInt(1, idProducto);
				ps.setInt(2, idProducto);
				ps.setInt(3, idProducto);
				
				ResultSet rs=ps.executeQuery();
				
				System.out.println("Operacion hecha");
				
				if(rs.next()) {
					System.out.println("Hay next");
					return false;
				}
				else {
					return true;
				}
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public ArrayList<Integer> obtenerProductosCarritoPorUsuario(int idUsuario){
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT id_producto FROM productos_carritos WHERE id_usuario=?");
				ArrayList<Integer> productos=new ArrayList<>();	
				
				ps.setInt(1, idUsuario);
				
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					productos.add(rs.getInt(1));
					
				}
				
				return productos;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
	
	public HashMap<Integer,DetallePedido> obtenerCarritoUsuario(int idUsuario){
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				ProductoDB modeloProducto=new ProductoDB();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM productos_carritos WHERE id_usuario=?");
				HashMap<Integer,DetallePedido> carrito=new HashMap<Integer,DetallePedido>();	
				
				ps.setInt(1, idUsuario);
				
				
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					Producto p=modeloProducto.buscarProductoPorId(rs.getInt(1));
					DetallePedido dp=new DetallePedido(0, p, (float) p.getPrecio(), rs.getInt(3),p.getImpuesto(),p.getPrecioConImpuesto()*rs.getInt(3),EstadoPedido.PE);
					carrito.put(rs.getInt(1), dp);
					
				}
				
				return carrito;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(DetallePedidoDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
	
}
