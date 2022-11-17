<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<%@page import="java.util.Base64" %>
    <%@page import="publicadores.DtSocio"%>
<meta charset="ISO-8859-1">
<title>Modificar Datos del Socio</title>
<link rel="stylesheet" href="css/styleLoginV2.css">
<%@include file ="/headerSocio.jsp" %>
</head>
<body>
<%
        String nicknamee = (String) ss.getAttribute("name");
        DtSocio dtSocio = port.findSocio(nicknamee);
        String imgEnn = (String)Base64.getEncoder().encodeToString(dtSocio.getProfileImage());
 %>
        
<form action="ModificarDatosUsuario" method="post">
			<div class="container">
				<div class="card">
					<h3 style="margin-top: 5vh;">Modificar datos<br>del Socio</h3>
					
					<img src="data:image/png;base64,<%=imgEnn%>" width="250px" height="250px" name="imagenPreCarga" id="imagenPreCarga" class="responsive">
					<input type="file" class="custom-file-input" name="imagenNew" id="imagenNew" maxlength="256" placeholder="ImagenNew" accept="image/*">
					<input type="hidden" name="img" id="img" value="">
					
					<div class="inputBox">
						<input id="1" type="text" name="nomUsuario" >
						<script>document.getElementById('1').value='<%=dtSoc.getNombre()%>';</script>
						<span>Nombre del Socio</span>
					</div>
					<div class="inputBox">
						<input id="2" type="text" name="apeUsuario">
						<script>document.getElementById('2').value='<%=dtSoc.getApellido()%>';</script>
						<span>Apellido del Socio</span>
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