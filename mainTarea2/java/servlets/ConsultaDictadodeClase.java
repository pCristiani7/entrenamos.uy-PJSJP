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
import javax.servlet.http.HttpSession;

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
		
		//Caso de Uso de Juan (Consulta dictado de clase)
		if(request.getParameter("origenConsulta").equals("consultaDictadodeClase")){
			String nomClase = request.getParameter("nomClase");
			DtClase dtClase = icon.ConsultaDictadoClase(nomClase);
			String url = dtClase.getUrl();
			String actividadDeportiva = dtClase.getActividadDeportiva();
			String profesor =  dtClase.getProfesor();
			LocalDate fecha =  dtClase.getFecha();
			LocalTime horario = dtClase.getHoraInicio();
			LocalDate fechaReg =  dtClase.getFechaReg();
			List <DtRegistro> registros = dtClase.getRegistros();	
			
			
		//Caso de Uso de Santi (Registro dictado de Clase)	
		}else if(request.getParameter("origenConsulta").equals("registroDictadodeClase")){
			String nomClase = request.getParameter("nomClase");
			DtClase dtClase = icon.ConsultaDictadoClase(nomClase);
			
			
			//REVISAR NOMBRES DE LAS VARIABLES EN consultaDictadodeClasePt2.jsp (SANTI)
			
			String insDepReg = request.getParameter("instDepReg");
			String activDepReg = request.getParameter("actDepReg");
			String url = dtClase.getUrl();
			String actividadDeportiva = dtClase.getActividadDeportiva();
			String profesor =  dtClase.getProfesor();
			LocalDate fecha =  dtClase.getFecha();
			LocalTime horario = dtClase.getHoraInicio();
			LocalDate fechaReg =  dtClase.getFechaReg();
			List <DtRegistro> registros = dtClase.getRegistros();	
		}		
		
		
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("/ConsultaDictadodeClasePt2.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
