package curso.java.modelo;

public enum EstadoPedido {
	PE("Pendiente de envío"),
	PC("Pendiente de cancelación"),
	PCD("Pendiente de cancelación de detalle"),
	E("Enviado"),
	C("Cancelado");
	
	private String estado;
	
	private EstadoPedido(String estado) {
		this.estado=estado;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
