package logica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
@Entity
public class Profesor extends Usuario {
	private String descripcion;
	private String biografia;
	private String sitioWeb;
	
	@OneToMany(mappedBy="profesor",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Clase> clases = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(
			name = "institucionDeportiva"
	)
	private InstitucionDeportiva institucionDeportiva;
	
	
	public Profesor() {
		super();
	}

	public Profesor(String nickname, String nombre, String apellido, String email, LocalDate fecha, String descripcion, String biografia, String sitioWeb, List<Clase> clases,InstitucionDeportiva institucionDeportiva) {
		super(nickname, nombre, apellido, email, fecha);
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioWeb = sitioWeb;
		this.clases = clases;
		this.institucionDeportiva = institucionDeportiva;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getBiografia() {
		return biografia;
	}

	public void setBiografia(String biografia) {
		this.biografia = biografia;
	}

	public String getSitioWeb() {
		return sitioWeb;
	}

	public void setSitioWeb(String sitioWeb) {
		this.sitioWeb = sitioWeb;
	}

	public List<Clase> getClases() {
		return clases;
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
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(biografia, clases, descripcion, institucionDeportiva, sitioWeb);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profesor other = (Profesor) obj;
		return Objects.equals(biografia, other.biografia) && Objects.equals(clases, other.clases)
				&& Objects.equals(descripcion, other.descripcion)
				&& Objects.equals(institucionDeportiva, other.institucionDeportiva)
				&& Objects.equals(sitioWeb, other.sitioWeb);
	}
	
	
}
