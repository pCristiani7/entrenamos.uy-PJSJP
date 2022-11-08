<%@page import="datatypes.DtActividadDeportiva"%>
<%@page import="datatypes.DtClase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@include file ="/headerProfesor.jsp" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="css/styleConsultas.css">
<body>
		<div class="container">
	<%
		String mostrar = (String) request.getAttribute("mostrar");
		if (mostrar.equals("actividades")) {
			List<DtActividadDeportiva> actividades = (List<DtActividadDeportiva>) request.getAttribute("dtacts");
	%>
	<h1>
		Actividades Deportivas
		</h1>
	<table >
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nombre</th>
				<th scope="col">Costo</th>
				<th scope="col">Descripcion</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
					for (DtActividadDeportiva dta : actividades) {
			%>
			<tr>
				<th scope="row"><%=i%></th>
				<td><%=dta.getNombre()%></td>
				<td><%=dta.getCosto()%></td>
				<td><%=dta.getDescripcion()%></td>
			</tr>
			<%
				i++;
					}
			%>
		</tbody>
	</table>
	<%
		} else if (mostrar.equals("clases")) {
			List<DtClase> dtc = (List<DtClase>) request.getAttribute("dtclases");
	%>
	<h1>
		Clases
		</h1>
	<table >
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Nombre</th>
				<th scope="col">Fecha</th>
				<th scope="col">URL</th>
			</tr>
		</thead>
		<tbody>
			<%
				int i = 1;
					for (DtClase dtClase : dtc) {
			%>
			<tr>
				<th scope="row"><%=i%></th>
				<td><%=dtClase.getNombre()%></td>
				<td><%=dtClase.getFecha()%></td>
				<td><%=dtClase.getUrl()%></td>				
			</tr>
			<%
			i++;
					}
			}
			%>
		</tbody>
	</table>
	</div>
</body>
</html>