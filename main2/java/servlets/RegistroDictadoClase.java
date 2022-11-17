package servlets;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

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
		Date fechaClase = new Date();
		LocalTime t = LocalTime.now();
		fechaClase.setHours(t.getHour());
		fechaClase.setMinutes(t.getMinute());
		fechaClase.setSeconds(t.getSecond());
		Calendar cal = Calendar.getInstance();
		cal.setTime(fechaClase);
			try {
				registroDictadoClase(clase, usuario, cal);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			RequestDispatcher rd;
			rd = request.getRequestDispatcher("/socioPage.jsp");
			rd.forward(request, response);
			doGet(request, response);
	}

	public void registroDictadoClase(String nomClase, String nomSocio, Calendar fecha) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		port.registroDictadoClase(nomClase,nomSocio,fecha);
	}

}
