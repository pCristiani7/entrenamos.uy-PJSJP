<%@page import="java.time.LocalDate"%>
<%@page import="datatypes.DtRegistro"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
		ArrayList<DtRegistro> registros = (ArrayList<DtRegistro>) request.getAttribute("registros");
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
		</div>
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
	    	int i = 1;
	    	for(DtRegistro dtr: registros){
	    %>
	    	<tr>
	    		<th scope="row"><%=i%></th>
	    		<td><%=dtr.getClase()%></td>
	    		<td><%=dtr.getFecha()%></td>

	    	</tr>
	    <%
	    	}
	    %>
	    </tbody>
	</table>
</body>
</html>