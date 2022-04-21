package curso.java.modelo;

public class MetodoPago {
	private int id;
	private String metodoPago;
	public MetodoPago(int id, String metodoPago) {
		super();
		this.id = id;
		this.metodoPago = metodoPago;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMetodoPago() {
		return metodoPago;
	}
	public void setMetodoPago(String metodoPago) {
		this.metodoPago = metodoPago;
	}
	@Override
	public String toString() {
		return "MetodoPago [id=" + id + ", metodoPago=" + metodoPago + "]";
	}
	
	
}
