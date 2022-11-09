package datatypes;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtRegistro {
	private String clase;
	private Date fecha;
	private String socio;
	
	
	
	public DtRegistro(String clase, Date fecha, String socio) {
		super();
		this.clase = clase;
		this.fecha = fecha;
		this.socio = socio;
	}

	public String getClase() {
		return clase;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getSocio() {
		return socio;
	}
}
