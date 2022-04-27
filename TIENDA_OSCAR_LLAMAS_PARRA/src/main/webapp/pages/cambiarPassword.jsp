<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cambiar contraseña - Tienda Óscar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Cambiar contraseña</h2>
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
					<label for="nombre">Contraseña actual</label>
					<input type="password" name="passwordActual">
				</div>
				<div>
					<label for="nombre">Contraseña nueva</label>
					<input type="password" name="passwordNueva">
				</div>
				<div>
					<label for="nombre">Confirmar contraseña</label>
					<input type="password" name="confirmarPassword">
				</div>
				<div>
					<input type="submit" name="cambiarPassword" value="Cambiar contraseña">
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>