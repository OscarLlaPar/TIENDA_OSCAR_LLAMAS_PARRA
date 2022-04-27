package curso.java.modelo;

public class Configuracion {
	private int id;
	private String clave;
	private String valor;
	private String tipo;
	public Configuracion(int id, String clave, String valor, String tipo) {
		super();
		this.id = id;
		this.clave = clave;
		this.valor = valor;
		this.tipo = tipo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Configuracion [id=" + id + ", clave=" + clave + ", valor=" + valor + ", tipo=" + tipo + "]";
	}
	
	
}
