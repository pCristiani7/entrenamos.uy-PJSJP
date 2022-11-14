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
        java.lang.String getEndpoint2mtemp = sampleControladorPublishProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        sampleControladorPublishProxyid.setEndpoint(endpoint_0idTemp);
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
        java.lang.String[] listarInstituciones13mtemp = sampleControladorPublishProxyid.listarInstituciones();
if(listarInstituciones13mtemp == null){
%>
<%=listarInstituciones13mtemp %>
<%
}else{
        String tempreturnp14 = null;
        if(listarInstituciones13mtemp != null){
        java.util.List listreturnp14= java.util.Arrays.asList(listarInstituciones13mtemp);
        tempreturnp14 = listreturnp14.toString();
        }
        %>
        <%=tempreturnp14%>
        <%
}
break;
case 16:
        gotMethod = true;
        java.lang.String[] listarProfesoresFront16mtemp = sampleControladorPublishProxyid.listarProfesoresFront();
if(listarProfesoresFront16mtemp == null){
%>
<%=listarProfesoresFront16mtemp %>
<%
}else{
        String tempreturnp17 = null;
        if(listarProfesoresFront16mtemp != null){
        java.util.List listreturnp17= java.util.Arrays.asList(listarProfesoresFront16mtemp);
        tempreturnp17 = listreturnp17.toString();
        }
        %>
        <%=tempreturnp17%>
        <%
}
break;
case 19:
        gotMethod = true;
        String descripcion_2id=  request.getParameter("descripcion24");
            java.lang.String descripcion_2idTemp = null;
        if(!descripcion_2id.equals("")){
         descripcion_2idTemp  = descripcion_2id;
        }
        String url_3id=  request.getParameter("url26");
            java.lang.String url_3idTemp = null;
        if(!url_3id.equals("")){
         url_3idTemp  = url_3id;
        }
        String nombre_4id=  request.getParameter("nombre28");
            java.lang.String nombre_4idTemp = null;
        if(!nombre_4id.equals("")){
         nombre_4idTemp  = nombre_4id;
        }
        %>
        <jsp:useBean id="publicadores1DtInstitucionDeportiva_1id" scope="session" class="publicadores.DtInstitucionDeportiva" />
        <%
        publicadores1DtInstitucionDeportiva_1id.setDescripcion(descripcion_2idTemp);
        publicadores1DtInstitucionDeportiva_1id.setUrl(url_3idTemp);
        publicadores1DtInstitucionDeportiva_1id.setNombre(nombre_4idTemp);
        sampleControladorPublishProxyid.altaInsitucionDeportiva(publicadores1DtInstitucionDeportiva_1id);
break;
case 30:
        gotMethod = true;
        String fecha_6id=  request.getParameter("fecha35");
            java.util.Calendar fecha_6idTemp = null;
        if(!fecha_6id.equals("")){
        java.text.DateFormat dateFormatfecha35 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfecha35  = dateFormatfecha35.parse(fecha_6id);
         fecha_6idTemp = new java.util.GregorianCalendar();
        fecha_6idTemp.setTime(dateTempfecha35);
        }
        String descripcion_7id=  request.getParameter("descripcion37");
            java.lang.String descripcion_7idTemp = null;
        if(!descripcion_7id.equals("")){
         descripcion_7idTemp  = descripcion_7id;
        }
        String duracion_8id=  request.getParameter("duracion39");
        int duracion_8idTemp  = Integer.parseInt(duracion_8id);
        String institucionDeportiva_9id=  request.getParameter("institucionDeportiva41");
            java.lang.String institucionDeportiva_9idTemp = null;
        if(!institucionDeportiva_9id.equals("")){
         institucionDeportiva_9idTemp  = institucionDeportiva_9id;
        }
        String costo_10id=  request.getParameter("costo43");
        float costo_10idTemp  = Float.parseFloat(costo_10id);
        String nombre_11id=  request.getParameter("nombre45");
            java.lang.String nombre_11idTemp = null;
        if(!nombre_11id.equals("")){
         nombre_11idTemp  = nombre_11id;
        }
        %>
        <jsp:useBean id="publicadores1DtActividadDeportiva_5id" scope="session" class="publicadores.DtActividadDeportiva" />
        <%
        publicadores1DtActividadDeportiva_5id.setFecha(fecha_6idTemp);
        publicadores1DtActividadDeportiva_5id.setDescripcion(descripcion_7idTemp);
        publicadores1DtActividadDeportiva_5id.setDuracion(duracion_8idTemp);
        publicadores1DtActividadDeportiva_5id.setInstitucionDeportiva(institucionDeportiva_9idTemp);
        publicadores1DtActividadDeportiva_5id.setCosto(costo_10idTemp);
        publicadores1DtActividadDeportiva_5id.setNombre(nombre_11idTemp);
        sampleControladorPublishProxyid.altaActividadDeportiva(publicadores1DtActividadDeportiva_5id);
break;
case 47:
        gotMethod = true;
        java.lang.String[] listarInstitucionesConActYProf47mtemp = sampleControladorPublishProxyid.listarInstitucionesConActYProf();
if(listarInstitucionesConActYProf47mtemp == null){
%>
<%=listarInstitucionesConActYProf47mtemp %>
<%
}else{
        String tempreturnp48 = null;
        if(listarInstitucionesConActYProf47mtemp != null){
        java.util.List listreturnp48= java.util.Arrays.asList(listarInstitucionesConActYProf47mtemp);
        tempreturnp48 = listreturnp48.toString();
        }
        %>
        <%=tempreturnp48%>
        <%
}
break;
case 50:
        gotMethod = true;
        String arg0_12id=  request.getParameter("arg053");
            java.lang.String arg0_12idTemp = null;
        if(!arg0_12id.equals("")){
         arg0_12idTemp  = arg0_12id;
        }
        publicadores.DtActividadDeportiva[] getActividadesInstitucion50mtemp = sampleControladorPublishProxyid.getActividadesInstitucion(arg0_12idTemp);
if(getActividadesInstitucion50mtemp == null){
%>
<%=getActividadesInstitucion50mtemp %>
<%
}else{
        String tempreturnp51 = null;
        if(getActividadesInstitucion50mtemp != null){
        java.util.List listreturnp51= java.util.Arrays.asList(getActividadesInstitucion50mtemp);
        tempreturnp51 = listreturnp51.toString();
        }
        %>
        <%=tempreturnp51%>
        <%
}
break;
case 55:
        gotMethod = true;
        String arg0_13id=  request.getParameter("arg058");
            java.lang.String arg0_13idTemp = null;
        if(!arg0_13id.equals("")){
         arg0_13idTemp  = arg0_13id;
        }
        java.lang.String[] listarRegistrosSocio55mtemp = sampleControladorPublishProxyid.listarRegistrosSocio(arg0_13idTemp);
if(listarRegistrosSocio55mtemp == null){
%>
<%=listarRegistrosSocio55mtemp %>
<%
}else{
        String tempreturnp56 = null;
        if(listarRegistrosSocio55mtemp != null){
        java.util.List listreturnp56= java.util.Arrays.asList(listarRegistrosSocio55mtemp);
        tempreturnp56 = listreturnp56.toString();
        }
        %>
        <%=tempreturnp56%>
        <%
}
break;
case 60:
        gotMethod = true;
        String arg0_14id=  request.getParameter("arg063");
            java.lang.String arg0_14idTemp = null;
        if(!arg0_14id.equals("")){
         arg0_14idTemp  = arg0_14id;
        }
        String arg1_15id=  request.getParameter("arg165");
            java.lang.String arg1_15idTemp = null;
        if(!arg1_15id.equals("")){
         arg1_15idTemp  = arg1_15id;
        }
        String arg2_16id=  request.getParameter("arg267");
            java.util.Calendar arg2_16idTemp = null;
        if(!arg2_16id.equals("")){
        java.text.DateFormat dateFormatarg267 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTemparg267  = dateFormatarg267.parse(arg2_16id);
         arg2_16idTemp = new java.util.GregorianCalendar();
        arg2_16idTemp.setTime(dateTemparg267);
        }
        sampleControladorPublishProxyid.registroDictadoClase(arg0_14idTemp,arg1_15idTemp,arg2_16idTemp);
break;
case 69:
        gotMethod = true;
        String arg0_17id=  request.getParameter("arg072");
            java.lang.String arg0_17idTemp = null;
        if(!arg0_17id.equals("")){
         arg0_17idTemp  = arg0_17id;
        }
        publicadores.DtProfesor[] getProfesoresInstitucion69mtemp = sampleControladorPublishProxyid.getProfesoresInstitucion(arg0_17idTemp);
if(getProfesoresInstitucion69mtemp == null){
%>
<%=getProfesoresInstitucion69mtemp %>
<%
}else{
        String tempreturnp70 = null;
        if(getProfesoresInstitucion69mtemp != null){
        java.util.List listreturnp70= java.util.Arrays.asList(getProfesoresInstitucion69mtemp);
        tempreturnp70 = listreturnp70.toString();
        }
        %>
        <%=tempreturnp70%>
        <%
}
break;
case 74:
        gotMethod = true;
        java.lang.String[] listarInstitucionesConActYClases74mtemp = sampleControladorPublishProxyid.listarInstitucionesConActYClases();
if(listarInstitucionesConActYClases74mtemp == null){
%>
<%=listarInstitucionesConActYClases74mtemp %>
<%
}else{
        String tempreturnp75 = null;
        if(listarInstitucionesConActYClases74mtemp != null){
        java.util.List listreturnp75= java.util.Arrays.asList(listarInstitucionesConActYClases74mtemp);
        tempreturnp75 = listreturnp75.toString();
        }
        %>
        <%=tempreturnp75%>
        <%
}
break;
case 77:
        gotMethod = true;
        String arg0_18id=  request.getParameter("arg092");
            java.lang.String arg0_18idTemp = null;
        if(!arg0_18id.equals("")){
         arg0_18idTemp  = arg0_18id;
        }
        publicadores.DtActividadDeportiva consultaActividadDeportiva77mtemp = sampleControladorPublishProxyid.consultaActividadDeportiva(arg0_18idTemp);
if(consultaActividadDeportiva77mtemp == null){
%>
<%=consultaActividadDeportiva77mtemp %>
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
if(consultaActividadDeportiva77mtemp != null){
java.util.Calendar typefecha80 = consultaActividadDeportiva77mtemp.getFecha();
        java.text.DateFormat dateFormatfecha80 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha80 = typefecha80.getTime();
        String tempResultfecha80 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha80.format(datefecha80));
        %>
        <%= tempResultfecha80 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(consultaActividadDeportiva77mtemp != null){
java.lang.String typedescripcion82 = consultaActividadDeportiva77mtemp.getDescripcion();
        String tempResultdescripcion82 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion82));
        %>
        <%= tempResultdescripcion82 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(consultaActividadDeportiva77mtemp != null){
%>
<%=consultaActividadDeportiva77mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">institucionDeportiva:</TD>
<TD>
<%
if(consultaActividadDeportiva77mtemp != null){
java.lang.String typeinstitucionDeportiva86 = consultaActividadDeportiva77mtemp.getInstitucionDeportiva();
        String tempResultinstitucionDeportiva86 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeinstitucionDeportiva86));
        %>
        <%= tempResultinstitucionDeportiva86 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(consultaActividadDeportiva77mtemp != null){
%>
<%=consultaActividadDeportiva77mtemp.getCosto()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(consultaActividadDeportiva77mtemp != null){
java.lang.String typenombre90 = consultaActividadDeportiva77mtemp.getNombre();
        String tempResultnombre90 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre90));
        %>
        <%= tempResultnombre90 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 94:
        gotMethod = true;
        String arg0_19id=  request.getParameter("arg097");
            java.lang.String arg0_19idTemp = null;
        if(!arg0_19id.equals("")){
         arg0_19idTemp  = arg0_19id;
        }
        java.lang.String[] listarClasesActividadDeportiva94mtemp = sampleControladorPublishProxyid.listarClasesActividadDeportiva(arg0_19idTemp);
if(listarClasesActividadDeportiva94mtemp == null){
%>
<%=listarClasesActividadDeportiva94mtemp %>
<%
}else{
        String tempreturnp95 = null;
        if(listarClasesActividadDeportiva94mtemp != null){
        java.util.List listreturnp95= java.util.Arrays.asList(listarClasesActividadDeportiva94mtemp);
        tempreturnp95 = listreturnp95.toString();
        }
        %>
        <%=tempreturnp95%>
        <%
}
break;
case 99:
        gotMethod = true;
        java.lang.String[] listarInstitucionesConAct99mtemp = sampleControladorPublishProxyid.listarInstitucionesConAct();
if(listarInstitucionesConAct99mtemp == null){
%>
<%=listarInstitucionesConAct99mtemp %>
<%
}else{
        String tempreturnp100 = null;
        if(listarInstitucionesConAct99mtemp != null){
        java.util.List listreturnp100= java.util.Arrays.asList(listarInstitucionesConAct99mtemp);
        tempreturnp100 = listreturnp100.toString();
        }
        %>
        <%=tempreturnp100%>
        <%
}
break;
case 102:
        gotMethod = true;
        publicadores.DtUsuario publicadores1DtUsuario_20id = null;
        publicadores.DtUsuario publicadores1DtUsuario_21id = null;
        boolean modificarDatosUsuario102mtemp = sampleControladorPublishProxyid.modificarDatosUsuario(publicadores1DtUsuario_20id,publicadores1DtUsuario_21id);
        String tempResultreturnp103 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(modificarDatosUsuario102mtemp));
        %>
        <%= tempResultreturnp103 %>
        <%
break;
case 109:
        gotMethod = true;
        String arg0_22id=  request.getParameter("arg0112");
            java.lang.String arg0_22idTemp = null;
        if(!arg0_22id.equals("")){
         arg0_22idTemp  = arg0_22id;
        }
        String fecha_24id=  request.getParameter("fecha116");
            java.util.Calendar fecha_24idTemp = null;
        if(!fecha_24id.equals("")){
        java.text.DateFormat dateFormatfecha116 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfecha116  = dateFormatfecha116.parse(fecha_24id);
         fecha_24idTemp = new java.util.GregorianCalendar();
        fecha_24idTemp.setTime(dateTempfecha116);
        }
        String descripcion_25id=  request.getParameter("descripcion118");
            java.lang.String descripcion_25idTemp = null;
        if(!descripcion_25id.equals("")){
         descripcion_25idTemp  = descripcion_25id;
        }
        String duracion_26id=  request.getParameter("duracion120");
        int duracion_26idTemp  = Integer.parseInt(duracion_26id);
        String institucionDeportiva_27id=  request.getParameter("institucionDeportiva122");
            java.lang.String institucionDeportiva_27idTemp = null;
        if(!institucionDeportiva_27id.equals("")){
         institucionDeportiva_27idTemp  = institucionDeportiva_27id;
        }
        String costo_28id=  request.getParameter("costo124");
        float costo_28idTemp  = Float.parseFloat(costo_28id);
        String nombre_29id=  request.getParameter("nombre126");
            java.lang.String nombre_29idTemp = null;
        if(!nombre_29id.equals("")){
         nombre_29idTemp  = nombre_29id;
        }
        %>
        <jsp:useBean id="publicadores1DtActividadDeportiva_23id" scope="session" class="publicadores.DtActividadDeportiva" />
        <%
        publicadores1DtActividadDeportiva_23id.setFecha(fecha_24idTemp);
        publicadores1DtActividadDeportiva_23id.setDescripcion(descripcion_25idTemp);
        publicadores1DtActividadDeportiva_23id.setDuracion(duracion_26idTemp);
        publicadores1DtActividadDeportiva_23id.setInstitucionDeportiva(institucionDeportiva_27idTemp);
        publicadores1DtActividadDeportiva_23id.setCosto(costo_28idTemp);
        publicadores1DtActividadDeportiva_23id.setNombre(nombre_29idTemp);
        boolean modificarActividadDeportiva109mtemp = sampleControladorPublishProxyid.modificarActividadDeportiva(arg0_22idTemp,publicadores1DtActividadDeportiva_23id);
        String tempResultreturnp110 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(modificarActividadDeportiva109mtemp));
        %>
        <%= tempResultreturnp110 %>
        <%
break;
case 128:
        gotMethod = true;
        publicadores.DtActividadDeportiva[] rankingActividadesDeportivas128mtemp = sampleControladorPublishProxyid.rankingActividadesDeportivas();
if(rankingActividadesDeportivas128mtemp == null){
%>
<%=rankingActividadesDeportivas128mtemp %>
<%
}else{
        String tempreturnp129 = null;
        if(rankingActividadesDeportivas128mtemp != null){
        java.util.List listreturnp129= java.util.Arrays.asList(rankingActividadesDeportivas128mtemp);
        tempreturnp129 = listreturnp129.toString();
        }
        %>
        <%=tempreturnp129%>
        <%
}
break;
case 131:
        gotMethod = true;
        String arg0_30id=  request.getParameter("arg0146");
            java.lang.String arg0_30idTemp = null;
        if(!arg0_30id.equals("")){
         arg0_30idTemp  = arg0_30id;
        }
        publicadores.DtClase consultaDictadoClase131mtemp = sampleControladorPublishProxyid.consultaDictadoClase(arg0_30idTemp);
if(consultaDictadoClase131mtemp == null){
%>
<%=consultaDictadoClase131mtemp %>
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
if(consultaDictadoClase131mtemp != null){
java.util.Calendar typefecha134 = consultaDictadoClase131mtemp.getFecha();
        java.text.DateFormat dateFormatfecha134 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha134 = typefecha134.getTime();
        String tempResultfecha134 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha134.format(datefecha134));
        %>
        <%= tempResultfecha134 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(consultaDictadoClase131mtemp != null){
java.lang.String typeurl136 = consultaDictadoClase131mtemp.getUrl();
        String tempResulturl136 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl136));
        %>
        <%= tempResulturl136 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">actividadDeportiva:</TD>
<TD>
<%
if(consultaDictadoClase131mtemp != null){
java.lang.String typeactividadDeportiva138 = consultaDictadoClase131mtemp.getActividadDeportiva();
        String tempResultactividadDeportiva138 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeactividadDeportiva138));
        %>
        <%= tempResultactividadDeportiva138 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">profesor:</TD>
<TD>
<%
if(consultaDictadoClase131mtemp != null){
java.lang.String typeprofesor140 = consultaDictadoClase131mtemp.getProfesor();
        String tempResultprofesor140 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeprofesor140));
        %>
        <%= tempResultprofesor140 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(consultaDictadoClase131mtemp != null){
java.lang.String typenombre142 = consultaDictadoClase131mtemp.getNombre();
        String tempResultnombre142 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre142));
        %>
        <%= tempResultnombre142 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(consultaDictadoClase131mtemp != null){
java.util.Calendar typefechaReg144 = consultaDictadoClase131mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg144 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg144 = typefechaReg144.getTime();
        String tempResultfechaReg144 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg144.format(datefechaReg144));
        %>
        <%= tempResultfechaReg144 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 148:
        gotMethod = true;
        publicadores.DtClase[] rankingDictadosClases148mtemp = sampleControladorPublishProxyid.rankingDictadosClases();
if(rankingDictadosClases148mtemp == null){
%>
<%=rankingDictadosClases148mtemp %>
<%
}else{
        String tempreturnp149 = null;
        if(rankingDictadosClases148mtemp != null){
        java.util.List listreturnp149= java.util.Arrays.asList(rankingDictadosClases148mtemp);
        tempreturnp149 = listreturnp149.toString();
        }
        %>
        <%=tempreturnp149%>
        <%
}
break;
case 151:
        gotMethod = true;
        String arg0_31id=  request.getParameter("arg0154");
            java.lang.String arg0_31idTemp = null;
        if(!arg0_31id.equals("")){
         arg0_31idTemp  = arg0_31id;
        }
        String descripcion_33id=  request.getParameter("descripcion158");
            java.lang.String descripcion_33idTemp = null;
        if(!descripcion_33id.equals("")){
         descripcion_33idTemp  = descripcion_33id;
        }
        String url_34id=  request.getParameter("url160");
            java.lang.String url_34idTemp = null;
        if(!url_34id.equals("")){
         url_34idTemp  = url_34id;
        }
        String nombre_35id=  request.getParameter("nombre162");
            java.lang.String nombre_35idTemp = null;
        if(!nombre_35id.equals("")){
         nombre_35idTemp  = nombre_35id;
        }
        %>
        <jsp:useBean id="publicadores1DtInstitucionDeportiva_32id" scope="session" class="publicadores.DtInstitucionDeportiva" />
        <%
        publicadores1DtInstitucionDeportiva_32id.setDescripcion(descripcion_33idTemp);
        publicadores1DtInstitucionDeportiva_32id.setUrl(url_34idTemp);
        publicadores1DtInstitucionDeportiva_32id.setNombre(nombre_35idTemp);
        boolean modificarInstitucionDeportiva151mtemp = sampleControladorPublishProxyid.modificarInstitucionDeportiva(arg0_31idTemp,publicadores1DtInstitucionDeportiva_32id);
        String tempResultreturnp152 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(modificarInstitucionDeportiva151mtemp));
        %>
        <%= tempResultreturnp152 %>
        <%
break;
case 164:
        gotMethod = true;
        String arg0_36id=  request.getParameter("arg0167");
            java.lang.String arg0_36idTemp = null;
        if(!arg0_36id.equals("")){
         arg0_36idTemp  = arg0_36id;
        }
        java.lang.String[] listarClasesProf164mtemp = sampleControladorPublishProxyid.listarClasesProf(arg0_36idTemp);
if(listarClasesProf164mtemp == null){
%>
<%=listarClasesProf164mtemp %>
<%
}else{
        String tempreturnp165 = null;
        if(listarClasesProf164mtemp != null){
        java.util.List listreturnp165= java.util.Arrays.asList(listarClasesProf164mtemp);
        tempreturnp165 = listreturnp165.toString();
        }
        %>
        <%=tempreturnp165%>
        <%
}
break;
case 169:
        gotMethod = true;
        java.lang.String[] listarUsuarios169mtemp = sampleControladorPublishProxyid.listarUsuarios();
if(listarUsuarios169mtemp == null){
%>
<%=listarUsuarios169mtemp %>
<%
}else{
        String tempreturnp170 = null;
        if(listarUsuarios169mtemp != null){
        java.util.List listreturnp170= java.util.Arrays.asList(listarUsuarios169mtemp);
        tempreturnp170 = listreturnp170.toString();
        }
        %>
        <%=tempreturnp170%>
        <%
}
break;
case 172:
        gotMethod = true;
        String arg0_37id=  request.getParameter("arg0181");
            java.lang.String arg0_37idTemp = null;
        if(!arg0_37id.equals("")){
         arg0_37idTemp  = arg0_37id;
        }
        publicadores.DtInstitucionDeportiva getInstitucionDt172mtemp = sampleControladorPublishProxyid.getInstitucionDt(arg0_37idTemp);
if(getInstitucionDt172mtemp == null){
%>
<%=getInstitucionDt172mtemp %>
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
if(getInstitucionDt172mtemp != null){
java.lang.String typedescripcion175 = getInstitucionDt172mtemp.getDescripcion();
        String tempResultdescripcion175 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion175));
        %>
        <%= tempResultdescripcion175 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getInstitucionDt172mtemp != null){
java.lang.String typeurl177 = getInstitucionDt172mtemp.getUrl();
        String tempResulturl177 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl177));
        %>
        <%= tempResulturl177 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getInstitucionDt172mtemp != null){
java.lang.String typenombre179 = getInstitucionDt172mtemp.getNombre();
        String tempResultnombre179 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre179));
        %>
        <%= tempResultnombre179 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 183:
        gotMethod = true;
        String fecha_39id=  request.getParameter("fecha188");
            java.util.Calendar fecha_39idTemp = null;
        if(!fecha_39id.equals("")){
        java.text.DateFormat dateFormatfecha188 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfecha188  = dateFormatfecha188.parse(fecha_39id);
         fecha_39idTemp = new java.util.GregorianCalendar();
        fecha_39idTemp.setTime(dateTempfecha188);
        }
        String descripcion_40id=  request.getParameter("descripcion190");
            java.lang.String descripcion_40idTemp = null;
        if(!descripcion_40id.equals("")){
         descripcion_40idTemp  = descripcion_40id;
        }
        String duracion_41id=  request.getParameter("duracion192");
        int duracion_41idTemp  = Integer.parseInt(duracion_41id);
        String institucionDeportiva_42id=  request.getParameter("institucionDeportiva194");
            java.lang.String institucionDeportiva_42idTemp = null;
        if(!institucionDeportiva_42id.equals("")){
         institucionDeportiva_42idTemp  = institucionDeportiva_42id;
        }
        String costo_43id=  request.getParameter("costo196");
        float costo_43idTemp  = Float.parseFloat(costo_43id);
        String nombre_44id=  request.getParameter("nombre198");
            java.lang.String nombre_44idTemp = null;
        if(!nombre_44id.equals("")){
         nombre_44idTemp  = nombre_44id;
        }
        %>
        <jsp:useBean id="publicadores1DtActividadDeportiva_38id" scope="session" class="publicadores.DtActividadDeportiva" />
        <%
        publicadores1DtActividadDeportiva_38id.setFecha(fecha_39idTemp);
        publicadores1DtActividadDeportiva_38id.setDescripcion(descripcion_40idTemp);
        publicadores1DtActividadDeportiva_38id.setDuracion(duracion_41idTemp);
        publicadores1DtActividadDeportiva_38id.setInstitucionDeportiva(institucionDeportiva_42idTemp);
        publicadores1DtActividadDeportiva_38id.setCosto(costo_43idTemp);
        publicadores1DtActividadDeportiva_38id.setNombre(nombre_44idTemp);
        String fecha_46id=  request.getParameter("fecha202");
            java.util.Calendar fecha_46idTemp = null;
        if(!fecha_46id.equals("")){
        java.text.DateFormat dateFormatfecha202 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfecha202  = dateFormatfecha202.parse(fecha_46id);
         fecha_46idTemp = new java.util.GregorianCalendar();
        fecha_46idTemp.setTime(dateTempfecha202);
        }
        String url_47id=  request.getParameter("url204");
            java.lang.String url_47idTemp = null;
        if(!url_47id.equals("")){
         url_47idTemp  = url_47id;
        }
        String actividadDeportiva_48id=  request.getParameter("actividadDeportiva206");
            java.lang.String actividadDeportiva_48idTemp = null;
        if(!actividadDeportiva_48id.equals("")){
         actividadDeportiva_48idTemp  = actividadDeportiva_48id;
        }
        String profesor_49id=  request.getParameter("profesor208");
            java.lang.String profesor_49idTemp = null;
        if(!profesor_49id.equals("")){
         profesor_49idTemp  = profesor_49id;
        }
        String nombre_50id=  request.getParameter("nombre210");
            java.lang.String nombre_50idTemp = null;
        if(!nombre_50id.equals("")){
         nombre_50idTemp  = nombre_50id;
        }
        String fechaReg_51id=  request.getParameter("fechaReg212");
            java.util.Calendar fechaReg_51idTemp = null;
        if(!fechaReg_51id.equals("")){
        java.text.DateFormat dateFormatfechaReg212 = java.text.DateFormat.getDateInstance();
        java.util.Date dateTempfechaReg212  = dateFormatfechaReg212.parse(fechaReg_51id);
         fechaReg_51idTemp = new java.util.GregorianCalendar();
        fechaReg_51idTemp.setTime(dateTempfechaReg212);
        }
        %>
        <jsp:useBean id="publicadores1DtClase_45id" scope="session" class="publicadores.DtClase" />
        <%
        publicadores1DtClase_45id.setFecha(fecha_46idTemp);
        publicadores1DtClase_45id.setUrl(url_47idTemp);
        publicadores1DtClase_45id.setActividadDeportiva(actividadDeportiva_48idTemp);
        publicadores1DtClase_45id.setProfesor(profesor_49idTemp);
        publicadores1DtClase_45id.setNombre(nombre_50idTemp);
        publicadores1DtClase_45id.setFechaReg(fechaReg_51idTemp);
        sampleControladorPublishProxyid.altaDictadoClase(publicadores1DtActividadDeportiva_38id,publicadores1DtClase_45id);
break;
case 214:
        gotMethod = true;
        String arg0_52id=  request.getParameter("arg0217");
            java.lang.String arg0_52idTemp = null;
        if(!arg0_52id.equals("")){
         arg0_52idTemp  = arg0_52id;
        }
        publicadores.Socio getSocio214mtemp = sampleControladorPublishProxyid.getSocio(arg0_52idTemp);
if(getSocio214mtemp == null){
%>
<%=getSocio214mtemp %>
<%
}else{
        if(getSocio214mtemp!= null){
        String tempreturnp215 = getSocio214mtemp.toString();
        %>
        <%=tempreturnp215%>
        <%
        }}
break;
case 219:
        gotMethod = true;
        String arg0_53id=  request.getParameter("arg0234");
            java.lang.String arg0_53idTemp = null;
        if(!arg0_53id.equals("")){
         arg0_53idTemp  = arg0_53id;
        }
        publicadores.DtClase getDatosClase219mtemp = sampleControladorPublishProxyid.getDatosClase(arg0_53idTemp);
if(getDatosClase219mtemp == null){
%>
<%=getDatosClase219mtemp %>
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
if(getDatosClase219mtemp != null){
java.util.Calendar typefecha222 = getDatosClase219mtemp.getFecha();
        java.text.DateFormat dateFormatfecha222 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha222 = typefecha222.getTime();
        String tempResultfecha222 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha222.format(datefecha222));
        %>
        <%= tempResultfecha222 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getDatosClase219mtemp != null){
java.lang.String typeurl224 = getDatosClase219mtemp.getUrl();
        String tempResulturl224 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl224));
        %>
        <%= tempResulturl224 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">actividadDeportiva:</TD>
<TD>
<%
if(getDatosClase219mtemp != null){
java.lang.String typeactividadDeportiva226 = getDatosClase219mtemp.getActividadDeportiva();
        String tempResultactividadDeportiva226 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeactividadDeportiva226));
        %>
        <%= tempResultactividadDeportiva226 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">profesor:</TD>
<TD>
<%
if(getDatosClase219mtemp != null){
java.lang.String typeprofesor228 = getDatosClase219mtemp.getProfesor();
        String tempResultprofesor228 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeprofesor228));
        %>
        <%= tempResultprofesor228 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getDatosClase219mtemp != null){
java.lang.String typenombre230 = getDatosClase219mtemp.getNombre();
        String tempResultnombre230 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre230));
        %>
        <%= tempResultnombre230 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getDatosClase219mtemp != null){
java.util.Calendar typefechaReg232 = getDatosClase219mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg232 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg232 = typefechaReg232.getTime();
        String tempResultfechaReg232 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg232.format(datefechaReg232));
        %>
        <%= tempResultfechaReg232 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 236:
        gotMethod = true;
        String arg0_54id=  request.getParameter("arg0239");
            java.lang.String arg0_54idTemp = null;
        if(!arg0_54id.equals("")){
         arg0_54idTemp  = arg0_54id;
        }
        publicadores.DtRegistro[] getRegistrosClase236mtemp = sampleControladorPublishProxyid.getRegistrosClase(arg0_54idTemp);
if(getRegistrosClase236mtemp == null){
%>
<%=getRegistrosClase236mtemp %>
<%
}else{
        String tempreturnp237 = null;
        if(getRegistrosClase236mtemp != null){
        java.util.List listreturnp237= java.util.Arrays.asList(getRegistrosClase236mtemp);
        tempreturnp237 = listreturnp237.toString();
        }
        %>
        <%=tempreturnp237%>
        <%
}
break;
case 241:
        gotMethod = true;
        java.lang.String[] listarSocios241mtemp = sampleControladorPublishProxyid.listarSocios();
if(listarSocios241mtemp == null){
%>
<%=listarSocios241mtemp %>
<%
}else{
        String tempreturnp242 = null;
        if(listarSocios241mtemp != null){
        java.util.List listreturnp242= java.util.Arrays.asList(listarSocios241mtemp);
        tempreturnp242 = listreturnp242.toString();
        }
        %>
        <%=tempreturnp242%>
        <%
}
break;
case 244:
        gotMethod = true;
        java.lang.String[] listarSociosFront244mtemp = sampleControladorPublishProxyid.listarSociosFront();
if(listarSociosFront244mtemp == null){
%>
<%=listarSociosFront244mtemp %>
<%
}else{
        String tempreturnp245 = null;
        if(listarSociosFront244mtemp != null){
        java.util.List listreturnp245= java.util.Arrays.asList(listarSociosFront244mtemp);
        tempreturnp245 = listreturnp245.toString();
        }
        %>
        <%=tempreturnp245%>
        <%
}
break;
case 247:
        gotMethod = true;
        String arg0_55id=  request.getParameter("arg0250");
            java.lang.String arg0_55idTemp = null;
        if(!arg0_55id.equals("")){
         arg0_55idTemp  = arg0_55id;
        }
        publicadores.DtUsuario consultaUsuario247mtemp = sampleControladorPublishProxyid.consultaUsuario(arg0_55idTemp);
if(consultaUsuario247mtemp == null){
%>
<%=consultaUsuario247mtemp %>
<%
}else{
        if(consultaUsuario247mtemp!= null){
        String tempreturnp248 = consultaUsuario247mtemp.toString();
        %>
        <%=tempreturnp248%>
        <%
        }}
break;
case 252:
        gotMethod = true;
        String arg0_56id=  request.getParameter("arg0275");
            java.lang.String arg0_56idTemp = null;
        if(!arg0_56id.equals("")){
         arg0_56idTemp  = arg0_56id;
        }
        publicadores.DtProfesor findProfesor252mtemp = sampleControladorPublishProxyid.findProfesor(arg0_56idTemp);
if(findProfesor252mtemp == null){
%>
<%=findProfesor252mtemp %>
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
if(findProfesor252mtemp != null){
java.lang.String typedescripcion255 = findProfesor252mtemp.getDescripcion();
        String tempResultdescripcion255 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion255));
        %>
        <%= tempResultdescripcion255 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
java.util.Calendar typefechaNac257 = findProfesor252mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac257 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac257 = typefechaNac257.getTime();
        String tempResultfechaNac257 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac257.format(datefechaNac257));
        %>
        <%= tempResultfechaNac257 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">institucionDeportiva:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
java.lang.String typeinstitucionDeportiva259 = findProfesor252mtemp.getInstitucionDeportiva();
        String tempResultinstitucionDeportiva259 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeinstitucionDeportiva259));
        %>
        <%= tempResultinstitucionDeportiva259 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">sitioweb:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
java.lang.String typesitioweb261 = findProfesor252mtemp.getSitioweb();
        String tempResultsitioweb261 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesitioweb261));
        %>
        <%= tempResultsitioweb261 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
java.lang.String typenickname263 = findProfesor252mtemp.getNickname();
        String tempResultnickname263 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname263));
        %>
        <%= tempResultnickname263 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
java.lang.String typeemail265 = findProfesor252mtemp.getEmail();
        String tempResultemail265 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail265));
        %>
        <%= tempResultemail265 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">biografia:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
java.lang.String typebiografia267 = findProfesor252mtemp.getBiografia();
        String tempResultbiografia267 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebiografia267));
        %>
        <%= tempResultbiografia267 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">profileImage:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
byte[] typeprofileImage269 = findProfesor252mtemp.getProfileImage();
        String tempprofileImage269 = "[";        for(int iprofileImage269=0;iprofileImage269< typeprofileImage269.length;iprofileImage269++){
            tempprofileImage269 = tempprofileImage269 + typeprofileImage269[iprofileImage269] + ",";
        }
        int lengthprofileImage269 = tempprofileImage269.length();
        tempprofileImage269 = tempprofileImage269.substring(0,(lengthprofileImage269 - 1)) + "]";
        %>
        <%=tempprofileImage269%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
java.lang.String typenombre271 = findProfesor252mtemp.getNombre();
        String tempResultnombre271 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre271));
        %>
        <%= tempResultnombre271 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(findProfesor252mtemp != null){
java.lang.String typeapellido273 = findProfesor252mtemp.getApellido();
        String tempResultapellido273 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido273));
        %>
        <%= tempResultapellido273 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 277:
        gotMethod = true;
        String arg0_57id=  request.getParameter("arg0292");
            java.lang.String arg0_57idTemp = null;
        if(!arg0_57id.equals("")){
         arg0_57idTemp  = arg0_57id;
        }
        publicadores.DtSocio findSocio277mtemp = sampleControladorPublishProxyid.findSocio(arg0_57idTemp);
if(findSocio277mtemp == null){
%>
<%=findSocio277mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaNac:</TD>
<TD>
<%
if(findSocio277mtemp != null){
java.util.Calendar typefechaNac280 = findSocio277mtemp.getFechaNac();
        java.text.DateFormat dateFormatfechaNac280 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaNac280 = typefechaNac280.getTime();
        String tempResultfechaNac280 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaNac280.format(datefechaNac280));
        %>
        <%= tempResultfechaNac280 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nickname:</TD>
<TD>
<%
if(findSocio277mtemp != null){
java.lang.String typenickname282 = findSocio277mtemp.getNickname();
        String tempResultnickname282 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenickname282));
        %>
        <%= tempResultnickname282 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">email:</TD>
<TD>
<%
if(findSocio277mtemp != null){
java.lang.String typeemail284 = findSocio277mtemp.getEmail();
        String tempResultemail284 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeemail284));
        %>
        <%= tempResultemail284 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">profileImage:</TD>
<TD>
<%
if(findSocio277mtemp != null){
byte[] typeprofileImage286 = findSocio277mtemp.getProfileImage();
        String tempprofileImage286 = "[";        for(int iprofileImage286=0;iprofileImage286< typeprofileImage286.length;iprofileImage286++){
            tempprofileImage286 = tempprofileImage286 + typeprofileImage286[iprofileImage286] + ",";
        }
        int lengthprofileImage286 = tempprofileImage286.length();
        tempprofileImage286 = tempprofileImage286.substring(0,(lengthprofileImage286 - 1)) + "]";
        %>
        <%=tempprofileImage286%>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">apellido:</TD>
<TD>
<%
if(findSocio277mtemp != null){
java.lang.String typeapellido288 = findSocio277mtemp.getApellido();
        String tempResultapellido288 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeapellido288));
        %>
        <%= tempResultapellido288 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(findSocio277mtemp != null){
java.lang.String typenombre290 = findSocio277mtemp.getNombre();
        String tempResultnombre290 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre290));
        %>
        <%= tempResultnombre290 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 294:
        gotMethod = true;
        java.lang.String[] listarActividades294mtemp = sampleControladorPublishProxyid.listarActividades();
if(listarActividades294mtemp == null){
%>
<%=listarActividades294mtemp %>
<%
}else{
        String tempreturnp295 = null;
        if(listarActividades294mtemp != null){
        java.util.List listreturnp295= java.util.Arrays.asList(listarActividades294mtemp);
        tempreturnp295 = listreturnp295.toString();
        }
        %>
        <%=tempreturnp295%>
        <%
}
break;
case 297:
        gotMethod = true;
        String arg0_58id=  request.getParameter("arg0300");
            java.lang.String arg0_58idTemp = null;
        if(!arg0_58id.equals("")){
         arg0_58idTemp  = arg0_58id;
        }
        publicadores.DtClase[] getClasesActDep297mtemp = sampleControladorPublishProxyid.getClasesActDep(arg0_58idTemp);
if(getClasesActDep297mtemp == null){
%>
<%=getClasesActDep297mtemp %>
<%
}else{
        String tempreturnp298 = null;
        if(getClasesActDep297mtemp != null){
        java.util.List listreturnp298= java.util.Arrays.asList(getClasesActDep297mtemp);
        tempreturnp298 = listreturnp298.toString();
        }
        %>
        <%=tempreturnp298%>
        <%
}
break;
case 302:
        gotMethod = true;
        java.lang.String[] listarActsFront302mtemp = sampleControladorPublishProxyid.listarActsFront();
if(listarActsFront302mtemp == null){
%>
<%=listarActsFront302mtemp %>
<%
}else{
        String tempreturnp303 = null;
        if(listarActsFront302mtemp != null){
        java.util.List listreturnp303= java.util.Arrays.asList(listarActsFront302mtemp);
        tempreturnp303 = listreturnp303.toString();
        }
        %>
        <%=tempreturnp303%>
        <%
}
break;
case 305:
        gotMethod = true;
        java.lang.String[] listarClasesFront305mtemp = sampleControladorPublishProxyid.listarClasesFront();
if(listarClasesFront305mtemp == null){
%>
<%=listarClasesFront305mtemp %>
<%
}else{
        String tempreturnp306 = null;
        if(listarClasesFront305mtemp != null){
        java.util.List listreturnp306= java.util.Arrays.asList(listarClasesFront305mtemp);
        tempreturnp306 = listreturnp306.toString();
        }
        %>
        <%=tempreturnp306%>
        <%
}
break;
case 308:
        gotMethod = true;
        publicadores.DtUsuario publicadores1DtUsuario_59id = null;
        String arg1_60id=  request.getParameter("arg1313");
            java.lang.String arg1_60idTemp = null;
        if(!arg1_60id.equals("")){
         arg1_60idTemp  = arg1_60id;
        }
        sampleControladorPublishProxyid.altaUsuario(publicadores1DtUsuario_59id,arg1_60idTemp);
break;
case 315:
        gotMethod = true;
        String arg0_61id=  request.getParameter("arg0362");
            java.lang.String arg0_61idTemp = null;
        if(!arg0_61id.equals("")){
         arg0_61idTemp  = arg0_61id;
        }
        publicadores.Clase getClase315mtemp = sampleControladorPublishProxyid.getClase(arg0_61idTemp);
if(getClase315mtemp == null){
%>
<%=getClase315mtemp %>
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
if(getClase315mtemp != null){
java.util.Calendar typefecha318 = getClase315mtemp.getFecha();
        java.text.DateFormat dateFormatfecha318 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha318 = typefecha318.getTime();
        String tempResultfecha318 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha318.format(datefecha318));
        %>
        <%= tempResultfecha318 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getClase315mtemp != null){
java.lang.String typeurl320 = getClase315mtemp.getUrl();
        String tempResulturl320 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl320));
        %>
        <%= tempResulturl320 %>
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
if(getClase315mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase315mtemp.getActividadDeportiva();
if(tebece0 != null){
java.util.Calendar typefecha324 = tebece0.getFecha();
        java.text.DateFormat dateFormatfecha324 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha324 = typefecha324.getTime();
        String tempResultfecha324 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha324.format(datefecha324));
        %>
        <%= tempResultfecha324 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getClase315mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase315mtemp.getActividadDeportiva();
if(tebece0 != null){
java.lang.String typedescripcion326 = tebece0.getDescripcion();
        String tempResultdescripcion326 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion326));
        %>
        <%= tempResultdescripcion326 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getClase315mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase315mtemp.getActividadDeportiva();
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
if(getClase315mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase315mtemp.getActividadDeportiva();
if(tebece0 != null){
java.lang.String typenombre330 = tebece0.getNombre();
        String tempResultnombre330 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre330));
        %>
        <%= tempResultnombre330 %>
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
if(getClase315mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase315mtemp.getActividadDeportiva();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typedescripcion334 = tebece1.getDescripcion();
        String tempResultdescripcion334 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion334));
        %>
        <%= tempResultdescripcion334 %>
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
if(getClase315mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase315mtemp.getActividadDeportiva();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typeurl336 = tebece1.getUrl();
        String tempResulturl336 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl336));
        %>
        <%= tempResulturl336 %>
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
if(getClase315mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase315mtemp.getActividadDeportiva();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typenombre338 = tebece1.getNombre();
        String tempResultnombre338 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre338));
        %>
        <%= tempResultnombre338 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getClase315mtemp != null){
publicadores.ActividadDeportiva tebece0=getClase315mtemp.getActividadDeportiva();
if(tebece0 != null){
%>
<%=tebece0.getCosto()
%><%}}%>
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
if(getClase315mtemp != null){
publicadores.Profesor tebece0=getClase315mtemp.getProfesor();
if(tebece0 != null){
java.lang.String typedescripcion344 = tebece0.getDescripcion();
        String tempResultdescripcion344 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion344));
        %>
        <%= tempResultdescripcion344 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">sitioWeb:</TD>
<TD>
<%
if(getClase315mtemp != null){
publicadores.Profesor tebece0=getClase315mtemp.getProfesor();
if(tebece0 != null){
java.lang.String typesitioWeb346 = tebece0.getSitioWeb();
        String tempResultsitioWeb346 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typesitioWeb346));
        %>
        <%= tempResultsitioWeb346 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">biografia:</TD>
<TD>
<%
if(getClase315mtemp != null){
publicadores.Profesor tebece0=getClase315mtemp.getProfesor();
if(tebece0 != null){
java.lang.String typebiografia348 = tebece0.getBiografia();
        String tempResultbiografia348 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typebiografia348));
        %>
        <%= tempResultbiografia348 %>
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
if(getClase315mtemp != null){
publicadores.Profesor tebece0=getClase315mtemp.getProfesor();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typedescripcion352 = tebece1.getDescripcion();
        String tempResultdescripcion352 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion352));
        %>
        <%= tempResultdescripcion352 %>
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
if(getClase315mtemp != null){
publicadores.Profesor tebece0=getClase315mtemp.getProfesor();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typeurl354 = tebece1.getUrl();
        String tempResulturl354 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl354));
        %>
        <%= tempResulturl354 %>
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
if(getClase315mtemp != null){
publicadores.Profesor tebece0=getClase315mtemp.getProfesor();
if(tebece0 != null){
publicadores.InstitucionDeportiva tebece1=tebece0.getInstitucionDeportiva();
if(tebece1 != null){
java.lang.String typenombre356 = tebece1.getNombre();
        String tempResultnombre356 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre356));
        %>
        <%= tempResultnombre356 %>
        <%
}}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getClase315mtemp != null){
java.lang.String typenombre358 = getClase315mtemp.getNombre();
        String tempResultnombre358 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre358));
        %>
        <%= tempResultnombre358 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">fechaReg:</TD>
<TD>
<%
if(getClase315mtemp != null){
java.util.Calendar typefechaReg360 = getClase315mtemp.getFechaReg();
        java.text.DateFormat dateFormatfechaReg360 = java.text.DateFormat.getDateInstance();
        java.util.Date datefechaReg360 = typefechaReg360.getTime();
        String tempResultfechaReg360 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfechaReg360.format(datefechaReg360));
        %>
        <%= tempResultfechaReg360 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 364:
        gotMethod = true;
        String arg0_62id=  request.getParameter("arg0367");
            java.lang.String arg0_62idTemp = null;
        if(!arg0_62id.equals("")){
         arg0_62idTemp  = arg0_62id;
        }
        String arg1_63id=  request.getParameter("arg1369");
            java.lang.String arg1_63idTemp = null;
        if(!arg1_63id.equals("")){
         arg1_63idTemp  = arg1_63id;
        }
        boolean inicioSesion364mtemp = sampleControladorPublishProxyid.inicioSesion(arg0_62idTemp,arg1_63idTemp);
        String tempResultreturnp365 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(inicioSesion364mtemp));
        %>
        <%= tempResultreturnp365 %>
        <%
break;
case 371:
        gotMethod = true;
        java.lang.String[] listarProfesores371mtemp = sampleControladorPublishProxyid.listarProfesores();
if(listarProfesores371mtemp == null){
%>
<%=listarProfesores371mtemp %>
<%
}else{
        String tempreturnp372 = null;
        if(listarProfesores371mtemp != null){
        java.util.List listreturnp372= java.util.Arrays.asList(listarProfesores371mtemp);
        tempreturnp372 = listreturnp372.toString();
        }
        %>
        <%=tempreturnp372%>
        <%
}
break;
case 374:
        gotMethod = true;
        String arg0_64id=  request.getParameter("arg0377");
            java.lang.String arg0_64idTemp = null;
        if(!arg0_64id.equals("")){
         arg0_64idTemp  = arg0_64id;
        }
        String arg1_65id=  request.getParameter("arg1379");
            java.lang.String arg1_65idTemp = null;
        if(!arg1_65id.equals("")){
         arg1_65idTemp  = arg1_65id;
        }
        sampleControladorPublishProxyid.eliminarRegistro(arg0_64idTemp,arg1_65idTemp);
break;
case 381:
        gotMethod = true;
        String arg0_66id=  request.getParameter("arg0384");
            java.lang.String arg0_66idTemp = null;
        if(!arg0_66id.equals("")){
         arg0_66idTemp  = arg0_66id;
        }
        boolean existeMail381mtemp = sampleControladorPublishProxyid.existeMail(arg0_66idTemp);
        String tempResultreturnp382 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existeMail381mtemp));
        %>
        <%= tempResultreturnp382 %>
        <%
break;
case 386:
        gotMethod = true;
        String arg0_67id=  request.getParameter("arg0389");
            java.lang.String arg0_67idTemp = null;
        if(!arg0_67id.equals("")){
         arg0_67idTemp  = arg0_67id;
        }
        boolean existeNickname386mtemp = sampleControladorPublishProxyid.existeNickname(arg0_67idTemp);
        String tempResultreturnp387 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(existeNickname386mtemp));
        %>
        <%= tempResultreturnp387 %>
        <%
break;
case 391:
        gotMethod = true;
        java.lang.String[] listarClases391mtemp = sampleControladorPublishProxyid.listarClases();
if(listarClases391mtemp == null){
%>
<%=listarClases391mtemp %>
<%
}else{
        String tempreturnp392 = null;
        if(listarClases391mtemp != null){
        java.util.List listreturnp392= java.util.Arrays.asList(listarClases391mtemp);
        tempreturnp392 = listreturnp392.toString();
        }
        %>
        <%=tempreturnp392%>
        <%
}
break;
case 394:
        gotMethod = true;
        String arg0_68id=  request.getParameter("arg0415");
            java.lang.String arg0_68idTemp = null;
        if(!arg0_68id.equals("")){
         arg0_68idTemp  = arg0_68id;
        }
        publicadores.ActividadDeportiva getAct394mtemp = sampleControladorPublishProxyid.getAct(arg0_68idTemp);
if(getAct394mtemp == null){
%>
<%=getAct394mtemp %>
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
if(getAct394mtemp != null){
java.util.Calendar typefecha397 = getAct394mtemp.getFecha();
        java.text.DateFormat dateFormatfecha397 = java.text.DateFormat.getDateInstance();
        java.util.Date datefecha397 = typefecha397.getTime();
        String tempResultfecha397 = org.eclipse.jst.ws.util.JspUtils.markup(dateFormatfecha397.format(datefecha397));
        %>
        <%= tempResultfecha397 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">descripcion:</TD>
<TD>
<%
if(getAct394mtemp != null){
java.lang.String typedescripcion399 = getAct394mtemp.getDescripcion();
        String tempResultdescripcion399 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion399));
        %>
        <%= tempResultdescripcion399 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">duracion:</TD>
<TD>
<%
if(getAct394mtemp != null){
%>
<%=getAct394mtemp.getDuracion()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getAct394mtemp != null){
java.lang.String typenombre403 = getAct394mtemp.getNombre();
        String tempResultnombre403 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre403));
        %>
        <%= tempResultnombre403 %>
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
if(getAct394mtemp != null){
publicadores.InstitucionDeportiva tebece0=getAct394mtemp.getInstitucionDeportiva();
if(tebece0 != null){
java.lang.String typedescripcion407 = tebece0.getDescripcion();
        String tempResultdescripcion407 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion407));
        %>
        <%= tempResultdescripcion407 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getAct394mtemp != null){
publicadores.InstitucionDeportiva tebece0=getAct394mtemp.getInstitucionDeportiva();
if(tebece0 != null){
java.lang.String typeurl409 = tebece0.getUrl();
        String tempResulturl409 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl409));
        %>
        <%= tempResulturl409 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD WIDTH="5%"></TD>
<TD COLSPAN="1" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getAct394mtemp != null){
publicadores.InstitucionDeportiva tebece0=getAct394mtemp.getInstitucionDeportiva();
if(tebece0 != null){
java.lang.String typenombre411 = tebece0.getNombre();
        String tempResultnombre411 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre411));
        %>
        <%= tempResultnombre411 %>
        <%
}}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">costo:</TD>
<TD>
<%
if(getAct394mtemp != null){
%>
<%=getAct394mtemp.getCosto()
%><%}%>
</TD>
</TABLE>
<%
}
break;
case 417:
        gotMethod = true;
        String arg0_69id=  request.getParameter("arg0426");
            java.lang.String arg0_69idTemp = null;
        if(!arg0_69id.equals("")){
         arg0_69idTemp  = arg0_69id;
        }
        publicadores.InstitucionDeportiva getInstitucion417mtemp = sampleControladorPublishProxyid.getInstitucion(arg0_69idTemp);
if(getInstitucion417mtemp == null){
%>
<%=getInstitucion417mtemp %>
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
if(getInstitucion417mtemp != null){
java.lang.String typedescripcion420 = getInstitucion417mtemp.getDescripcion();
        String tempResultdescripcion420 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typedescripcion420));
        %>
        <%= tempResultdescripcion420 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">url:</TD>
<TD>
<%
if(getInstitucion417mtemp != null){
java.lang.String typeurl422 = getInstitucion417mtemp.getUrl();
        String tempResulturl422 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typeurl422));
        %>
        <%= tempResulturl422 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">nombre:</TD>
<TD>
<%
if(getInstitucion417mtemp != null){
java.lang.String typenombre424 = getInstitucion417mtemp.getNombre();
        String tempResultnombre424 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typenombre424));
        %>
        <%= tempResultnombre424 %>
        <%
}%>
</TD>
</TABLE>
<%
}
break;
case 428:
        gotMethod = true;
        String arg0_70id=  request.getParameter("arg0431");
            java.lang.String arg0_70idTemp = null;
        if(!arg0_70id.equals("")){
         arg0_70idTemp  = arg0_70id;
        }
        publicadores.DtRegistro[] getRegistrosSocio428mtemp = sampleControladorPublishProxyid.getRegistrosSocio(arg0_70idTemp);
if(getRegistrosSocio428mtemp == null){
%>
<%=getRegistrosSocio428mtemp %>
<%
}else{
        String tempreturnp429 = null;
        if(getRegistrosSocio428mtemp != null){
        java.util.List listreturnp429= java.util.Arrays.asList(getRegistrosSocio428mtemp);
        tempreturnp429 = listreturnp429.toString();
        }
        %>
        <%=tempreturnp429%>
        <%
}
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