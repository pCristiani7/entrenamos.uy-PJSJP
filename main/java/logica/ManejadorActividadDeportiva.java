package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorActividadDeportiva {
	
	private static ManejadorActividadDeportiva instancia = null;
	
	public static ManejadorActividadDeportiva getInstancia() {
		if (instancia == null)
			instancia = new ManejadorActividadDeportiva();
		return instancia;
	}
	
	public ActividadDeportiva buscarActividadDeportiva(String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a from ActividadDeportiva a");
		@SuppressWarnings("unchecked")
		List<ActividadDeportiva> listActividad = (List<ActividadDeportiva>) query.getResultList();
		for(ActividadDeportiva actDep: listActividad) {
			if(actDep.getNombre().equals(nombre))
				return actDep;
		}
		return null;
	}
	
	public boolean existeNombre(String nombre) {
		boolean encontre = false;
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a from ActividadDeportiva a");
		@SuppressWarnings("unchecked")
		List<ActividadDeportiva> listActividad = (List<ActividadDeportiva>) query.getResultList();
		for(ActividadDeportiva a: listActividad) {
			if(a.getNombre().equals(nombre))
				encontre = true;
		}
		return encontre;
	}
	
	public ArrayList<String> obtenerActividades(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a from ActividadDeportiva a");
		@SuppressWarnings("unchecked")
		List<ActividadDeportiva> listActividad = (List<ActividadDeportiva>) query.getResultList();
		ArrayList<String> aRetornar = new ArrayList<>();
		for(ActividadDeportiva a: listActividad) {
			aRetornar.add(a.getNombre());
		}
		return aRetornar;
	}
	
	public void addActividadDeportiva(ActividadDeportiva actDep) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(actDep);
		em.getTransaction().commit();
	}
	
	public List<ActividadDeportiva> getActividades(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a from ActividadDeportiva a");
		@SuppressWarnings("unchecked")
		List<ActividadDeportiva> listActividad = (List<ActividadDeportiva>) query.getResultList();
		return listActividad;
	}
	
	public Boolean compareActividades(ActividadDeportiva a, ActividadDeportiva b) {
		return a.getCantClases() < b.getCantClases();
	}
}
