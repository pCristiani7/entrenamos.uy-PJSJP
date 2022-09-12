package datatypes;

import java.time.LocalDate;

public class DtRegistro {
	private String clase;
	private LocalDate fecha;
	private String socio;
	
	
	
	public DtRegistro(String clase, LocalDate fecha, String socio) {
		super();
		this.clase = clase;
		this.fecha = fecha;
		this.socio = socio;
	}

	public String getClase() {
		return clase;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public String getSocio() {
		return socio;
	}
}
