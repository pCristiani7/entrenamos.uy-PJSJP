package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorProfesor {
	
	private static ManejadorProfesor instancia = null;
	private List<Profesor> profesores = new ArrayList<>();
	
	
	public static ManejadorProfesor getInstancia() {
		if (instancia == null)
			instancia = new ManejadorProfesor();
		return instancia;
	}
	
	public void addProfesor(Profesor prof) {
		profesores.add(prof);
	}
	
	public boolean existeEmail(String email) {
		boolean encontre = false;
		for(Profesor p: profesores) {
			if(p.getEmail().equals(email))
				encontre = true;
		}
		return encontre;
	}
	
	public boolean existeNickname(String nickname) {
		boolean encontre = false;
		for(Profesor p: profesores) {
			if(p.getNickname().equals(nickname))
				encontre = true;
		}
		return encontre;
	}
	
}
