package datatypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtClase {
	private String nombre;
	private String url;
	private String actividadDeportiva;
	private String profesor;
	private Date fecha;
	private Date fechaReg;

	public DtClase() {
		super();
	}

	public DtClase(String nombre, String url, String actividadDeportiva, Date fecha, Date fechaReg, String profesor) {
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
	
	
	public Date getFecha() {
		return fecha;
	}
	
	
	public Date getFechaReg() {
		return fechaReg;
	}
		
	public String getActividadDeportiva() {
		return actividadDeportiva;
	}

	public String getProfesor() {
		return profesor;
	}
}
