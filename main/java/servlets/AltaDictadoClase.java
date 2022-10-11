package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtRegistro;
import excepciones.ClaseRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;

@WebServlet("/AltaDictadoClase")
public class AltaDictadoClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public AltaDictadoClase() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String actAsoc = request.getParameter("actAso");
		String nombre = request.getParameter("nomClase");
		String url = request.getParameter("urlClase");
		String prof = request.getParameter("profClase");
		String fecha = request.getParameter("fechaClase");
		LocalDate date = LocalDate.parse(fecha);
		LocalDate fechareg = LocalDate.now();
		String horario = request.getParameter("horarioClase");
		LocalTime horarioClase = LocalTime.parse(horario);
		List<DtRegistro> registros = new ArrayList<>();
		DtActividadDeportiva actAso = null;
		DtClase clase = new DtClase(nombre, url, registros, actAsoc, date, fechareg, horarioClase, prof);

		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		
		try {
		icon.AltaDictadoClase(actAso, clase);
		}catch(ClaseRepetidaExcepcion e){
			throw new ServletException(e.getMessage());
		}
		RequestDispatcher rd;
		request.setAttribute("mensaje", "Se ha agregado correctamente la clase " + nombre + " en el sistema.");
		rd = request.getRequestDispatcher("/notificacion.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
