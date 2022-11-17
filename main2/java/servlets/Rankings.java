package servlets;

import java.io.IOException;
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
import publicadores.DtActividadDeportiva;

/**
 * Servlet implementation class Rankings
 */
@WebServlet("/Rankings")
public class Rankings extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rankings() {
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
		if (request.getParameter("boton").equals("actividades")){
			DtActividadDeportiva[] actsDep = null;
			try {
				actsDep = RankingActividadesDeportivas();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("dtacts", actsDep);
			request.setAttribute("mostrar", "actividades");
		}else if (request.getParameter("boton").equals("clases")) {
			DtClase[] dictsClases = null;
			try {
				dictsClases = RankingDictadosClases();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("dtclases", dictsClases);
			request.setAttribute("mostrar", "clases");
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/infoRanking.jsp");
		rd.forward(request, response);
	}

	public DtActividadDeportiva[] RankingActividadesDeportivas() throws Exception{
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.rankingActividadesDeportivas();
	}
	
	public DtClase[] RankingDictadosClases() throws Exception{
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.rankingDictadosClases();
	}
}