package datatypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DtSocio extends DtUsuario {

	private List<DtRegistro> dtRegistros = new ArrayList<>();

	public DtSocio() {
		super();		
	}

	public DtSocio(String nickname, String nombre, String apellido, String email, LocalDate fechaNac, List<DtRegistro> dtRegistros, byte[] profileImage) {
		super(nickname, nombre, apellido, email, fechaNac, profileImage);
		this.dtRegistros = dtRegistros;
	}

	public List<DtRegistro> getDtRegistros() {
		return dtRegistros;
	}
	
}
