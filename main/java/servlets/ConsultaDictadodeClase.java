package servlets;

import java.io.IOException;
import java.time.LocalDate;
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
		//Datos para completar el Registro a Dictado de Clase
		HttpSession sesion = request.getSession();
		Object usuario = sesion.getAttribute("name");
		String insDep = request.getParameter("instDepReg");
		String activDep = request.getParameter("actDepReg");
		String nomClaseReg = request.getParameter("nomClaseReg");
		
		//Datos para imprimir la informacion de Consulta Dictado de Clase 
		String nomClaseConsulta = request.getParameter("nomClase");
		
		//Verificacion del origen del llamado de la operacion
		String origen = request.getParameter("origen");
		//Ejecucion de Consulta dictado de clase
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		DtClase dtClase = new DtClase();
		if(origen == "ConsultaDictadodeClase") {
			dtClase = icon.ConsultaDictadoClase(nomClaseConsulta);
		}else if(origen == "RegistroDictadodeClase") {
			dtClase = icon.ConsultaDictadoClase(nomClaseReg);
		}
			String nomClase = dtClase.getNombre();
			/*String url = dtClase.getUrl();
			List <DtRegistro> registros = dtClase.getRegistros();
			String actividadDeportiva = dtClase.getActividadDeportiva();
			String profesor =  dtClase.getProfesor());
			LocalDate fecha =  dtClase.getFecha());
			LocalTime horario = dtClase.getHoraInicio());
			request.setAttribute("fechaReg", dtClase.getFechaReg());*/
		
		
		RequestDispatcher rd;
		rd= request.getRequestDispatcher("/ConsultaDictadodeClasePt2.jsp");
		rd.forward(request, response);
		
		doGet(request, response);
	}

}
