package datatypes;

import java.util.ArrayList;
import java.util.List;

public class DtInstitucionDeportiva {
	private String nombre;
	private String descripcion;
	private String url;
	private List<DtActividadDeportiva> actividadesDeportivas = new ArrayList<>();
	private List<DtProfesor> profesores = new ArrayList<>();
	
	public DtInstitucionDeportiva() {
		super();
	}

	public DtInstitucionDeportiva(String nombre, String descripcion, String url,
			List<DtActividadDeportiva> actividadesDeportivas, List<DtProfesor> profesores) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
		this.actividadesDeportivas = actividadesDeportivas;
		this.profesores = profesores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<DtActividadDeportiva> getActividadesDeportivas() {
		return actividadesDeportivas;
	}

	public void setActividadesDeportivas(List<DtActividadDeportiva> actividadesDeportivas) {
		this.actividadesDeportivas = actividadesDeportivas;
	}

	public List<DtProfesor> getProfesores() {
		return profesores;
	}

	public void setProfesores(List<DtProfesor> profesores) {
		this.profesores = profesores;
	}
	
}
