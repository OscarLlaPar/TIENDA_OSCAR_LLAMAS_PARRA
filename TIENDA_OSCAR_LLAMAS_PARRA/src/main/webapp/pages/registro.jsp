<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro - Tienda Óscar Llamas Parra</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/registro.css">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Registro</h2>
		</div>
		
		<form action="<%= request.getContextPath() %>/ServletRegistro" method="post">
			<div class=campo>
				<label for="email">Email</label>
				<input type="email" name="email" placeholder="ejemplo@mail.com">
			</div>
			<div class=campo>
				<label for="nombre">Nombre</label>
				<input type="text" name="nombre" placeholder="Nombre de pila">
			</div>
			<div class=campo>
				<label for="apellido1">Primer apellido</label>
				<input type="text" name="apellido1" placeholder="Primer apellido">
			</div>
			<div class=campo>
				<label for="apellido2">Segundo apellido</label>
				<input type="text" name="apellido2" placeholder="Segundo apellido">
			</div>
			<div class=campo>
				<label for="direccion">Dirección</label>
				<input type="text" name="direccion" placeholder="C/ Calle, nº 1">
			</div>
			<div class=campo>
				<label for="provincia">Provincia</label>
				<input type="text" name="provincia" placeholder="Provincia">
			</div>
			<div class=campo>
				<label for="localidad">Localidad</label>
				<input type="text" name="localidad" placeholder="Localidad">
			</div>
			<div class=campo>
				<label for="telefono">Teléfono</label>
				<input type="text" name="telefono" placeholder="Teléfono">
			</div>
			<div class=campo>
				<label for="dni">DNI</label>
				<input type="text" name="dni" placeholder="DNI">
			</div>
			<div class=campo>
				<label for="password">Contraseña</label>
				<input type="password" name="password" placeholder="">
			</div>
			<div class=campo>
				<label for="confirmarPassword">Confirmar contraseña</label>
				<input type="password" name="confirmarPassword" placeholder="">
			</div>
			<input type="submit" name="registro" value="Registrarse">
		</form>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>