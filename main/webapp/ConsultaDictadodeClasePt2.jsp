

<%@page import="datatypes.DtRegistro"%>
<%@page import="java.util.ArrayList"%>
<%@ page import = "java.time.LocalDate"%>
<%@ page import = "java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Dictado de Clase</title>
</head>
<body>
 <%
 		//Datos recibidos para la impresion del dtClase
        String nomClase = (String)request.getAttribute("nomClase");
        String url = (String)request.getAttribute("url");
        ArrayList <DtRegistro> registros = (ArrayList<DtRegistro>)request.getAttribute("registros");
        String actividadDeportiva = (String)request.getAttribute("actividadDeportiva");
        String profesor = (String)request.getAttribute("profesor");
        LocalDate fecha = (LocalDate)request.getAttribute("fecha");
        LocalTime horaInicio = (LocalTime)request.getAttribute("horaInicio");
        LocalDate fechaReg = (LocalDate)request.getAttribute("fechaReg");
        //Datos recibidos para el registro a Dictado de Clase
        String insDep = request.getParameter("instDepReg");
		String activDep = request.getParameter("actDepReg");
		String nomClaseReg = request.getParameter("nomClaseReg");
		String origen = request.getParameter("origen");
    %>


	<h3>Nombre: <%=nomClase%></h3>
    <h3>URL: <%=url%></h3>activDep
    <h3>Actividad deportiva: <%=actividadDeportiva%></h3>
    <h3>Profesor: <%=profesor%></h3>
    <h3>Fecha: <%=fecha%></h3>
    <h3>Hora de inicio: <%=horaInicio%></h3>
    <h3>Fecha de registro: <%=fechaReg%></h3>
	<table class="table">
	  <thead>
	    <tr>
			<th scope="col">#</th>    
	      <th scope="col">Clase</th>
	      <th scope="col">Fecha</th>
	    </tr>
	  </thead>
	  <tbody>
	    <%
	    int i=1;
	    registros = new ArrayList<>();
	    for (DtRegistro dtR : registros){
	    %>
	 
	    	<tr>
	    		<th scope="row"><%=i%></th>
	      		<td><%="nomClase"%></td>
	      		<td><%=dtR.getFecha()%></td>
	    	</tr>
	    	<%
	    }
	    %>
  	  </tbody>
	</table>

	<form action="RegistroDictadoDeClase" method="post">
		<input type="hidden" name="instDepReg" class="form-control" value=<%=insDep%>>
		<input type="hidden" name="actDepReg" class="form-control" value=<%=activDep%>>
		<input type="hidden" name="nombreClaseReg" class="form-control" value=<%=nomClaseReg%>>	
		<%
		if(origen=="RegistroDictadoDeClase"){ %>
			<button type="submit" class="btn btn-primary">Registrarse</button>
		<% } %>
	</form>
</body>
</html>