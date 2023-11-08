package ar.edu.unlam.dominio;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Venta {

	private String codigo;
    private Cliente cliente;
    private Vendedor vendedor;
    private Map<Vendible, Integer> items = new HashMap<>();

    

    public Venta(String codigo, Cliente cliente, Vendedor vendedor) {
		super();
		this.codigo = codigo;
		this.cliente = cliente;
		this.vendedor = vendedor;
		this.items = new HashMap<>();
	}

	public void agregarItem(Vendible vendible, Integer cantidad) {
        items.put(vendible, cantidad);
    }

    public Double getTotal() {
        Double total = 0d;
        for (Map.Entry<Vendible, Integer> entry : items.entrySet()) {
            total += entry.getKey().getPrecio() * entry.getValue();
        }
        return total;
    }

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Map<Vendible, Integer> getItems() {
		return items;
	}

	public void setItems(Map<Vendible, Integer> items) {
		this.items = items;
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
		Venta other = (Venta) obj;
		return Objects.equals(codigo, other.codigo);
	}


    
	
	
	
}
