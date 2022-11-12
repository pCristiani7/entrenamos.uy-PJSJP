<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Alta dictado de clase - Entrenamos UY</title>
		<link rel="stylesheet" href="css/styleLogin.css">
		<%@page import="publicadores.DtUsuario"%>
		<%@page import="publicadores.DtProfesor"%>
		<%@page import="publicadores.DtInstitucionDeportiva"%>
		<%@page import="publicadores.DtActividadDeportiva"%>
		<%@include file ="/headerProfesor.jsp" %>
		<%@page import="java.util.List"%>
		
	</head>
	<body>
	<%
 	HttpSession sesion = request.getSession();
	String profNick = (String) sesion.getAttribute("name");
	DtUsuario dtUsuario = port.consultaUsuario(profNick);
	DtProfesor dtProfesor = (DtProfesor) dtUser;
	DtInstitucionDeportiva dtInst = port.getInstitucionDt(dtProf.getInstitucionDeportiva());
	DtActividadDeportiva[] listAct = port.getActividadesInstitucion(dtInst.getNombre());
	%>
 	<%if(listAct.length==0){%>
 		<p>En tu institucion no hay Actividades deportivas registradas!</p>
 		<%}else{%>
		<form action="AltaDictadoClase" method="post">
			<div class="container">
				<div class="card">
					<h3>Alta dictado<br>de clase</h3>
	            	<div class="select">
					<select name="actAso" id="actividades">
	                    <%for(DtActividadDeportiva a: listAct){%> 
	                        <option value="<%=a.getNombre()%>"><%=a.getNombre()%></option>
	                  <%}%>
	            	</select>
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
		<%}%>
		<%@include file="/libraries.jsp"%>
	</body>
</html>