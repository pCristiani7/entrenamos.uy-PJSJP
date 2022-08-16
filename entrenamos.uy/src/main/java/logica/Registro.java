package logica;

import java.util.Date;

public class Registro {
 private Date fecha;
 private Socio socio;
 private Clase clase;

 
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