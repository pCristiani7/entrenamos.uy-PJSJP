package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorInstitucionDeportiva {
	
	private static ManejadorInstitucionDeportiva instancia = null;
	private List<InstitucionDeportiva> institucionesDeportivas= new ArrayList<>();
	
	
	public static ManejadorInstitucionDeportiva getInstancia() {
		if (instancia == null)
			instancia = new ManejadorInstitucionDeportiva();
		return instancia;
	}
	
	public void addProfesor(InstitucionDeportiva instDep) {
		institucionesDeportivas.add(instDep);
	}
	
	public void removeProfesor(InstitucionDeportiva instDep){
		institucionesDeportivas.remove(instDep);
	}
	
	public boolean existeNickname(String nombre) {
		boolean encontre = false;
		for(InstitucionDeportiva p: institucionesDeportivas) {
			if(p.getNombre().equals(nombre))
				encontre = true;
		}
		return encontre;
	}
	
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		InstitucionDeportiva x = null;
		for(InstitucionDeportiva p: institucionesDeportivas) {
			if(p.getNombre().equals(nombre))
				return p;
		}
		return x;
	}
	
	public String retornarNomInstDep(String nombre) {
		String nomProf = null;
		for(InstitucionDeportiva id: institucionesDeportivas) {
			if(id.getNombre().equals(nombre))
				nomProf = id.getNombre();
		}
		return nomProf;
	}
}
