<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Datos del Socio</title>
<link rel="stylesheet" href="css/styleLogin.css">
</head>
<body>
<form action="ModificarDatosUsuario" method="post">
			<div class="container">
				<div class="card">
					<h3>Modificar datos<br>del Socio</h3>
					
					<div class="inputBox">
						<input type="text" name="nomUsuario" required="required">
						<span>Nombre del Socio</span>
					</div>
					<div class="inputBox">
						<input type="text" name="apeUsuario" required="required">
						<span>Apellido del Socio</span>
					</div>
					<div class="inputBox">
					    <label>Fecha de Nacimiento nueva</label>
					    <input type="date" name="fNacUsuario">
					  </div>
					<button type="submit">Enviar</button>
				</div>
			</div>	
		</form>
 

</body>
</html>