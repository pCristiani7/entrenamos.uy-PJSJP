package datatypes;

import java.time.LocalDate;
import java.util.ArrayList;

public class DtSocio extends DtUsuario {

	private ArrayList<DtRegistro> dtRegistros;

	public DtSocio() {
		super();		
	}

	public DtSocio(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, ArrayList<DtRegistro> dtRegistros) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.dtRegistros = dtRegistros;
	}

	public ArrayList<DtRegistro> getDtRegistros() {
		return dtRegistros;
	}
	
}
