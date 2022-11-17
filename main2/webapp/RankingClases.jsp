<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>Rankings - Entrenamos UY</title>
	<link rel="stylesheet" href="css/styleLogin.css">
	<%@include file ="/headerProfesor.jsp" %>
</head>
<body>
<form id="myForm" action="Rankings" method="post">
			<input type="hidden" name="boton" id="idBoton" value="clases">
</form>
<script type="text/javascript">
    document.getElementById('myForm').submit();
</script>
<script type="text/javascript">
</script>
</body>
</html>