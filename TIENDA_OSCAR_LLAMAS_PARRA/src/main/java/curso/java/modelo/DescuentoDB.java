package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import curso.java.util.LogUtil;
import curso.java.util.TipoLog;

public class DescuentoDB {
	private static Connection conexion=Conexion.getConexion();
	
	public DescuentoDB() {
		Conexion.conectar();
	}
	
	public Descuento obtenerPorCodigo(String codigo) {
		try {
			Statement statement=conexion.createStatement();
			Descuento descuento=null;
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM descuentos WHERE codigo =?");
				ps.setString(1, codigo);
				
				ResultSet rs=ps.executeQuery();
				if(rs.next()) {
					descuento=new Descuento(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getDate(4).toLocalDate(),rs.getDate(5).toLocalDate()
							);
				}
				return descuento;
				
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			LogUtil.registrarInfo(CategoriaDB.class, TipoLog.ERROR, e.getMessage());
			return null;
		}
	}
	
}
