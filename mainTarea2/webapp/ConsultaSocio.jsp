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
		Calendar cal = (Calendar) request.getAttribute("fechaNac");
	    String fechaNac = new SimpleDateFormat ("dd/MM/yyyy").format(cal.getTime());
		DtRegistro[] reg = (DtRegistro[]) request.getAttribute("registros");
		String img = (String)request.getAttribute("imagen");
		
	%>
	</div>
	<div class="container">
        <div class="card">
			<h2>Consulta Usuario</h2>
			<img width="380px" height="380px" src="data:image/png;base64,<%=img%>">
			<h3>Nickname: <%=nicknamee%></h3>
			<h3>nombre: <%=nombre%></h3>
			<h3>apellido: <%=apellido%></h3>
			<h3>email: <%=emaill%></h3>
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
	    	}
	    %>
	    </tbody>
	</table>
</body>
</html>