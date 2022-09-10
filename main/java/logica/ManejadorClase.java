package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorClase {
	private static ManejadorClase instancia = null;

	
	public static ManejadorClase getInstancia() {
		if (instancia == null)
			instancia = new ManejadorClase();
		return instancia;
	}
	
	public Clase buscarClase (String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Clase.class, nombre);
	}
	
	public boolean existeClase (String nombre) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Clase.class, nombre) != null;
	}
	
	public ArrayList<String> obtenerClases(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select c from Clase c");
		@SuppressWarnings("unchecked")
		List<Clase> listClase = (List<Clase>) query.getResultList();
		ArrayList<String> aRetornar = new ArrayList<>();
		for(Clase a: listClase) {
			aRetornar.add(a.getNombre());
		}
		return aRetornar;
	}
	
	public void addClase(Clase c) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.persist(c);
		em.getTransaction().commit();
	}
	
	public void modClase(Clase c) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		em.merge(c);
		em.getTransaction().commit();
	}

	public List<Clase> getClases(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select c from Clase c");
		@SuppressWarnings("unchecked")
		List<Clase> listClase = (List<Clase>) query.getResultList();
		return listClase;
	}
	
	public Boolean compareClases(Clase a, Clase b) {
		return a.getRegistros().size() < b.getRegistros().size();
	}
}
