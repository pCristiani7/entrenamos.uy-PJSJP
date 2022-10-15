package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logica.ManejadorClase;
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
		HttpSession sesion = request.getSession();
		Object prof = sesion.getAttribute("name");
		String actAsoc = request.getParameter("actAso");
		String nombre = request.getParameter("nomClase");
		String url = request.getParameter("urlClase");
		String fecha = request.getParameter("fechaClase");
		LocalDate date = LocalDate.parse(fecha);
		LocalDate fechareg = LocalDate.now();
		String horario = request.getParameter("horarioClase");
		LocalTime horarioClase = LocalTime.parse(horario);
		List<DtRegistro> registros = new ArrayList<>();
		DtActividadDeportiva actAso = new DtActividadDeportiva();
		DtClase clase = new DtClase(nombre, url, registros, actAsoc, date, fechareg, horarioClase, "prof3");

		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		ManejadorClase mj = ManejadorClase.getInstancia();
		RequestDispatcher rd;
		
		if(mj.existeClase(nombre)){
			rd = request.getRequestDispatcher("/modOCancel.jsp");
			rd.forward(request, response);
		}else {
			try {
			icon.AltaDictadoClase(actAso, clase);
			}catch(ClaseRepetidaExcepcion e){
				throw new ServletException(e.getMessage());
			}
			request.setAttribute("mensaje", "Se ha agregado correctamente la clase " + nombre + " en el sistema.");
			rd = request.getRequestDispatcher("/notificacion.jsp");
			rd.forward(request, response);
		}
		doGet(request, response);
	}

}
