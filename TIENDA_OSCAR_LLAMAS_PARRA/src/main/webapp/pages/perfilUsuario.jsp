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
			<p><strong>Email: </strong><%= usuario.getEmail() %></p>
			<p><strong>Dirección: </strong><%= usuario.getDireccion() %></p>
			<p><strong>Provincia: </strong><%= usuario.getProvincia() %></p>
			<p><strong>Localidad: </strong><%= usuario.getLocalidad() %></p>
			<p><strong>Teléfono: </strong><%= usuario.getTelefono() %></p>
			<p><strong>DNI: </strong><%= usuario.getDni() %></p>
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>