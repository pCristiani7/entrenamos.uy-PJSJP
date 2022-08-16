package logica;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ActividadDeportiva {
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private Date fecha;
	private List<Clase> clases = new ArrayList<>();
	private InstitucionDeportiva institucionDeportiva;
	
	public ActividadDeportiva() {
		super();
	}
	
	public ActividadDeportiva(String nombre, String descripcion, int duracion, float costo, Date fecha,
			List<Clase> clases, InstitucionDeportiva institucionDeportiva) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
		this.clases = clases;
		this.institucionDeportiva = institucionDeportiva;
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

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public float getCosto() {
		return costo;
	}

	public void setCosto(float costo) {
		this.costo = costo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public List<Clase> getClases() {
		return clases;
	}

	public void setClases(List<Clase> clases) {
		this.clases = clases;
	}

	public InstitucionDeportiva getInstitucionDeportiva() {
		return institucionDeportiva;
	}

	public void setInstitucionDeportiva(InstitucionDeportiva institucionDeportiva) {
		this.institucionDeportiva = institucionDeportiva;
	}
	
	
	
}
