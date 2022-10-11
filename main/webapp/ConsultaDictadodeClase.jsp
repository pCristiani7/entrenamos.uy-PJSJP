<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta Dictado de Clase</title>
</head>
<body>
	<form action="ConsultaDictadodeClase" method="post">
	<div class="mb-3 row">
	<label for="inputNick" class="col-sm-2 col-form-label">Ingrese el nombre de la Clase a consultar</label>
	</div>
	<input class="form-control" 
	type="text"
	placeholder="Nombre de la clase" 
	id="inputClase"
	name="nomClase">
	<div>
   	<button class="btn btn-primary" type="submit">Consultar esta Clase</button>
    </div>
	</form>
	
		<input type="hidden" name="origen" class="form-control" id="origenConsulta" value="ConsultaDictadodeClase">
</body>
</html>