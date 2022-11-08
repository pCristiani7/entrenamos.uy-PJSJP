<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/styleIndex.css">
	<script defer src="js/about.js"></script>
	<title>Home - Entrenamos UY</title>
	<!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
	</head>

	<body>
		
		<header>
			<i class='bx bx-dumbbell icon' style="margin-right: 80vh; width: 400px;"></i>
			<button data-modal-target="#modal">About</button>
			<a class="cta" href="login.jsp"><button>Login</button></a>
		</header>
		
		<div class="text">
				<p>Entrenamos UY</p>
		</div>
		
  <div class="modal" id="modal">
    <div class="modal-header">
      <div class="title">About</div>
      <button data-close-button class="close-button">&times;</button>
    </div>
    <div class="modal-body">
    <p1>
    
    Tecnologo en Informatica - Programacion de Aplicaciones
    <br><br/>
    Tarea 2 : Desarrollo Web
	<br>Aplicación Web : EntrenamosUy Web<br/>

	Herramientas Utilizadas : 
	 <br>Java, Apache Tomcat, Apache Maven, Eclipse IDE<br/>

	<br>Realizado por:<br/>
	Pablo Cristiani - pact1602@gmail.com<br/>
	Pedro Aldama - pedroaldama47@gmail.com
	<br>Juan Ugas Lopez - jsebastian.ugas@gmail.com<br/>
	Javier Rydel - javierydel98@gmail.com
	<br>Santiago Tutzo - santiagotutzo@gmail.com <br/>
	</p1>
    </div>
  </div>
  <div id="overlay"></div>
		
	</body>
</html>