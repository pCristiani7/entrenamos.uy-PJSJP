<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Actividad Deportiva</title>
</head>
<body>
	<form action="ConsultaActividadDeportiva" method="post">
		<div class="mb-3">
		  <label for="exampleFormControlInput1" class="form-label">Actividad Deportiva:</label>
		  <input type="text" class="form-control" id="inputActividadDeportiva" name="NomActDep">
		</div>
		<button type="submit" class="btn btn-primary">Confirmar</button>
	</form>
</body>
</html>