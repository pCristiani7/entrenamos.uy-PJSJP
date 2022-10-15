package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		request.setAttribute("nombre", dtUser.getNombre());
		request.setAttribute("apellido", dtUser.getApellido());
		request.setAttribute("email", dtUser.getEmail());
		request.setAttribute("fechaNac", dtUser.getFechaNac());
		RequestDispatcher rd;
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
	}

}
