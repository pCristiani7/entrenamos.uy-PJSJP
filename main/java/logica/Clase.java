package logica;

import java.time.LocalDate;
import java.time.LocalTime;
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
public class Clase {
	@Id
	private String nombre;
	private String url;
	
	@OneToMany(mappedBy="clase",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private ActividadDeportiva actividadDeportiva;
	
	@ManyToOne
	@JoinColumn(
			insertable=false,
			updatable=false
	)
	private Profesor profesor;
	
	private LocalDate   fecha;
	private LocalTime horaInicio;
	private LocalDate fechaReg;

	public Clase() {
		super();
	}

	public Clase(String nombre, String url, List<Registro> registros, ActividadDeportiva actividadDeportiva, LocalDate  fecha,
			LocalTime horaInicio, LocalDate fechaReg, Profesor profesor) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.registros = registros;
		this.actividadDeportiva = actividadDeportiva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.fechaReg = fechaReg;
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public LocalDate  getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate  fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}
	public LocalDate getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(LocalDate fechaReg) {
		this.fechaReg = fechaReg;
	}
	public List<Registro> getRegistros() {
		return registros;
	}
	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	public ActividadDeportiva getActividadDeportiva() {
		return actividadDeportiva;
	}

	public void setActividadDeportiva(ActividadDeportiva actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public void addRegistro(Registro r) {
		this.registros.add(r);
	}

	@Override
	public int hashCode() {
		return Objects.hash(actividadDeportiva, fecha, fechaReg, horaInicio, nombre, profesor, registros, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Clase other = (Clase) obj;
		return Objects.equals(actividadDeportiva, other.actividadDeportiva) && Objects.equals(fecha, other.fecha)
				&& Objects.equals(fechaReg, other.fechaReg) && Objects.equals(horaInicio, other.horaInicio)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(profesor, other.profesor)
				&& Objects.equals(registros, other.registros) && Objects.equals(url, other.url);
	}
	
	
}
