<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/styleLogin.css">
<title>Consulta Dictado de Clase</title>
</head>
<body>

<form action="ConsultaDictadodeClase" method="post">
	<div class="container">
		<div class="card">
			<h3>Consulta dictado<br>de clase</h3>
			
			<input type="hidden" name="origin" value="">

			<div class="inputBox">
				<input type="text" name="nameClase" required="required">
				<span>Clase</span>
			</div>
		
			<button onclick="procesar('consulta')">Aceptar</button>
		</div>
	</div>	
</form>
	<input type="hidden" name="origen" class="form-control" id="origenConsulta" value="ConsultaDictadodeClase">
</body>
</html>