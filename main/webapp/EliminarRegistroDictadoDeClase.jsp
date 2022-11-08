<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Eliminar Registro a Dictado de Clase - Entrenamos UY</title>
	<link rel="stylesheet" href="css/styleLoginV2.css">
	<%@page import="interfaces.Fabrica"%>
	<%@page import="interfaces.IControlador"%>
	<%@page import="datatypes.DtSocio"%>
	<%@page import="datatypes.DtRegistro"%>
	<%@page import="java.util.List"%>
	<%@include file ="/headerSocio.jsp" %>
</head>
<body>
				<%
        String nicknamee = (String) ss.getAttribute("name");
        DtSocio dtSocc = ii.findSocio(nicknamee);
        List<DtRegistro> registros = ii.getRegistrosSocio(nicknamee);
        String[] list = new String[registros.size()];
        int u=0;
        for(DtRegistro r: registros) {
            list[u]= r.getClase();
            u++;
        }
        %>
        
        <%
			if(registros.isEmpty()){ %>
				<p>El usuario no tiene registros!</p>
				
            <%
			}else{    %>
            <div class="container">
                <div class="card">
                    <h3>Eliminar registro</h3>
                       <form action="EliminarRegistroDictadoDeClase" method="post">
                        <div class="select">
                        <select name="nomClase">
                            <%for(String a: list){%> 
                                <option value="<%=a%>"><%=a%></option>
                          <%}%>
                        </select>
                        </div>
                        <div style="text-align:center; margin-top: 5vh;"><button>Aceptar</button></div>
                    </form>
                </div>
            </div>
    <%}%>
</body>
</html>