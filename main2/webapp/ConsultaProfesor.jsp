<%@page import="java.util.Date"%>
<%@ page import = "java.util.Calendar"%>
<%@ page import = "java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Usuario</title>
<link rel="stylesheet" href="css/styleConsultas.css">
<%@include file ="/headerProfesor.jsp" %>
</head>
<body>
	<div id="divCheckbox" style="display: none;">
	<%
		String nicknamee = (String)request.getAttribute("nickname");
		String nombree = (String)request.getAttribute("nombre");
		String apellidoo = (String)request.getAttribute("apellido");
		String emaill = (String)request.getAttribute("email");
	    String fechaNacc = (String)request.getAttribute("fechaNac");
		String descripcionn = (String)request.getAttribute("descripcion");
		String biografiaa = (String)request.getAttribute("biografia");
		String sitiowebb = (String)request.getAttribute("sitioweb");
		String instDepp = (String)request.getAttribute("instDep");
		String img = (String)request.getAttribute("imagen");
	%>
	</div>
	<div class="container">
        <div class="card">
			<h1 style="margin-top: 3vh; margin-bottom: -3vh;" >Consulta Usuario</h1>
			<img width="250px" height="250px" src="data:image/png;base64,<%=img%>" class="responsive">
			<h3>Nickname: <%=nicknamee%></h3>
			<h3>Nombre: <%=nombree%></h3>
			<h3>Apellido: <%=apellidoo%></h3>
			<h3>Email: <%=emaill%></h3>
			<h3>Fecha de Nacimiento: <%=fechaNacc%></h3>
			<h3>Descripcion: <%=descripcionn%></h3>
			<h3>Biografia: <%=biografiaa%></h3>
			<h3>Sitio web: <%=sitiowebb%></h3>
			<h3 style="margin-bottom: 5vh;">Instituion Deportiva: <%=instDepp%></h3>
		</div>
	</div>
</body>
</html>