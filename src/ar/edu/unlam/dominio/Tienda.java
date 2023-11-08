package ar.edu.unlam.dominio;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class Tienda {

	private String cuit;
    private String nombre;
    private Map<String, Vendible> inventario = new HashMap<>();
    private Map<String, Cliente> clientes = new HashMap<>();
    private Map<String, Vendedor> vendedores = new HashMap<>();
    private Map<String, Venta> ventas = new HashMap<>();

    
    
    public Tienda(String cuit, String nombre) {
		super();
		this.cuit = cuit;
		this.nombre = nombre;
		this.inventario = new HashMap<>();
		this.clientes = new HashMap<>();
		this.vendedores = new HashMap<>();
		this.ventas = new HashMap<>();
	}

	public void agregarProducto(Producto producto) {
        inventario.put(producto.getCodigo(), producto);
    }

    public void agregarProducto(Producto producto, Integer cantidad) {
        inventario.put(producto.getCodigo(), producto);
        producto.setStock(cantidad);
    }

    public void agregarServicio(Servicio servicio) {
        inventario.put(servicio.getCodigo(), servicio);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getCuit(), cliente);
    }

    public void agregarVendedor(Vendedor vendedor) {
        vendedores.put(vendedor.getDni(), vendedor);
    }

    public void agregarVenta(Venta venta) {
        ventas.put(venta.getCodigo(), venta);
    }

    public void agregarProductoAVenta(String codigoVenta, Producto producto, Integer cantidad) throws StockInsuficienteException {
        Vendible vendible = inventario.get(producto.getCodigo());
        if (vendible instanceof Producto) {
            Producto productoEnInventario = (Producto) vendible;
            if (productoEnInventario.getStock() >= cantidad) {
                productoEnInventario.decrementarStock(cantidad);
                ventas.get(codigoVenta).agregarItem(productoEnInventario, cantidad);
            } else {
                throw new StockInsuficienteException("Stock insuficiente para el producto: " + productoEnInventario.getNombre());
            }
        }
    }

    public void agregarServicioAVenta(String codigoVenta, Servicio servicio) throws StockInsuficienteException {
        Vendible vendible = inventario.get(servicio.getCodigo());
        if (vendible instanceof Servicio) {
            ventas.get(codigoVenta).agregarItem((Servicio) vendible, 1);
        }
    }

    public Vendible getVendible(String codigo) {
        return inventario.get(codigo);
    }

    public Integer getStock(Producto producto) {
        Vendible vendible = inventario.get(producto.getCodigo());
        if (vendible instanceof Producto) {
            return ((Producto) vendible).getStock();
        }
        return 0;
    }

    public Cliente getCliente(String cuit) {
        return clientes.get(cuit);
    }

    public Vendedor getVendedor(String dni) {
        return vendedores.get(dni);
    }

	public String getCuit() {
		return cuit;
	}

	public void setCuit(String cuit) {
		this.cuit = cuit;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Map<String, Vendible> getInventario() {
		return inventario;
	}

	public void setInventario(Map<String, Vendible> inventario) {
		this.inventario = inventario;
	}

	public Map<String, Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(Map<String, Cliente> clientes) {
		this.clientes = clientes;
	}

	public Map<String, Vendedor> getVendedores() {
		return vendedores;
	}

	public void setVendedores(Map<String, Vendedor> vendedores) {
		this.vendedores = vendedores;
	}

	public Map<String, Venta> getVentas() {
		return ventas;
	}

	public void setVentas(Map<String, Venta> ventas) {
		this.ventas = ventas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cuit);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tienda other = (Tienda) obj;
		return Objects.equals(cuit, other.cuit);
	}

	
	
}
