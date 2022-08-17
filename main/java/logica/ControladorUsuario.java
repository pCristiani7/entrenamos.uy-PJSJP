package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import interfaces.IControladorUsuario;

public class ControladorUsuario implements IControladorUsuario{
	public ControladorUsuario() {
		
	}

	public boolean existeMail(String email) {
		ManejadorProfesor mp = ManejadorProfesor.getInstancia();
		ManejadorSocio ms = ManejadorSocio.getInstancia();
		return (mp.existeEmail(email) || ms.existeEmail(email));
	}
	
	public boolean existeNickname(String nickname) {
		ManejadorProfesor mp = ManejadorProfesor.getInstancia();
		ManejadorSocio ms = ManejadorSocio.getInstancia();
		return (mp.existeNickname(nickname) || ms.existeNickname(nickname));
	}
	
	@Override
	public void AltaUsuario(DtUsuario dtUser) {
		// TODO Auto-generated method stub
		if(!existeMail(dtUser.getEmail()) || !existeNickname(dtUser.getNickname())) {
			if(dtUser instanceof DtProfesor){
				List<Clase> clases = new ArrayList<>();
				DtProfesor dtProf = (DtProfesor) dtUser;
				Profesor prof = new Profesor(dtProf.getNickname(),dtProf.getNombre(),dtProf.getApellido(),dtProf.getEmail(),dtProf.getFechaNac(),dtProf.getDescripcion(),dtProf.getBiografia(),dtProf.getSitioweb(),clases,dtProf.getInstitucionDeportiva() ); 
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
			//printear mensaje.
		}
	}

	@Override
	public void ConsultaUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModificarDatosUsuario() {
		// TODO Auto-generated method stub
		
	}
}