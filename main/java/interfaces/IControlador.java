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
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtSocio;

public interface IControlador {
	
	public boolean existeMail(String email);
	public boolean existeNickname(String nickname);
	
	public void AltaUsuario(DtUsuario dtUser) throws UsuarioRepetidoExcepcion;
	public DtUsuario ConsultaUsuario(String user);
	public boolean ModificarDatosUsuario(DtUsuario dtUser, DtUsuario dtUserNew);
	
	public void AltaActividadDeportiva(DtActividadDeportiva dtAD) throws ActividadDeportivaRepetidaExcepcion;
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep);
	public boolean ModificarActividadDeportiva(String actDep, DtActividadDeportiva dtActDepNew);
	public List<DtActividadDeportiva> RankingActividadesDeportivas();
	public ActividadDeportiva getAct(String nombre);
	
	public void AltaInsitucionDeportiva(DtInstitucionDeportiva dtInstDep) throws InstitucionDeportivaRepetidaExcepcion;
	public boolean ModificarInstitucionDeportiva(String instDep, DtInstitucionDeportiva dtInstDepNew);
	public InstitucionDeportiva getInstitucion(String nombre);
	
	public List<DtActividadDeportiva> listarActividades(DtInstitucionDeportiva dtID); //auxiliar para alta dictado clase
	public void AltaDictadoClase(DtActividadDeportiva dtAct, DtClase c) throws ClaseRepetidaExcepcion;
	public void RegistroDictadoClase(String nomClase, String nomSocio, LocalDate fecha) throws RegistroRepetidoExcepcion;
	public DtClase getDatosClase(String nomClase);
	public DtClase ConsultaDictadoClase(String nomClase);
	public List<DtClase> RankingDictadosClases();
	public String[] listarClasesActividadDeportiva(String ActDep);
	
	
	public String[] listarInstituciones();
	public String[] listarClasesProf(String nickname);
	public String[] listarRegistrosSocio(String nickname);
	public String[] listarUsuarios();
	public String[] listarProfesores();
	public String[] listarSocios();
	public Clase getClase(String nombre);
	public Socio getSocio(String nombre);
	public List<DtRegistro> getRegistrosSocio(String nombre);
	public DtSocio findSocio(String name);
	public DtProfesor findProfesor(String name);
	public String[] listarActividades();
	public DtInstitucionDeportiva getInstitucionDt(String nombre);
	
}
