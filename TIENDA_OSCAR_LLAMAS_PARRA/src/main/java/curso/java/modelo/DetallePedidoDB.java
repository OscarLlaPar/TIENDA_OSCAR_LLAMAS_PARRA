package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class DetallePedidoDB {
	private static Connection conexion=Conexion.getConexion();
	
	public DetallePedidoDB() {
		Conexion.conectar();
	}
	
	public boolean insertarDetallePedido(DetallePedido dp, int idPedido) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO detalles_pedido (id_pedido, id_producto, precio_unidad, unidades, impuesto, total) VALUES (?,?,?,?,?,?)");
					
				ps.setInt(1, idPedido);
				ps.setInt(2, dp.getProducto().getId());
				ps.setFloat(3, dp.getPrecioUnidad());
				ps.setInt(4, dp.getUnidades());
				ps.setFloat(5, dp.getImpuesto());
				ps.setDouble(6, dp.getTotal());
				
				ps.execute();
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
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
					
					DetallePedido dp=new DetallePedido(modeloProducto.buscarProductoPorId(rs.getInt(3)),rs.getFloat(4),rs.getInt(5),rs.getFloat(6),rs.getDouble(7));
					detalles.put(rs.getInt(3),dp);
				}
				
				return detalles;
			}
			
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
