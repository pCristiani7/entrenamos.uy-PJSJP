package interfaces;

import datatypes.DtUsuario;
//import datatypes.DtActividadDeportiva;
//import datatypes.DtInstitucionDeportiva;
//import datatypes.DtClase;

public interface IControlador {
	
	public boolean existeMail(String email);
	public boolean existeNickname(String nickname);
	
	public void AltaUsuario(DtUsuario dtUser);
	public DtUsuario ConsultaUsuario(String user);
	public void ModificarDatosUsuario();	
	
	public void AltaActividadDeportiva();
	public void ConsultaActividadDeportiva();
	public void ModificarActividadDeportiva();
	
	public void AltaInsitucionDeportiva();
	public void ModificarInstitucionDeportiva();
	
	public void AltaDictadoClase();
	public void RegistroDictadoClase();
	public void ConsultaDictadoClase();
	public void RankingDictadosClases();
	
}
