<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@page import="java.util.Base64" %>
	<%@page import="publicadores.DtProfesor"%>
	<%@page import ="java.util.Date"%>
<meta charset="ISO-8859-1">
<title>Modificar Datos del Profesor</title>
<%@include file ="/headerProfesor.jsp" %>
<link rel="stylesheet" href="css/styleLoginV2.css">
</head>
<body>

<%
        HttpSession sesion = request.getSession();
        String nicknamee = (String) sesion.getAttribute("name");
        DtProfesor dtProfesor = port.findProfesor(nicknamee);
        String imgEnn = (String)Base64.getEncoder().encodeToString(dtProfesor.getProfileImage());
 %>
 
<form action="ModificarDatosUsuario" method="post">
			<div class="container">
				<div class="card">
					<h3 style="margin-top: 5vh;">Modificar datos<br>del profesor</h3>
					
					<img src="data:image/png;base64,<%=imgEnn%>" width="250px" height="250px" name="imagenPreCarga" id="imagenPreCarga" class="responsive">
					<input type="file" class="custom-file-input" name="imagenNew" id="imagenNew" maxlength="256" placeholder="ImagenNew" accept="image/*">
					<input type="hidden" name="img" id="img" value="">
					
					<div class="inputBox">
						<input id="1" type="text" name="nomUsuario">
						<script>document.getElementById('1').value='<%=dtProf.getNombre()%>';</script>
						<span>Nombre del Profesor</span>
					</div>
					<div class="inputBox">
						<input id="2" type="text" name="apeUsuario" >
						<script>document.getElementById('2').value='<%=dtProf.getApellido()%>';</script>
						<span>Apellido del Profesor</span>
					</div>
					 <div class="inputBox">
						<input id="4" type="text" name="descProf" >
						<script>document.getElementById('4').value='<%=dtProf.getDescripcion()%>';</script>
						<span>Descripcion</span>
					</div>
					<div class="inputBox">
						<input id="5" type="text" name="bioProf" >
						<script>document.getElementById('5').value='<%=dtProf.getBiografia()%>';</script>
						<span>Biografia</span>
					</div>
					<div class="inputBox">
						<input id="6" type="text" name="swProf" >
						<script>document.getElementById('6').value='<%=dtProf.getSitioweb()%>';</script>
						<span>Sitio Web</span>
					</div>
					
					<button type="submit" style="margin-bottom: 3vh;" >Enviar</button>
				</div>
			</div>	
		</form>

</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script> 
<script>
    function readURL(input) {
          if (input.files && input.files[0]) {
            var reader = new FileReader();
            reader.onload = function(e) {
                  // Asignamos el atributo src a la tag de imagenNew
                  $('#imagenPreCarga').attr('src', e.target.result);
                  $('#img').attr('value', e.target.result);
            }
               reader.readAsDataURL(input.files[0]);
             }
    }
    //El listener va asignado al input
    $("#imagenNew").change(function() {readURL(this);});
</script>
</html>