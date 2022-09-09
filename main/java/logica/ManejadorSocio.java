package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorSocio {
	
	private static ManejadorSocio instancia = null;
	
	private ManejadorSocio() {}
	
	public static ManejadorSocio getInstancia() {
		if (instancia == null)
			instancia = new ManejadorSocio();
		return instancia;
	}
	
	public void addSocio(Socio socio) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(socio);
		
		em.getTransaction().commit();
	}
	
	public void modSocio(Socio soc) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.merge(soc);
		
		em.getTransaction().commit();
	}
	
	@SuppressWarnings("unchecked")
	public boolean existeEmail(String email) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		Query query = em.createQuery("select s from Socio s where s.email='"+email+"'");
		List<Socio> socios = query.getResultList();
		return (socios .size() != 0);
	}
	
	public boolean existeNickname(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Socio.class, nickname) != null;
	}
	
	public Socio buscarSocio(String nickname) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		return em.find(Socio.class, nickname);
	}
	
	
	public ArrayList<String> obtenerSocios(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select s from Socio s");
		@SuppressWarnings("unchecked")
		List<Socio> listSoc = (List<Socio>) query.getResultList();
		
		ArrayList<String> aRetornar = new ArrayList<>();
		
		for(Socio s: listSoc) {
			aRetornar.add(s.getNickname());
		}
		return aRetornar;
	}
}