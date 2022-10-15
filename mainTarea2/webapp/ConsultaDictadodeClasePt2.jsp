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
 <%
 		//Datos recibidos para la impresion del dtClase
        String nameClase = (String)request.getAttribute("nombreClase");
        String url = (String)request.getAttribute("urlClase");
        String actividadDeportiva = (String)request.getAttribute("actDepClase");
        String profesor = (String)request.getAttribute("profClase");
        LocalDate fecha = (LocalDate)request.getAttribute("fechaClase");
        LocalTime horaInicio = (LocalTime)request.getAttribute("horarioClase");
        LocalDate fechaReg = (LocalDate)request.getAttribute("fechaRegClase");
        List <DtRegistro> registrosClase = (List<DtRegistro>) request.getAttribute("registrosClase");
        
        //Datos recibidos para el Registro Dictado de Clase
        String institDep = (String)request.getAttribute("institRegistro");
		String actividadDep = (String)request.getAttribute("activRegistro");
		String nombreClaseReg = (String)request.getAttribute("claseRegistro");
		String elOrigen = (String)request.getAttribute("origen");
    %>

   <div class="container">
        <div class="card">
			<h3>Nombre: <%=nameClase%></h3>
		    <h3>URL: <%=url%></h3>
		    <h3>Actividad deportiva: <%=actividadDeportiva%></h3>
		    <h3>Profesor: <%=profesor%></h3>
		    <h3>Fecha: <%=fecha%></h3>
		    <h3>Hora de inicio: <%=horaInicio%></h3>
		    <h3>Fecha de registro: <%=fechaReg%></h3>		    
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

	<%if(elOrigen=="regDictadoClase"){ %>
		<form action="RegistroDictadoClase" method="post">
			<input type="hidden" name="instDepReg" class="form-control" value="<%=institDep%>">
			<input type="hidden" name="actDepReg" class="form-control" value="<%=actividadDep%>">
			<input type="hidden" name="nombreClaseReg" class="form-control" value="<%=nombreClaseReg%>">	
			<button type="submit" class="btn btn-primary">Registrarse</button>
		</form>
	<% } %>
</body>
</html>