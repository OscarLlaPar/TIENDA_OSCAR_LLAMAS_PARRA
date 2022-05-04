<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="curso.java.modelo.Usuario, java.util.ArrayList" %>
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
<body  class="min-vh-100 d-flex flex-column justify-content-between">
	<jsp:include page="../layout/header.jsp" />
	
		<div class="bg-dark py-3 text-center text-white">
			<h2>Perfil de <%=usuario.getNombre()+" "+usuario.getApellido1()+" "+usuario.getApellido2()%>  </h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
		<a class="btn btn-secondary my-3" href="<%= request.getContextPath() %>"><i class="bi bi-arrow-left"></i>Volver al inicio</a>
		<div class=" card container p-3">
			<form action="<%= request.getContextPath() %>/ServletEditarPerfil" method="post">
			<div class="row py-2">
				<div class="col-sm">
					<label for="email">Email</label>
					<input class="form-control" type="email" name="email" value="<%= usuario.getEmail() %>">
				</div>
				<div class="col-sm">
					<label for="nombre">Nombre</label>
					<input class="form-control" type="text" name="nombre" value="<%=usuario.getNombre()%>">
				</div>
			</div>
			<div class="row py-2">
				<div class="col-sm">
					<label for="apellido1">Primer apellido</label>
					<input class="form-control" type="text" name="apellido1" value="<%= usuario.getApellido1() %>">
				</div>
				<div class="col-sm">
					<label for="apellido2">Segundo apellido</label>
					<input class="form-control" type="text" name="apellido2" value="<%= usuario.getApellido2() %>">
				</div>
			</div>
			<div class="row py-2">
				<div class="col-sm">
					<label for="direccion">Dirección</label>
					<input class="form-control" type="text" name="direccion" value="<%= usuario.getDireccion() %>">
				</div>
			</div>
			<div class="row py-2">
				<div class="col-sm">
					<label for="provincia">Provincia</label>
					<select class="form-select" name="provincia">
						<% 
						ArrayList<String> provincias =(ArrayList) request.getAttribute("provincias");
						for(String provincia: provincias){
							%>
							<option value="<%= provincia %>" <%= usuario.getProvincia().equals(provincia)?"selected":"" %> ><%= provincia %></option>
							<%
						}
								%>
						
						
						</select>
				</div>
				<div  class="col-sm">
					<label for="localidad">Localidad</label>
					<input class="form-control" type="text" name="localidad" value="<%= usuario.getLocalidad() %>">
				</div>
			</div>
			<div class="row py-2">
				<div class="col-sm">
					<label for="telefono">Teléfono</label>
					<input class="form-control" type="text" name="telefono" value="<%= usuario.getTelefono() %>">
				</div>
				<div class="col-sm">
					<label for="dni">DNI</label>
					<input class="form-control" type="text" name="dni" value="<%= usuario.getDni()%>">
				</div>
			</div>
			<div class="form-group py-3">
				<input type="hidden" name="id" value="<%= usuario.getId() %>">
				<input class="btn btn-primary" type="submit" name="editar" value="Editar perfil">
				<a class="btn btn-secondary" href="<%= request.getContextPath()%>/pages/cambiarPassword.jsp"><i class="bi bi-key"></i> Cambiar contraseña</a>
			</div>
			
			</form>
			</div>
		</div>
		<div class="h-25 w-100">
		</div>
	
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>