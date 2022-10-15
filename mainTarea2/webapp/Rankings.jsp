<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Rankings - Entrenamos UY</title>
	<link rel="stylesheet" href="css/styleLogin.css">
</head>
<body>
<form action="Rankings" method="post">
	<div class="container">
		<div class="card">
			<h3>Rankings</h3>
			<input type="hidden" name="boton" id="idBoton" value="">
			<button type="button" class="btn btn-primary"
				onclick="procesar('clases')">Dictados de Clases</button>
			<button type="button" class="btn btn-primary"
				onclick="procesar('actividades')">Actividades Deportivas</button>	
		</div>
	</div>	
</form>
<script type="text/javascript">
		function procesar(tipo) {
			document.getElementById("idBoton").value = tipo;
			document.forms[0].submit();
		}
</script>
</body>
</html>