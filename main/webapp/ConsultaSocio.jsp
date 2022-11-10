<%@page import="java.util.Date"%>
<%@page import="datatypes.DtRegistro"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		Date fechaNac = (Date)request.getAttribute("fechaNac");
		List<DtRegistro> reg = (List<DtRegistro>) request.getAttribute("registros");
		String img = (String)request.getAttribute("imagen");
		
	%>
	</div>
	<div class="container">
        <div class="card">
			<h2 style="margin-top: 3vh; margin-bottom: -3vh;" >Consulta Usuario</h2>
			<img width="250px" height="250px" src="data:image/png;base64,<%=img%>" class="responsive">
			<h3>Nickname: <%=nicknamee%></h3>
			<h3>nombre: <%=nombre%></h3>
			<h3>apellido: <%=apellido%></h3>
			<h3>email: <%=emaill%></h3>
			<h3 style="margin-bottom: 5vh;" >fechaNac: <%=fechaNac%></h3>
		</div>

	
	<!-- controlar si tiene registros antes de crear la tabla  -->
	
	
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
	    %>
	    	<tr>
	    		<th scope="row"><%=x%></th>
	    		<td><%=dtr.getClase()%></td>
	    		<td><%=dtr.getFecha()%></td>

	    	</tr>
	    <%
	    	}
	    %>
	    </tbody>
	</table>
		</div>
</body>
</html>