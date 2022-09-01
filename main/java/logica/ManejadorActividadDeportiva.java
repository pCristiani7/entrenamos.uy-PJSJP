package logica;

import java.util.ArrayList;
import java.util.List;

public class ManejadorActividadDeportiva {
	
	private static ManejadorActividadDeportiva instancia = null;
	private List<ActividadDeportiva> actividadesDeportivas = new ArrayList<>();
	
	public static ManejadorActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new ManejadorActividadDeportiva();
		return instancia;
	}
	
	public ActividadDeportiva buscarActividadDeportiva(String nombre) {
		for(ActividadDeportiva actDep: actividadesDeportivas) {
			if(actDep.getNombre().equals(nombre))
				return actDep;
		}
		return null;
	}
	
	public boolean existeNombre(String nombre) {
		boolean encontre = false;
		for(ActividadDeportiva a: actividadesDeportivas) {
			if(a.getNombre().equals(nombre))
				encontre = true;
		}
		return encontre;
	}
	
	public ArrayList<String> obtenerActividades(){
		ArrayList<String> aRetornar = new ArrayList<>();
		for(ActividadDeportiva a: actividadesDeportivas) {
			aRetornar.add(a.getNombre());
		}
		return aRetornar;
	}
	
	public void addActividadDeportiva(ActividadDeportiva actDep) {
		actividadesDeportivas.add(actDep);
	}
	
	public void removeActividadDeportiva (ActividadDeportiva actDep){
		actividadesDeportivas.remove(actDep);
	}
	
	public List<ActividadDeportiva> getActividades(){
		return this.actividadesDeportivas;
	}
	
	public Boolean compareActividades(ActividadDeportiva a, ActividadDeportiva b) {
		return a.getCantClases() < b.getCantClases();
	}
	
}
