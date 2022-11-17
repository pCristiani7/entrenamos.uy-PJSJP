/**
 * ControladorPublish.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package publicadores;

public interface ControladorPublish extends java.rmi.Remote {
    public java.lang.String[] listarInstituciones() throws java.rmi.RemoteException;
    public java.lang.String[] listarProfesoresFront() throws java.rmi.RemoteException;
    public void altaInsitucionDeportiva(publicadores.DtInstitucionDeportiva arg0) throws java.rmi.RemoteException, publicadores.InstitucionDeportivaRepetidaExcepcion;
    public void altaActividadDeportiva(publicadores.DtActividadDeportiva arg0) throws java.rmi.RemoteException, publicadores.ActividadDeportivaRepetidaExcepcion;
    public java.lang.String[] listarInstitucionesConActYProf() throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva[] getActividadesInstitucion(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarRegistrosSocio(java.lang.String arg0) throws java.rmi.RemoteException;
    public void registroDictadoClase(java.lang.String arg0, java.lang.String arg1, java.util.Calendar arg2) throws java.rmi.RemoteException, publicadores.RegistroRepetidoExcepcion;
    public publicadores.DtProfesor[] getProfesoresInstitucion(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarInstitucionesConActYClases() throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva consultaActividadDeportiva(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarClasesActividadDeportiva(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarInstitucionesConAct() throws java.rmi.RemoteException;
    public boolean modificarDatosUsuario(publicadores.DtUsuario arg0, publicadores.DtUsuario arg1) throws java.rmi.RemoteException;
    public boolean modificarActividadDeportiva(java.lang.String arg0, publicadores.DtActividadDeportiva arg1) throws java.rmi.RemoteException;
    public publicadores.DtActividadDeportiva[] rankingActividadesDeportivas() throws java.rmi.RemoteException;
    public publicadores.DtClase consultaDictadoClase(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase[] rankingDictadosClases() throws java.rmi.RemoteException;
    public boolean modificarInstitucionDeportiva(java.lang.String arg0, publicadores.DtInstitucionDeportiva arg1) throws java.rmi.RemoteException;
    public java.lang.String[] listarClasesProf(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarUsuarios() throws java.rmi.RemoteException;
    public publicadores.DtInstitucionDeportiva getInstitucionDt(java.lang.String arg0) throws java.rmi.RemoteException;
    public void altaDictadoClase(publicadores.DtActividadDeportiva arg0, publicadores.DtClase arg1) throws java.rmi.RemoteException, publicadores.ClaseRepetidaExcepcion;
    public publicadores.Socio getSocio(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtClase getDatosClase(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtRegistro[] getRegistrosClase(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarSocios() throws java.rmi.RemoteException;
    public java.lang.String[] listarSociosFront() throws java.rmi.RemoteException;
    public publicadores.DtUsuario consultaUsuario(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtProfesor findProfesor(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtSocio findSocio(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarActividades() throws java.rmi.RemoteException;
    public publicadores.DtClase[] getClasesActDep(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarActsFront() throws java.rmi.RemoteException;
    public java.lang.String[] listarClasesFront() throws java.rmi.RemoteException;
    public void altaUsuario(publicadores.DtUsuario arg0, java.lang.String arg1) throws java.rmi.RemoteException, publicadores.UsuarioRepetidoExcepcion;
    public publicadores.Clase getClase(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean inicioSesion(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public java.lang.String[] listarProfesores() throws java.rmi.RemoteException;
    public void eliminarRegistro(java.lang.String arg0, java.lang.String arg1) throws java.rmi.RemoteException;
    public boolean existeMail(java.lang.String arg0) throws java.rmi.RemoteException;
    public boolean existeNickname(java.lang.String arg0) throws java.rmi.RemoteException;
    public java.lang.String[] listarClases() throws java.rmi.RemoteException;
    public publicadores.ActividadDeportiva getAct(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.InstitucionDeportiva getInstitucion(java.lang.String arg0) throws java.rmi.RemoteException;
    public publicadores.DtRegistro[] getRegistrosSocio(java.lang.String arg0) throws java.rmi.RemoteException;
}
