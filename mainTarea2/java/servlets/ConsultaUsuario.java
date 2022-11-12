package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.ControladorPublish;
import publicadores.ControladorPublishService;
import publicadores.ControladorPublishServiceLocator;

import publicadores.DtProfesor;
import publicadores.DtRegistro;
import publicadores.DtSocio;
import publicadores.DtUsuario;

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
		DtUsuario dtUser = null;
		try {
			dtUser = ConsultaUsuario(nickname);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		request.setAttribute("nickname", nickname);
		RequestDispatcher rd;
		if(dtUser == null) {
			//Mensaje de error
		}else if(dtUser instanceof DtProfesor) {
			DtProfesor dtProf = (DtProfesor) dtUser;
			request.setAttribute("nombre", dtProf.getNombre());
			request.setAttribute("apellido", dtProf.getApellido());
			request.setAttribute("email", dtProf.getEmail());
			Calendar cal = dtProf.getFechaNac();
		    String fechaNacc = new SimpleDateFormat ("dd-MM-yyyy").format(cal.getTime());
			request.setAttribute("fechaNac", fechaNacc);
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
			try {
				request.setAttribute("registros", getRegistrosSocio(dtSoc.getNickname()));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("imagen", Base64.getEncoder().encodeToString(dtSoc.getProfileImage()));
			rd = request.getRequestDispatcher("/ConsultaSocio.jsp");
			rd.forward(request, response);
		}
	}

	public DtUsuario ConsultaUsuario(String nickname) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.consultaUsuario(nickname);
	}
	
	public DtRegistro[] getRegistrosSocio(String nickname) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.getRegistrosSocio(nickname);
	}
}
