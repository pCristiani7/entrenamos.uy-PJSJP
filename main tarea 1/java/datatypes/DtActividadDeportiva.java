package datatypes;

import java.time.LocalDate;
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
	private LocalDate fecha;
	//private List<DtClase> clases = new ArrayList<>();
	private String institucionDeportiva;
	
	public DtActividadDeportiva() {
		super();
	}
	
	public DtActividadDeportiva(String nombre, String descripcion, int duracion, float costo, LocalDate fecha,/*List<DtClase> clases,*/ String institucionDeportiva) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.duracion = duracion;
		this.costo = costo;
		this.fecha = fecha;
		//this.clases = clases;
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

	public LocalDate getFecha() {
		return fecha;
	}


	/*public List<DtClase> getClases() {
		return clases;
	}*/


	public String getInstitucionDeportiva() {
		return institucionDeportiva;
	}

}
