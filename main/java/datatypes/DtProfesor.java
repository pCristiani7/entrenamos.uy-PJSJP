package datatypes;

import java.time.LocalDate;

public class DtProfesor extends DtUsuario {

	private String descripcion;
	private String biografia;
	private String sitioweb;
	private String institucionDeportiva;
	
	
	public DtProfesor(String nickname, String nombre, String apellido, 
			String email, LocalDate fechaNac, String descripcion, String biografia, 
			String sitioweb, String institucionDeportiva) {
		super(nickname, nombre, apellido, email, fechaNac);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucionDeportiva = institucionDeportiva;
	}

	public DtProfesor() {
		super();
	}
	
	public String getInstitucionDeportiva() {
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
