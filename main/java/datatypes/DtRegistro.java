package datatypes;

import java.time.LocalDate;

public class DtRegistro {
	private String clase;
	private LocalDate fecha;
	
	
	
	public DtRegistro(String clase, LocalDate fecha) {
		super();
		this.clase = clase;
		this.fecha = fecha;
	}

	public String getClase() {
		return clase;
	}

	public LocalDate getFecha() {
		return fecha;
	}
	
}
