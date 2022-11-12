<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Registro dictado de clase - Entrenamos UY</title>
		<%@page import="publicadores.DtClase"%>
		<%@include file ="/headerSocio.jsp" %>
		<link rel="stylesheet" href="css/styleLogin.css">
	</head>
	<body>
	<%
	String[] listClases = port.listarClasesFront();
	%>
	<%if(listClases.length == 0){%>
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
				  <button type="submit" style="margin-bottom:10px">Registrarse</button>
				</div>
			</div>
		</form>
		<%}%>
	</body>
</html>