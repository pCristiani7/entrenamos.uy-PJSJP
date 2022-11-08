<!DOCTYPE html>
<!-- Created by CodingLab |www.youtube.com/c/CodingLabYT-->
<html lang="en" dir="ltr">
  <head>
      <%@page import="java.util.Base64" %>
  <%@page import="interfaces.Fabrica"%>
    <%@page import="interfaces.IControlador"%>
    <%@page import="datatypes.DtProfesor"%>
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
    DtProfesor dtProff = (DtProfesor) dtUser;
    String imgEn = Base64.getEncoder().encodeToString(dtProff.getProfileImage());
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
       <a href="ModificarDatosProfesor.jsp">
         <i class='bx bx-id-card' ></i>
         <span class="links_name">Modificar Perfil</span>
       </a>
       <span class="tooltip">Modificar Perfil</span>
     </li>
     <li>
       <a href="AltaDictadoDeClase.jsp">
         <i class='bx bx-add-to-queue' ></i>
         <span class="links_name">Alta Clase</span>
       </a>
       <span class="tooltip">Alta Clase</span>
     </li>
     <li>
       <a href="ConsultaDictadodeClase.jsp">
         <i class='bx bx-search-alt' ></i>
         <span class="links_name">Consulta Clase</span>
       </a>
       <span class="tooltip">Consulta Clase</span>
     </li>
     <li>
       <a href="RankingClases.jsp">
         <i class='bx bx-line-chart' ></i>
         <span class="links_name">Ranking Clases</span>
       </a>
       <span class="tooltip">Ranking Clases</span>
     </li>
     <li>
       <a href="ConsultaActividadDeportiva.jsp">
         <i class='bx bx-search-alt' ></i>
         <span class="links_name">Consulta Actividad</span>
       </a>
       <span class="tooltip">Consulta Actividad</span>
     </li>
     <li>
       <a href="RankingsActividadDeportiva.jsp">
         <i class='bx bx-line-chart' ></i>
         <span class="links_name">Ranking Actividades</span>
       </a>
       <span class="tooltip">Ranking Actividades</span>
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
             <div class="tipoUsuario">Profesor</div>
           </div>
         </div>
         <i class='bx bx-dumbbell icon' id="log_out" ></i>
     </li>
    </ul>
  </div>
  <script src="js/scriptSocioHeader.js"></script>
</body>
</html>
