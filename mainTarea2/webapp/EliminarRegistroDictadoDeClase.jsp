<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Eliminar Registro a Dictado de Clase - Entrenamos UY</title>
	<link rel="stylesheet" href="css/styleLogin.css">
	<%@page import="interfaces.Fabrica"%>
	<%@page import="interfaces.IControlador"%>
	<%@page import="datatypes.DtSocio"%>
	<%@page import="datatypes.DtRegistro"%>
	<%@page import="java.util.List"%>
</head>
<body>
<form action="EliminarRegistroDictadoDeClase" method="post">
	<div class="container">
		<div class="card">
			<h3>Eliminar<br>Registro<br>a Dictado de Clase</h3>			
			<div class="inputBox">
				<select class="inputBox" name="regDict" id="registros">
                      <%
                      	Fabrica fab = Fabrica.getInstance();
              			IControlador icon = fab.getIControlador();
              			
              			HttpSession sesion = request.getSession();
              			String nickname = (String) sesion.getAttribute("name");
                  		
              			DtSocio dtSoc = icon.findSocio(nickname);
              			List<DtRegistro> registros = dtSoc.getDtRegistros();
              			
                        for(DtRegistro a: registros){%> 
                        <option value="<%=a%>"><%=a.getClase()%> - <%=a.getFecha()%></option>
                      <%}%>
                </select>
			</div>
			<%
			if(registros.isEmpty()){ %>
				<p>El usuario no tiene registros!</p>
				
            <%
            }else{	%>
            	<button>Aceptar</button>
           
           <%
           } %>
		</div>
	</div>	
</form>
</body>
</html>