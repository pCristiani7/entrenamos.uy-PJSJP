package servlets;

import java.io.IOException;
import java.util.Date;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import excepciones.RegistroRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;
import datatypes.DtClase;

@WebServlet("/RegistroDictadoClase")
public class RegistroDictadoClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public RegistroDictadoClase() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		String usuario = (String) sesion.getAttribute("name");
		String clase = request.getParameter("nomClase");
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		Date date = new Date();
		try {
			icon.RegistroDictadoClase(clase, usuario, date);
			}catch(RegistroRepetidoExcepcion e){
				throw new ServletException(e.getMessage());
			}
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/socioPage.jsp");
			rd.forward(request, response);
		doGet(request, response);
	}
}
