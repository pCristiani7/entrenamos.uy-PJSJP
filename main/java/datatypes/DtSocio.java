package datatypes;

import java.util.ArrayList;
import java.util.Date;

public class DtSocio extends DtUsuario {

	private ArrayList<DtRegistro> dtRegistros;

	public DtSocio() {
		super();		
	}

	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac, ArrayList<DtRegistro> dtRegistros) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.dtRegistros = dtRegistros;
	}

	public ArrayList<DtRegistro> getDtRegistros() {
		return dtRegistros;
	}
	
}
