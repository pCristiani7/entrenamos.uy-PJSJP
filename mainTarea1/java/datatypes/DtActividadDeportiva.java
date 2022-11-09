package datatypes;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtActividadDeportiva {
	private String nombre;
	private String descripcion;
	private int duracion;
	private float costo;
	private Date fecha;
	private String institucionDeportiva;
	
	public DtActividadDeportiva() {
		super();
	}
	
	public DtActividadDeportiva(String nombre, String descripcion, int duracion, float costo, Date fecha, String institucionDeportiva) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
		this.institucionDeportiva = institucionDeportiva;
	}

	public String getNombre() {
		return nombre;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public int getDuracion() {
		return duracion;
	}


	public float getCosto() {
		return costo;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getInstitucionDeportiva() {
		return institucionDeportiva;
	}

}
