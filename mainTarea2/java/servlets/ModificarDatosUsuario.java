package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import publicadores.ControladorPublish;
import publicadores.ControladorPublishService;
import publicadores.ControladorPublishServiceLocator;

import publicadores.DtUsuario;
import publicadores.DtSocio;
import publicadores.DtProfesor;
import publicadores.DtRegistro;

import java.util.Date;
import java.util.Base64;
import java.util.Calendar;


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
		DtUsuario dtUser = null;
		try {
			dtUser = ConsultaUsuario(nickname);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String nomUser = request.getParameter("nomUsuario");		
		String apeUser = request.getParameter("apeUsuario");
		String fNacUser = request.getParameter("fNacUsuario");
		Date fNacUsuarioConv = null;
		try {
			fNacUsuarioConv = new SimpleDateFormat ("yyyy-MM-dd").parse(fNacUser);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		Calendar cal = Calendar.getInstance();
		cal.setTime(fNacUsuarioConv);
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
			DtProfesor dtProfNew = new DtProfesor(nickname, nomUser, apeUser, emailUsuario, cal, foto, descPr, bioPr, swPr, dtProf.getInstitucionDeportiva());
			DtUsuario dtUsuarioNew = (DtUsuario) dtProfNew;
			try {
				ModificarDatosUsuario(dtUser, dtUsuarioNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(dtUser instanceof DtSocio) {
			DtSocio dtSoc = (DtSocio) dtUser;
			String emailUsuario = dtSoc.getEmail();
			if(image.equals(""))
                foto=dtSoc.getProfileImage();
			else 
				foto=Base64.getDecoder().decode(image.substring(image.lastIndexOf(",") + 1));
			DtSocio dtSocioNew = new DtSocio(nickname, nomUser, apeUser, emailUsuario, cal,foto);
			DtUsuario dtUsuarioNew = (DtUsuario) dtSocioNew;
			try {
				ModificarDatosUsuario(dtUser, dtUsuarioNew);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		RequestDispatcher rd;
		try {
			dtUser = ConsultaUsuario(nickname);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
				try {
					request.setAttribute("registros", getRegistrosSocio(dtSoc.getNickname()));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				rd = request.getRequestDispatcher("/ConsultaSocio.jsp");
				rd.forward(request, response);
			}
			
		doGet(request, response);
	}

	public DtUsuario ConsultaUsuario(String user) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.consultaUsuario(user);
	}

	public boolean ModificarDatosUsuario(DtUsuario dtUser, DtUsuario dtUserNew) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.modificarDatosUsuario(dtUser,dtUserNew);
	}

	public DtRegistro[] getRegistrosSocio(String nickname) throws Exception {
		ControladorPublishService cps = new ControladorPublishServiceLocator();
		ControladorPublish port = cps.getControladorPublishPort();
		return port.getRegistrosSocio(nickname);
	}
}
