package logica;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Usuario {
	@Id
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fecha;
	private String password;
	
	public Usuario() {
		super();
	}

	public Usuario(String nickname, String nombre, String apellido, String email, LocalDate fecha, String password) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fecha = fecha;
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, email, fecha, nickname, nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(email, other.email)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(nickname, other.nickname)
				&& Objects.equals(nombre, other.nombre);
	}

	public String getPassword() {
		return password;
		
	}

	public void setPassword(String password) {
		this.password = password;
		
	}
	
	
}	
