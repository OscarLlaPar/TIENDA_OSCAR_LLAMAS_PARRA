<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Iniciar sesi�n - Tienda �scar Llamas Parra</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<h2>Iniciar sesi�n</h2>
		 <a href="<%=request.getContextPath()%>">Volver</a>
		<form action="<%=request.getContextPath()%>/ServletLogin" method="post">
			<%
				if(request.getAttribute("errorLogin")!=null){
			%>
					<p class="error"><%= request.getAttribute("errorLogin") %></p>
			<%
				}
			%>
			<label for="email">Email:</label>
			<br>
			<input type="email" name="email" placeholder="ejemplo@mail.com">
			<br>
			<label for="password">Contrase�a:</label>
			<br>
			<input type="password" name="password" placeholder="Contrase�a...">
			<br>
			<input type="submit" name="login" value="Log in">
		</form>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>