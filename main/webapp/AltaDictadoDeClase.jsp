<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<%@include file="/bootcss.jsp"%>
		<title>EntrenamosUy - Alta dictado de clase</title>
	</head>
	<body>
		<h3 class="card">Alta dictado de clase</h3>
	
		<form action="AltaDictadoClase" method="post">
			<div style="margin:0 auto; position:relative; margin-left:50px; width:900px; margin-bottom:40px">
			  <div class="mb-3">
			    <label for="field1" class="form-label">Institucion Deportiva</label>
			    <input type="text" name="instDep" class="form-control" id="inputField1">
			  </div>
			  <div class="mb-3">
			    <label for="field2" class="form-label">Actividad Asociada</label>
			    <input type="text" name="actAso" class="form-control" id="inputField2">
			  </div>
			  <div class="mb-3">
			    <label for="field3" class="form-label">Nombre</label>
			    <input type="text" name="nomClase" class="form-control" id="inputField3">
			  </div>
			  <div class="mb-3">
			    <label for="field4" class="form-label">Fecha</label>
			    <input type="date" name="fechaClase" class="form-control" id="inputField4">
			  </div>
			  <div class="mb-3">
			    <label for="field5" class="form-label">Horario</label>
			    <input type="time" name="horarioClase" class="form-control" id="inputField5">
			  </div>
			  <div class="mb-3">
			    <label for="field9" class="form-label">URL</label>
			    <input type="text" name="urlClase" class="form-control" id="inputField8">
			  </div>
			  <button type="submit" class="btn btn-primary">Enviar</button>
			</div>  
		</form>
	<%@include file="/libraries.jsp"%>
	</body>
</html>