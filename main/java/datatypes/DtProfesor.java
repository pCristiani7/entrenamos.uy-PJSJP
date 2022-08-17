package datatypes;

import java.util.Date;

public class DtProfesor extends DtUsuario {

	private String descripcion;
	private String biografia;
	private String sitioweb;
	
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public String getBiografia() {
		return biografia;
	}


	public String getSitioweb() {
		return sitioweb;
	}
	
	
}
