package persistencia;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

<<<<<<< HEAD
import interfaces.Fabrica;
import interfaces.IControlador;
import logica.Controlador;

=======
>>>>>>> ce3e71320ed301ba79f58d857d6ce6226f60ec49
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
	
<<<<<<< HEAD
=======
	@SuppressWarnings("static-access")
>>>>>>> ce3e71320ed301ba79f58d857d6ce6226f60ec49
	public EntityManager getEntityManager() {
		return this.em;
	}
	
<<<<<<< HEAD
=======
	@SuppressWarnings("static-access")
>>>>>>> ce3e71320ed301ba79f58d857d6ce6226f60ec49
	public void close() {
		this.em.close();
		this.emf.close();
	}


}
