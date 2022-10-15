package logica;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
@Entity
public class InstitucionDeportiva {
	@Id
	private String nombre;
	private String descripcion;
	private String url;
	
	@OneToMany(mappedBy="institucionDeportiva",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<ActividadDeportiva> actividadesDeportivas = new ArrayList<>();
	
	@OneToMany(mappedBy="institucionDeportiva",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Profesor> profesores = new ArrayList<>();
	
	public InstitucionDeportiva() {
		super();
	}

	public InstitucionDeportiva(String nombre, String descripcion, String url,
			List<ActividadDeportiva> actividadesDeportivas, List<Profesor> profesores) {
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

	public List<ActividadDeportiva> getActividadesDeportivas() {
		return actividadesDeportivas;
	}

	public void setActividadesDeportivas(List<ActividadDeportiva> actividadesDeportivas) {
		this.actividadesDeportivas = actividadesDeportivas;
	}

	public List<Profesor> getProfesores() {
	return profesores;
	}

	public void setProfesores(List<Profesor> profesores) {
		this.profesores = profesores;
	}
	
	public void addActividad(ActividadDeportiva actividad) {
		this.actividadesDeportivas.add(actividad);
	}
	public void addProfesor(Profesor profesor) {
		this.profesores.add(profesor);
	}

}
