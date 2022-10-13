<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Usuario</title>
<link rel="stylesheet" href="css/styleConsultas.css">
</head>
<body>
	<div id="divCheckbox" style="display: none;">
	<%
		String nickname = (String)request.getAttribute("nickname");
		String nombre = (String)request.getAttribute("nombre");
		String apellido = (String)request.getAttribute("apellido");
		String email = (String)request.getAttribute("email");
		LocalDate fechaNac = (LocalDate)request.getAttribute("fechaNac");
		String descripcion = (String)request.getAttribute("descripcion");
		String biografia = (String)request.getAttribute("biografia");
		String sitioweb = (String)request.getAttribute("sitioweb");
		String instDep = (String)request.getAttribute("instDep");
	%>
	</div>
	<div class="container">
        <div class="card">
			<h2>Consulta Usuario</h2>
			<h3>Nickname: <%=nickname%></h3>
			<h3>nombre: <%=nombre%></h3>
			<h3>apellido: <%=apellido%></h3>
			<h3>email: <%=email%></h3>
			<h3>fechaNac: <%=fechaNac%></h3>
			<h3>descripcion: <%=descripcion%></h3>
			<h3>biografia: <%=biografia%></h3>
			<h3>sitioweb: <%=sitioweb%></h3>
			<h3>instDep: <%=instDep%></h3>
		</div>
	</div>
</body>
</html>