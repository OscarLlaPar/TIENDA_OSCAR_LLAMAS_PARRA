package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DetallePedidoDB {
	private static Connection conexion=Conexion.getConexion();
	
	public DetallePedidoDB() {
		Conexion.conectar();
	}
	
	public boolean insertarDetallePedido(DetallePedido dp) {
		try {
			Statement statement=conexion.createStatement();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO detalles_pedido (id_pedido, id_producto, precio_unidad, unidades, impuesto, total) VALUES (?,?,?,?,?,?)");
				
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
}
