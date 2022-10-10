<%@page import="datatypes.DtClase"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Actividad Deportiva</title>
</head>
<body>
	<div id="divCheckbox" style="display: none;">
	<%
		String nombre = (String)request.getAttribute("nombre");
		String descripcion = (String)request.getAttribute("descripcion");
		int duracion = (int)request.getAttribute("duracion");
		float costo = (float)request.getAttribute("costo");
		ArrayList<DtClase> clases = (ArrayList<DtClase>) request.getAttribute("clases");
		String InstitucionDeportiva = (String)request.getAttribute("InstitucionDeportiva");
	%>
	</div>
	
	<h1>Informacion de Actividad Deportiva</h1>
	<h3>Nombre: <%=nombre%></h3>
	<h3>Descripcion: <%=descripcion%></h3>
	<h3>Duracion: <%=duracion%></h3>
	<h3>Costo: <%=costo%></h3>
	<h3>Institucion deportiva: <%=InstitucionDeportiva%></h3>
	
	<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      <th scope="col">Clase</th>
	      <th scope="col">Profesor</th>
	      <th scope="col">Url</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    	int i = 1;
	    	for(DtClase dtc: clases){
	    %>
	    	<tr>
	    		<th scope="row"><%=i%></th>
	    		<td><%=dtc.getNombre()%></td>
	    		<td><%=dtc.getProfesor()%></td>
	    		<td><%=dtc.getUrl()%></td>
	    	</tr>
	    <%
	    	}
	    %>
	  </tbody>
	</table>
	
</body>
</html>