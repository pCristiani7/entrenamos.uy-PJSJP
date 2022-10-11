<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@include file="/bootcss.jsp"%>
		<title>Registro dictado de clase</title>
	</head>
	<body>
		<h3 class="card">Registro dictado de clase</h3>
	
		<form action="RegistroDictadoClase" method="post">
			<div style="margin:0 auto; position:relative; margin-left:50px; width:900px; margin-bottom:40px">
			  <div class="mb-3">
			    <label for="field1" class="form-label">Institucion Deportiva</label>
			    <input type="text" name="instDep" class="form-control" id="inputField1">
			  </div>
			  <div class="mb-3">
			    <label for="field2" class="form-label">Actividad Deportiva</label>
			    <input type="text" name="actDep" class="form-control" id="inputField2">
			  </div>
			  <div class="mb-3">
			    <label for="field3" class="form-label">Clase</label>
			    <input type="text" name="nomClase" class="form-control" id="inputField3">
			  </div>
			  <button type="submit" class="btn btn-primary">Registrarse</button>
			</div>  
		</form>
		<%@include file="/libraries.jsp"%>
	</body>
</html>