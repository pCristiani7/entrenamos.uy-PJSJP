package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
			DtProfesor dtProfNew = new DtProfesor(nickname, nomUsuario, apeUsuario, emailUsuario, fNacUsuarioConv, descProf, bioProf, swProf, null);
			dtProfNew = (DtProfesor) dtUserNew;
		
		
		
		}else if(dtUser instanceof DtSocio) {
			DtSocio dtSoc = (DtSocio) dtUser;
			DtSocio dtSocioNew = (DtSocio) dtUserNew;
		}
		
		
		RequestDispatcher rd;
		
			icon.ModificarDatosUsuario(dtUser, dtUserNew);
			request.setAttribute("nickname", nickname);
			request.setAttribute("nombre", dtUser.getNombre());
			request.setAttribute("apellido", dtUser.getApellido());
			request.setAttribute("email", dtUser.getEmail());
			request.setAttribute("fechaNac", dtUser.getFechaNac());
			if(dtUser instanceof DtProfesor) {
				DtProfesor dtProf = (DtProfesor) dtUser;
				request.setAttribute("descripcion", dtProf.getDescripcion());
				request.setAttribute("biografia", dtProf.getBiografia());
				request.setAttribute("sitioweb", dtProf.getSitioweb());
				request.setAttribute("instDep", dtProf.getInstitucionDeportiva());
				rd = request.getRequestDispatcher("/ConsultaProfesor.jsp");
				rd.forward(request, response);
			}else if(dtUser instanceof DtSocio) {
				DtSocio dtSoc = (DtSocio) dtUser;
				request.setAttribute("registros", dtSoc.getDtRegistros());
				rd = request.getRequestDispatcher("/ConsultaSocio.jsp");
				rd.forward(request, response);
			}
			
		doGet(request, response);
	}
}
