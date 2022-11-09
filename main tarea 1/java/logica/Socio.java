package logica;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Socio extends Usuario {
	
	@OneToMany(mappedBy="socio",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Registro> registros = new ArrayList<>();

	public Socio(String nickname, String nombre, String apellido, String email, Date fecha, String password, List<Registro> registros, byte[] profileImage) {
		super(nickname, nombre, apellido, email, fecha, password, profileImage);
		this.registros = registros;
	}

	public Socio() {
		super();
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}
	
	public void addRegistro(Registro r) {
		this.registros.add(r);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(registros);
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
		Socio other = (Socio) obj;
		return Objects.equals(registros, other.registros);
	}

	
}

