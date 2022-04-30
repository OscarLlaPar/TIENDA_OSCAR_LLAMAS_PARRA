package curso.java.modelo;

public class Valoracion {
	private int id;
	private Producto producto;
	private Usuario usuario;
	private int valoracion;
	private String comentario;
	
	public Valoracion(int id, Producto producto, Usuario usuario, int valoracion, String comentario) {
		super();
		this.id = id;
		this.producto = producto;
		this.usuario = usuario;
		this.valoracion = valoracion;
		this.comentario = comentario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	@Override
	public String toString() {
		return "Valoracion [id=" + id + ", producto=" + producto + ", usuario=" + usuario + ", valoracion=" + valoracion
				+ ", comentario=" + comentario + "]";
	}
	
	
}
