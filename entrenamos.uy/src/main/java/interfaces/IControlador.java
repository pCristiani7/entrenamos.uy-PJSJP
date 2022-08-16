package interfaces;

public interface IControlador {
	
	public void AltaUsuario();
	public void ConsultaUsuario();
	public void AltaActividadDeportiva();
	public void ConsultaActividadDeportiva();
	public void AltaDictadoClase();
	public void RegistroDictadoClase();
	public void AltaInstitucionDeportiva();
	
	//Opcionales
	
	public void ModificarDatosUsuario();
	public void ConsultaDictadoClase();
	public void ModificarActividadDeportiva();
	public void ModificarInstitucionDeportiva();
	public void RankingDictadoClases();
	public void RankingActividadDeportiva();
}
