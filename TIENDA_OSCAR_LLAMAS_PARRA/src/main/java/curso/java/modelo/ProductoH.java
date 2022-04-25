package curso.java.modelo;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class ProductoH {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name="id_categoria")
	private int categoria;
	@Column(name="nombre")
	private String nombre;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="precio")
	private double precio;
	@Column(name="stock")
	private int stock;
	@Column(name="fecha_alta")
	private Timestamp fechaAlta;
	@Column(name="fecha_baja")
	private Timestamp fechaBaja;
	@Column(name="impuesto")
	private float impuesto;
	@Column(name="imagen")
	private String imagen;
	
	public ProductoH() {
		
	}
	
	public ProductoH(int id, int categoria, String nombre, String descripcion, double precio, int stock,
			Timestamp fechaAlta, Timestamp fechaBaja, float impuesto, String imagen) {
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
	}

	public ProductoH(ProductoH p) {
		this.categoria = p.getCategoria();
		this.nombre = p.getNombre();
		this.descripcion = p.getDescripcion();
		this.precio = p.getPrecio();
		this.stock = p.getStock();
		this.fechaAlta = p.getFechaAlta();
		this.fechaBaja = p.getFechaBaja();
		this.impuesto = p.getImpuesto();
		this.imagen = p.getImagen();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategoria() {
		return categoria;
	}

	public void setCategoria(int categoria) {
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

	@Override
	public String toString() {
		return "Producto [id=" + id + ", categoria=" + categoria + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio="
				+ precio + ", stock=" + stock + ", fechaAlta=" + fechaAlta + ", fechaBaja=" + fechaBaja + ", impuesto="
				+ impuesto + ", imagen=" + imagen + "]";
	}
	
	
}
