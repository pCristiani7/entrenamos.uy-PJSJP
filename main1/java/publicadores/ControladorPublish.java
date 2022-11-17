package publicadores;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

//import configuraciones.WebServiceConfiguracion;
import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import excepciones.ClaseRepetidaExcepcion;
import excepciones.InstitucionDeportivaRepetidaExcepcion;
import excepciones.RegistroRepetidoExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;
import logica.ActividadDeportiva;
import logica.Clase;
import logica.InstitucionDeportiva;
import logica.Socio;



@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class ControladorPublish{
	private Fabrica fab;
	private IControlador icon;
	//private WebServiceConfiguracion configuracion;
	private Endpoint endpoint;
	
	public ControladorPublish(){
		fab = Fabrica.getInstance();
		icon = fab.getIControlador();
		/*try {
			configuracion = new WebServiceConfiguracion();
		} catch (Exception ex) {
			
		}*/
	}
	
	@WebMethod(exclude = true)
	public void publicar() {
		endpoint = Endpoint.publish("http://127.0.0.1:8082/Controlador",this);
		System.out.println("http://127.0.0.1:8082/Controlador");
	}
	
	@WebMethod(exclude = true)
	public Endpoint getEndpoint() {
		return endpoint;
	}
	
	//LOS METODOS QUE VAMOS A PUBLICAR
	@WebMethod
	public boolean existeMail(String email) {
		return icon.existeMail(email);
	}
	
	@WebMethod
	public boolean existeNickname(String nickname) {
		return icon.existeNickname(nickname);
	}
	
	@WebMethod
	public void EliminarRegistro(String clase, String socio){
		icon.EliminarRegistro(clase, socio);
	}
	
	@WebMethod
	public void AltaUsuario(DtUsuario dtUser, String pass) throws UsuarioRepetidoExcepcion {
		icon.AltaUsuario(dtUser,pass);
	}
	
	@WebMethod
	public DtUsuario ConsultaUsuario(String user) {
		return icon.ConsultaUsuario(user);
	}
	
	@WebMethod
	public boolean ModificarDatosUsuario(DtUsuario dtUser, DtUsuario dtUserNew) {
		return icon.ModificarDatosUsuario(dtUser,dtUserNew);
	}
	
	@WebMethod
	public boolean inicioSesion(String nickname, String pass) {
		return icon.inicioSesion(nickname,pass);
	}
	
	@WebMethod
	public void AltaActividadDeportiva(DtActividadDeportiva dtAD) throws ActividadDeportivaRepetidaExcepcion{
		icon.AltaActividadDeportiva(dtAD);
	}
	
	@WebMethod
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep) {
		return icon.ConsultaActividadDeportiva(actDep);
	}
	
	@WebMethod
	public boolean ModificarActividadDeportiva(String actDep, DtActividadDeportiva dtActDepNew) {
		return icon.ModificarActividadDeportiva(actDep, dtActDepNew);
	}
	
	@WebMethod
	public DtActividadDeportiva[] RankingActividadesDeportivas(){
		List<DtActividadDeportiva> dtActDep = icon.RankingActividadesDeportivas();
		int i = 0;
		DtActividadDeportiva[] ret = new DtActividadDeportiva[dtActDep.size()];
		for(DtActividadDeportiva dt : dtActDep) {
			ret[i] = dt;
			i++;
		}
		return ret;
	}
	
	@WebMethod
	public ActividadDeportiva getAct(String nombre) {
		return icon.getAct(nombre);
	}
	
	@WebMethod
	public void AltaInsitucionDeportiva(DtInstitucionDeportiva dtInstDep) throws InstitucionDeportivaRepetidaExcepcion {
		icon.AltaInsitucionDeportiva(dtInstDep);
	}
	
	@WebMethod
	public boolean ModificarInstitucionDeportiva(String instDep, DtInstitucionDeportiva dtInstDepNew) {
		return icon.ModificarInstitucionDeportiva(instDep, dtInstDepNew);
	}
	
	@WebMethod
	public InstitucionDeportiva getInstitucion(String nombre) {
		return icon.getInstitucion(nombre);
	}
	
	
	@WebMethod
	public void AltaDictadoClase(DtActividadDeportiva dtAct, DtClase c) throws ClaseRepetidaExcepcion {
		icon.AltaDictadoClase(dtAct,c);
	}
	
	@WebMethod
	public void RegistroDictadoClase(String nomClase, String nomSocio, Date fecha) throws RegistroRepetidoExcepcion{
		icon.RegistroDictadoClase(nomClase, nomSocio, fecha);
	}
	
   @WebMethod
    public DtClase getDatosClase(String nomClase) {
        return icon.getDatosClase(nomClase);
      }

   @WebMethod
      public DtClase ConsultaDictadoClase(String nomClase){
         return icon.ConsultaDictadoClase(nomClase);
      }

   @WebMethod
     public DtClase[] RankingDictadosClases(){
        List<DtClase> dtclase = icon.RankingDictadosClases();
        int i = 0;
        DtClase[] ret = new DtClase [dtclase.size()];
        for(DtClase dt : dtclase) {
            ret[i] = dt;
            i++;
        }
        return ret;
    }
   

   @WebMethod
      public String[] listarClasesActividadDeportiva(String ActDep){
         return icon.listarClasesActividadDeportiva(ActDep);
      }

   @WebMethod
      public String[] listarInstitucionesConActYProf(){
         return icon.listarInstitucionesConActYProf();
      }

   @WebMethod
      public String[] listarInstitucionesConAct(){
         return icon.listarInstitucionesConAct();
      }

   @WebMethod
      public String[] listarInstitucionesConActYClases(){
         return icon.listarInstitucionesConActYClases();
      }

   @WebMethod
      public String[] listarInstituciones(){
         return icon.listarInstituciones();
      }

   @WebMethod
      public String[] listarClasesProf(String nickname){
         return icon.listarClasesProf(nickname);
      }

   @WebMethod
      public String[] listarRegistrosSocio(String nickname){
         return icon.listarRegistrosSocio(nickname);
      }

   @WebMethod
      public String[] listarUsuarios(){
         return icon.listarUsuarios();
      }

   @WebMethod
      public String[] listarProfesores(){
         return icon.listarProfesores();
      }

   @WebMethod
     public String[] listarSocios(){
         return icon.listarSocios();
      }

   @WebMethod
      public Clase getClase(String nombre){
         return icon.getClase(nombre);
      }                     

   @WebMethod
      public Socio getSocio(String nombre){
         return icon.getSocio(nombre);
      } 

   @WebMethod
      public DtSocio findSocio(String name){
         return icon.findSocio(name);
      }

   @WebMethod
      public DtProfesor findProfesor(String name){
         return icon.findProfesor(name);
      }

   @WebMethod
      public String[] listarActividades(){
	   	return icon.listarActividades();
      }

   @WebMethod
      public DtInstitucionDeportiva getInstitucionDt(String nombre){
	   	return icon.getInstitucionDt(nombre);
      }

   @WebMethod
      public String[] listarClases(){
         return icon.listarClases();
      }

   @WebMethod
      public String[] listarSociosFront(){
          ArrayList<String> socio = icon.listarSociosFront();
        int i = 0;
        String[] ret = new String [socio.size()];
        for(String s: socio) {
            ret[i] = s;
            i++;
        }
        return ret;
      } 

   @WebMethod
      public String[] listarActsFront(){
          ArrayList<String> actDep = icon.listarActsFront();
        int i = 0;
        String[] ret = new String [actDep.size()];
        for(String a: actDep) {
            ret[i] = a;
            i++;
        }
        return ret;
      }

   @WebMethod
      public String[] listarClasesFront(){
          ArrayList<String> clase = icon.listarClasesFront();
        int i = 0;
        String[] ret = new String [clase.size()];
        for(String c: clase) {
            ret[i] = c;
            i++;
        }
        return ret;
      }

   @WebMethod
      public String[] listarProfesoresFront(){
         ArrayList<String> prof = icon.listarProfesoresFront();
        int i = 0;
        String[] ret = new String [prof.size()];
        for(String p: prof) {
            ret[i] = p;
            i++;
        }
        return ret;
      }   
   @WebMethod
   public DtRegistro[] getRegistrosClase(String nomClase){
       ArrayList<DtRegistro> dtReg = icon.getRegistrosClase(nomClase);
        int i = 0;
        DtRegistro[] ret = new DtRegistro [dtReg.size()];
        for(DtRegistro dtreg: dtReg) {
            ret[i] = dtreg;
            i++;
        }
        return ret;
   }

   @WebMethod
   public DtActividadDeportiva[] getActividadesInstitucion(String nomInstDep){
     ArrayList<DtActividadDeportiva> dtActsDeps = icon.getActividadesInstitucion(nomInstDep);
     int i = 0;
     DtActividadDeportiva[] ret = new DtActividadDeportiva [dtActsDeps.size()];
       for(DtActividadDeportiva dtActDep: dtActsDeps) {
           ret[i] = dtActDep;
           i++;
       }
       return ret;
  }
   
  @WebMethod
   public DtProfesor[] getProfesoresInstitucion(String nomInstDep){
     ArrayList<DtProfesor> dtProfs = icon.getProfesoresInstitucion(nomInstDep);
     int i = 0;
     DtProfesor[] ret = new DtProfesor [dtProfs.size()];
       for(DtProfesor dtProf: dtProfs) {
           ret[i] = dtProf;
           i++;
       }
       return ret;
  }
  
  public DtClase[] getClasesActDep(String nomActDep){
	  ArrayList<DtClase> dtClases = icon.getClasesActDep(nomActDep);
	  int i = 0;
	  DtClase[] ret = new DtClase [dtClases.size()];
       for(DtClase dtClase: dtClases) {
           ret[i] = dtClase;
           i++;
       }
       return ret;
  }
	public DtRegistro[] getRegistrosSocio(String nomSocio){
		ArrayList<DtRegistro> dtRegistros = icon.getRegistrosSocio(nomSocio);
		  int i = 0;
		  DtRegistro[] ret = new DtRegistro [dtRegistros.size()];
	       for(DtRegistro dtRegistro: dtRegistros) {
	           ret[i] = dtRegistro;
	           i++;
	       }
	       return ret;
	}
}