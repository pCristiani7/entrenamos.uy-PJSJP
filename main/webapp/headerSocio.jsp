<!DOCTYPE html>
<!-- Created by CodingLab |www.youtube.com/c/CodingLabYT-->
<html lang="en" dir="ltr">
  <head>
      <%@page import="java.util.Base64" %>
  <%@page import="interfaces.Fabrica"%>
    <%@page import="interfaces.IControlador"%>
    <%@page import="datatypes.DtSocio"%>
    <%@page import="datatypes.DtUsuario"%>
  <meta charset="ISO-8859-1">
  <link rel="stylesheet" href="css/newStyleSocio.css">
  <title>Socio - EntrenamosUY</title>

    <meta charset="UTF-8">
    <link rel="stylesheet" href="style.css">
    <!-- Boxicons CDN Link -->
    <link href='https://unpkg.com/boxicons@2.0.7/css/boxicons.min.css' rel='stylesheet'>
    <meta name="viewport" content="width=device-width, maximum-scale=1">
     
   </head>
<body>


  <%
    Fabrica ff = Fabrica.getInstance();
    IControlador ii = ff.getIControlador();
    HttpSession ss = request.getSession();
    String nickname = ss.getAttribute("name").toString();
    String email = ss.getAttribute("email").toString();
    DtUsuario dtUser = ii.ConsultaUsuario(nickname);
    DtSocio dtSoc = (DtSocio) dtUser;
    String imgEn = Base64.getEncoder().encodeToString(dtSoc.getProfileImage());
  %>

  
  <div class="sidebar">
    <div class="logo-details">
      <i class='bx bx-dumbbell icon'></i>
        <div class="logo_name">EntrenamosUY</div>
        <i class='bx bx-menu' id="btn" ></i>
    </div>
    <ul class="nav-list">
      <li>
       <a href="ConsultaUsuario.jsp">
         <i class='bx bx-user' ></i>
         <span class="links_name">Ver Perfil</span>
       </a>
       <span class="tooltip">Ver Perfil</span>
     </li>
     <li>
       <a href="ModificarDatosSocio.jsp">
         <i class='bx bx-id-card' ></i>
         <span class="links_name">Modificar Perfil</span>
       </a>
       <span class="tooltip">Modificar Perfil</span>
     </li>
     <li>
       <a href="ConsultaActividadDeportiva.jsp">
         <i class='bx bx-search-alt' ></i>
         <span class="links_name">Consulta Actividad</span>
       </a>
       <span class="tooltip">Consulta Actividad</span>
     </li>
     <li>
       <a href="RegistroDictadoDeClase.jsp">
         <i class='bx bx-add-to-queue' ></i>
         <span class="links_name">Registro a Clase</span>
       </a>
       <span class="tooltip">Registro a Clase</span>
     </li>
     <li>
       <a href="EliminarRegistroDictadoDeClase.jsp">
         <i class='bx bx-trash' ></i>
         <span class="links_name">Eliminar Registro</span>
       </a>
       <span class="tooltip">Eliminar Registro</span>
     </li>
     <li>
       <a href="logout.jsp" target="_blank" onclick="window.open('', '_self', ''); window.close();">
         <i class='bx bx-log-out' ></i>
         <span class="links_name">Cerrar Sesion</span>
       </a>
       <span class="tooltip">Cerrar Sesion</span>
     </li>
     <li class="profile">
         <div class="profile-details">
           <img src="data:image/png;base64,<%=imgEn%>">
           <div class="name_job">
             <div class="name"><%=nickname%></div>
             <div class="tipoUsuario">Socio</div>
           </div>
         </div>
         <i class='bx bx-dumbbell icon' id="log_out" ></i>
     </li>
    </ul>
  </div>
  <script src="js/scriptSocioHeader.js"></script>
</body>
</html>
