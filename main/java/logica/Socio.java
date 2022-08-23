package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Socio extends Usuario {
	private List<Registro> registros = new ArrayList<>();

	public Socio(String nickname, String nombre, String apellido, String email, Date fecha, List<Registro> registros) {
		super(nickname, nombre, apellido, email, fecha);
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

