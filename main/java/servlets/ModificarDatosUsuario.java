	package servlets;

import java.io.IOException;
import java.text.SimpleDateFormat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import datatypes.DtUsuario;
import interfaces.Fabrica;
import interfaces.IControlador;
import datatypes.DtSocio;
import datatypes.DtProfesor;
import java.util.Date;
import java.util.Base64;


/**
 * Servlet implementation class ModificarDatosUsuario
 */
@WebServlet("/ModificarDatosUsuario")
public class ModificarDatosUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarDatosUsuario() {
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
		HttpSession session = request.getSession(false);
		String nickname = (String) session.getAttribute("name");
		Fabrica fabrica = Fabrica.getInstance();
		IControlador icon = fabrica.getIControlador();
		DtUsuario dtUser = (icon.ConsultaUsuario(nickname));
		String nomUser = request.getParameter("nomUsuario");		
		String apeUser = request.getParameter("apeUsuario");
		String fNacUser = request.getParameter("fNacUsuario");
		Date fNacUsuarioConv = new SimpleDateFormat ("dd/MM/yyyy").parse(fNacUser);
		String image=request.getParameter("img");
		byte[] foto;
		
		if(dtUser instanceof DtProfesor) {
			DtProfesor dtProf = (DtProfesor) dtUser;
			String emailUsuario = dtProf.getEmail();
			String descPr = request.getParameter("descProf");
			String bioPr = request.getParameter("bioProf");
			String swPr = request.getParameter("swProf");
			if(image.equals(""))
	                foto=dtProf.getProfileImage();
	        else 
	            foto=Base64.getDecoder().decode(image.substring(image.lastIndexOf(",") + 1));
			DtProfesor dtProfNew = new DtProfesor(nickname, nomUser, apeUser, emailUsuario, fNacUsuarioConv, descPr, bioPr, swPr, dtProf.getInstitucionDeportiva(), foto);
			DtUsuario dtUsuarioNew = (DtUsuario) dtProfNew;
			icon.ModificarDatosUsuario(dtUser, dtUsuarioNew);
		}else if(dtUser instanceof DtSocio) {
			DtSocio dtSoc = (DtSocio) dtUser;
			String emailUsuario = dtSoc.getEmail();
			if(image.equals(""))
                foto=dtSoc.getProfileImage();
			else 
				foto=Base64.getDecoder().decode(image.substring(image.lastIndexOf(",") + 1));
			DtSocio dtSocioNew = new DtSocio(nickname, nomUser, apeUser, emailUsuario, fNacUsuarioConv,foto);
			DtUsuario dtUsuarioNew = (DtUsuario) dtSocioNew;
			icon.ModificarDatosUsuario(dtUser, dtUsuarioNew);
		}
		RequestDispatcher rd;
		dtUser = icon.ConsultaUsuario(nickname);
			request.setAttribute("nickname", nickname);
			if(dtUser instanceof DtProfesor) {
				DtProfesor dtProf = (DtProfesor) dtUser;
				request.setAttribute("nombre", dtProf.getNombre());
				request.setAttribute("apellido", dtProf.getApellido());
				request.setAttribute("email", dtProf.getEmail());
				request.setAttribute("fechaNac", dtProf.getFechaNac());
				request.setAttribute("descripcion", dtProf.getDescripcion());
				request.setAttribute("biografia", dtProf.getBiografia());
				request.setAttribute("sitioweb", dtProf.getSitioweb());
				request.setAttribute("instDep", dtProf.getInstitucionDeportiva());
				request.setAttribute("imagen", Base64.getEncoder().encodeToString(dtProf.getProfileImage()));
				rd = request.getRequestDispatcher("/ConsultaProfesor.jsp");
				rd.forward(request, response);
			}else if(dtUser instanceof DtSocio) {
				DtSocio dtSoc = (DtSocio) dtUser;
				request.setAttribute("nombre", dtSoc.getNombre());
				request.setAttribute("apellido", dtSoc.getApellido());
				request.setAttribute("email", dtSoc.getEmail());
				request.setAttribute("fechaNac", dtSoc.getFechaNac());
				request.setAttribute("imagen", Base64.getEncoder().encodeToString(dtSoc.getProfileImage()));
				request.setAttribute("registros", icon.getRegistrosSocio(dtSoc.getNombre()));
				rd = request.getRequestDispatcher("/ConsultaSocio.jsp");
				rd.forward(request, response);
			}
			
		doGet(request, response);
	}
}
