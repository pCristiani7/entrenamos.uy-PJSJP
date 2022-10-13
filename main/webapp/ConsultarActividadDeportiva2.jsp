 <%@page import="datatypes.DtClase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Actividad Deportiva</title>
<link rel="stylesheet" href="css/styleConsultas.css">
</head>
<body>
	<div id="divCheckbox" style="display: none;">
	<%
		String nombre = (String)request.getAttribute("nombre");
		String descripcion = (String)request.getAttribute("descripcion");
		int duracion = (int)request.getAttribute("duracion");
		float costo = (float)request.getAttribute("costo");
		List<DtClase> clases = (List<DtClase>) request.getAttribute("listClases");
		String InstitucionDeportiva = (String)request.getAttribute("InstitucionDeportiva");
	%>
	</div>
	
    <div class="container">
        <div class="card">
        	<h2>Informacion<br>Actividad Deportiva</h2>
			<h3>Nombre: <%=nombre%></h3>
			<h3>Descripcion: <%=descripcion%></h3>
			<h3>Duracion: <%=duracion%></h3>
			<h3>Costo: <%=costo%></h3>
			<h3>Institucion deportiva: <%=InstitucionDeportiva%></h3>
        </div>
       </div>
			<table class="center">
			  <thead>
			    <tr>
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
			    		<td><%=dtc.getNombre()%></td>
			    		<td><%=dtc.getProfesor()%></td>
			    		<td><%=dtc.getUrl()%></td>
			    	</tr>
			    <%
			    	i++;
			    }
			    %>
			  </tbody>
			</table>
</body>
</html>