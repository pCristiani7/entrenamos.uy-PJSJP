<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Alta dictado de clase - Entrenamos UY</title>
		<link rel="stylesheet" href="css/styleLoginV2.css">
		<%@page import="interfaces.Fabrica"%>
		<%@page import="interfaces.IControlador"%>
		<%@page import="datatypes.DtUsuario"%>
		<%@page import="datatypes.DtProfesor"%>
		<%@page import="datatypes.DtInstitucionDeportiva"%>
		<%@page import="datatypes.DtActividadDeportiva"%>
		<%@include file ="/headerProfesor.jsp" %>
		<%@page import="java.util.List"%>
		
	</head>
	<body>
	<%Fabrica fab = Fabrica.getInstance();
 	IControlador icon = fab.getIControlador();
 	HttpSession sesion = request.getSession();
	String profNick = (String) sesion.getAttribute("name");
	DtUsuario dtUserr = icon.ConsultaUsuario(profNick);
	DtProfesor dtProf = (DtProfesor) dtUserr;
	DtInstitucionDeportiva dtInst = icon.getInstitucionDt(dtProf.getInstitucionDeportiva());
	List<DtActividadDeportiva> listAct = icon.getActividadesInstitucion(dtInst.getNombre());
	%>
 	<%if(listAct.isEmpty()){%>
 		<p>En tu institucion no hay Actividades deportivas registradas!</p>
 		<%}else{%>
		<form action="AltaDictadoClase" method="post">
			<div class="container">
				<div class="card">
					<h3 style="margin-top: 3vh;">Alta dictado<br>de clase</h3>
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
					<button style="margin-bottom: 3vh; ">Enviar</button>
				</div>
			</div>	
		</form>
		<%}%>
		<%@include file="/libraries.jsp"%>
	</body>
</html>