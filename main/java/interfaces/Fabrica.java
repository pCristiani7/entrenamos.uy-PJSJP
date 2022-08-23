package interfaces;

import logica.Controlador;

public class Fabrica {
	private static Fabrica instancia = null;

	private Fabrica(){}	
	
	public static Fabrica getInstance(){
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;	
	}
	
	public IControlador getIControladorActividadDeportiva() {
		return new Controlador();
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

