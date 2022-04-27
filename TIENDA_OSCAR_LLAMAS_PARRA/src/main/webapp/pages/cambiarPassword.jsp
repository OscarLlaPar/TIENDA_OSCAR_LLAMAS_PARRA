<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cambiar contrase�a - Tienda �scar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Cambiar contrase�a</h2>
		</div>
		<div>
			<form action="<%= request.getContextPath() %>/ServletCambiarPassword" method="post">
				<%
					if(request.getAttribute("mensajePassword")!=null){
						%>
						<p><%= request.getAttribute("mensajePassword") %></p>
						<%
					}
				%>
				<div>
					<label for="nombre">Contrase�a actual</label>
					<input type="password" name="passwordActual">
				</div>
				<div>
					<label for="nombre">Contrase�a nueva</label>
					<input type="password" name="passwordNueva">
				</div>
				<div>
					<label for="nombre">Confirmar contrase�a</label>
					<input type="password" name="confirmarPassword">
				</div>
				<div>
					<input type="submit" name="cambiarPassword" value="Cambiar contrase�a">
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>