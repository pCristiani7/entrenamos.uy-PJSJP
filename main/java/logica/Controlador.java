package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDeportiva;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControlador;

public class Controlador implements IControlador{

	ManejadorInstitucionDeportiva mid = ManejadorInstitucionDeportiva.getInstancia();
	ManejadorProfesor mp = ManejadorProfesor.getInstancia();
	ManejadorSocio ms = ManejadorSocio.getInstancia();
	ManejadorActividadDeportiva mad = ManejadorActividadDeportiva.getInstancia();
	
	public Controlador() {
		
	}

	public boolean existeMail(String email) {
		return (mp.existeEmail(email) || ms.existeEmail(email));
	}
	
	public boolean existeNickname(String nickname) {
		return (mp.existeNickname(nickname) || ms.existeNickname(nickname));
	}
	
	public boolean existeNombreInstDep(String nombre) {
		return mid.existeNickname(nombre);
	}
	
	//-------------------Casos de uso Usuario-------------------
	@Override
	public void AltaUsuario(DtUsuario dtUser) throws UsuarioRepetidoExcepcion {
		// TODO Auto-generated method stub
		if(!existeMail(dtUser.getEmail()) || !existeNickname(dtUser.getNickname())) {
			if(dtUser instanceof DtProfesor){
				List<Clase> clases = new ArrayList<>();
				DtProfesor dtProf = (DtProfesor) dtUser;
				InstitucionDeportiva id = mid.buscarInstitucionDeportiva(dtProf.getInstitucionDeportiva());
				Profesor prof = new Profesor(dtProf.getNickname(),dtProf.getNombre(),dtProf.getApellido(),dtProf.getEmail(),dtProf.getFechaNac(),dtProf.getDescripcion(),dtProf.getBiografia(),dtProf.getSitioweb(),clases,id); 
				ManejadorProfesor mp = ManejadorProfesor.getInstancia();
				mp.addProfesor(prof);
			}else if(dtUser instanceof DtSocio){
				List<Registro> registros = new ArrayList<>();
				DtSocio dtSocio = (DtSocio) dtUser;
				Socio socio = new Socio(dtSocio.getNickname(),dtSocio.getNombre(),dtSocio.getApellido(),dtSocio.getEmail(),dtSocio.getFechaNac(),registros);
				ManejadorSocio ms = ManejadorSocio.getInstancia();
				ms.addSocio(socio);
			}
		} else {
			throw new UsuarioRepetidoExcepcion("El usuario " + dtUser.getNickname() + " ya esta registrado!");
		}
	}

	@Override
	public DtUsuario ConsultaUsuario(String user) {
		DtUsuario dtUser = null;
		if(mp.existeNickname(user)) {
			Profesor prof = mp.buscarProfesor(user);
			String nomInstDep = mid.retornarNomInstDep(prof.getNickname());	//arreglar
			DtProfesor dtProf = new DtProfesor(prof.getNickname(), prof.getNombre(),prof.getApellido(), prof.getEmail(),prof.getFecha(), prof.getDescripcion(), prof.getBiografia(), prof.getSitioWeb(), nomInstDep);
			dtUser = (DtUsuario) dtProf;
		}else if(ms.existeNickname(user)) {
			Socio soc = ms.buscarSocio(user);
			List<Registro> registros = soc.getRegistros();
			ArrayList<DtRegistro> dtRegistros = new ArrayList<DtRegistro>();
			for(Registro r: registros) {
				DtRegistro dtReg = new DtRegistro(r.getClase(),r.getFecha());
				dtRegistros.add(dtReg);
			}
			DtSocio dtSocio = new DtSocio(soc.getNickname(), soc.getNombre(),soc.getApellido(), soc.getEmail(),soc.getFecha(), dtRegistros);	
			dtUser = (DtUsuario) dtSocio;
		}
		return dtUser;	
	}

	@Override
	//Opcional
	public void ModificarDatosUsuario() {
		// TODO Auto-generated method stub
		
	}
	
	//-------------------Casos de uso Institucion Deportiva------------------- 
	
	public void AltaInsitucionDeportiva(DtInstitucionDeportiva dtInstDep) {
		if(!existeNombreInstDep(dtInstDep.getNombre())) {
			List<ActividadDeportiva> actividadesDeportivas = new ArrayList<>();
			List<Profesor> profesores = new ArrayList<>();
			InstitucionDeportiva id = new InstitucionDeportiva(dtInstDep.getNombre(),dtInstDep.getDescripcion(),dtInstDep.getUrl(),actividadesDeportivas,profesores);
			mid.addIntitucionDeportiva(id);
		}else {
			//THROW INVALID INSTIT_DEP
		}
	}
	
	//Opcional
	public void ModificarInstitucionDeportiva() {
		
	}
	
	//-------------------Casos de uso Actividad Deportiva------------------- 
	
	@Override
	public void AltaActividadDeportiva(DtActividadDeportiva dtAD){
		if(mad.existeNombre(dtAD.getNombre())){
			//ya existe la actividad deportiva
		}else {
			List<Clase> clases = new ArrayList<>();
			DtInstitucionDeportiva dtID = dtAD.getInstitucionDeportiva();
			InstitucionDeportiva ID = mid.buscarInstitucionDeportiva(dtID.getNombre());
			ActividadDeportiva aD = new ActividadDeportiva(dtAD.getNombre(),dtAD.getDescripcion(),dtAD.getDuracion(),dtAD.getCosto(),dtAD.getFecha(),clases,ID);
			mad.addActividadDeportiva(aD);
		}
	}
	
	@Override
	public void ConsultaActividadDeportiva(){
		
	}
	
	public void ModificarActividadDeportiva() {
		
	}
	
	//-------------------Casos de uso Clase------------------- 
	
	public void AltaDictadoClase(){
		
	}
	
	public void RegistroDictadoClase(){
		
	}
	
	public void ConsultaDictadoClase(){
		
	}
	
	public void RankingDictadosClases(){
		
	}
	
	public String[] listarInstituciones() {
		ArrayList<String> instituciones;
		ManejadorInstitucionDeportiva mID = ManejadorInstitucionDeportiva.getInstancia();
		instituciones = mID.obtenerInstituciones();
		String[] instituciones_ret = new String[instituciones.size()];
        int i=0;
        for(String s:instituciones) {
        	instituciones_ret[i]=s;
        	i++;
        }
        return instituciones_ret;
	}
}
