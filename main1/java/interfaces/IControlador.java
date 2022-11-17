package interfaces;

import java.util.ArrayList;
import java.util.Date;
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
	
	
	public void EliminarRegistro(String clase, String socio);
	public void AltaUsuario(DtUsuario dtUser, String pass) throws UsuarioRepetidoExcepcion;
	public DtUsuario ConsultaUsuario(String user);
	public boolean ModificarDatosUsuario(DtUsuario dtUser, DtUsuario dtUserNew);
	public boolean inicioSesion(String nickname, String pass);
	
	public void AltaActividadDeportiva(DtActividadDeportiva dtAD) throws ActividadDeportivaRepetidaExcepcion;
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep);
	public boolean ModificarActividadDeportiva(String actDep, DtActividadDeportiva dtActDepNew);
	public List<DtActividadDeportiva> RankingActividadesDeportivas();
	public ActividadDeportiva getAct(String nombre);
	
	public void AltaInsitucionDeportiva(DtInstitucionDeportiva dtInstDep) throws InstitucionDeportivaRepetidaExcepcion;
	public boolean ModificarInstitucionDeportiva(String instDep, DtInstitucionDeportiva dtInstDepNew);
	public InstitucionDeportiva getInstitucion(String nombre);
	
	public void AltaDictadoClase(DtActividadDeportiva dtAct, DtClase c) throws ClaseRepetidaExcepcion;
	public void RegistroDictadoClase(String nomClase, String nomSocio, Date fecha) throws RegistroRepetidoExcepcion;
	public DtClase getDatosClase(String nomClase);
	public DtClase ConsultaDictadoClase(String nomClase);
	public List<DtClase> RankingDictadosClases();
	public String[] listarClasesActividadDeportiva(String ActDep);
	
	public String[] listarInstitucionesConActYProf();
	public String[] listarInstitucionesConAct();
	public String[] listarInstitucionesConActYClases();
	public String[] listarInstituciones();
	public String[] listarClasesProf(String nickname);
	public String[] listarRegistrosSocio(String nickname);
	public String[] listarUsuarios();
	public String[] listarProfesores();
	public String[] listarSocios();
	public Clase getClase(String nombre);
	public Socio getSocio(String nombre);
	public DtSocio findSocio(String name);
	public DtProfesor findProfesor(String name);
	public String[] listarActividades();
	public DtInstitucionDeportiva getInstitucionDt(String nombre);
	public String[] listarClases();
	public ArrayList<String> listarSociosFront();
	public ArrayList<String> listarActsFront();
	public ArrayList<String> listarClasesFront();
	public ArrayList<String> listarProfesoresFront();
	public ArrayList<DtRegistro> getRegistrosClase(String nomClase);
	public ArrayList<DtClase> getClasesActDep(String nomActDep);
	public ArrayList<DtRegistro> getRegistrosSocio(String nomSocio);
	public ArrayList<DtActividadDeportiva> getActividadesInstitucion(String nomInstDep);
	public ArrayList<DtProfesor> getProfesoresInstitucion(String nomInstDep);
}
