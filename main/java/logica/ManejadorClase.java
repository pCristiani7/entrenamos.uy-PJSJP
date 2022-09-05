package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorClase {
	private static ManejadorClase instancia = null;
	private List<Clase> clases = new ArrayList<>();
	
	public static ManejadorClase getInstancia() {
		if (instancia == null)
			instancia = new ManejadorClase();
		return instancia;
	}
	
	public Clase buscarClase (String nombre) {
		Clase x = null;
		for(Clase c: clases) {
			if(c.getNombre().equals(nombre))
				return c;
		}
		return x;
	}
	
	public boolean existeClase (String nombre) {
		boolean existe = false;
		for(Clase c: clases) {
			if(c.getNombre().equals(nombre))
				existe = true;
		}
		return existe;
	}
	
	public ArrayList<String> obtenerClases(){
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Clase a: clases) {
			aRetornar.add(a.getNombre());
		}
		return aRetornar;
	}
	
	public void addClase(Clase c) {
		clases.add(c);
	}
	
	public void removeClase (Clase c){
		clases.remove(c);
	}
	
	public List<Clase> getClases(){
		return this.clases;
	}
	
	public Boolean compareClases(Clase a, Clase b) {
		return a.getRegistros().size() < b.getRegistros().size();
	}
	
}
