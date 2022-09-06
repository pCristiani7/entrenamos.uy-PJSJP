package logica;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(RegistroId.class)
public class Registro {
	@Id
	private LocalDate fecha;
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Socio socio;
	@Id
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Clase clase;

 
 public Registro() {
		super();
	}

public Registro(LocalDate fecha, Socio socio, Clase clase) {
	super();
	this.fecha = fecha;
	this.socio = socio;
	this.clase = clase;
 }


public LocalDate getFecha() {
	return fecha;
}


public void setFecha(LocalDate fecha) {
	this.fecha = fecha;
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
 
 
 
}