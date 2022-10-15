	package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControlador;
import datatypes.DtSocio;
import datatypes.DtProfesor;
import java.time.LocalDate;


/**
 * Servlet implementation class ModificarDatosUsuario
 */
@WebServlet("/ModificarDatosUsuario")
public class ModificarDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatosUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String nickname = (String) session.getAttribute("name");
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		DtUsuario dtUser = (icon.ConsultaUsuario(nickname));
		DtUsuario dtUserNew = null; 
		String nomUsuario = request.getParameter("nomUsuario");
		if (nomUsuario == null) {
			nomUsuario = dtUser.getNombre();
			}				
		String apeUsuario = request.getParameter("apeUsuario");
		if (apeUsuario == null) {
			apeUsuario = dtUser.getApellido();
			}
		String fNacUsuario = request.getParameter("fNacUsuario");
		String emailUsuario = dtUser.getEmail();
		LocalDate fNacUsuarioConv = LocalDate.parse(fNacUsuario);
		if (fNacUsuarioConv == null) {
			fNacUsuarioConv = dtUser.getFechaNac();
			}
		
	
		if(dtUser instanceof DtProfesor) {
			DtProfesor dtProf = (DtProfesor) dtUser;
			String descProf = request.getParameter("descProf");
			if (descProf == null) {
				descProf = dtProf.getDescripcion();
			}
			String bioProf = request.getParameter("bioProf");
			if (bioProf == null) {
				bioProf = dtProf.getBiografia();
			}
			String swProf = request.getParameter("swProf");
			if (swProf == null) {
				swProf = dtProf.getSitioweb();
			}
			DtProfesor dtProfNew = new DtProfesor(nickname, nomUsuario, apeUsuario, emailUsuario, fNacUsuarioConv, descProf, bioProf, swProf, dtProf.getInstitucionDeportiva(),);
			dtProfNew = (DtProfesor) dtUserNew;
		
		}else if(dtUser instanceof DtSocio) {
			DtSocio dtSoc = (DtSocio) dtUser;
			DtSocio dtSocioNew = (DtSocio) dtUserNew;
		}
			
		//el ID del usuario es recibido de la sesion creada por el caso de uso Inicio de Sesion
		RequestDispatcher rd;
		
			icon.ModificarDatosUsuario(dtUser, dtUserNew);
			rd= request.getRequestDispatcher("/ModificarDatosUsuarioPt2.jsp");
		
		doGet(request, response);
	}
}
