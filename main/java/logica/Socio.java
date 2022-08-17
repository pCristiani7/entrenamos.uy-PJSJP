package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtUsuario;

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

	@Override
	public DtUsuario altaDeUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	
}

