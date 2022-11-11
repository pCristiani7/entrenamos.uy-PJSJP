package servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.ManejadorClase;
import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtRegistro;
import datatypes.DtUsuario;
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
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		HttpSession sesion = request.getSession();
		String prof = (String)sesion.getAttribute("name");
		DtUsuario dtUser = icon.ConsultaUsuario(prof);
		DtProfesor dtProf = (DtProfesor) dtUser;
		String actAsoc = request.getParameter("actAso");
		String nombre = request.getParameter("nomClase");		
		DtActividadDeportiva actAso = icon.ConsultaActividadDeportiva(actAsoc);
		List <DtClase> listDt = icon.getClasesActDep(actAso.getNombre());
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
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			cal.setTime(sdf.parse(fecha));
			Calendar cal2 = Calendar.getInstance();
			Date fechareg = cal2.getTime();
			String horario = request.getParameter("horarioClase");
			LocalTime horarioClase = LocalTime.parse(horario);
			List<DtRegistro> registros = new ArrayList<>();
			DtClase clase = new DtClase(nombre, url, actAsoc, cal, fechareg, horarioClase, dtProf.getNickname());
			icon.AltaDictadoClase(actAso, clase);
			}catch(ClaseRepetidaExcepcion e){
				throw new ServletException(e.getMessage());
			}
			request.setAttribute("mensaje", "Se ha agregado correctamente la clase " + nombre + " en el sistema.");
			rd = request.getRequestDispatcher("/profesorPage.jsp");
			rd.forward(request, response);
		}
		doGet(request, response);
	}

}
