<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<link rel="stylesheet" href="css/styleLogin.css">
	</head>
	<body>
		<div class="container">
			<div class="card">
			<h3>ERROR</h3>
			<p style="text-align:center">Hubo un error al intentar dar de alta la clase, puede reintentarlo o volver al menú principal</p>
			<div>
				<button onclick="location.href='http://localhost:8080/entrenamosWeb/AltaDictadoDeClase.jsp'">Reintentar</button>
				<button style="margin-left:20px" onclick="location.href='http://localhost:8080/entrenamosWeb/userPage.jsp'">Cancelar</button>
			</div>
			</div>
		</div>
	</body>
</html>