package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import interfaces.IControladorUsuario;

public class ControladorUsuario implements IControladorUsuario{

	ManejadorInstitucionDeportiva mid = ManejadorInstitucionDeportiva.getInstancia();
	ManejadorProfesor mp = ManejadorProfesor.getInstancia();
	ManejadorSocio ms = ManejadorSocio.getInstancia();
	
	public ControladorUsuario() {
		
	}

	public boolean existeMail(String email) {
		return (mp.existeEmail(email) || ms.existeEmail(email));
	}
	
	public boolean existeNickname(String nickname) {
		return (mp.existeNickname(nickname) || ms.existeNickname(nickname));
	}
	
	@Override
	public void AltaUsuario(DtUsuario dtUser) {
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
			//THROW INVALIDUSER
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
	public void ModificarDatosUsuario() {
		// TODO Auto-generated method stub
		
	}
}