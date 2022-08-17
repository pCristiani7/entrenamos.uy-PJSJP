package interfaces;

import datatypes.DtUsuario;

public interface IControladorUsuario {
	
	public void AltaUsuario(DtUsuario dtUser);
	public void ConsultaUsuario();
	public boolean existeMail(String email);
	public boolean existeNickname(String nickname);
	
	//Opcionales
	
	public void ModificarDatosUsuario();
	
}
