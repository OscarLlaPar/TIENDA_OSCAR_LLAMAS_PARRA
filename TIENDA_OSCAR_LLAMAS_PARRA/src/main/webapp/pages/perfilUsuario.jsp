<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="curso.java.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<%
    	Usuario usuario=(Usuario)request.getSession().getAttribute("usuarioTienda");
    %>
<head>
<meta charset="ISO-8859-1">
<title><%=usuario.getNombre() %> - Tienda Óscar Llamas Parra</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Perfil de <%=usuario.getNombre()+" "+usuario.getApellido1()+" "+usuario.getApellido2()%>  </h2>
		</div>
		
		<a href="<%= request.getContextPath() %>">Volver</a>
		<div>
			<form action="<%= request.getContextPath() %>/ServletEditarPerfil" method="post">
			<div>
				<label for="nombre">Nombre</label>
				<input type="text" name="nombre" value="<%=usuario.getNombre()%>">
			</div>
			<div>
				<label for="apellido1">Primer apellido</label>
				<input type="text" name="apellido1" value="<%= usuario.getApellido1() %>">
			</div>
			<div>
				<label for="apellido2">Segundo apellido</label>
				<input type="text" name="apellido2" value="<%= usuario.getApellido2() %>">
			</div>
			<div>
				<label for="email">Email</label>
				<input type="email" name="email" value="<%= usuario.getEmail() %>">
			</div>
			<div class=campo>
				<label for="direccion">Dirección</label>
				<input type="text" name="direccion" value="<%= usuario.getDireccion() %>">
			</div>
			<div class=campo>
				<label for="provincia">Provincia</label>
				<input type="text" name="provincia" value="<%= usuario.getProvincia() %>">
			</div>
			<div class=campo>
				<label for="localidad">Localidad</label>
				<input type="text" name="localidad" value="<%= usuario.getLocalidad() %>">
			</div>
			<div class=campo>
				<label for="telefono">Teléfono</label>
				<input type="text" name="telefono" value="<%= usuario.getTelefono() %>">
			</div>
			<div class=campo>
				<label for="dni">DNI</label>
				<input type="text" name="dni" value="<%= usuario.getDni()%>">
			</div>
			
			<input type="submit" name="editar" value="Editar perfil">
			</form>
			<p>
				<a href="<%= request.getContextPath()%>/pages/cambiarPassword.jsp">Cambiar contraseña</a>
			</p>
			
			
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>