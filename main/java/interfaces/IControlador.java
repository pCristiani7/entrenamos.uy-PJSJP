package interfaces;

import java.util.List;

import datatypes.DtActividadDeportiva;
import datatypes.DtUsuario;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import excepciones.InstitucionDeportivaRepetidaExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import logica.ActividadDeportiva;
import logica.InstitucionDeportiva;
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
	
	public void AltaActividadDeportiva(DtActividadDeportiva dtAD) throws ActividadDeportivaRepetidaExcepcion;
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep);
	public void ModificarActividadDeportiva();
	
	public void AltaInsitucionDeportiva(DtInstitucionDeportiva dtInstDep) throws InstitucionDeportivaRepetidaExcepcion;
	public void ModificarInstitucionDeportiva();
	
	public List<DtActividadDeportiva> listarActividades(DtInstitucionDeportiva dtID); //auxiliar para alta dictado clase
	public void AltaDictadoClase(DtActividadDeportiva dtAct);
	public void RegistroDictadoClase();
	public void ConsultaDictadoClase();
	public void RankingDictadosClases();
	
	public String[] listarInstituciones();
	public String[] listarUsuarios();
	
}
