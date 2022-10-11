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
	
		<form action="ConsultaDictadodeClase" method="post">
			<div style="margin:0 auto; position:relative; margin-left:50px; width:900px; margin-bottom:40px">
			  <div class="mb-3">
			    <label for="field1" class="form-label">Institucion Deportiva</label>
			    <input type="text" name="instDepReg" class="form-control" id="inputField1">
			  </div>
			  <div class="mb-3">
			    <label for="field2" class="form-label">Actividad Deportiva</label>
			    <input type="text" name="actDepReg" class="form-control" id="inputField2">
			  </div>
			  <div class="mb-3">
			    <label for="field3" class="form-label">Clase</label>
			    <input type="text" name="nomClaseReg" class="form-control" id="inputField3">
			  </div>		  
			  <button type="submit" class="btn btn-primary">Registrarse</button>
			</div>  
		</form>
		<form action="ConsultaDictadodeClasePt2.jsp" method="post">
				<input type="hidden" name="origen" class="form-control" id="origenConsulta" value="RegistroDictadodeClase">
			</form>	
		<%@include file="/libraries.jsp"%>
	</body>
</html>