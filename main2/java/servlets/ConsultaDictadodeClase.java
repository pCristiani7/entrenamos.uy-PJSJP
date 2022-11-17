package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.ControladorPublish;
import publicadores.ControladorPublishService;
import publicadores.ControladorPublishServiceLocator;

import publicadores.DtClase;
import publicadores.DtRegistro;

/**
 * Servlet implementation class ConsultaDictatodeClase
 */
@WebServlet("/ConsultaDictadodeClase")
public class ConsultaDictadodeClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaDictadodeClase() {
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
		DtClase dtClase = new DtClase();
		//Caso de Uso de Juan (Consulta dictado de clase)
		if(request.getParameter("origenConsulta").equals("consultaDictadodeClase")){
			String nomClase = request.getParameter("nomClase");
			try {
				dtClase = ConsultaDictadoClase(nomClase);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = dtClase.getUrl();
			String actividadDeportiva = dtClase.getActividadDeportiva();
			String profesor =  dtClase.getProfesor();
			Calendar fecha =  dtClase.getFecha();
			Calendar horario = dtClase.getFecha();
			String horario1 = new SimpleDateFormat("hh:mm").format(horario.getTime());
			Calendar fechaReg =  dtClase.getFechaReg();
			DtRegistro[] registros = null;
			try {
				registros = getRegistrosClase(nomClase);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("nomClase", nomClase);
			request.setAttribute("url", url);
			request.setAttribute("actividadDeportiva", actividadDeportiva);
			request.setAttribute("profesor", profesor);
			request.setAttribute("fecha", fecha);
			request.setAttribute("horario", horario1);
			request.setAttribute("fechaReg", fechaReg);
			request.setAttribute("registros", registros);
			//se vuelve a setear el valor porque se pierde al hacer os forward entre archivos
			request.setAttribute("origenConsulta", "consultaDictadodeClase");
			
		//Caso de Uso de Santi (Registro dictado de Clase)	
		}else if(request.getParameter("origenConsulta").equals("registroDictadodeClase")){
			String nomClase = request.getParameter("nombreClase");
			try {
				dtClase = ConsultaDictadoClase(nomClase);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String url = dtClase.getUrl();
			String actividadDeportiva = dtClase.getActividadDeportiva();
			String profesor =  dtClase.getProfesor();
			Calendar fecha =  dtClase.getFecha();
			Calendar horario = dtClase.getFecha();
			String horario1 = new SimpleDateFormat("hh:mm").format(horario.getTime());
			Calendar fechaReg =  dtClase.getFechaReg();
			DtRegistro[] registros = null;
			try {
				registros = getRegistrosClase(nomClase);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("nomClase", nomClase);
			request.setAttribute("url", url);
			request.setAttribute("actividadDeportiva", actividadDeportiva);
			request.setAttribute("profesor", profesor);
			request.setAttribute("fecha", fecha);
			request.setAttribute("horario", horario1);
			request.setAttribute("fechaReg", fechaReg);
			request.setAttribute("registros", registros);
			//se vuelve a setear el valor porque se pierde al hacer os forward entre archivos
			request.setAttribute("origenConsulta", "registroDictadodeClase");
		}		
		
		
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("/ConsultaDictadodeClasePt2.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

	public DtClase ConsultaDictadoClase(String nomClase) throws Exception{
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.consultaDictadoClase(nomClase);
	}

	public DtRegistro[] getRegistrosClase(String nomClase) throws Exception{
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.getRegistrosClase(nomClase);
	}
}
