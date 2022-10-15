<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/userPage.css">
	<title>Socio - EntrenamosUY</title>
</head>

	<body>
	<%
		String nickname = (String)request.getAttribute("nickname");
		String nombre = (String)request.getAttribute("nombre");
		String apellido = (String)request.getAttribute("apellido");
		String email = (String)request.getAttribute("email");
	%>
	
		<div class="hero">
			<nav>
				<img src="images/logo.svg" class="logo">
				<ul>
					<li><a href="ConsultaActividadDeportiva.jsp">Consulta Actividad Deportiva</a>
					<li><a href="RegistroDictadoDeClase.jsp">Registro a Dictado de Clase</a>
					<li><a href="EliminarRegistroAClase.jsp">Eliminar Registro a Clase</a>
				</ul>
				<img src="images/profile.svg" class="user-pic" onclick="toggleMenu()">
				
				<div class="sub-menu-wrap" id="subMenu">
					<div class="sub-menu">
						<div class="user-info">
							<img src="images/profile.svg">
							<h2><%=nickname%></h2>
							
							<div class="emailSocio">
								<h3><%=email%></h3>
							</div>
							
						</div>
						<hr>
						
						<form action="ConsultaUsuario" method="post">
						<a class="sub-menu-link">
							<img src="images/profileEdit.svg">
							<button>Ver Perfil</button>
							<span></span>
						</a>
						</form>
						
						<a href="ModificarDatosSocio.jsp" class="sub-menu-link">
							<img src="images/consulta.svg">
							<p>Modificar Perfil</p>
							<span></span>
						</a>
						
						<a href="logout.jsp" class="sub-menu-link">
							<img src="images/logoutt.svg">
							<p>Cerrar Sesion</p>
							<span></span>
						</a>
						
						
					</div>
				</div>
				
			</nav>
		</div>
		
		<script>
			let subMenu = document.getElementById("subMenu");
			
			function toggleMenu(){
				subMenu.classList.toggle("open-menu");
			}
		</script>
		
	</body>

</html>