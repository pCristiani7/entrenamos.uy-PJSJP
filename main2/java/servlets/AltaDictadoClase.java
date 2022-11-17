package servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

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

import publicadores.DtActividadDeportiva;
import publicadores.DtClase;
import publicadores.DtProfesor;
import publicadores.DtRegistro;
import publicadores.DtUsuario;

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
		String prof = (String)sesion.getAttribute("name");
		DtUsuario dtUser = null;
		try {
			dtUser = ConsultaUsuario(prof);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DtProfesor dtProf = (DtProfesor) dtUser;
		String actAsoc = request.getParameter("actAso");
		String nombre = request.getParameter("nomClase");			
		DtActividadDeportiva actAso = null;
		try {
			actAso = ConsultaActividadDeportiva(actAsoc);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		DtClase[] listDt = null;
		try {
			listDt = getClasesActDep(actAso.getNombre());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean existe = false;
		for(DtClase a: listDt) {
			if(a.getNombre()==nombre) {
				existe = true;
			}
		}
		RequestDispatcher rd;
		if(existe){
			rd = request.getRequestDispatcher("/modOCancel.jsp");
			rd.forward(request, response);
		}else {
			try {
			String url = request.getParameter("urlClase");
			String fecha = request.getParameter("fechaClase");
			Date dateAlta = new SimpleDateFormat ("yyyy-MM-dd").parse(fecha);
			Date FechaReg = new Date();
			Calendar cal = Calendar.getInstance(), cal2 = Calendar.getInstance();
			cal2.setTime(FechaReg);
			cal.setTime(dateAlta);
			
			String horario = request.getParameter("horarioClase"); // 15:30
	        char[] horaArray = new char[horario.length()];
			for (int i = 0; i < horario.length(); i++) {
				horaArray[i] = horario.charAt(i);
			}
			int hora = horaArray[0] + horaArray[1]; //15
			int minuto = horaArray[3] + horaArray[4]; //30
			dateAlta.setHours(hora);
			dateAlta.setMinutes(minuto);

			DtClase clase = new DtClase(nombre, url, actAsoc,dtProf.getNickname(),cal, cal2);
			try {
				AltaDictadoClase(actAso, clase);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}catch(Exception e){
				throw new ServletException(e.getMessage());
			}
			request.setAttribute("mensaje", "Se ha agregado correctamente la clase " + nombre + " en el sistema.");
			rd = request.getRequestDispatcher("/profesorPage.jsp");
			rd.forward(request, response);
		}
		doGet(request, response);
	}

	public DtUsuario ConsultaUsuario(String prof) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.consultaUsuario(prof);
	}

	public void AltaDictadoClase(DtActividadDeportiva actAso, DtClase clase) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		port.altaDictadoClase(actAso,clase);
	}

	public DtClase[] getClasesActDep(String nomActDep) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.getClasesActDep(nomActDep);
	}

	public DtActividadDeportiva ConsultaActividadDeportiva(String actDep) throws Exception{
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.consultaActividadDeportiva(actDep);
	}
}
