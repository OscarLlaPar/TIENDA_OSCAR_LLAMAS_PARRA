package curso.java.modelo;

public enum EstadoPedido {
	PE("Pendiente de env�o"),
	PC("Pendiente de cancelaci�n"),
	PCD("Pendiente de cancelaci�n de detalle"),
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
