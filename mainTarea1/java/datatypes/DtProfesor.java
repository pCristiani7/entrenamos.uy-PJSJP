package datatypes;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtProfesor extends DtUsuario {

	private String nickname;
	private String nombre;
	private String apellido;
	private String email;
	private Calendar fechaNac;
	private byte[] profileImage;
	private String descripcion;
	private String biografia;
	private String sitioweb;
	private String institucionDeportiva;
	
	
	public DtProfesor(String nickname, String nombre, String apellido, 
			String email, Calendar fechaNac, String descripcion, String biografia, 
			String sitioweb, String institucionDeportiva, byte[] profileImage) {
		super();
		this.nickname = nickname;
		this.nombre = nombre;
		this.apellido = apellido;
		this.email = email;
		this.fechaNac = fechaNac;
		this.profileImage = profileImage;
		this.descripcion = descripcion;
		this.biografia = biografia;
		this.sitioweb = sitioweb;
		this.institucionDeportiva = institucionDeportiva;
	}

	public DtProfesor() {
		super();
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

	public Calendar getFechaNac() {
		return fechaNac;
	}
	
	public byte[] getProfileImage() {
		return profileImage;
	}
	
	public String getInstitucionDeportiva() {
		return institucionDeportiva;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public String getBiografia() {
		return biografia;
	}


	public String getSitioweb() {
		return sitioweb;
	}
	
}
