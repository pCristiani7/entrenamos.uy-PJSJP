<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Alta dictado de clase - Entrenamos UY</title>
		<link rel="stylesheet" href="css/styleLogin.css">
	</head>
	<body>
		<form action="AltaDictadoClase" method="post">
			<div class="container">
				<div class="card">
					<h3>Alta dictado<br>de clase</h3>
					
					<div class="inputBox">
						<input type="text" name="instDep" required="required">
						<span>Institucion Deportiva</span>
					</div>
					<div class="inputBox">
						<input type="text" name="actAso" required="required">
						<span>Actividad Deportiva</span>
					</div>
					<div class="inputBox">
						<input type="text" name="nomClase" required="required">
						<span>Nombre</span>
					</div>
					<div class="inputBox">
					    <label>Fecha</label>
					    <input type="date" name="fechaClase">
					  </div>
					  <div class="inputBox">
					    <label>Horario</label>
					    <input type="time" name="horarioClase">
					 </div>
					<div class="inputBox">
						<input type="text" name="urlClase" required="required">
						<span>URL</span>
					</div>
					<button>Enviar</button>
				</div>
			</div>	
		</form>
		<%@include file="/libraries.jsp"%>
	</body>
</html>