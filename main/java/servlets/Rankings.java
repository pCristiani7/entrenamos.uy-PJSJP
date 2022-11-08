package servlets;

import java.io.IOException;
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
import datatypes.DtActividadDeportiva;
import interfaces.Fabrica;
import interfaces.IControlador;

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
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		if (request.getParameter("boton").equals("actividades")){
			List<DtActividadDeportiva> actsDep = icon.RankingActividadesDeportivas();
			request.setAttribute("dtacts", actsDep);
			request.setAttribute("mostrar", "actividades");
		}else if (request.getParameter("boton").equals("clases")) {
			List<DtClase> dictsClases = icon.RankingDictadosClases();
			request.setAttribute("dtclases", dictsClases);
			request.setAttribute("mostrar", "clases");
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("/infoRanking.jsp");
		rd.forward(request, response);
	}
}