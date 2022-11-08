<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="sampleControladorPublishProxyid" scope="session" class="publicadores.ControladorPublishProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
sampleControladorPublishProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        String getEndpoint2mtemp = sampleControladorPublishProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        if(getEndpoint2mtemp!= null){
        String tempreturnp3 = getEndpoint2mtemp.toString();
        %>
        <%=tempreturnp3%>
        <%
        }}
break;
case 5:
        gotMethod = true;
        %>
        <jsp:useBean id="String_0id" scope="session" class="String" />
        <%
        sampleControladorPublishProxyid.setEndpoint(String_0id);
break;
case 10:
        gotMethod = true;
        publicadores.ControladorPublish getControladorPublish10mtemp = sampleControladorPublishProxyid.getControladorPublish();
if(getControladorPublish10mtemp == null){
%>
<%=getControladorPublish10mtemp %>
<%
}else{
        if(getControladorPublish10mtemp!= null){
        String tempreturnp11 = getControladorPublish10mtemp.toString();
        %>
        <%=tempreturnp11%>
        <%
        }}
break;
case 13:
        gotMethod = true;
        String arg0_1id=  request.getParameter("arg016");
            java.lang.String arg0_1idTemp = null;
        if(!arg0_1id.equals("")){
         arg0_1idTemp  = arg0_1id;
        }
        publicadores.DtClase consultaDictadoClase13mtemp = sampleControladorPublishProxyid.consultaDictadoClase(arg0_1idTemp);
if(consultaDictadoClase13mtemp == null){
%>
<%=consultaDictadoClase13mtemp %>
<%
}else{
        if(consultaDictadoClase13mtemp!= null){
        String tempreturnp14 = consultaDictadoClase13mtemp.toString();
        %>
        <%=tempreturnp14%>
        <%
        }}
break;
case 18:
        gotMethod = true;
        publicadores.DtClase[] rankingDictadosClases18mtemp = sampleControladorPublishProxyid.rankingDictadosClases();
if(rankingDictadosClases18mtemp == null){
%>
<%=rankingDictadosClases18mtemp %>
<%
}else{
        String tempreturnp19 = null;
        if(rankingDictadosClases18mtemp != null){
        java.util.List listreturnp19= java.util.Arrays.asList(rankingDictadosClases18mtemp);
        tempreturnp19 = listreturnp19.toString();
        }
        %>
        <%=tempreturnp19%>
        <%
}
break;
case 21:
        gotMethod = true;
        java.lang.String[] listarClasesFront21mtemp = sampleControladorPublishProxyid.listarClasesFront();
if(listarClasesFront21mtemp == null){
%>
<%=listarClasesFront21mtemp %>
<%
}else{
        String tempreturnp22 = null;
        if(listarClasesFront21mtemp != null){
        java.util.List listreturnp22= java.util.Arrays.asList(listarClasesFront21mtemp);
        tempreturnp22 = listreturnp22.toString();
        }
        %>
        <%=tempreturnp22%>
        <%
}
break;
case 24:
        gotMethod = true;
        publicadores.DtUsuario publicadores1DtUsuario_2id = null;
        publicadores.DtUsuario publicadores1DtUsuario_3id = null;
        boolean modificarDatosUsuario24mtemp = sampleControladorPublishProxyid.modificarDatosUsuario(publicadores1DtUsuario_2id,publicadores1DtUsuario_3id);
        String tempResultreturnp25 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(modificarDatosUsuario24mtemp));
        %>
        <%= tempResultreturnp25 %>
        <%
break;
case 31:
        gotMethod = true;
        java.lang.String[] listarActividades31mtemp = sampleControladorPublishProxyid.listarActividades();
if(listarActividades31mtemp == null){
%>
<%=listarActividades31mtemp %>
<%
}else{
        String tempreturnp32 = null;
        if(listarActividades31mtemp != null){
        java.util.List listreturnp32= java.util.Arrays.asList(listarActividades31mtemp);
        tempreturnp32 = listreturnp32.toString();
        }
        %>
        <%=tempreturnp32%>
        <%
}
break;
case 34:
        gotMethod = true;
        java.lang.String[] listarSocios34mtemp = sampleControladorPublishProxyid.listarSocios();
if(listarSocios34mtemp == null){
%>
<%=listarSocios34mtemp %>
<%
}else{
        String tempreturnp35 = null;
        if(listarSocios34mtemp != null){
        java.util.List listreturnp35= java.util.Arrays.asList(listarSocios34mtemp);
        tempreturnp35 = listreturnp35.toString();
        }
        %>
        <%=tempreturnp35%>
        <%
}
break;
case 37:
        gotMethod = true;
        String arg0_4id=  request.getParameter("arg040");
            java.lang.String arg0_4idTemp = null;
        if(!arg0_4id.equals("")){
         arg0_4idTemp  = arg0_4id;
        }
        publicadores.DtUsuario consultaUsuario37mtemp = sampleControladorPublishProxyid.consultaUsuario(arg0_4idTemp);
if(consultaUsuario37mtemp == null){
%>
<%=consultaUsuario37mtemp %>
<%
}else{
        if(consultaUsuario37mtemp!= null){
        String tempreturnp38 = consultaUsuario37mtemp.toString();
        %>
        <%=tempreturnp38%>
        <%
        }}
break;
case 42:
        gotMethod = true;
        String arg0_5id=  request.getParameter("arg045");
            java.lang.String arg0_5idTemp = null;
        if(!arg0_5id.equals("")){
         arg0_5idTemp  = arg0_5id;
        }
        publicadores.DtSocio findSocio42mtemp = sampleControladorPublishProxyid.findSocio(arg0_5idTemp);
if(findSocio42mtemp == null){
%>
<%=findSocio42mtemp %>
<%
}else{
        if(findSocio42mtemp!= null){
        String tempreturnp43 = findSocio42mtemp.toString();
        %>
        <%=tempreturnp43%>
        <%
        }}
break;
case 47:
        gotMethod = true;
        String arg0_6id=  request.getParameter("arg050");
            java.lang.String arg0_6idTemp = null;
        if(!arg0_6id.equals("")){
         arg0_6idTemp  = arg0_6id;
        }
        publicadores.DtClase getDatosClase47mtemp = sampleControladorPublishProxyid.getDatosClase(arg0_6idTemp);
if(getDatosClase47mtemp == null){
%>
<%=getDatosClase47mtemp %>
<%
}else{
        if(getDatosClase47mtemp!= null){
        String tempreturnp48 = getDatosClase47mtemp.toString();
        %>
        <%=tempreturnp48%>
        <%
        }}
break;
case 52:
        gotMethod = true;
        String arg0_7id=  request.getParameter("arg055");
            java.lang.String arg0_7idTemp = null;
        if(!arg0_7id.equals("")){
         arg0_7idTemp  = arg0_7id;
        }
        publicadores.DtInstitucionDeportiva getInstitucionDt52mtemp = sampleControladorPublishProxyid.getInstitucionDt(arg0_7idTemp);
if(getInstitucionDt52mtemp == null){
%>
<%=getInstitucionDt52mtemp %>
<%
}else{
        if(getInstitucionDt52mtemp!= null){
        String tempreturnp53 = getInstitucionDt52mtemp.toString();
        %>
        <%=tempreturnp53%>
        <%
        }}
break;
case 57:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1DtActividadDeportiva_8id" scope="session" class="publicadores.DtActividadDeportiva" />
        <%
        %>
        <jsp:useBean id="publicadores1DtClase_9id" scope="session" class="publicadores.DtClase" />
        <%
        sampleControladorPublishProxyid.altaDictadoClase(publicadores1DtActividadDeportiva_8id,publicadores1DtClase_9id);
break;
case 64:
        gotMethod = true;
        String arg0_10id=  request.getParameter("arg067");
            java.lang.String arg0_10idTemp = null;
        if(!arg0_10id.equals("")){
         arg0_10idTemp  = arg0_10id;
        }
        publicadores.Socio getSocio64mtemp = sampleControladorPublishProxyid.getSocio(arg0_10idTemp);
if(getSocio64mtemp == null){
%>
<%=getSocio64mtemp %>
<%
}else{
        if(getSocio64mtemp!= null){
        String tempreturnp65 = getSocio64mtemp.toString();
        %>
        <%=tempreturnp65%>
        <%
        }}
break;
case 69:
        gotMethod = true;
        java.lang.String[] listarInstituciones69mtemp = sampleControladorPublishProxyid.listarInstituciones();
if(listarInstituciones69mtemp == null){
%>
<%=listarInstituciones69mtemp %>
<%
}else{
        String tempreturnp70 = null;
        if(listarInstituciones69mtemp != null){
        java.util.List listreturnp70= java.util.Arrays.asList(listarInstituciones69mtemp);
        tempreturnp70 = listreturnp70.toString();
        }
        %>
        <%=tempreturnp70%>
        <%
}
break;
case 72:
        gotMethod = true;
        java.lang.String[] listarProfesoresFront72mtemp = sampleControladorPublishProxyid.listarProfesoresFront();
if(listarProfesoresFront72mtemp == null){
%>
<%=listarProfesoresFront72mtemp %>
<%
}else{
        String tempreturnp73 = null;
        if(listarProfesoresFront72mtemp != null){
        java.util.List listreturnp73= java.util.Arrays.asList(listarProfesoresFront72mtemp);
        tempreturnp73 = listreturnp73.toString();
        }
        %>
        <%=tempreturnp73%>
        <%
}
break;
case 75:
        gotMethod = true;
        publicadores.DtUsuario publicadores1DtUsuario_11id = null;
        String arg1_12id=  request.getParameter("arg180");
            java.lang.String arg1_12idTemp = null;
        if(!arg1_12id.equals("")){
         arg1_12idTemp  = arg1_12id;
        }
        sampleControladorPublishProxyid.altaUsuario(publicadores1DtUsuario_11id,arg1_12idTemp);
break;
case 82:
        gotMethod = true;
        java.lang.String[] listarUsuarios82mtemp = sampleControladorPublishProxyid.listarUsuarios();
if(listarUsuarios82mtemp == null){
%>
<%=listarUsuarios82mtemp %>
<%
}else{
        String tempreturnp83 = null;
        if(listarUsuarios82mtemp != null){
        java.util.List listreturnp83= java.util.Arrays.asList(listarUsuarios82mtemp);
        tempreturnp83 = listreturnp83.toString();
        }
        %>
        <%=tempreturnp83%>
        <%
}
break;
case 85:
        gotMethod = true;
        String arg0_13id=  request.getParameter("arg088");
            java.lang.String arg0_13idTemp = null;
        if(!arg0_13id.equals("")){
         arg0_13idTemp  = arg0_13id;
        }
        java.lang.String[] listarClasesProf85mtemp = sampleControladorPublishProxyid.listarClasesProf(arg0_13idTemp);
if(listarClasesProf85mtemp == null){
%>
<%=listarClasesProf85mtemp %>
<%
}else{
        String tempreturnp86 = null;
        if(listarClasesProf85mtemp != null){
        java.util.List listreturnp86= java.util.Arrays.asList(listarClasesProf85mtemp);
        tempreturnp86 = listreturnp86.toString();
        }
        %>
        <%=tempreturnp86%>
        <%
}
break;
case 90:
        gotMethod = true;
        String arg0_14id=  request.getParameter("arg093");
            java.lang.String arg0_14idTemp = null;
        if(!arg0_14id.equals("")){
         arg0_14idTemp  = arg0_14id;
        }
        java.lang.String[] listarRegistrosSocio90mtemp = sampleControladorPublishProxyid.listarRegistrosSocio(arg0_14idTemp);
if(listarRegistrosSocio90mtemp == null){
%>
<%=listarRegistrosSocio90mtemp %>
<%
}else{
        String tempreturnp91 = null;
        if(listarRegistrosSocio90mtemp != null){
        java.util.List listreturnp91= java.util.Arrays.asList(listarRegistrosSocio90mtemp);
        tempreturnp91 = listreturnp91.toString();
        }
        %>
        <%=tempreturnp91%>
        <%
}
break;
case 95:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1DtInstitucionDeportiva_15id" scope="session" class="publicadores.DtInstitucionDeportiva" />
        <%
        sampleControladorPublishProxyid.altaInsitucionDeportiva(publicadores1DtInstitucionDeportiva_15id);
break;
case 100:
        gotMethod = true;
        String arg0_16id=  request.getParameter("arg0103");
            java.lang.String arg0_16idTemp = null;
        if(!arg0_16id.equals("")){
         arg0_16idTemp  = arg0_16id;
        }
        String arg1_17id=  request.getParameter("arg1105");
            java.lang.String arg1_17idTemp = null;
        if(!arg1_17id.equals("")){
         arg1_17idTemp  = arg1_17id;
        }
        %>
        <jsp:useBean id="publicadores1LocalDate_18id" scope="session" class="publicadores.LocalDate" />
        <%
        sampleControladorPublishProxyid.registroDictadoClase(arg0_16idTemp,arg1_17idTemp,publicadores1LocalDate_18id);
break;
case 109:
        gotMethod = true;
        java.lang.String[] listarSociosFront109mtemp = sampleControladorPublishProxyid.listarSociosFront();
if(listarSociosFront109mtemp == null){
%>
<%=listarSociosFront109mtemp %>
<%
}else{
        String tempreturnp110 = null;
        if(listarSociosFront109mtemp != null){
        java.util.List listreturnp110= java.util.Arrays.asList(listarSociosFront109mtemp);
        tempreturnp110 = listreturnp110.toString();
        }
        %>
        <%=tempreturnp110%>
        <%
}
break;
case 112:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1DtActividadDeportiva_19id" scope="session" class="publicadores.DtActividadDeportiva" />
        <%
        sampleControladorPublishProxyid.altaActividadDeportiva(publicadores1DtActividadDeportiva_19id);
break;
case 117:
        gotMethod = true;
        String arg0_20id=  request.getParameter("arg0120");
            java.lang.String arg0_20idTemp = null;
        if(!arg0_20id.equals("")){
         arg0_20idTemp  = arg0_20id;
        }
        publicadores.DtProfesor findProfesor117mtemp = sampleControladorPublishProxyid.findProfesor(arg0_20idTemp);
if(findProfesor117mtemp == null){
%>
<%=findProfesor117mtemp %>
<%
}else{
        if(findProfesor117mtemp!= null){
        String tempreturnp118 = findProfesor117mtemp.toString();
        %>
        <%=tempreturnp118%>
        <%
        }}
break;
case 122:
        gotMethod = true;
        java.lang.String[] listarActsFront122mtemp = sampleControladorPublishProxyid.listarActsFront();
if(listarActsFront122mtemp == null){
%>
<%=listarActsFront122mtemp %>
<%
}else{
        String tempreturnp123 = null;
        if(listarActsFront122mtemp != null){
        java.util.List listreturnp123= java.util.Arrays.asList(listarActsFront122mtemp);
        tempreturnp123 = listreturnp123.toString();
        }
        %>
        <%=tempreturnp123%>
        <%
}
break;
case 125:
        gotMethod = true;
        java.lang.String[] listarInstitucionesConActYClases125mtemp = sampleControladorPublishProxyid.listarInstitucionesConActYClases();
if(listarInstitucionesConActYClases125mtemp == null){
%>
<%=listarInstitucionesConActYClases125mtemp %>
<%
}else{
        String tempreturnp126 = null;
        if(listarInstitucionesConActYClases125mtemp != null){
        java.util.List listreturnp126= java.util.Arrays.asList(listarInstitucionesConActYClases125mtemp);
        tempreturnp126 = listreturnp126.toString();
        }
        %>
        <%=tempreturnp126%>
        <%
}
break;
case 128:
        gotMethod = true;
        java.lang.String[] listarInstitucionesConAct128mtemp = sampleControladorPublishProxyid.listarInstitucionesConAct();
if(listarInstitucionesConAct128mtemp == null){
%>
<%=listarInstitucionesConAct128mtemp %>
<%
}else{
        String tempreturnp129 = null;
        if(listarInstitucionesConAct128mtemp != null){
        java.util.List listreturnp129= java.util.Arrays.asList(listarInstitucionesConAct128mtemp);
        tempreturnp129 = listreturnp129.toString();
        }
        %>
        <%=tempreturnp129%>
        <%
}
break;
case 131:
        gotMethod = true;
        String arg0_21id=  request.getParameter("arg0134");
            java.lang.String arg0_21idTemp = null;
        if(!arg0_21id.equals("")){
         arg0_21idTemp  = arg0_21id;
        }
        java.lang.String[] listarClasesActividadDeportiva131mtemp = sampleControladorPublishProxyid.listarClasesActividadDeportiva(arg0_21idTemp);
if(listarClasesActividadDeportiva131mtemp == null){
%>
<%=listarClasesActividadDeportiva131mtemp %>
<%
}else{
        String tempreturnp132 = null;
        if(listarClasesActividadDeportiva131mtemp != null){
        java.util.List listreturnp132= java.util.Arrays.asList(listarClasesActividadDeportiva131mtemp);
        tempreturnp132 = listreturnp132.toString();
        }
        %>
        <%=tempreturnp132%>
        <%
}
break;
case 136:
        gotMethod = true;
        java.lang.String[] listarInstitucionesConActYProf136mtemp = sampleControladorPublishProxyid.listarInstitucionesConActYProf();
if(listarInstitucionesConActYProf136mtemp == null){
%>
<%=listarInstitucionesConActYProf136mtemp %>
<%
}else{
        String tempreturnp137 = null;
        if(listarInstitucionesConActYProf136mtemp != null){
        java.util.List listreturnp137= java.util.Arrays.asList(listarInstitucionesConActYProf136mtemp);
        tempreturnp137 = listreturnp137.toString();
        }
        %>
        <%=tempreturnp137%>
        <%
}
break;
case 139:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0142");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        publicadores.DtActividadDeportiva consultaActividadDeportiva139mtemp = sampleControladorPublishProxyid.consultaActividadDeportiva(arg0_22idTemp);
if(consultaActividadDeportiva139mtemp == null){
%>
<%=consultaActividadDeportiva139mtemp %>
<%
}else{
        if(consultaActividadDeportiva139mtemp!= null){
        String tempreturnp140 = consultaActividadDeportiva139mtemp.toString();
        %>
        <%=tempreturnp140%>
        <%
        }}
break;
case 144:
        gotMethod = true;
        publicadores.DtActividadDeportiva[] rankingActividadesDeportivas144mtemp = sampleControladorPublishProxyid.rankingActividadesDeportivas();
if(rankingActividadesDeportivas144mtemp == null){
%>
<%=rankingActividadesDeportivas144mtemp %>
<%
}else{
        String tempreturnp145 = null;
        if(rankingActividadesDeportivas144mtemp != null){
        java.util.List listreturnp145= java.util.Arrays.asList(rankingActividadesDeportivas144mtemp);
        tempreturnp145 = listreturnp145.toString();
        }
        %>
        <%=tempreturnp145%>
        <%
}
break;
case 147:
        gotMethod = true;
        String arg0_23id=  request.getParameter("arg0150");
            java.lang.String arg0_23idTemp = null;
        if(!arg0_23id.equals("")){
         arg0_23idTemp  = arg0_23id;
        }
        %>
        <jsp:useBean id="publicadores1DtInstitucionDeportiva_24id" scope="session" class="publicadores.DtInstitucionDeportiva" />
        <%
        boolean modificarInstitucionDeportiva147mtemp = sampleControladorPublishProxyid.modificarInstitucionDeportiva(arg0_23idTemp,publicadores1DtInstitucionDeportiva_24id);
        String tempResultreturnp148 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(modificarInstitucionDeportiva147mtemp));
        %>
        <%= tempResultreturnp148 %>
        <%
break;
case 154:
        gotMethod = true;
        String arg0_25id=  request.getParameter("arg0157");
            java.lang.String arg0_25idTemp = null;
        if(!arg0_25id.equals("")){
         arg0_25idTemp  = arg0_25id;
        }
        %>
        <jsp:useBean id="publicadores1DtActividadDeportiva_26id" scope="session" class="publicadores.DtActividadDeportiva" />
        <%
        boolean modificarActividadDeportiva154mtemp = sampleControladorPublishProxyid.modificarActividadDeportiva(arg0_25idTemp,publicadores1DtActividadDeportiva_26id);
        String tempResultreturnp155 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(modificarActividadDeportiva154mtemp));
        %>
        <%= tempResultreturnp155 %>
        <%
break;
case 161:
        gotMethod = true;
        String arg0_27id=  request.getParameter("arg0182");
            java.lang.String arg0_27idTemp = null;
        if(!arg0_27id.equals("")){
         arg0_27idTemp  = arg0_27id;
        }
        publicadores.ActividadDeportiva getAct161mtemp = sampleControladorPublishProxyid.getAct(arg0_27idTemp);
if(getAct161mtemp == null){
%>
<%=getAct161mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(getAct161mtemp != null){
publicadores.LocalDate typefecha164 = getAct161mtemp.getFecha();
        if(typefecha164!= null){
        String tempfecha164 = typefecha164.toString();
        %>
        <%=tempfecha164%>
        <%
        }}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getAct161mtemp != null){
java.lang.String typedescripcion166 = getAct161mtemp.getDescripcion();
        String tempResultdescripcion166 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion166));
        %>
        <%= tempResultdescripcion166 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getAct161mtemp != null){
%>
<%=getAct161mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getAct161mtemp != null){
java.lang.String typenombre170 = getAct161mtemp.getNombre();
        String tempResultnombre170 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre170));
        %>
        <%= tempResultnombre170 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">institucionDeportiva:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getAct161mtemp != null){
publicadores.InstitucionDeportiva tebece0=getAct161mtemp.getInstitucionDeportiva();
if(tebece0 != null){
java.lang.String typedescripcion174 = tebece0.getDescripcion();
        String tempResultdescripcion174 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion174));
        %>
        <%= tempResultdescripcion174 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getAct161mtemp != null){
publicadores.InstitucionDeportiva tebece0=getAct161mtemp.getInstitucionDeportiva();
if(tebece0 != null){
java.lang.String typeurl176 = tebece0.getUrl();
        String tempResulturl176 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl176));
        %>
        <%= tempResulturl176 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getAct161mtemp != null){
publicadores.InstitucionDeportiva tebece0=getAct161mtemp.getInstitucionDeportiva();
if(tebece0 != null){
java.lang.String typenombre178 = tebece0.getNombre();
        String tempResultnombre178 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre178));
        %>
        <%= tempResultnombre178 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getAct161mtemp != null){
%>
<%=getAct161mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 184:
        gotMethod = true;
        String arg0_28id=  request.getParameter("arg0233");
            java.lang.String arg0_28idTemp = null;
        if(!arg0_28id.equals("")){
         arg0_28idTemp  = arg0_28id;
        }
        publicadores.Clase getClase184mtemp = sampleControladorPublishProxyid.getClase(arg0_28idTemp);
if(getClase184mtemp == null){
%>
<%=getClase184mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getClase184mtemp != null){
java.lang.String typeurl187 = getClase184mtemp.getUrl();
        String tempResulturl187 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl187));
        %>
        <%= tempResulturl187 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">actividadDeportiva:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase184mtemp.getActividadDeportiva();
if(tebece0 != null){
publicadores.LocalDate typefecha191 = tebece0.getFecha();
        if(typefecha191!= null){
        String tempfecha191 = typefecha191.toString();
        %>
        <%=tempfecha191%>
        <%
        }}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase184mtemp.getActividadDeportiva();
if(tebece0 != null){
java.lang.String typedescripcion193 = tebece0.getDescripcion();
        String tempResultdescripcion193 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion193));
        %>
        <%= tempResultdescripcion193 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase184mtemp.getActividadDeportiva();
if(tebece0 != null){
%>
<%=tebece0.getDuracion()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase184mtemp.getActividadDeportiva();
if(tebece0 != null){
java.lang.String typenombre197 = tebece0.getNombre();
        String tempResultnombre197 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre197));
        %>
        <%= tempResultnombre197 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">institucionDeportiva:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="0" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase184mtemp.getActividadDeportiva();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typedescripcion201 = tebece1.getDescripcion();
        String tempResultdescripcion201 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion201));
        %>
        <%= tempResultdescripcion201 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="0" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase184mtemp.getActividadDeportiva();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typeurl203 = tebece1.getUrl();
        String tempResulturl203 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl203));
        %>
        <%= tempResulturl203 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="0" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase184mtemp.getActividadDeportiva();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typenombre205 = tebece1.getNombre();
        String tempResultnombre205 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre205));
        %>
        <%= tempResultnombre205 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase184mtemp.getActividadDeportiva();
if(tebece0 != null){
%>
<%=tebece0.getCosto()
%><%}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">horaInicio:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.LocalTime typehoraInicio209 = getClase184mtemp.getHoraInicio();
        if(typehoraInicio209!= null){
        String temphoraInicio209 = typehoraInicio209.toString();
        %>
        <%=temphoraInicio209%>
        <%
        }}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.LocalDate typefechaReg211 = getClase184mtemp.getFechaReg();
        if(typefechaReg211!= null){
        String tempfechaReg211 = typefechaReg211.toString();
        %>
        <%=tempfechaReg211%>
        <%
        }}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getClase184mtemp != null){
java.lang.String typenombre213 = getClase184mtemp.getNombre();
        String tempResultnombre213 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre213));
        %>
        <%= tempResultnombre213 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fecha:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.LocalDate typefecha215 = getClase184mtemp.getFecha();
        if(typefecha215!= null){
        String tempfecha215 = typefecha215.toString();
        %>
        <%=tempfecha215%>
        <%
        }}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">profesor:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.Profesor tebece0=getClase184mtemp.getProfesor();
if(tebece0 != null){
java.lang.String typedescripcion219 = tebece0.getDescripcion();
        String tempResultdescripcion219 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion219));
        %>
        <%= tempResultdescripcion219 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">sitioWeb:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.Profesor tebece0=getClase184mtemp.getProfesor();
if(tebece0 != null){
java.lang.String typesitioWeb221 = tebece0.getSitioWeb();
        String tempResultsitioWeb221 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesitioWeb221));
        %>
        <%= tempResultsitioWeb221 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">biografia:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.Profesor tebece0=getClase184mtemp.getProfesor();
if(tebece0 != null){
java.lang.String typebiografia223 = tebece0.getBiografia();
        String tempResultbiografia223 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebiografia223));
        %>
        <%= tempResultbiografia223 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">institucionDeportiva:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="0" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.Profesor tebece0=getClase184mtemp.getProfesor();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typedescripcion227 = tebece1.getDescripcion();
        String tempResultdescripcion227 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion227));
        %>
        <%= tempResultdescripcion227 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="0" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.Profesor tebece0=getClase184mtemp.getProfesor();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typeurl229 = tebece1.getUrl();
        String tempResulturl229 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl229));
        %>
        <%= tempResulturl229 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="0" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getClase184mtemp != null){
publicadores.Profesor tebece0=getClase184mtemp.getProfesor();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typenombre231 = tebece1.getNombre();
        String tempResultnombre231 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre231));
        %>
        <%= tempResultnombre231 %>
        <%
}}}%>
</TD>
</TABLE>
<%
}
break;
case 235:
        gotMethod = true;
        java.lang.String[] listarClases235mtemp = sampleControladorPublishProxyid.listarClases();
if(listarClases235mtemp == null){
%>
<%=listarClases235mtemp %>
<%
}else{
        String tempreturnp236 = null;
        if(listarClases235mtemp != null){
        java.util.List listreturnp236= java.util.Arrays.asList(listarClases235mtemp);
        tempreturnp236 = listreturnp236.toString();
        }
        %>
        <%=tempreturnp236%>
        <%
}
break;
case 238:
        gotMethod = true;
        %>
        <jsp:useBean id="publicadores1DtRegistro_29id" scope="session" class="publicadores.DtRegistro" />
        <%
        sampleControladorPublishProxyid.eliminarRegistro(publicadores1DtRegistro_29id);
break;
case 243:
        gotMethod = true;
        String arg0_30id=  request.getParameter("arg0252");
            java.lang.String arg0_30idTemp = null;
        if(!arg0_30id.equals("")){
         arg0_30idTemp  = arg0_30id;
        }
        publicadores.InstitucionDeportiva getInstitucion243mtemp = sampleControladorPublishProxyid.getInstitucion(arg0_30idTemp);
if(getInstitucion243mtemp == null){
%>
<%=getInstitucion243mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getInstitucion243mtemp != null){
java.lang.String typedescripcion246 = getInstitucion243mtemp.getDescripcion();
        String tempResultdescripcion246 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion246));
        %>
        <%= tempResultdescripcion246 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getInstitucion243mtemp != null){
java.lang.String typeurl248 = getInstitucion243mtemp.getUrl();
        String tempResulturl248 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl248));
        %>
        <%= tempResulturl248 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getInstitucion243mtemp != null){
java.lang.String typenombre250 = getInstitucion243mtemp.getNombre();
        String tempResultnombre250 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre250));
        %>
        <%= tempResultnombre250 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 254:
        gotMethod = true;
        String arg0_31id=  request.getParameter("arg0257");
            java.lang.String arg0_31idTemp = null;
        if(!arg0_31id.equals("")){
         arg0_31idTemp  = arg0_31id;
        }
        boolean existeNickname254mtemp = sampleControladorPublishProxyid.existeNickname(arg0_31idTemp);
        String tempResultreturnp255 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existeNickname254mtemp));
        %>
        <%= tempResultreturnp255 %>
        <%
break;
case 259:
        gotMethod = true;
        java.lang.String[] listarProfesores259mtemp = sampleControladorPublishProxyid.listarProfesores();
if(listarProfesores259mtemp == null){
%>
<%=listarProfesores259mtemp %>
<%
}else{
        String tempreturnp260 = null;
        if(listarProfesores259mtemp != null){
        java.util.List listreturnp260= java.util.Arrays.asList(listarProfesores259mtemp);
        tempreturnp260 = listreturnp260.toString();
        }
        %>
        <%=tempreturnp260%>
        <%
}
break;
case 262:
        gotMethod = true;
        String arg0_32id=  request.getParameter("arg0265");
            java.lang.String arg0_32idTemp = null;
        if(!arg0_32id.equals("")){
         arg0_32idTemp  = arg0_32id;
        }
        String arg1_33id=  request.getParameter("arg1267");
            java.lang.String arg1_33idTemp = null;
        if(!arg1_33id.equals("")){
         arg1_33idTemp  = arg1_33id;
        }
        boolean inicioSesion262mtemp = sampleControladorPublishProxyid.inicioSesion(arg0_32idTemp,arg1_33idTemp);
        String tempResultreturnp263 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inicioSesion262mtemp));
        %>
        <%= tempResultreturnp263 %>
        <%
break;
case 269:
        gotMethod = true;
        String arg0_34id=  request.getParameter("arg0272");
            java.lang.String arg0_34idTemp = null;
        if(!arg0_34id.equals("")){
         arg0_34idTemp  = arg0_34id;
        }
        boolean existeMail269mtemp = sampleControladorPublishProxyid.existeMail(arg0_34idTemp);
        String tempResultreturnp270 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existeMail269mtemp));
        %>
        <%= tempResultreturnp270 %>
        <%
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>