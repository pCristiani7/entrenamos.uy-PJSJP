package datatypes;

import java.util.Date;

import logica.Clase;

public class DtRegistro {
	private Clase clase;
	private Date fecha;
	
	
	
	public DtRegistro(Clase clase, Date fecha) {
		super();
		this.clase = clase;
		this.fecha = fecha;
	}

	public Clase getClase() {
		return clase;
	}

	public Date getFecha() {
		return fecha;
	}
	
}
