package datatypes;

import java.util.Date;

public class DtProfesor extends DtUsuario {

	private String descripcion;
	private String biografia;
	private String sitioweb;
	private DtInstitucionDeportiva institucionDeportiva;
	
	
	public DtProfesor(String nickname, String nombre, String apellido, String email, Date fechaNac, String descripcion, String biografia, String sitioweb, DtInstitucionDeportiva institucionDeportiva) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucionDeportiva = institucionDeportiva;
	}


	
	public DtInstitucionDeportiva getInstitucionDeportiva() {
		return institucionDeportiva;
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
