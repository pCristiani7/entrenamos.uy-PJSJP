package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtActividadDeportiva;
import datatypes.DtInstitucionDeportiva;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import datatypes.DtClase;
import excepciones.ActividadDeportivaRepetidaExcepcion;
import excepciones.ClaseRepetidaExcepcion;
import excepciones.InstitucionDeportivaRepetidaExcepcion;
import excepciones.UsuarioRepetidoExcepcion;
import interfaces.IControlador;

public class Controlador implements IControlador{

	ManejadorInstitucionDeportiva mid = ManejadorInstitucionDeportiva.getInstancia();
	ManejadorProfesor mp = ManejadorProfesor.getInstancia();
	ManejadorSocio ms = ManejadorSocio.getInstancia();
	ManejadorUsuario mu = ManejadorUsuario.getInstancia();
	ManejadorActividadDeportiva mad = ManejadorActividadDeportiva.getInstancia();
	ManejadorClase mc = ManejadorClase.getInstancia();
	
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
		if(!existeMail(dtUser.getEmail()) && !existeNickname(dtUser.getNickname())) {
			if(dtUser instanceof DtProfesor){
				List<Clase> clases = new ArrayList<>();
				DtProfesor dtProf = (DtProfesor) dtUser;
				InstitucionDeportiva id = mid.buscarInstitucionDeportiva(dtProf.getInstitucionDeportiva());
				Profesor prof = new Profesor(dtProf.getNickname(),dtProf.getNombre(),dtProf.getApellido(),dtProf.getEmail(),dtProf.getFechaNac(),dtProf.getDescripcion(),dtProf.getBiografia(),dtProf.getSitioweb(),clases,id); 
				mp.addProfesor(prof);
				id.addProfesor(prof);
				mu.agregarUsuario(prof);
			}else if(dtUser instanceof DtSocio){
				List<Registro> registros = new ArrayList<>();
				DtSocio dtSocio = (DtSocio) dtUser;
				Socio socio = new Socio(dtSocio.getNickname(),dtSocio.getNombre(),dtSocio.getApellido(),dtSocio.getEmail(),dtSocio.getFechaNac(),registros);
				ms.addSocio(socio);
				mu.agregarUsuario(socio);
			}
		} else {
			throw new UsuarioRepetidoExcepcion("Ya existe un usuario con esas credenciales!");
		}
	}

	@Override
	public DtUsuario ConsultaUsuario(String user) {
		DtUsuario dtUser = null;
		if(mp.existeNickname(user)) {
			Profesor prof = mp.buscarProfesor(user);
			String nomInstDep = mid.retornarNomInstDep(prof.getNickname());
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
	
	public void AltaInsitucionDeportiva(DtInstitucionDeportiva dtInstDep) throws InstitucionDeportivaRepetidaExcepcion {
		if(!existeNombreInstDep(dtInstDep.getNombre())) {
			List<ActividadDeportiva> actividadesDeportivas = new ArrayList<>();
			List<Profesor> profesores = new ArrayList<>();
			InstitucionDeportiva id = new InstitucionDeportiva(dtInstDep.getNombre(),dtInstDep.getDescripcion(),dtInstDep.getUrl(),actividadesDeportivas,profesores);
			mid.addIntitucionDeportiva(id);
		}else {
			throw new InstitucionDeportivaRepetidaExcepcion("Ya existe una Institucion con ese nombre!");
		}
	}
	
	//Opcional
	public void ModificarInstitucionDeportiva() {
		
	}
	
	//-------------------Casos de uso Actividad Deportiva------------------- 
	
	@Override
	public void AltaActividadDeportiva(DtActividadDeportiva dtAD) throws ActividadDeportivaRepetidaExcepcion{
		if(mad.existeNombre(dtAD.getNombre())){
			throw new ActividadDeportivaRepetidaExcepcion("Ya existe una Actividad con ese nombre!");
		}else {
			List<Clase> clases = new ArrayList<>();
			String dtID = dtAD.getInstitucionDeportiva();
			InstitucionDeportiva ID = mid.buscarInstitucionDeportiva(dtID);
			ActividadDeportiva aD = new ActividadDeportiva(dtAD.getNombre(),dtAD.getDescripcion(),dtAD.getDuracion(),dtAD.getCosto(),dtAD.getFecha(),clases,ID);
			mad.addActividadDeportiva(aD);
			ID.addActividad(aD);
		}
	}
	
	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep){
		DtActividadDeportiva dtActDep = null;
		if(mad.existeNombre(actDep)) {
			ActividadDeportiva ad = mad.buscarActividadDeportiva(actDep);
			List<Clase> clases = ad.getClases();
			ArrayList<DtClase> dtClases = new ArrayList<DtClase>();
			for(Clase c: clases) {
				List<Registro> registros = c.getRegistros();
				ArrayList<DtRegistro> dtRegistros = new ArrayList<DtRegistro>();
				for(Registro r: registros) {									//Para cada clase, obtengo su lista de registros
					DtRegistro dtReg = new DtRegistro(r.getClase(),r.getFecha());
					dtRegistros.add(dtReg);
				}		
				DtClase dtclase = new DtClase(c.getNombre(), c.getUrl(), dtRegistros, c.getActividadDeportiva().getNombre(), c.getFecha(), c.getFechaReg(), c.getHoraInicio(), c.getProfesor().getNickname());
				dtClases.add(dtclase);
			}
			DtActividadDeportiva dtActividadDeportiva = new DtActividadDeportiva(ad.getNombre(), ad.getDescripcion(), ad.getDuracion(), ad.getCosto(), ad.getFecha(), dtClases, ad.getInstitucionDeportiva().getNombre());	
			dtActDep = (DtActividadDeportiva) dtActividadDeportiva;
		}
		return dtActDep;	
	}
	
	public void ModificarActividadDeportiva() {
		
	}
	
	//-------------------Casos de uso Clase------------------- 
	
	public List<DtActividadDeportiva> listarActividades(DtInstitucionDeportiva dtID){
		List<DtActividadDeportiva> listDtAct = new ArrayList<>();
		InstitucionDeportiva ID = mid.buscarInstitucionDeportiva(dtID.getNombre());
		List<ActividadDeportiva> listAct = ID.getActividadesDeportivas();
		for(ActividadDeportiva a: listAct) {
			List<DtClase> listDtClase = new ArrayList<>();
			List<Clase> listClase = a.getClases();
			for(Clase c: listClase) {
				List<Registro> registros = c.getRegistros();
				ArrayList<DtRegistro> dtRegistros = new ArrayList<DtRegistro>();
				for(Registro r: registros) {									//Para cada clase, obtengo su lista de registros
					DtRegistro dtReg = new DtRegistro(r.getClase(),r.getFecha());
					dtRegistros.add(dtReg);
				}		
				DtClase dtclase = new DtClase(c.getNombre(), c.getUrl(), dtRegistros, c.getActividadDeportiva().getNombre(), c.getFecha(), c.getFechaReg(), c.getHoraInicio(), c.getProfesor().getNickname());
				listDtClase.add(dtclase);
			}
			DtActividadDeportiva dtAct = new DtActividadDeportiva(a.getNombre(),a.getDescripcion(),a.getDuracion(),a.getCosto(),a.getFecha(),listDtClase,a.getInstitucionDeportiva().getNombre());
			listDtAct.add(dtAct);
		}
		return listDtAct;
	}
	
	public void AltaDictadoClase(DtActividadDeportiva dtAct, DtClase c) throws ClaseRepetidaExcepcion{
		if(!mc.existeClase(c.getNombre())) {
			List<Registro> registros = new ArrayList<>();
			ActividadDeportiva AD = mad.buscarActividadDeportiva(c.getActividadDeportiva());
			Profesor prof = mp.buscarProfesor(c.getProfesor());
			Clase clase = new Clase(c.getNombre(), c.getUrl(), registros, AD, c.getFecha(), c.getHoraInicio(), c.getFechaReg(),prof);
			mc.addClase(clase);
		}else {
			throw new ClaseRepetidaExcepcion("Ya existe una Clase con ese nombre!");
		}
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
	
	public String[] listarProfesores() {
		ArrayList<String> profesores;
		ManejadorProfesor mP = ManejadorProfesor.getInstancia();
		profesores = mP.obtenerProfesores();
		String[] profesores_ret = new String[profesores.size()];
        int i=0;
        for(String s:profesores) {
        	profesores_ret[i]=s;
        	i++;
        }
        return profesores_ret;
	}
	
	public String[] listarUsuarios(){
		ArrayList<String> usuarios;
		ManejadorUsuario mu = ManejadorUsuario.getInstancia();
		usuarios = mu.obtenerUsuarios();
		String[] usuarios_ret = new String[usuarios.size()];
        int i=0;
        for(String s:usuarios) {
        	usuarios_ret[i]=s;
        	i++;
        }
        return usuarios_ret;
	}
	
	public InstitucionDeportiva getInstitucion(String nombre){
		ManejadorInstitucionDeportiva mInst = ManejadorInstitucionDeportiva.getInstancia();
		InstitucionDeportiva instDep = mInst.buscarInstitucionDeportiva(nombre);
		return instDep;
	}
	
	public ActividadDeportiva getAct(String nombre){
		ManejadorActividadDeportiva mAct = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actDep = mAct.buscarActividadDeportiva(nombre);
		return actDep;
	}
}
