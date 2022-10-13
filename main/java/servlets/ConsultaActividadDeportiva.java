package servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import interfaces.Fabrica;
import interfaces.IControlador;

/**
 * Servlet implementation class ConsultaActividadDeportiva
 */
@WebServlet("/ConsultaActividadDeportiva")
public class ConsultaActividadDeportiva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividadDeportiva() {
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
		String nomActDep = request.getParameter("NomActDep");
		Fabrica fab = Fabrica.getInstance();
		IControlador icon = fab.getIControlador();
		
		//consultar si existe la actividad deportiva
		
		DtActividadDeportiva dtAct = icon.ConsultaActividadDeportiva(nomActDep);
		if(dtAct != null) {
			String descripcion = dtAct.getDescripcion();
			int duracion = dtAct.getDuracion();
			float costo = dtAct.getCosto();
			LocalDate fecha = dtAct.getFecha();
			List<DtClase> clases = dtAct.getClases();
			String InstitucionDeportiva = dtAct.getInstitucionDeportiva();
			request.setAttribute("nombre", nomActDep);
			request.setAttribute("descripcion", descripcion);
			request.setAttribute("duracion", duracion);
			request.setAttribute("costo", costo);
			request.setAttribute("fecha", fecha);
			request.setAttribute("listClases", clases);
			request.setAttribute("InstitucionDeportiva", InstitucionDeportiva);
		}else{
			//mensaje de error
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/ConsultaActividadDeportiva2.jsp");
		rd.forward(request, response);
	}

}
