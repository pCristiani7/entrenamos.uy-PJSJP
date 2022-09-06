package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import interfaces.Fabrica;
import interfaces.IControlador;
import logica.Controlador;

public class Conexion {
	private static Conexion instancia = null;
	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	private Conexion(){}
	
	public static Conexion getInstancia() {
		if (instancia == null) {
			instancia = new Conexion();
			emf = Persistence.createEntityManagerFactory("gymhibernate");
			em=emf.createEntityManager();
		}
		return instancia;
	}
	
	public EntityManager getEntityManager() {
		return this.em;
	}
	
	public void close() {
		this.em.close();
		this.emf.close();
	}


}
