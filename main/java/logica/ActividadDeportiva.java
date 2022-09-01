package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ActividadDeportiva {
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private LocalDate fecha;
	private List<Clase> clases = new ArrayList<>();
	private int cantClases;
	private InstitucionDeportiva institucionDeportiva;
	
	public ActividadDeportiva() {
		super();
	}
	
	public ActividadDeportiva(String nombre, String descripcion, int duracion, float costo, LocalDate fecha,
			List<Clase> clases, InstitucionDeportiva institucionDeportiva) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
		this.clases = clases;
		this.cantClases = clases.size();
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

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public List<Clase> getClases() {
		return clases;
	}
	
	public int getCantClases() {
		return cantClases;
	}
	
	public void setCantClases() {
		this.cantClases = clases.size();
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
	
	public void addClase(Clase c) {
		this.clases.add(c);
	}
	
}
