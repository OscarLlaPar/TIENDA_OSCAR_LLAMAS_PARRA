<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<header>
		<h1>Tienda �scar Llamas Parra</h1>
		<%
		if(request.getSession().getAttribute("usuarioTienda")==null){
			%>
			<a href="pages/login.jsp">Iniciar sesi�n</a>
			<a href="pages/registro.jsp">Registrarse</a>
			<%
		}
		else{
			%>
			<a href="<%= request.getContextPath()%>/pages/perfilUsuario.jsp">Ver perfil</a>
			<a href="<%= request.getContextPath()%>/ServletLogin">Cerrar sesi�n</a>
			<%
		}
		%>
		
	</header>
</body>
</html>