package curso.java.modelo;

import java.sql.Timestamp;

public class Producto {
	private int id;
	private Categoria categoria;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	private Timestamp fechaAlta;
	private Timestamp fechaBaja;
	private float impuesto;
	private String imagen;
	private String audio;
	private Proveedor proveedor;
	
	public Producto(int id, Categoria categoria, String nombre, String descripcion, double precio, int stock,
			Timestamp fechaAlta, Timestamp fechaBaja, float impuesto, String imagen, String audio, Proveedor proveedor) {
		super();
		this.id=id;
		this.categoria = categoria;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.fechaAlta = fechaAlta;
		this.fechaBaja = fechaBaja;
		this.impuesto = impuesto;
		this.imagen = imagen;
		this.audio = audio;
		this.proveedor = proveedor;
	}

	public Producto(Producto p) {
		this.categoria = p.getCategoria();
		this.nombre = p.getNombre();
		this.descripcion = p.getDescripcion();
		this.precio = p.getPrecio();
		this.stock = p.getStock();
		this.fechaAlta = p.getFechaAlta();
		this.fechaBaja = p.getFechaBaja();
		this.impuesto = p.getImpuesto();
		this.imagen = p.getImagen();
		this.audio = p.getAudio();
		this.proveedor = p.getProveedor();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Timestamp getFechaAlta() {
		return fechaAlta;
	}

	public void setFechaAlta(Timestamp fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Timestamp getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Timestamp fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	
	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", categoria=" + categoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", stock=" + stock + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", impuesto="
				+ impuesto + ", imagen=" + imagen + ", audio="+ audio +", proveedor=" + proveedor + "]";
	}
	
	
}
