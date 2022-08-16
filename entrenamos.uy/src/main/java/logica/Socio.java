package logica;

import java.util.ArrayList;
import java.util.List;

public class Socio extends Usuario {
	private List<Registro> registros = new ArrayList<>();

	public Socio(List<Registro> registros) {
		super();
		this.registros = registros;
	}

	public Socio() {
		super();
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	
}

