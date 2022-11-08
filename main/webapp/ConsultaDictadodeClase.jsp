<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
 <%@page import="datatypes.DtClase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styleLoginV2.css">
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
	
<title>Consulta Dictado de Clase</title>
</head>
<body>
		<%Fabrica fab = Fabrica.getInstance();
		 	IControlador icon = fab.getIControlador();
			ArrayList <String> listClases = icon.listarClasesFront();
			%>
			<%if(listClases.isEmpty()){%>
				<p>No hay clases en el sistema</p>
			<%}else{%>
		<form action="ConsultaDictadodeClase" method="post">
			<div class="container">
				<div class="card">
					<h3>Consulta dictado<br>de clase</h3>
					<div class="select">
					<select name="nomClase" id="actividades">
	                    <%for(String a: listClases){%> 
	                        <option value="<%=a%>"><%=a%></option>
	                  <%}%>
	            	</select>
					</div>
					<input type="hidden" name="origenConsulta" class="form-control" id="idOrigenConsulta" value="consultaDictadodeClase">
					<button class="btn btn-primary" type="submit">Aceptar</button>
				</div>
			</div>	
		</form>
		<%}%>
	</body>
</html>