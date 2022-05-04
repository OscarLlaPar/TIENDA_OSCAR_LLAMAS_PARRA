package curso.java.modelo;

import java.sql.Timestamp;

public class Proveedor {
	private int id;
	private String nombre;
	private String direccion;
	private String localidad;
	private String provincia;
	private String telefono;
	private String cif;
	private String email;
	private Timestamp fechaBaja;
	
	public Proveedor(int id, String nombre, String direccion, String localidad, String provincia, String telefono,
			String cif, String email, Timestamp fechaBaja) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.localidad = localidad;
		this.provincia = provincia;
		this.telefono = telefono;
		this.cif = cif;
		this.email = email;
		this.fechaBaja = fechaBaja;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public Timestamp getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Timestamp fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	@Override
	public String toString() {
		return "Proveedor [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", localidad=" + localidad
				+ ", provincia=" + provincia + ", telefono=" + telefono + ", cif=" + cif + ", email=" + email + ", fechaBaja=" + fechaBaja + "]";
	}
	
	
}
