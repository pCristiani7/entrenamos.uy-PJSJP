package datatypes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtSocio extends DtUsuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private LocalDate fechaNac;
	private byte[] profileImage;
	//private List<DtRegistro> dtRegistros = new ArrayList<>();

	public DtSocio() {
		super();		
	}

	public DtSocio(String nickname, String nombre, String apellido, String email, LocalDate fechaNac,/* List<DtRegistro> dtRegistros,*/ byte[] profileImage) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.profileImage = profileImage;
		//this.dtRegistros = dtRegistros;
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
	
	public byte[] getProfileImage() {
		return profileImage;
	}
	
	/*public List<DtRegistro> getDtRegistros() {
		return dtRegistros;
	}*/
	
}
