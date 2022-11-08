 <%@page import="datatypes.DtClase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	
	<%HttpSession sesion = request.getSession(); 
String tipoUsuario = (String) sesion.getAttribute("tipoUsuario");
%>
	
	<%
	if(tipoUsuario.equals("profesor")){
		%>
		<%@include file ="/headerProfesor.jsp" %>
		
		<% 	}else{
			%>
			<%@include file ="/headerSocio.jsp" %>
	<%} %>
	
		<meta charset="ISO-8859-1">
		<title>Consulta de Actividad Deportiva</title>
		<link rel="stylesheet" href="css/styleConsultas.css">
		<%@page import="interfaces.Fabrica"%>
		<%@page import="interfaces.IControlador"%>
	</head>
	<body style="background: #e3e3e3">
		<%
			String nombre = (String)request.getAttribute("nombre");
			String descripcion = (String)request.getAttribute("descripcion");
			int duracion = (int)request.getAttribute("duracion");
			float costo = (float)request.getAttribute("costo");
			List<DtClase> clases = (List<DtClase>) request.getAttribute("listClases");
			String InstitucionDeportiva = (String)request.getAttribute("InstitucionDeportiva");
		%>	
	    <div class="container">
	        <div class="card">
	        	<h2>Informacion<br>Actividad Deportiva</h2>
				<h3>Nombre: <%=nombre%></h3>
				<h3>Descripcion: <%=descripcion%></h3>
				<h3>Duracion: <%=duracion%></h3>
				<h3>Costo: <%=costo%></h3>
				<h3>Institucion deportiva: <%=InstitucionDeportiva%></h3>
				<form action="ConsultaDictadodeClase" method="post">
					<div class="select">
						<select class="inputBox" name="nomClase" id="actividades">
		                      <%Fabrica fab = Fabrica.getInstance();
		              			IControlador icon = fab.getIControlador();
		                        for(String a: icon.listarClasesActividadDeportiva(nombre)){%> 
		                            <option value="<%=a%>"><%=a%></option>
		                      <%}%>
		                </select>
	                </div>
	                <div style="margin-top:15px; margin-bottom:10px; text-align:center">
	                <input type="hidden" name="origenConsulta" class="form-control" id="idOrigenConsulta" value="consultaDictadodeClase">
	                	<button>Buscar Clase</button>
					</div>
				</form>
	        </div>
	       </div>
	</body>
</html>