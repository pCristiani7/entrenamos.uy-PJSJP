package logica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import persistencia.RegistroId;

@Entity
@IdClass(RegistroId.class)
public class Registro {
	
	private Date fecha;
	@Id
	@ManyToOne
	@JoinColumn(
			name = "socio"
	)
	private Socio socio;
	@Id
	@ManyToOne
	@JoinColumn(
			name = "clase"
	)
	private Clase clase;

 
 public Registro() {
		super();
	}

public Registro(Date fecha, Socio socio, Clase clase) {
	super();
	this.fecha = fecha;
	this.socio = socio;
	this.clase = clase;
 }


public Date getFecha() {
	return fecha;
}


public void setFecha(Date fecha) {
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