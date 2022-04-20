package curso.java.modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;

public class OpcionMenuDB {
	private static Connection conexion=Conexion.getConexion();
	
	public OpcionMenuDB() {
		Conexion.conectar();
	}
	
	public HashSet<OpcionMenu> mostrarOpciones(Rol rol){
		try {
			Statement statement=conexion.createStatement();
			HashSet<OpcionMenu> menu=new HashSet<>();
			RolDB modeloRol=new RolDB();
			if(conexion!=null) {
				PreparedStatement ps = conexion.prepareStatement("SELECT * FROM opciones_menu WHERE id_rol=?");
				ps.setInt(1, rol.getId());
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					OpcionMenu opcion=new OpcionMenu(rs.getInt(1),rol,rs.getString(3),rs.getString(4));
					menu.add(opcion);
				}
				return menu;
			}
			return null;
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
}
