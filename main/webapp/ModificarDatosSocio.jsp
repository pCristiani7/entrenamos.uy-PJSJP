<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modificar Datos del Socio</title>
</head>
<body>
<form action="ModificarDatosUsuario" method="post">
  <div class="mb-3 row">
    <label for="inputNombre" class="col-sm-2 col-form-label">Nombre nuevo</label>
    <div class="col-sm-10">
      <input type="text" 
      class="form-control"
       id="inputNombre"
       name= "nomUsuario">
    	</div>
    </div>
   
   <label for="inputApellido" class="col-sm-2 col-form-label">Apellido nuevo</label>
    <div class="col-sm-10">
      <input type="text" 
      class="form-control"
       id="inputApellido"
       name= "apeUsuario">
    	</div>
   
   
   <label for="inputfNac">Fecha de Nacimiento Nueva</label>
    <div class="col-sm-10">
      <input type="datetime-local" 
       id="inputFechaNac"
       placeholder="aaaa-mm-dd"
       name= "fNacUsuario">
    	</div>
   
   
    <div>
   	<button class="btn btn-primary" type="submit">Enviar datos a modificar</button>
    </div>
 </form>
 

</body>
</html>