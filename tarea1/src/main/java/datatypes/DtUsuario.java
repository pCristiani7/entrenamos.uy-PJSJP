package datatypes;

import java.time.LocalDate;

public abstract class DtUsuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaNac;
	
	public DtUsuario() {
		super();
	}
	
	public DtUsuario(String nickname, String nombre, String apellido, String email, LocalDate fechaNac) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
	}

	public String getNickname() {
		return nickname;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getFechaNac() {
		return fechaNac;
	}
	
}
