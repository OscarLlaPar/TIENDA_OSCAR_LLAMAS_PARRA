package curso.java.modelo;

public class OpcionMenu {
	private int id;
	private Rol rol;
	private String nombre;
	private String url;
	
	public OpcionMenu(int id, Rol rol, String nombre, String url) {
		super();
		this.id = id;
		this.rol = rol;
		this.nombre = nombre;
		this.url = url;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public String toString() {
		return "OpcionMenu [id=" + id + ", rol=" + rol + ", nombre=" + nombre + ", url=" + url + "]";
	}
	
	
}
