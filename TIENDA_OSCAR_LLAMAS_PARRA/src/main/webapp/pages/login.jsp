<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<form action="<%=request.getContextPath()%>/ServletLogin" method="post">
			<label for="nombre">Nombre:</label>
			<br>
			<input type="text" name="nombre" placeholder="Nombre de usuario...">
			<br>
			<label for="password">Contraseña:</label>
			<br>
			<input type="password" name="password" placeholder="Contraseña...">
			<br>
			<input type="submit" name="login" value="Log in">
		</form>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>