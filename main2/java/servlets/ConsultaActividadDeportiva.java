package servlets;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import publicadores.ControladorPublish;
import publicadores.ControladorPublishService;
import publicadores.ControladorPublishServiceLocator;

import publicadores.DtActividadDeportiva;
import publicadores.DtClase;

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
		String nomActDep = request.getParameter("ActDep");
		//consultar si existe la actividad deportiva
		DtActividadDeportiva dtAct = null;
		try {
			dtAct = ConsultaActividadDeportiva(nomActDep);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(dtAct != null) {
			String descripcion = dtAct.getDescripcion();
			int duracion = dtAct.getDuracion();
			float costo = dtAct.getCosto();
			Calendar fecha = dtAct.getFecha();
			DtClase[] clases = null;
			try {
				clases = getClasesActDep(nomActDep);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
		rd = request.getRequestDispatcher("/ConsultarActividadDeportiva2.jsp");
		rd.forward(request, response);
	}

	public DtActividadDeportiva ConsultaActividadDeportiva(String nomActDep) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.consultaActividadDeportiva(nomActDep);
	}

	public DtClase[] getClasesActDep(String nomActDep) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.getClasesActDep(nomActDep);
	}
}
