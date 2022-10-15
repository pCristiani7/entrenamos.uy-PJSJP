<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Registro dictado de clase</title>
			<link rel="stylesheet" href="css/styleLogin.css">
	</head>
	<body>
	
		<form action="RegistroDictadoClase" method="post">
			<div class="container">
				<div class="card">
					<h3>Registrarse<br>a clase</h3>
					<div class="inputBox">
						<input type="text" name="instDep" required="required">
						<span>Institucion Deportiva</span>
					</div>
					<div class="inputBox">
						<input type="text" name="actDep" required="required">
						<span>Actividad Deportiva</span>
					</div>
					<div class="inputBox">
						<input type="text" name="nomClase" required="required">
						<span>Clase</span>
					</div>
					<button>Registrarse</button>
				</div>
			</div>	
		</form>	

	</body>
</html>