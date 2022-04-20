package curso.java.modelo;

public class DetallePedido {
	private Pedido pedido;
	private Producto producto;
	private float precioUnidad;
	private int unidades;
	private float impuesto;
	private double total;
	
	public DetallePedido(Pedido pedido, Producto producto, float precioUnidad, int unidades, float impuesto,
			double total) {
		super();
		this.pedido = pedido;
		this.producto = producto;
		this.precioUnidad = precioUnidad;
		this.unidades = unidades;
		this.impuesto = impuesto;
		this.total = total;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public float getPrecioUnidad() {
		return precioUnidad;
	}

	public void setPrecioUnidad(float precioUnidad) {
		this.precioUnidad = precioUnidad;
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public float getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(float impuesto) {
		this.impuesto = impuesto;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "DetallePedido [pedido=" + pedido + ", producto=" + producto + ", precioUnidad=" + precioUnidad
				+ ", unidades=" + unidades + ", impuesto=" + impuesto + ", total=" + total + "]";
	}
	
	
}
