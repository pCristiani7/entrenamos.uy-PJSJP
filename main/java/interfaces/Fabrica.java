package interfaces;

import logica.ControladorActividadDeportiva;
import logica.ControladorClase;
import logica.ControladorInstitucionDeportiva;
import logica.ControladorUsuario;

public class Fabrica {
	private static Fabrica instancia = null;

	private Fabrica(){}	
	
	public static Fabrica getInstance(){
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;	
	}
	
	public IControladorUsuario getIControladorActividadDeportiva() {
		return new ControladorUsuario();
	}
	public IControladorActividadDeportiva getIControladorUsuario() {
		return new ControladorActividadDeportiva();
	}
    public IControladorClase getIControladorDictadoClase(){
    	return new ControladorClase();
     }
    public IControladorInstitucionDeportiva getIControladorInstitucionDeportiva() {
    	return new ControladorInstitucionDeportiva();
    }
}

