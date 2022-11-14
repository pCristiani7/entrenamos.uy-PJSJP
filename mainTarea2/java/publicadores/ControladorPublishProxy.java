package publicadores;

public class ControladorPublishProxy implements publicadores.ControladorPublish {
  private String _endpoint = null;
  private publicadores.ControladorPublish controladorPublish = null;
  
  public ControladorPublishProxy() {
    _initControladorPublishProxy();
  }
  
  public ControladorPublishProxy(String endpoint) {
    _endpoint = endpoint;
    _initControladorPublishProxy();
  }
  
  private void _initControladorPublishProxy() {
    try {
      controladorPublish = (new publicadores.ControladorPublishServiceLocator()).getControladorPublishPort();
      if (controladorPublish != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)controladorPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)controladorPublish)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (controladorPublish != null)
      ((javax.xml.rpc.Stub)controladorPublish)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public publicadores.ControladorPublish getControladorPublish() {
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish;
  }
  
  public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarInstituciones();
  }
  
  public java.lang.String[] listarProfesoresFront() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarProfesoresFront();
  }
  
  public void altaInsitucionDeportiva(publicadores.DtInstitucionDeportiva arg0) throws java.rmi.RemoteException, publicadores.InstitucionDeportivaRepetidaExcepcion{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    controladorPublish.altaInsitucionDeportiva(arg0);
  }
  
  public void altaActividadDeportiva(publicadores.DtActividadDeportiva arg0) throws java.rmi.RemoteException, publicadores.ActividadDeportivaRepetidaExcepcion{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    controladorPublish.altaActividadDeportiva(arg0);
  }
  
  public java.lang.String[] listarInstitucionesConActYProf() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarInstitucionesConActYProf();
  }
  
  public publicadores.DtActividadDeportiva[] getActividadesInstitucion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getActividadesInstitucion(arg0);
  }
  
  public java.lang.String[] listarRegistrosSocio(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarRegistrosSocio(arg0);
  }
  
  public void registroDictadoClase(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2) throws java.rmi.RemoteException, publicadores.RegistroRepetidoExcepcion{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    controladorPublish.registroDictadoClase(arg0, arg1, arg2);
  }
  
  public publicadores.DtProfesor[] getProfesoresInstitucion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getProfesoresInstitucion(arg0);
  }
  
  public java.lang.String[] listarInstitucionesConActYClases() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarInstitucionesConActYClases();
  }
  
  public publicadores.DtActividadDeportiva consultaActividadDeportiva(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.consultaActividadDeportiva(arg0);
  }
  
  public java.lang.String[] listarClasesActividadDeportiva(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarClasesActividadDeportiva(arg0);
  }
  
  public java.lang.String[] listarInstitucionesConAct() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarInstitucionesConAct();
  }
  
  public boolean modificarDatosUsuario(publicadores.DtUsuario arg0, publicadores.DtUsuario arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.modificarDatosUsuario(arg0, arg1);
  }
  
  public boolean modificarActividadDeportiva(java.lang.String arg0, publicadores.DtActividadDeportiva arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.modificarActividadDeportiva(arg0, arg1);
  }
  
  public publicadores.DtActividadDeportiva[] rankingActividadesDeportivas() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.rankingActividadesDeportivas();
  }
  
  public publicadores.DtClase consultaDictadoClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.consultaDictadoClase(arg0);
  }
  
  public publicadores.DtClase[] rankingDictadosClases() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.rankingDictadosClases();
  }
  
  public boolean modificarInstitucionDeportiva(java.lang.String arg0, publicadores.DtInstitucionDeportiva arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.modificarInstitucionDeportiva(arg0, arg1);
  }
  
  public java.lang.String[] listarClasesProf(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarClasesProf(arg0);
  }
  
  public java.lang.String[] listarUsuarios() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarUsuarios();
  }
  
  public publicadores.DtInstitucionDeportiva getInstitucionDt(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getInstitucionDt(arg0);
  }
  
  public void altaDictadoClase(publicadores.DtActividadDeportiva arg0, publicadores.DtClase arg1) throws java.rmi.RemoteException, publicadores.ClaseRepetidaExcepcion{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    controladorPublish.altaDictadoClase(arg0, arg1);
  }
  
  public publicadores.Socio getSocio(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getSocio(arg0);
  }
  
  public publicadores.DtClase getDatosClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getDatosClase(arg0);
  }
  
  public publicadores.DtRegistro[] getRegistrosClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getRegistrosClase(arg0);
  }
  
  public java.lang.String[] listarSocios() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarSocios();
  }
  
  public java.lang.String[] listarSociosFront() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarSociosFront();
  }
  
  public publicadores.DtUsuario consultaUsuario(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.consultaUsuario(arg0);
  }
  
  public publicadores.DtProfesor findProfesor(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.findProfesor(arg0);
  }
  
  public publicadores.DtSocio findSocio(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.findSocio(arg0);
  }
  
  public java.lang.String[] listarActividades() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarActividades();
  }
  
  public publicadores.DtClase[] getClasesActDep(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getClasesActDep(arg0);
  }
  
  public java.lang.String[] listarActsFront() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarActsFront();
  }
  
  public java.lang.String[] listarClasesFront() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarClasesFront();
  }
  
  public void altaUsuario(publicadores.DtUsuario arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoExcepcion{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    controladorPublish.altaUsuario(arg0, arg1);
  }
  
  public publicadores.Clase getClase(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getClase(arg0);
  }
  
  public boolean inicioSesion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.inicioSesion(arg0, arg1);
  }
  
  public java.lang.String[] listarProfesores() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarProfesores();
  }
  
  public void eliminarRegistro(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    controladorPublish.eliminarRegistro(arg0, arg1);
  }
  
  public boolean existeMail(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.existeMail(arg0);
  }
  
  public boolean existeNickname(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.existeNickname(arg0);
  }
  
  public java.lang.String[] listarClases() throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.listarClases();
  }
  
  public publicadores.ActividadDeportiva getAct(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getAct(arg0);
  }
  
  public publicadores.InstitucionDeportiva getInstitucion(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getInstitucion(arg0);
  }
  
  public publicadores.DtRegistro[] getRegistrosSocio(java.lang.String arg0) throws java.rmi.RemoteException{
    if (controladorPublish == null)
      _initControladorPublishProxy();
    return controladorPublish.getRegistrosSocio(arg0);
  }
  
  
}