package datatypes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtClase {
	private String nombre;
	private String url;
	//private List<DtRegistro> registros = new ArrayList<>();
	private String actividadDeportiva;
	private String profesor;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalDate fechaReg;

	public DtClase() {
		super();
	}

	public DtClase(String nombre, String url, /*List<DtRegistro> registros,*/ String actividadDeportiva, LocalDate fecha,
			LocalDate fechaReg, LocalTime horaInicio, String profesor) {
		super();
		this.nombre = nombre;
		this.url = url;
		//this.registros = registros;
		this.actividadDeportiva = actividadDeportiva;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.fechaReg = fechaReg;
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	public String getUrl() {
		return url;
	}
	
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	
	public LocalTime getHoraInicio() {
		return horaInicio;
	}
	
	
	public LocalDate getFechaReg() {
		return fechaReg;
	}
		
	public String getActividadDeportiva() {
		return actividadDeportiva;
	}

	public String getProfesor() {
		return profesor;
	}
}
