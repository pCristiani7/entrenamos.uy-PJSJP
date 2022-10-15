<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Datos del Profesor</title>
<link rel="stylesheet" href="css/styleLogin.css">
</head>
<body>
<form action="ModificarDatosUsuario" method="post">
			<div class="container">
				<div class="card">
					<h3>Modificar datos<br>del profesor</h3>
					
					<div class="inputBox">
						<input type="text" name="nomUsuario" required="required">
						<span>Nombre del Profesor</span>
					</div>
					<div class="inputBox">
						<input type="text" name="apeUsuario" required="required">
						<span>Apellido del Profesor</span>
					</div>
					<div class="inputBox">
					    <label>Fecha de Nacimiento nueva</label>
					    <input type="date" name="fNacUsuario">
					  </div>
					 <div class="inputBox">
						<input type="text" name="descProf" required="required">
						<span>Descripcion</span>
					</div>
					<div class="inputBox">
						<input type="text" name="bioProf" required="required">
						<span>Biografia</span>
					</div>
					<div class="inputBox">
						<input type="text" name="swProf" required="required">
						<span>Sitio Web</span>
					</div>
					
					<button type="submit">Enviar</button>
				</div>
			</div>	
		</form>

</body>
</html>