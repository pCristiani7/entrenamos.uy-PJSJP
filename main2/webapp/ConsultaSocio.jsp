<%@page import="java.util.Date"%>
<%@page import="publicadores.DtRegistro"%>
<%@ page import = "java.util.Calendar"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Entrenamos Uy - Consulta Socio</title>
<link rel="stylesheet" href="css/styleConsultas.css">
<%@include file ="/headerSocio.jsp" %>
</head>
<body>
	
	<div id="divCheckbox" style="display: none;">
	<%
		String nicknamee = (String)request.getAttribute("nickname");
		String nombre = (String)request.getAttribute("nombre");
		String apellido = (String)request.getAttribute("apellido");
		String emaill = (String)request.getAttribute("email");
		Calendar cal = (Calendar) request.getAttribute("fechaNac");
	    String fechaNac = new SimpleDateFormat ("dd/MM/yyyy").format(cal.getTime());
		DtRegistro[] reg = (DtRegistro[]) request.getAttribute("registros");
		String img = (String)request.getAttribute("imagen");
		
	%>
	</div>
	<div class="container">
        <div class="card">
			<h2 style="margin-top: 3vh; margin-bottom: -3vh;" >Consulta Usuario</h2>
			<img width="250px" height="250px" src="data:image/png;base64,<%=img%>" class="responsive">
			<h3>Nickname: <%=nicknamee%></h3>
			<h3>Nombre: <%=nombre%></h3>
			<h3>Apellido: <%=apellido%></h3>
			<h3>Email: <%=emaill%></h3>
			<h3 style="margin-bottom: 25px">Fecha de Nacimiento: <%=fechaNac%></h3>
		</div>

	
	<!-- controlar si tiene registros antes de crear la tabla  -->
	
		<div style="margin-top:30px; width:100%">
			<table class="center">
			  <thead>
			    <tr>
			      <th scope="col">#</th>
			      <th scope="col">Clase</th>
			      <th scope="col">Fecha</th>
			    </tr>
			  </thead>
			  <tbody>
			    <%
			    	int x = 1;
			    	for(DtRegistro dtr: reg){
			    		String fecha = new SimpleDateFormat ("yyyy-MM-dd").format(dtr.getFecha().getTime());
			    %>
			    	<tr>
			    		<th scope="row"><%=x%></th>
			    		<td><%=dtr.getClase()%></td>
			    		<td><%=fecha%></td>
		
			    	</tr>
			    <%
			    	x++;}
			    %>
			    </tbody>
			</table>
		</div>
	</div>
</body>
</html>