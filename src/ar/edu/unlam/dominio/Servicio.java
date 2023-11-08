package ar.edu.unlam.dominio;

import java.util.Objects;

public class Servicio implements Vendible{

		private String codigo;
	    private String nombre;
	    private Double precio;
	    private String fechaInicio;
	    private String fechaFin;
	
	
	    
	public Servicio(String codigo, String nombre, Double precio, String fechaInicio, String fechaFin) {
			super();
			this.codigo = codigo;
			this.nombre = nombre;
			this.precio = precio;
			this.fechaInicio = fechaInicio;
			this.fechaFin = fechaFin;
		}

	
	public String getCodigo() {
		return codigo;
	}


	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public Double getPrecio() {
		return precio;
	}


	public void setPrecio(Double precio) {
		this.precio = precio;
	}


	public String getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public String getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}


	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Servicio other = (Servicio) obj;
		return Objects.equals(codigo, other.codigo);
	}
	
	
	
}
