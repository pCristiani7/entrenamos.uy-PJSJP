package datatypes;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DtClase {
	private String nombre;
	private String url;
	private List<DtRegistro> registros = new ArrayList<>();
	private String actividadDeportiva;
	private String profesor;
	private Date fecha;
	private Date horaInicio;
	private Date fechaReg;

	public DtClase() {
		super();
	}

	public DtClase(String nombre, String url, List<DtRegistro> registros, String actividadDeportiva, Date fecha,
			Date horaInicio, Date fechaReg, String profesor) {
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
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Date getHoraInicio() {
		return horaInicio;
	}
	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}
	public Date getFechaReg() {
		return fechaReg;
	}
	public void setFechaReg(Date fechaReg) {
		this.fechaReg = fechaReg;
	}
	public List<DtRegistro> getRegistros() {
		return registros;
	}
	public void setRegistros(List<DtRegistro> registros) {
		this.registros = registros;
	}
	public String getActividadDeportiva() {
		return actividadDeportiva;
	}

	public void setActividadDeportiva(String actividadDeportiva) {
		this.actividadDeportiva = actividadDeportiva;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}
}
