 <%@page import="datatypes.DtClase"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Consulta de Actividad Deportiva</title>
<link rel="stylesheet" href="css/styleConsultas.css">
<%@page import="interfaces.Fabrica"%>
<%@page import="interfaces.IControlador"%>
</head>
<body>
	<div id="divCheckbox" style="display: none;">
	<%
		String nombre = (String)request.getAttribute("nombre");
		String descripcion = (String)request.getAttribute("descripcion");
		int duracion = (int)request.getAttribute("duracion");
		float costo = (float)request.getAttribute("costo");
		List<DtClase> clases = (List<DtClase>) request.getAttribute("listClases");
		String InstitucionDeportiva = (String)request.getAttribute("InstitucionDeportiva");
	%>
	</div>
	
    <div class="container">
        <div class="card">
        	<h2>Informacion<br>Actividad Deportiva</h2>
			<h3>Nombre: <%=nombre%></h3>
			<h3>Descripcion: <%=descripcion%></h3>
			<h3>Duracion: <%=duracion%></h3>
			<h3>Costo: <%=costo%></h3>
			<h3>Institucion deportiva: <%=InstitucionDeportiva%></h3>
			<form action="ConsultaDictadodeClase" method="post">
				<select class="inputBox" name="nomClase" id="actividades">
                      <%Fabrica fab = Fabrica.getInstance();
              			IControlador icon = fab.getIControlador();
                        for(String a: icon.listarClasesActividadDeportiva(nombre)){%> 
                            <option value="<%=a%>"><%=a%></option>
                      <%}%>
                </select>
                <button>Buscar Clase</button>
			</form>
        </div>
       </div>
</body>
</html>