package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class ActividadDeportiva {
	@Id
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private LocalDate fecha;
	
	@OneToMany(mappedBy="actividadDeportiva",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Clase> clases = new ArrayList<>();
	
	private int cantClases;
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
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

	@Override
	public int hashCode() {
		return Objects.hash(cantClases, clases, costo, descripcion, duracion, fecha, institucionDeportiva, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActividadDeportiva other = (ActividadDeportiva) obj;
		return cantClases == other.cantClases && Objects.equals(clases, other.clases)
				&& Float.floatToIntBits(costo) == Float.floatToIntBits(other.costo)
				&& Objects.equals(descripcion, other.descripcion) && duracion == other.duracion
				&& Objects.equals(fecha, other.fecha)
				&& Objects.equals(institucionDeportiva, other.institucionDeportiva)
				&& Objects.equals(nombre, other.nombre);
	}
	
	
}
