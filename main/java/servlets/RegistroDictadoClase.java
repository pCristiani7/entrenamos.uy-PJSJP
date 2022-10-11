package servlets;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import excepciones.RegistroRepetidoExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;


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
		Object usuario = sesion.getAttribute("name");
		String insDep = request.getParameter("instDep");
		String activDep = request.getParameter("actDep");
		String clase = request.getParameter("nomClase");
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		
		try {
			icon.RegistroDictadoClase(clase, usuario.toString(), LocalDate.now());
			}catch(RegistroRepetidoExcepcion e){
				throw new ServletException(e.getMessage());
			}
			RequestDispatcher rd;
			request.setAttribute("mensaje", "Se ha registrado correctamente a la clase " + clase + " en el sistema.");
			rd = request.getRequestDispatcher("/notificacion.jsp");
			rd.forward(request, response);
		
		
		
		doGet(request, response);
	}

}
