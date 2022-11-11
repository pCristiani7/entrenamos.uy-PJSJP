package datatypes;

import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtClase {
	private String nombre;
	private String url;
	private String actividadDeportiva;
	private String profesor;
	private Calendar fecha;
	private Calendar fechaReg;

	public DtClase() {
		super();
	}

	public DtClase(String nombre, String url, String actividadDeportiva, Calendar fecha, Calendar fechaReg, String profesor) {
		super();
		this.nombre = nombre;
		this.url = url;
		this.actividadDeportiva = actividadDeportiva;
		this.fecha = fecha;
		this.fechaReg = fechaReg;
		this.profesor = profesor;
	}

	public String getNombre() {
		return nombre;
	}
	
	
	public String getUrl() {
		return url;
	}
	
	
	public Calendar getFecha() {
		return fecha;
	}
	
	
	public Calendar getFechaReg() {
		return fechaReg;
	}
		
	public String getActividadDeportiva() {
		return actividadDeportiva;
	}

	public String getProfesor() {
		return profesor;
	}
}
