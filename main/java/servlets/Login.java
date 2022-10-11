package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		doGet(request,response);
		PrintWriter out = response.getWriter();
		String nickname = request.getParameter("nick");
		String password = request.getParameter("pass");
		Fabrica fab = Fabrica.getInstance();
		IControlador iCon = fab.getIControlador();
		
		if(nickname.equals("pablito") && password.equals("abc")) {
			HttpSession session = request.getSession();
			session.setAttribute("name", nickname);
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("userPage.jsp");
			rd.forward(request, response);
		}
	/*	
		try {
			if(iCon.inicioSesion(nickname, password)) {
				HttpSession session = request.getSession();
				session.setAttribute("name", nickname);
				response.sendRedirect("home.jsp");
			}else {
				out.println("Nickname o Password incorrecta!");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
			*/
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
