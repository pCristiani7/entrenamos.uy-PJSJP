package servlets;

import java.io.IOException;
import java.util.Base64;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControlador;

/**
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
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
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
		String nickname = (String) session.getAttribute("name");
		Fabrica fab = Fabrica.getInstance();
		IControlador icon = fab.getIControlador();
		
		DtUsuario dtUser = icon.ConsultaUsuario(nickname);
		request.setAttribute("nickname", nickname);
		RequestDispatcher rd;
		if(dtUser == null) {
			//Mensaje de error
		}else if(dtUser instanceof DtProfesor) {
			DtProfesor dtProf = (DtProfesor) dtUser;
			request.setAttribute("nombre", dtProf.getNombre());
			request.setAttribute("apellido", dtProf.getApellido());
			request.setAttribute("email", dtProf.getEmail());
			request.setAttribute("fechaNac", dtProf.getFechaNac());
			request.setAttribute("descripcion", dtProf.getDescripcion());
			request.setAttribute("biografia", dtProf.getBiografia());
			request.setAttribute("sitioweb", dtProf.getSitioweb());
			request.setAttribute("instDep", dtProf.getInstitucionDeportiva());
			request.setAttribute("imagen", Base64.getEncoder().encodeToString(dtProf.getProfileImage()));
			rd = request.getRequestDispatcher("/ConsultaProfesor.jsp");
			rd.forward(request, response);
		}else if(dtUser instanceof DtSocio) {
			DtSocio dtSoc = (DtSocio) dtUser;
			request.setAttribute("nombre", dtSoc.getNombre());
			request.setAttribute("apellido", dtSoc.getApellido());
			request.setAttribute("email", dtSoc.getEmail());
			request.setAttribute("fechaNac", dtSoc.getFechaNac());
			request.setAttribute("registros", icon.getRegistrosSocio(dtSoc.getNombre()));
			request.setAttribute("imagen", Base64.getEncoder().encodeToString(dtSoc.getProfileImage()));
			rd = request.getRequestDispatcher("/ConsultaSocio.jsp");
			rd.forward(request, response);
		}
	}

}
