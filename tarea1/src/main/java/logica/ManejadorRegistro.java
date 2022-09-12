package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import persistencia.Conexion;

public class ManejadorRegistro {
	private static ManejadorRegistro instancia = null;
	
	private ManejadorRegistro(){}
	
	public static ManejadorRegistro getInstancia() {
		if (instancia == null)
			instancia = new ManejadorRegistro();
		return instancia;
	}
	
	public void addRegisistro (Registro reg) {
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		em.getTransaction().begin();
		
		em.persist(reg);
		
		em.getTransaction().commit();
	}
	
	public List<Registro> getRegistros(){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select s from Registro s");
		@SuppressWarnings("unchecked")
		List<Registro> registros = (List<Registro>) query.getResultList();
		return registros;
	}
	
	public List<Registro> getRegistrosSocio(Socio s){
		Conexion conexion = Conexion.getInstancia();
		EntityManager em = conexion.getEntityManager();
		
		Query query = em.createQuery("select s from Registro s");
		@SuppressWarnings("unchecked")
		List<Registro> registros = (List<Registro>) query.getResultList();
		List<Registro> registrosSocio = new ArrayList<>();
		for(Registro r: registros) {
			if(r.getSocio() == s) {
				registrosSocio.add(r);
			}
		}
		return registrosSocio;
	}
}
