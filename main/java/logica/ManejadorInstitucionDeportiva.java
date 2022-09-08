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
	
	public void modIntitucionDeportiva(InstitucionDeportiva instDep) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.merge(instDep);
		
		em.getTransaction().commit();
	}
	
	public boolean existeNickname(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(InstitucionDeportiva.class, nombre) != null;
	}
	
	public InstitucionDeportiva buscarInstitucionDeportiva(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(InstitucionDeportiva.class, nombre);
	}
	
	public String retornarNomInstDep(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		return em.find(InstitucionDeportiva.class, nombre).getNombre();
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
