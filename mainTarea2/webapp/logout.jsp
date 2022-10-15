<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout - Entrenamos UY</title>
<script src="js/backNoWork.js" type="text/javascript"></script>
</head>


<body>

	<% 	
		response.setHeader("Cache-Control", "private,no-store,no-cache");
		request.getSession().setAttribute("name", null);
		request.getSession().invalidate();
		response.sendRedirect(request.getContextPath() + "/index.jsp");
	%>
	
</body>
</html>