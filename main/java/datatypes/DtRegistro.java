package datatypes;

import java.time.LocalDate;

import logica.Clase;

public class DtRegistro {
	private Clase clase;
	private LocalDate fecha;
	
	
	
	public DtRegistro(Clase clase, LocalDate fecha) {
		super();
		this.clase = clase;
		this.fecha = fecha;
	}

	public Clase getClase() {
		return clase;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
}
