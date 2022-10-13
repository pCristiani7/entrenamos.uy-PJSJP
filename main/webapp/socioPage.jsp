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
							<h2>Pablo Cristiani</h2>
						</div>
						<hr>
						
						<a href="ModificarDatosSocio.jsp" class="sub-menu-link">
							<img src="images/editprofile.svg">
							<p>Edit Profile</p>
							<span></span>
						</a>
						
						<a href="logout.jsp" class="sub-menu-link">
							<img src="images/logout.svg">
							<p>Logout</p>
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