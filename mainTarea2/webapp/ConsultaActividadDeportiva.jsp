<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Consulta Actividad Deportiva - Entrenamos UY</title>
	<link rel="stylesheet" href="css/styleLogin.css">
	<%@page import="interfaces.Fabrica"%>
	<%@page import="interfaces.IControlador"%>
</head>
<body>

<form action="ConsultaActividadDeportiva" method="post">
	<div class="container">
		<div class="card">
			<h3>Consulta<br>Actividad<br>Deportiva</h3>			
			<div class="inputBox">
				<select class="inputBox" name="ActDep" id="actividades">
                      <%Fabrica fab = Fabrica.getInstance();
              			IControlador icon = fab.getIControlador();
                        for(String a: icon.listarActividades()){%> 
                            <option value="<%=a%>"><%=a%></option>
                      <%}%>
                </select>
			</div>			
			<button>Aceptar</button>
		</div>
	</div>	
</form>
</body>

</html>