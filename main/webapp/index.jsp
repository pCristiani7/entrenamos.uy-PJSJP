<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="ISO-8859-1">
	<link rel="stylesheet" href="css/styleIndex.css">
	<script defer src="js/about.js"></script>
	<title>Home - Entrenamos UY</title>
	</head>

	<body>
	
		<header>
			<img class="logo" src="images/logo.svg" alt="logo">	
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
      Lorem ipsum dolor sit amet consectetur adipisicing elit. Esse quod alias ut illo doloremque eum ipsum obcaecati distinctio debitis reiciendis quae quia soluta totam doloribus quos nesciunt necessitatibus, consectetur quisquam accusamus ex, dolorum, dicta vel? Nostrum voluptatem totam, molestiae rem at ad autem dolor ex aperiam. Amet assumenda eos architecto, dolor placeat deserunt voluptatibus tenetur sint officiis perferendis atque! Voluptatem maxime eius eum dolorem dolor exercitationem quis iusto totam! Repudiandae nobis nesciunt sequi iure! Eligendi, eius libero. Ex, repellat sapiente!
    </div>
  </div>
  <div id="overlay"></div>
		
	</body>
</html>