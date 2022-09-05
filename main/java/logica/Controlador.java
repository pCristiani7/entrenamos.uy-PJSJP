package logica;

import java.time.LocalDate;
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
import excepciones.RegistroRepetidoExcepcion;
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
				DtRegistro dtReg = new DtRegistro(r.getClase().getNombre(),r.getFecha());
				dtRegistros.add(dtReg);
			}
			DtSocio dtSocio = new DtSocio(soc.getNickname(), soc.getNombre(),soc.getApellido(), soc.getEmail(),soc.getFecha(), dtRegistros);	
			dtUser = (DtUsuario) dtSocio;
		}
		return dtUser;	
	}

	@Override
	//Opcional
	public boolean ModificarDatosUsuario(DtUsuario dtUser, DtUsuario dtUserNew) {
		// TODO Auto-generated method stub
		if(dtUser instanceof DtSocio) {
			DtSocio dtSocio = (DtSocio) dtUser;
			DtSocio dtSocioNew = (DtSocio) dtUserNew;
			Socio s = ms.buscarSocio(dtSocio.getNickname());
			s.setNombre(dtSocioNew.getNombre());
			s.setApellido(dtSocioNew.getApellido());
			s.setFecha(dtSocioNew.getFechaNac());
			return true;
			
		}else if(dtUser instanceof DtProfesor) {
			DtProfesor dtProf = (DtProfesor) dtUser;
			DtProfesor dtProfNew = (DtProfesor) dtUserNew;
			Profesor p = mp.buscarProfesor(dtProf.getNickname());
			p.setNombre(dtProfNew.getNombre());
			p.setApellido(dtProfNew.getApellido());
			p.setFecha(dtProfNew.getFechaNac());
			p.setDescripcion(dtProfNew.getDescripcion());
			p.setBiografia(dtProfNew.getBiografia());
			p.setSitioWeb(dtProfNew.getSitioweb());
			return true;	
		}
		return false;
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
	public boolean ModificarInstitucionDeportiva(String instDep, DtInstitucionDeportiva dtInstDepNew) {
		if(mid.existeNickname(instDep)) {
			InstitucionDeportiva id = mid.buscarInstitucionDeportiva(instDep);
			id.setDescripcion(dtInstDepNew.getDescripcion());
			id.setUrl(dtInstDepNew.getUrl());
			return true;
		}
		return false;
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
					DtRegistro dtReg = new DtRegistro(r.getClase().getNombre(),r.getFecha());
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
	
	public boolean ModificarActividadDeportiva(String actDep, DtActividadDeportiva dtActDepNew) {
        if(mad.existeNombre(actDep)) {
            ActividadDeportiva ad = mad.buscarActividadDeportiva(actDep);
            ad.setDescripcion(dtActDepNew.getDescripcion());
            ad.setDuracion(dtActDepNew.getDuracion());
            ad.setCosto(dtActDepNew.getCosto());
            	return true;
            }
        return false;
	}
	
	public List<DtActividadDeportiva> RankingActividadesDeportivas() {
		List<DtActividadDeportiva> listDtAct = new ArrayList<>();
		List<ActividadDeportiva> listAct = mad.getActividades();
		List<DtClase> listDtClase = new ArrayList<>();
		int pos;			//Selection sort
        ActividadDeportiva temp;
        for (int i = 0; i < listAct.size(); i++) { 	
            pos = i; 
            for (int j = i+1; j < listAct.size(); j++) {
            	ActividadDeportiva actDep1 = listAct.get(j);
            	ActividadDeportiva actDep2 = listAct.get(pos);
                if (mad.compareActividades(actDep1,actDep2)) {
                    pos = j;
                }
            }

            temp = listAct.get(pos);
            listAct.set(pos, listAct.get(i)); 
            listAct.set(i, temp); 
        } 
        for(ActividadDeportiva ad: listAct) {
        	DtActividadDeportiva dtActDep = new DtActividadDeportiva(ad.getNombre(),ad.getDescripcion(),ad.getDuracion(),ad.getCosto(),ad.getFecha(),listDtClase,ad.getInstitucionDeportiva().getNombre());
        	listDtAct.add(dtActDep);
        }
        return listDtAct;
	}
	
	//-------------------Casos de uso Clase------------------- 
	
	public List<DtActividadDeportiva> listarActividades(String nombre){
		List<DtActividadDeportiva> listDtAct = new ArrayList<>();
		InstitucionDeportiva ID = mid.buscarInstitucionDeportiva(nombre);
		List<ActividadDeportiva> listAct = ID.getActividadesDeportivas();
		for(ActividadDeportiva a: listAct) {
			List<DtClase> listDtClase = new ArrayList<>();
			List<Clase> listClase = a.getClases();
			for(Clase c: listClase) {
				List<Registro> registros = c.getRegistros();
				ArrayList<DtRegistro> dtRegistros = new ArrayList<DtRegistro>();
				for(Registro r: registros) {									//Para cada clase, obtengo su lista de registros
					DtRegistro dtReg = new DtRegistro(r.getClase().getNombre(),r.getFecha());
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
			AD.addClase(clase);
			prof.addClase(clase);
		}else {
			throw new ClaseRepetidaExcepcion("Ya existe una Clase con ese nombre!");
		}
	}
	
	public void RegistroDictadoClase(String nomClase, String nomSocio, LocalDate fecha) throws RegistroRepetidoExcepcion{
			Clase clase = mc.buscarClase(nomClase);
			Socio socio = ms.buscarSocio(nomSocio);
			List<Registro> registros = socio.getRegistros();
			boolean existeReg = false;
			for(Registro r: registros) {
				if(r.getClase().getNombre() == clase.getNombre() && r.getFecha().equals(fecha) && r.getSocio().getNickname() == socio.getNickname()) {
					existeReg = true;
				}
			}
			if(!existeReg) {
				Registro reg = new Registro(fecha,socio,clase);
				socio.addRegistro(reg);
				clase.addRegistro(reg);
			}else {
				throw new RegistroRepetidoExcepcion("El socio ya esta registrado en esa clase!");
		}
	}
	
	public DtClase getDatosClase(String nomClase){
			Clase c = mc.buscarClase(nomClase);
			List<DtRegistro> listDtReg = new ArrayList<>();
			List<Registro> listReg = c.getRegistros();
			for(Registro r: listReg) {
				DtRegistro dtReg = new DtRegistro(r.getClase().getNombre(),r.getFecha());
				listDtReg.add(dtReg);
			}
			DtClase dtClase = new DtClase(c.getNombre(),c.getUrl(), listDtReg, c.getActividadDeportiva().getNombre(),c.getFecha(),c.getFechaReg(),c.getHoraInicio(),c.getProfesor().getNickname());
			return dtClase;
	}
	
	public DtClase ConsultaDictadoClase(String nomClase){
		DtClase dtClase = null;
		if(mc.existeClase(nomClase)) {
			dtClase = getDatosClase(nomClase);
		}
		return dtClase;
	}
	
	public List<DtClase> RankingDictadosClases(){
		List<DtClase> listDtClase = new ArrayList<>();
		List<Clase> listClase = mc.getClases();
		int pos;			//Selection sort
		Clase temp;
        for (int i = 0; i < listClase.size(); i++) { 	
            pos = i; 
            for (int j = i+1; j < listClase.size(); j++) {
            	Clase clase1 = listClase.get(j);
            	Clase clase2 = listClase.get(pos);
                if (mc.compareClases(clase1,clase2)) {
                    pos = j;
                }
            }

            temp = listClase.get(pos);
            listClase.set(pos, listClase.get(i)); 
            listClase.set(i, temp); 
        } 
        for(Clase c: listClase) {
        	List<DtRegistro> listDtReg = new ArrayList<>();
        	DtClase dtClase = new DtClase(c.getNombre(),c.getUrl(),listDtReg,c.getActividadDeportiva().getNombre(),c.getFecha(),c.getFechaReg(),c.getHoraInicio(),c.getProfesor().getNombre());
        	listDtClase.add(dtClase);
        }
        return listDtClase;
	}
	
	public String[] listarClasesActividadDeportiva(String actDep) {
		ActividadDeportiva AD = mad.buscarActividadDeportiva(actDep);
		List<Clase> clases = AD.getClases();
		String[] clases_ret = new String[clases.size()];
        int i=0;
        for(Clase c:clases) {
        	clases_ret[i]=c.getNombre();
        	i++;
        }
        return clases_ret;
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
	
	public String[] listarClasesProf(String nickname) {
		Profesor p = mp.buscarProfesor(nickname);
		List<Clase> clases = p.getClases();
		String[] clases_ret = new String[clases.size()];
        int i=0;
        for(Clase c: clases) {
        	clases_ret[i]=c.getNombre();
        	i++;
        }
        return clases_ret;
	}
	
	public String[] listarRegistrosSocio(String nickname) {
		Socio s = ms.buscarSocio(nickname);
		List<Registro> registros = s.getRegistros();
		String[] registros_ret = new String[registros.size()];
        int i=0;
        for(Registro r: registros) {
        	registros_ret[i]= r.getClase().getNombre();
        	i++;
        }
        return registros_ret;
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
	
	public String[] listarSocios() {
		ArrayList<String> socios;
		ManejadorSocio mS = ManejadorSocio.getInstancia();
		socios = mS.obtenerSocios();
		String[]socios_ret = new String[socios.size()];
        int i=0;
        for(String s:socios) {
        	socios_ret[i]=s;
        	i++;
        }
        return socios_ret;
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
	
	public DtInstitucionDeportiva getInstitucionDt(String nombre){
		InstitucionDeportiva instDep = mid.buscarInstitucionDeportiva(nombre);
		List<DtActividadDeportiva> actividades = listarActividades(nombre);
		
		List<DtProfesor> profesores = new ArrayList<>();
		List<Profesor> listProf = instDep.getProfesores();
		for(Profesor p: listProf) {
			DtProfesor dtProf = new DtProfesor(p.getNickname(),p.getNombre(),p.getApellido(),p.getEmail(),p.getFecha(),p.getDescripcion(),p.getBiografia(),p.getSitioWeb(),p.getInstitucionDeportiva().getNombre());
			profesores.add(dtProf);
		}	
		DtInstitucionDeportiva dtInst = new DtInstitucionDeportiva(instDep.getNombre(),instDep.getDescripcion(),instDep.getUrl(),actividades, profesores);
		return dtInst;
	}
	
	public ActividadDeportiva getAct(String nombre){
		ManejadorActividadDeportiva mAct = ManejadorActividadDeportiva.getInstancia();
		ActividadDeportiva actDep = mAct.buscarActividadDeportiva(nombre);
		return actDep;
	}
	
	public Clase getClase(String nombre){
		Clase c = mc.buscarClase(nombre);
		return c;
	}
	
	public Socio getSocio(String nombre){
		Socio s = ms.buscarSocio(nombre);
		return s;
	}
	
	public DtSocio findSocio(String name) {
		Socio s = ms.buscarSocio(name);
		List<Registro> registros = s.getRegistros();
		ArrayList<DtRegistro> dtRegistros = new ArrayList<DtRegistro>();
		for(Registro r: registros) {							
			DtRegistro dtReg = new DtRegistro(r.getClase().getNombre(),r.getFecha());
			dtRegistros.add(dtReg);
		}	
		DtSocio dtSocio = new DtSocio(s.getNickname(),s.getNombre(),s.getApellido(),s.getEmail(),s.getFecha(),dtRegistros);
		return dtSocio;
	}
	
	public DtProfesor findProfesor(String name) {
		Profesor p = mp.buscarProfesor(name);
		DtProfesor dtProf = new DtProfesor(p.getNickname(),p.getNombre(),p.getApellido(),p.getEmail(),p.getFecha(),p.getDescripcion(),p.getBiografia(),p.getSitioWeb(),p.getInstitucionDeportiva().toString());
		return dtProf;
	}
	
	public String[] listarActividades() {
		ArrayList<String> acts;
		acts = mad.obtenerActividades();
		String[] acts_ret = new String[acts.size()];
        int i=0;
        for(String s:acts) {
        	acts_ret[i]=s;
        	i++;
        }
        return acts_ret;
	
	}

	@Override
	public List<DtRegistro> getRegistrosSocio(String nombre) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<DtActividadDeportiva> listarActividades(DtInstitucionDeportiva dtID) {
		// TODO Auto-generated method stub
		return null;
	}

}

