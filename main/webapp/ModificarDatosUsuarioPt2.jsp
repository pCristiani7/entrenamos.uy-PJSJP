<%@page import="java.time.LocalDate"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar de datos usuario EntrenamosUy</title>
</head>
<body>

<div id="divCheckbox" style="display: none;">
<%
		String nickname = (String)request.getAttribute("nickname");
		String nombre = (String)request.getAttribute("nombre");
		String apellido = (String)request.getAttribute("apellido");
		String email = (String)request.getAttribute("email");
		LocalDate fechaNac = (LocalDate)request.getAttribute("fechaNac");
		
	%>
	</div>
	<h1>Usuario Modificado</h1>
	<h3>Nickname: <%=nickname%></h3>
	<h3>nombre: <%=nombre%></h3>
	<h3>apellido: <%=apellido%></h3>
	<h3>email: <%=email%></h3>
	<h3>fechaNac: <%=fechaNac%></h3>
	
</body>
</html>