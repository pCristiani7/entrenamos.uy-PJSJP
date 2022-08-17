package logica;

import java.util.Date;

import datatypes.DtUsuario;

public abstract class Usuario {
	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fecha;
	
	
	public Usuario() {
		super();
	}

	public Usuario(String nickname, String nombre, String apellido, String email, Date fecha) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fecha = fecha;
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

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public abstract DtUsuario altaDeUsuario ();
	
}	
