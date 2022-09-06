package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorInstitucionDeportiva {
	private static ManejadorInstitucionDeportiva instancia = null;
	
	private ManejadorInstitucionDeportiva(){}
	
	public static ManejadorInstitucionDeportiva getInstancia() {
		if (instancia == null)
			instancia = new ManejadorInstitucionDeportiva();
		return instancia;
	}
	
	public void addIntitucionDeportiva(InstitucionDeportiva instDep) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(instDep);
		
		em.getTransaction().commit();
	}
	
	public boolean existeNickname(String nombre) {
		boolean encontre = false;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select s from InstitucionDeportiva s");
		@SuppressWarnings("unchecked")
		List<InstitucionDeportiva> listInstDep = (List<InstitucionDeportiva>) query.getResultList();
		
		for(InstitucionDeportiva p: listInstDep) {
			if(p.getNombre().equals(nombre))
				encontre = true;
		}
		return encontre;
	}
	
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		InstitucionDeportiva instDep = em.find(InstitucionDeportiva.class, nombre);
		return instDep;
	}
	
	public String retornarNomInstDep(String nombre) {
		String nomProf = null;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select s from InstitucionDeportiva s");
		@SuppressWarnings("unchecked")
		List<InstitucionDeportiva> listInstDep = (List<InstitucionDeportiva>) query.getResultList();
		
		for(InstitucionDeportiva id: listInstDep) {
			if(id.getNombre().equals(nombre))
				nomProf = id.getNombre();
		}
		return nomProf;
	}
	
	public ArrayList<String> obtenerInstituciones(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select s from InstitucionDeportiva s");
		@SuppressWarnings("unchecked")
		List<InstitucionDeportiva> listInstDep = (List<InstitucionDeportiva>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		
		for(InstitucionDeportiva id: listInstDep) {
			aRetornar.add(id.getNombre());
		}
		return aRetornar;
	}
}
