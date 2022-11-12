package datatypes;

import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtSocio extends DtUsuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Date fechaNac;
	private byte[] profileImage;

	public DtSocio() {
		super();		
	}

	public DtSocio(String nickname, String nombre, String apellido, String email, Date fechaNac, byte[] profileImage) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.profileImage = profileImage;
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

	public Date getFechaNac() {
		return fechaNac;
	}
	
	public byte[] getProfileImage() {
		return profileImage;
	}

}
