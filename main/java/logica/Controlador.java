package logica;

import java.util.ArrayList;
import java.util.List;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import interfaces.IControlador;

public class Controlador implements IControlador{
	public Controlador() {
		
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
	public void AltaActividadDeportiva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ConsultaActividadDeportiva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AltaDictadoClase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RegistroDictadoClase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void AltaInstitucionDeportiva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModificarDatosUsuario() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ConsultaDictadoClase() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModificarActividadDeportiva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ModificarInstitucionDeportiva() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RankingDictadoClases() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RankingActividadDeportiva() {
		// TODO Auto-generated method stub
		
	}
}
