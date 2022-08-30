package interfaces;

import java.time.LocalDate;
import java.util.List;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtUsuario;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import excepciones.ClaseRepetidaExcepcion;
import excepciones.InstitucionDeportivaRepetidaExcepcion;
import excepciones.RegistroRepetidoExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.Socio;
//import datatypes.DtActividadDeportiva;
//import datatypes.DtInstitucionDeportiva;
//import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtRegistro;
import datatypes.DtSocio;

public interface IControlador {
	
	public boolean existeMail(String email);
	public boolean existeNickname(String nickname);
	
	public void AltaUsuario(DtUsuario dtUser) throws UsuarioRepetidoExcepcion;
	public DtUsuario ConsultaUsuario(String user);
	public void ModificarDatosUsuario();	
	
	public void AltaActividadDeportiva(DtActividadDeportiva dtAD) throws ActividadDeportivaRepetidaExcepcion;
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep);
	public void ModificarActividadDeportiva();
	public ActividadDeportiva getAct(String nombre);
	
	public void AltaInsitucionDeportiva(DtInstitucionDeportiva dtInstDep) throws InstitucionDeportivaRepetidaExcepcion;
	public void ModificarInstitucionDeportiva();
	public InstitucionDeportiva getInstitucion(String nombre);
	
	public List<DtActividadDeportiva> listarActividades(DtInstitucionDeportiva dtID); //auxiliar para alta dictado clase
	public void AltaDictadoClase(DtActividadDeportiva dtAct, DtClase c) throws ClaseRepetidaExcepcion;
	public void RegistroDictadoClase(DtClase dtClase, DtSocio dtSocio, LocalDate fecha) throws RegistroRepetidoExcepcion;
	public void ConsultaDictadoClase();
	public void RankingDictadosClases();
	public String[] listarClasesActividadDeportiva(String ActDep);
	public DtClase findClase(String clase);
	
	
	public String[] listarInstituciones();
	public String[] listarUsuarios();
	public String[] listarProfesores();
	public String[] listarSocios();
	public Clase getClase(String nombre);
	public Socio getSocio(String nombre);
	public List<DtRegistro> getRegistrosSocio(String nombre);
	public DtSocio findSocio(String name);
	
}
