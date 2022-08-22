package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorSocio {
	
	private static ManejadorSocio instancia = null;
	private List<Socio> socios = new ArrayList<>();
	
	
	public static ManejadorSocio getInstancia() {
		if (instancia == null)
			instancia = new ManejadorSocio();
		return instancia;
	}
	
	public void addSocio(Socio socio) {
		socios.add(socio);
	}
	
	public void removeSocio(Socio socio){
		socios.remove(socio);
	}
	
	public boolean existeEmail(String email) {
		boolean encontre = false;
		for(Socio s: socios) {
			if(s.getEmail().equals(email))
				encontre = true;
		}
		return encontre;
	}
	
	public boolean existeNickname(String nickname) {
		boolean encontre = false;
		for(Socio s: socios) {
			if(s.getNickname().equals(nickname))
				encontre = true;
		}
		return encontre;
	}
	
	public Socio buscarSocio(String nickname) {
		Socio x = null;
		for(Socio s: socios) {
			if(s.getNickname().equals(nickname))
				return s;
		}
		return x;
	}
}