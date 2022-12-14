package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorProfesor {
	
	private static ManejadorProfesor instancia = null;
	
	private ManejadorProfesor(){}
	
	public static ManejadorProfesor getInstancia() {
		if (instancia == null)
			instancia = new ManejadorProfesor();
		return instancia;
	}
	
	public void addProfesor(Profesor prof) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(prof);
		
		em.getTransaction().commit();
	}
	
	public void modProfesor(Profesor prof) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.merge(prof);
		
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public boolean existeEmail(String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select p from Profesor p where p.email='"+email+"'");
		List<Profesor> profesores = query.getResultList();
		return (profesores .size() != 0);
	}
	
	public boolean existeNickname(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Profesor.class, nickname) != null;
	}
	
	public Profesor buscarProfesor(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Profesor.class, nickname);
	}
	
	public List<Profesor> getProfesroresDeInstDep(InstitucionDeportiva ID){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select a from Profesor a");
		@SuppressWarnings("unchecked")
		List<Profesor> listProf = (List<Profesor>) query.getResultList();
		List<Profesor> ret = new ArrayList<>();
		for(Profesor p: listProf) {
			if(p.getInstitucionDeportiva() == ID) {
				ret.add(p);
			}
		}
		return ret;
	}
	
	
	public ArrayList<String> obtenerProfesores(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select s from Profesor s");
		@SuppressWarnings("unchecked")
		List<Profesor> listProf = (List<Profesor>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		
		for(Profesor p: listProf) {
			aRetornar.add(p.getNickname());
		}
		return aRetornar;
	}
	
}
