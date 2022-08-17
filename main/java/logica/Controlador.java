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

	@Override
	public void AltaUsuario(DtUsuario dtUser) {
		// TODO Auto-generated method stub
		
		if(dtUser instanceof DtProfesor){
			List<Clase> clases = new ArrayList<>();
			DtProfesor dtProf = (DtProfesor) dtUser;
			Profesor prof = new Profesor(dtProf.getNickname(),dtProf.getNombre(),dtProf.getApellido(),dtProf.getEmail(),dtProf.getFechaNac(),dtProf.getDescripcion(),dtProf.getBiografia(),dtProf.getSitioweb(),clases,dtProf.getInstitucionDeportiva() ); //AGREGAR LOS DATOS PARA EL CONTRUCTOR
			//Agregar al manejador profesor
		}else if(dtUser instanceof DtSocio){
			List<Registro> registros = new ArrayList<>();
			DtSocio dtSocio = (DtSocio) dtUser;
			Socio socio = new Socio(dtSocio.getNickname(),dtSocio.getNombre(),dtSocio.getApellido(),dtSocio.getEmail(),dtSocio.getFechaNac(),registros);//AGREGAR LOS DATOS PARA EL CONTRUCTOR
			//Agregar al manejador socio
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
