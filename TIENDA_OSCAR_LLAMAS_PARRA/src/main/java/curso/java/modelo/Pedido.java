package curso.java.modelo;

import java.sql.Timestamp;
import java.util.HashMap;

public class Pedido {
	private int id;
	private Usuario usuario;
	private Timestamp fecha;
	private MetodoPago metodoPago;
	private EstadoPedido estado;
	private String numFactura;
	private double total;
	private HashMap<Integer,DetallePedido> detallesPedido;
	
	public Pedido(int id, Usuario usuario, Timestamp fecha, MetodoPago metodoPago, EstadoPedido estado,
			String numFactura, double total, HashMap<Integer, DetallePedido> detallesPedido) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.fecha = fecha;
		this.metodoPago = metodoPago;
		this.estado = estado;
		this.numFactura = numFactura;
		this.total = total;
		this.detallesPedido = detallesPedido;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Timestamp getFecha() {
		return fecha;
	}

	public void setFecha(Timestamp fecha) {
		this.fecha = fecha;
	}

	public MetodoPago getMetodoPago() {
		return metodoPago;
	}

	public void setMetodoPago(MetodoPago metodoPago) {
		this.metodoPago = metodoPago;
	}

	public EstadoPedido getEstado() {
		return estado;
	}

	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public HashMap<Integer, DetallePedido> getDetallesPedido() {
		return detallesPedido;
	}

	public void setDetallesPedido(HashMap<Integer, DetallePedido> detallesPedido) {
		this.detallesPedido = detallesPedido;
	}

	@Override
	public String toString() {
		return "Pedido [id=" + id + ", usuario=" + usuario + ", fecha=" + fecha + ", metodoPago=" + metodoPago
				+ ", estado=" + estado + ", numFactura=" + numFactura + ", total=" + total + ", detallesPedido="
				+ detallesPedido + "]";
	}
	
	
	
	
}
