package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.HashSet;

import curso.java.util.LogUtil;
import curso.java.util.TipoLog;

public class ValoracionDB {
	private static Connection conexion=Conexion.getConexion();
	
	public ValoracionDB() {
		Conexion.conectar();
	}
	
	public boolean insertarValoracion(Valoracion v) {
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("INSERT INTO valoraciones (id_producto, id_usuario, valoracion, comentario) VALUES (?,?,?,?)");
				
				ps.setInt(1, v.getProducto().getId());
				ps.setInt(2, v.getUsuario().getId());
				ps.setInt(3, v.getValoracion());
				ps.setString(4, v.getComentario());
				
				ps.execute();
				
				return true;
			}
			
			return false;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(ValoracionDB.class, TipoLog.ERROR, e.getMessage());
			return false;
		}
	}
	
	public HashSet<Valoracion> obtenerValoracionesProducto(int idProducto){
		try {
			Statement statement=conexion.createStatement();
			
			if(conexion!=null) {
				ProductoDB modeloProducto=new ProductoDB();
				UsuarioDB modeloUsuario=new UsuarioDB();
				HashSet<Valoracion> valoraciones=new HashSet<>();
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM valoraciones WHERE id_producto = ?");
				ps.setInt(1, idProducto);
				
				ResultSet rs=ps.executeQuery();
				
				while(rs.next()) {
					valoraciones.add(new Valoracion(rs.getInt(1),modeloProducto.buscarProductoPorId(rs.getInt(2)),modeloUsuario.buscarUsuarioPorId(rs.getInt(3)),rs.getInt(4),rs.getString(5)));
				}
				
				return valoraciones;
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(ValoracionDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
	
}
