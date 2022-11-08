<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Consulta Actividad Deportiva - Entrenamos UY</title>
		<link rel="stylesheet" href="css/styleLoginV2.css">
	<%HttpSession sesion = request.getSession(); 
String tipoUsuario = (String) sesion.getAttribute("tipoUsuario");
%>

<%
	if(tipoUsuario.equals("profesor")){
		%>
		<%@include file ="/headerProfesor.jsp" %>
		
		<% 	}else{
			%>
			<%@include file ="/headerSocio.jsp" %>
	<%} %>
	<%@page import="interfaces.Fabrica"%>
	<%@page import="interfaces.IControlador"%>
</head>
<body>
<%Fabrica fab = Fabrica.getInstance();
 IControlador icon = fab.getIControlador();
 String[] list = icon.listarActividades();%>
	<div class="container">
		<div class="card">
			<h3>Consulta<br>Actividad<br>Deportiva</h3>			
						<%
			if(list.length == 0){ %>
				<p>No hay actividades deportivas!</p>
				
            <%
            }else{	%>
           	<form action="ConsultaActividadDeportiva" method="post">
            	<div class="select">
				<select name="ActDep" id="actividades">
                    <%for(String a: list){%> 
                        <option value="<%=a%>"><%=a%></option>
                  <%}%>
            </select>
				</div>
            	<div style="text-align:center"><button style="margin-top: 5vh;" >Aceptar</button></div>
            </form>
           <%
           } %>		
		</div>
	</div>	
</body>

</html>