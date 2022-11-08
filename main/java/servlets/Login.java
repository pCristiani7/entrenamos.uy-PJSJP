package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import datatypes.DtUsuario;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import interfaces.Fabrica;
import interfaces.IControlador;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		PrintWriter out = response.getWriter();
		String nickname = request.getParameter("nick");
		String password = request.getParameter("pass");
		Fabrica fab = Fabrica.getInstance();
		IControlador iCon = fab.getIControlador();
		RequestDispatcher rd;
		
		try {
			if(iCon.inicioSesion(nickname, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("name", nickname);
				DtUsuario dtUser = iCon.ConsultaUsuario(nickname);
				
	            if(dtUser instanceof DtProfesor) {
	            	DtProfesor DtProf = (DtProfesor) dtUser;
	            	String user = "profesor";
	            	session.setAttribute("email", DtProf.getEmail());
					request.setAttribute("nickname", nickname);
		            request.setAttribute("apellido", DtProf.getApellido());
		            request.setAttribute("email", DtProf.getEmail());
		            request.setAttribute("nombre", DtProf.getNombre());
	            	session.setAttribute("tipoUsuario",user);
	            	rd = request.getRequestDispatcher("/profesorPage.jsp");
	            	rd.forward(request, response);
	            }else if(dtUser instanceof DtSocio) {
	            	DtSocio DtSoc = (DtSocio) dtUser;
	            	String user = "socio";
	            	session.setAttribute("email", DtSoc.getEmail());
					request.setAttribute("nickname", nickname);
		            request.setAttribute("apellido", DtSoc.getApellido());
		            request.setAttribute("email", DtSoc.getEmail());
		            request.setAttribute("nombre", DtSoc.getNombre());
	            	session.setAttribute("tipoUsuario",user);
	            	rd = request.getRequestDispatcher("/socioPage.jsp");
	            	rd.forward(request, response);
	            }
			}else {
				out.println("Nickname o Password incorrecta!");
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		doGet(request,response);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
