package curso.java.modelo;


import java.time.LocalDate;

public class Descuento {
	private int id;
	private String codigo;
	private float descuento;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	
	public Descuento(int id, String codigo, float descuento, LocalDate fechaInicio, LocalDate fechaFin) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.descuento = descuento;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public float getDescuento() {
		return descuento;
	}

	public void setDescuento(float descuento) {
		this.descuento = descuento;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public String toString() {
		return "Descuento [id=" + id + ", codigo=" + codigo + ", descuento=" + descuento + ", fechaInicio="
				+ fechaInicio + ", fechaFin=" + fechaFin + "]";
	}
	
	
}
