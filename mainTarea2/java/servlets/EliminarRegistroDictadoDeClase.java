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
import logica.ManejadorClase;
import datatypes.DtActividadDeportiva;
import datatypes.DtClase;
import datatypes.DtRegistro;
import excepciones.ClaseRepetidaExcepcion;
import interfaces.Fabrica;
import interfaces.IControlador;

@WebServlet("/AltaDictadoClase")
public class EliminarRegistroDictadoDeClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
    public EliminarRegistroDictadoDeClase() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fabrica fabrica = Fabrica.getInstance();
        IControlador icon = fabrica.getIControlador();
        HttpSession sesion = request.getSession();
        String nickname = (String) sesion.getAttribute("name");
        DtRegistro dtReg = (DtRegistro) request.getAttribute("a");
        icon.EliminarRegistro(dtReg);
        RequestDispatcher rd;
		rd = request.getRequestDispatcher("/socioPage.jsp");
		rd.forward(request, response);
		
	}

}
