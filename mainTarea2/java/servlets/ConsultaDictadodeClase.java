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
		//Datos para completar el Registro a Dictado de Clase
		String insDepReg = request.getParameter("instDepReg");
		String activDepReg = request.getParameter("actDepReg");
		String nomClaseReg = request.getParameter("nomClaseReg");
		
		//Datos para imprimir la informacion de Consulta Dictado de Clase 
		String nomClaseConsulta = request.getParameter("nameClase");
		
		//Verificacion del origen del llamado de la operacion
		String origen = request.getParameter("origin");
		
		//Ejecucion de Consulta dictado de clase o Registro Dictado de Clase
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		DtClase dtClase = new DtClase();
		
		if(request.getParameter("origin").equals("consulta")){
			dtClase = icon.ConsultaDictadoClase(nomClaseConsulta);
		}else if(request.getParameter("origin").equals("registro")){
			dtClase = icon.ConsultaDictadoClase(nomClaseReg);
		}
			String nomClase = dtClase.getNombre();
			String url = dtClase.getUrl();
			String actividadDeportiva = dtClase.getActividadDeportiva();
			String profesor =  dtClase.getProfesor();
			LocalDate fecha =  dtClase.getFecha();
			LocalTime horario = dtClase.getHoraInicio();
			LocalDate fechaReg =  dtClase.getFechaReg();
			List <DtRegistro> registros = dtClase.getRegistros();			
		
		//Envío a jsp atributos para Registro Dictado de Clase
		request.setAttribute("activRegistro", activDepReg);
		request.setAttribute("institRegistro",insDepReg);
		request.setAttribute("claseRegistro", nomClaseReg);
		
		//Envío a jsp lista de datos a imprimir en Consulta Dictado De Clase Pt2
		request.setAttribute("nombreClase", nomClase);
		request.setAttribute("urlClase", url);
		request.setAttribute("actDepClase", actividadDeportiva);
		request.setAttribute("profClase", profesor);
		request.setAttribute("fechaClase", fecha);
		request.setAttribute("horarioClase", horario);
		request.setAttribute("fechaRegClase", fechaReg);
		request.setAttribute("registrosClase", registros);
		
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("/ConsultaDictadodeClasePt2.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
