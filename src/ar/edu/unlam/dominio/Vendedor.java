package ar.edu.unlam.dominio;

import java.util.Objects;

public class Vendedor{

	 private String dni;
	    private String nombre;
		public Vendedor(String dni, String nombre) {
			super();
			this.dni = dni;
			this.nombre = nombre;
		}
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		@Override
		public int hashCode() {
			return Objects.hash(dni);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Vendedor other = (Vendedor) obj;
			return Objects.equals(dni, other.dni);
		}
	

    
	

}
