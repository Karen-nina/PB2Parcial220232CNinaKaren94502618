package ar.edu.unlam.dominio;

import java.util.Objects;

public class Producto implements Vendible{

	private String codigo;
    private String nombre;
    private Double precio;
    private Integer stock;
	
	public Producto(String codigo, String nombre, Double precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}

	

	public Producto(String codigo, String nombre, Double precio, Integer stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		this.stock = stock;
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


	
	public Integer getStock() {
		return stock;
	}



	public void setStock(Integer stock) {
		this.stock = stock;
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
		Producto other = (Producto) obj;
		return Objects.equals(codigo, other.codigo);
	}



	public void decrementarStock(Integer cantidad) throws StockInsuficienteException {
		if (stock >= cantidad) {
            stock -= cantidad;
        } else {
            throw new StockInsuficienteException("Stock insuficiente para decrementar la cantidad especificada");
        }
    }
}

