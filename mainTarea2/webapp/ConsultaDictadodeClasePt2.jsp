<%@page import="datatypes.DtRegistro"%>
<%@page import="java.util.List"%>
<%@ page import = "java.time.LocalDate"%>
<%@ page import = "java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styleConsultas.css">
<title>Consulta Dictado de Clase</title>
</head>
<body>
 							<!--Caso de uso Conulta Dictado de Clase (Juan) -->
 <%
 		String origen = (String)request.getAttribute("origenConsulta");
        if(origen.equals("consultaDictadodeClase")){
 		String nombreClase = (String)request.getAttribute("nomClase");
        String urlClase = (String)request.getAttribute("url");
        String actividadDeportivaClase = (String)request.getAttribute("actividadDeportiva");
        String profesorClase = (String)request.getAttribute("profesor");
        LocalDate fechaClase = (LocalDate)request.getAttribute("fecha");
        LocalTime horaInicioClase = (LocalTime)request.getAttribute("horario");
        LocalDate fechaRegClase = (LocalDate)request.getAttribute("fechaReg");
        List <DtRegistro> registrosClase = (List<DtRegistro>) request.getAttribute("registros");
        %>
        
        <div class="container">
        <div class="card">
			<h3>Nombre: <%=nombreClase%></h3>
		    <h3>URL: <%=urlClase%></h3>
		    <h3>Actividad deportiva: <%=actividadDeportivaClase%></h3>
		    <h3>Profesor: <%=profesorClase%></h3>
		    <h3>Fecha: <%=fechaClase%></h3>
		    <h3>Hora de inicio: <%=horaInicioClase%></h3>
		    <h3>Fecha de registro: <%=fechaRegClase%></h3>		    
		</div>
	</div>
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
	    for (DtRegistro dtR : registrosClase){
	    %>
	    	<tr>
	    		<th scope="row"><%=i%></th>
	      		<td><%=dtR.getSocio()%></td>
	      		<td><%=dtR.getFecha()%></td>
	    	</tr>
	    	<%
	    	i++;
	    }
	    %>
  	  </tbody>
	</table>
        
        		<!--Caso de uso Registro Dictado de Clase (Santi)  -->
        
        <% }else if(origen.equals("registroDictadodeClase")){
 		
        //Datos recibidos para el Registro Dictado de Clase
        String nombreClase = (String)request.getAttribute("nomClase");
        String urlClase = (String)request.getAttribute("url");
        String actividadDeportivaClase = (String)request.getAttribute("actividadDeportiva");
        String profesorClase = (String)request.getAttribute("profesor");
        LocalDate fechaClase = (LocalDate)request.getAttribute("fecha");
        LocalTime horaInicioClase = (LocalTime)request.getAttribute("horario");
        LocalDate fechaRegClase = (LocalDate)request.getAttribute("fechaReg");
        List <DtRegistro> registrosClase = (List<DtRegistro>) request.getAttribute("registros");
        String institDep = (String)request.getAttribute("institRegistro");
		String actividadDep = (String)request.getAttribute("activRegistro");
		String nombreClaseReg = (String)request.getAttribute("claseRegistro");
		%>
		<div class="container">
        <div class="card">
			<h3>Nombre: <%=nombreClase%></h3>
		    <h3>URL: <%=urlClase%></h3>
		    <h3>Actividad deportiva: <%=actividadDeportivaClase%></h3>
		    <h3>Profesor: <%=profesorClase%></h3>
		    <h3>Fecha: <%=fechaClase%></h3>
		    <h3>Hora de inicio: <%=horaInicioClase%></h3>
		    <h3>Fecha de registro: <%=fechaRegClase%></h3>		    
		</div>
	</div>
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
	    for (DtRegistro dtR : registrosClase){
	    %>
	    	<tr>
	    		<th scope="row"><%=i%></th>
	      		<td><%=dtR.getSocio()%></td>
	      		<td><%=dtR.getFecha()%></td>
	    	</tr>
	    	<%
	    	i++;
	    }
	    %>
  	  </tbody>
	</table>
					<!--Revisar nombre de las variables para seguir con RegistroDictadoDeClase.java(servlet)  -->
        <form action="RegistroDictadoClase" method="post">
		<input type="hidden" name="instDepReg" class="form-control" value="<%=institDep%>">
		<input type="hidden" name="actDepReg" class="form-control" value="<%=actividadDep%>">
		<input type="hidden" name="nombreClaseReg" class="form-control" value="<%=nombreClaseReg%>">	
		<button type="submit" class="btn btn-primary">Registrarse</button>
	</form>
 	}
 	%>	

</body>
</html>