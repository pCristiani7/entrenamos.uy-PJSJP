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
		ActividadDeportiva x = null;
		for(ActividadDeportiva actDep: actividadesDeportivas) {
			if(actDep.getNombre().equals(nombre))
				return actDep;
		}
		return x;
	}
	
	public void addActividadDeportiva(ActividadDeportiva actDep) {
		actividadesDeportivas.add(actDep);
	}
	
	public void removeActividadDeportiva (ActividadDeportiva actDep){
		actividadesDeportivas.remove(actDep);
	}
	
}
