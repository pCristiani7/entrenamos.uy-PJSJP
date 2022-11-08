<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<title>Registro dictado de clase - Entrenamos UY</title>
		<%@page import="datatypes.DtClase"%>
		<%@page import="interfaces.Fabrica"%>
		<%@page import="interfaces.IControlador"%>
		<%@page import="java.util.ArrayList"%>
		<%@include file ="/headerSocio.jsp" %>
		<link rel="stylesheet" href="css/styleLoginV2.css">
	</head>
	<body>
	<%Fabrica fab = Fabrica.getInstance();
 	IControlador icon = fab.getIControlador();
	ArrayList <String> listClases = icon.listarClasesFront();
	%>
	<%if(listClases.isEmpty()){%>
		<p>No hay clases en el sistema</p>
	<%}else{%>
		<form action="ConsultaDictadodeClase" method="post">
			<div class="container">
				<div class="card">
					<h3>Registro dictado<br>de clase</h3>

	            	<div class="select">
					<select name="nombreClase" id="actividades">
	                    <%for(String a: listClases){%> 
	                        <option value="<%=a%>"><%=a%></option>
	                  <%}%>
	            	</select>
					</div>
				  <input type="hidden" name="origenConsulta" id=idOrigenConsulta value="registroDictadodeClase">
				  <button type="submit">Registrarse</button>
				</div>
			</div>
		</form>
		<%}%>
	</body>
</html>