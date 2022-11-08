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

import datatypes.DtClase;
import datatypes.DtRegistro;
import interfaces.Fabrica;
import interfaces.IControlador;



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
		
		
		//NO CAMBIES EL NOMBRE DE LAS VARIABLES Y DEJALAS COMO ESTAN!!!!
		//NO CAMBIES EL NOMBRE DE LAS VARIABLES Y DEJALAS COMO ESTAN!!!!
		//NO CAMBIES EL NOMBRE DE LAS VARIABLES Y DEJALAS COMO ESTAN!!!!
		
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		DtClase dtClase = new DtClase();
		
		//Caso de Uso de Juan (Consulta dictado de clase)
		if(request.getParameter("origenConsulta").equals("consultaDictadodeClase")){
			String nomClase = request.getParameter("nomClase");
			dtClase = icon.ConsultaDictadoClase(nomClase);
			String url = dtClase.getUrl();
			String actividadDeportiva = dtClase.getActividadDeportiva();
			String profesor =  dtClase.getProfesor();
			LocalDate fecha =  dtClase.getFecha();
			LocalTime horario = dtClase.getHoraInicio();
			LocalDate fechaReg =  dtClase.getFechaReg();
			List <DtRegistro> registros = icon.getRegistrosClase(nomClase);
			
			request.setAttribute("nomClase", nomClase);
			request.setAttribute("url", url);
			request.setAttribute("actividadDeportiva", actividadDeportiva);
			request.setAttribute("profesor", profesor);
			request.setAttribute("fecha", fecha);
			request.setAttribute("horario", horario);
			request.setAttribute("fechaReg", fechaReg);
			request.setAttribute("registros", registros);
			//se vuelve a setear el valor porque se pierde al hacer os forward entre archivos
			request.setAttribute("origenConsulta", "consultaDictadodeClase");
			
		//Caso de Uso de Santi (Registro dictado de Clase)	
		}else if(request.getParameter("origenConsulta").equals("registroDictadodeClase")){
			String nomClase = request.getParameter("nombreClase");
			dtClase = icon.ConsultaDictadoClase(nomClase);
			String url = dtClase.getUrl();
			String actividadDeportiva = dtClase.getActividadDeportiva();
			String profesor =  dtClase.getProfesor();
			LocalDate fecha =  dtClase.getFecha();
			LocalTime horario = dtClase.getHoraInicio();
			LocalDate fechaReg =  dtClase.getFechaReg();
			List <DtRegistro> registros = icon.getRegistrosClase(nomClase);
			
			request.setAttribute("nomClase", nomClase);
			request.setAttribute("url", url);
			request.setAttribute("actividadDeportiva", actividadDeportiva);
			request.setAttribute("profesor", profesor);
			request.setAttribute("fecha", fecha);
			request.setAttribute("horario", horario);
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


}
