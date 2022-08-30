package logica;

import java.time.LocalDate;

public class Registro {
 private LocalDate fecha;
 private Socio socio;
 private Clase clase;

 
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