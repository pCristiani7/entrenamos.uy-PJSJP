package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtUsuario;

public class Profesor extends Usuario {
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	private List<Clase> clases = new ArrayList<>();
	private String institucionDeportiva;
	
	
	public Profesor() {
		super();
	}

	public Profesor(String nickname, String nombre, String apellido, String email, Date fecha, String descripcion, String biografia, String sitioWeb, List<Clase> clases,String institucionDeportiva) {
		super(nickname, nombre, apellido, email, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.clases = clases;
		this.institucionDeportiva = institucionDeportiva;
	}



	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public String getInstitucionDeportiva() {
		return institucionDeportiva;
	}

	public void setInstitucionDeportiva(String institucionDeportiva) {
		this.institucionDeportiva = institucionDeportiva;
	}

	@Override
	public DtUsuario altaDeUsuario() {
		// TODO Auto-generated method stub
		return null;
	}
	

	
	
	
}
