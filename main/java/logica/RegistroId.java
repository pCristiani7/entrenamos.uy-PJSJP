package logica;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class RegistroId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private LocalDate fecha;
	private Socio socio;
	private Clase clase;
	
	public RegistroId() {
		super();
	}
	public Socio getSocio() {
		return socio;
	}
	public void setSocio(Socio socio) {
		this.socio = socio;
	}
	public Clase getClase() {
		return clase;
	}
	public void setClase(Clase clase) {
		this.clase = clase;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	@Override
	public int hashCode() {
		return Objects.hash(clase, fecha, socio);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RegistroId other = (RegistroId) obj;
		return Objects.equals(clase, other.clase) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(socio, other.socio);
	}
	
	
	
}
