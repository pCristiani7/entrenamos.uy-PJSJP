package interfaces;

import datatypes.DtActividadDeportiva;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
//import datatypes.DtActividadDeportiva;
//import datatypes.DtInstitucionDeportiva;
//import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;

public interface IControlador {
	
	public boolean existeMail(String email);
	public boolean existeNickname(String nickname);
	
	public void AltaUsuario(DtUsuario dtUser) throws UsuarioRepetidoExcepcion;
	public DtUsuario ConsultaUsuario(String user);
	public void ModificarDatosUsuario();	
	
	public void AltaActividadDeportiva(DtActividadDeportiva dtAD);
	public void ConsultaActividadDeportiva();
	public void ModificarActividadDeportiva();
	
	public void AltaInsitucionDeportiva(DtInstitucionDeportiva dtInstDep);
	public void ModificarInstitucionDeportiva();
	
	public void AltaDictadoClase();
	public void RegistroDictadoClase();
	public void ConsultaDictadoClase();
	public void RankingDictadosClases();
	
	public String[] listarInstituciones();
	
}
