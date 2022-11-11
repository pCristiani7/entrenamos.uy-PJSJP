<%@page import="datatypes.DtRegistro"%>
<%@page import="java.util.List"%>
<%@ page import = "java.util.Calendar"%>
<%@ page import = "java.time.LocalTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<%HttpSession sesion = request.getSession(); 
String tipoUsuario = (String) sesion.getAttribute("tipoUsuario");
%>

<%
	if(tipoUsuario.equals("profesor")){
		%>
		<%@include file ="/headerProfesor.jsp" %>
		
		<% 	}else{
			%>
			<%@include file ="/headerSocio.jsp" %>
	<%} %>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/styleConsultas.css">
		<title>Consulta Dictado de Clase</title>
	</head>
	<body style="background: #e3e3e3">
	 							<!--Caso de uso Consulta Dictado de Clase (Juan) -->
	 <%
	 String origen = (String) request.getAttribute("origenConsulta");
	 
	 if(origen.equals("consultaDictadodeClase")){
		 	String nombreClase = (String) request.getAttribute("nomClase");
		    String urlClase = (String) request.getAttribute("url");
		    String actividadDeportivaClase = (String) request.getAttribute("actividadDeportiva");
		    String profesorClase = (String) request.getAttribute("profesor");
		    Calendar fechaClase = (Calendar) request.getAttribute("fecha");
		    LocalTime horaInicioClase = (LocalTime) request.getAttribute("horario");
		    Calendar fechaRegClase = (Calendar) request.getAttribute("fechaReg");
		    List <DtRegistro> registrosClase = (List<DtRegistro>) request.getAttribute("registros");
	 %>
	        
	    <div class="container">
	        <div class="card">
	        	<div class="datosCard">
					<h3>Nombre: <%=nombreClase%></h3>
				    <h3>URL: <%=urlClase%></h3>
				    <h3>Actividad deportiva: <%=actividadDeportivaClase%></h3>
				    <h3>Profesor: <%=profesorClase%></h3>
				    <h3>Fecha: <%=fechaClase%></h3>
				    <h3>Hora de inicio: <%=horaInicioClase%></h3>
				    <h3>Fecha de registro: <%=fechaRegClase%></h3>
				</div>    		    
			</div>
			<div class="forTable">
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
			</div>
		</div>
        
        		<!--Caso de uso Registro Dictado de Clase (Santi)  -->
        
        <% }else if(origen.equals("registroDictadodeClase")){
	 		String nombreClase = (String) request.getAttribute("nomClase");
	        String urlClase = (String) request.getAttribute("url");
	        String actividadDeportivaClase = (String) request.getAttribute("actividadDeportiva");
	        String profesorClase = (String) request.getAttribute("profesor");
	        Calendar fechaClase = (Calendar) request.getAttribute("fecha");
	        LocalTime horaInicioClase = (LocalTime) request.getAttribute("horario");
	        Calendar fechaRegClase = (Calendar) request.getAttribute("fechaReg");
	        List <DtRegistro> registrosClase = (List<DtRegistro>) request.getAttribute("registros");
        //Datos recibidos para el Registro Dictado de Clase

		%>
		<div class="container">
	        <div class="card">
	        	<div class="datosCard">
					<h3>Nombre: <%=nombreClase%></h3>
				    <h3>URL: <%=urlClase%></h3>
				    <h3>Actividad deportiva: <%=actividadDeportivaClase%></h3>
				    <h3>Profesor: <%=profesorClase%></h3>
				    <h3>Fecha: <%=fechaClase%></h3>
				    <h3>Hora de inicio: <%=horaInicioClase%></h3>
				    <h3>Fecha de registro: <%=fechaRegClase%></h3>
				</div>	    
			</div>
			<div class="forTable">
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
			</div>
			<div style="margin:auto; margin-top:20px; position:relative; text-align:center; width:50%">
				<form action="RegistroDictadoClase" method="post">
					<input type="hidden" name="nomClase" class="form-control" value="<%=nombreClase%>">
					<button type="submit" class="btn btn-primary" style="text-align:center; margin-top: 30vh;" >Registrarse</button>
				</form>
			</div>
		</div>
 		<% }%>
	</body>
</html>