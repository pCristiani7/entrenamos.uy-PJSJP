package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.List;

import datatypes.DtProfesor;
import datatypes.DtRegistro;
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
 * Servlet implementation class EliminarRegistroDictadoDeClase
 */
@WebServlet("/EliminarRegistroDictadoDeClase")
public class EliminarRegistroDictadoDeClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarRegistroDictadoDeClase() {
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
		Fabrica fabrica = Fabrica.getInstance();
        IControlador icon = fabrica.getIControlador();
        HttpSession sesion = request.getSession();
        String nickname = (String)sesion.getAttribute("name");
        String clase = (String) request.getParameter("nomClase");
        icon.EliminarRegistro(clase,nickname);
        RequestDispatcher rd;
		rd = request.getRequestDispatcher("/socioPage.jsp");
		rd.forward(request, response);
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
