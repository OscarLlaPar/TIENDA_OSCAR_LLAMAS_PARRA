<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="curso.java.modelo.Producto, curso.java.modelo.Usuario" %>
<%
	Producto productoEnCurso=(Producto)request.getAttribute("productoEnCurso");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= productoEnCurso.getNombre() %> - Tienda Óscar Llamas Parra</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2><%= productoEnCurso.getNombre() %></h2>
		</div>
		<a href="<%= request.getContextPath() %>">Volver</a>
		<p><%= productoEnCurso.getDescripcion() %></p>
		<p><strong>Precio: </strong><%= productoEnCurso.getPrecio() %> &euro;</p>
		<p><strong>Cantidad en stock: </strong><%= productoEnCurso.getStock() %></p>
		<p><strong>Disponible desde: </strong><%= productoEnCurso.getFechaAlta() %></p>
		<p><strong>Impuesto: </strong><%= productoEnCurso.getImpuesto() %></p>
		<%
		Usuario usuario=(Usuario)request.getSession().getAttribute("usuarioTienda");
		if(usuario==null || usuario.getRol().getId()==1){
		%>
			<form action="<%= request.getContextPath() %>/ServletAnadir" method="post">
				<label for="cantidad<%= productoEnCurso.getId()%>">Cantidad para comprar:</label>
				<br>
				<input type="number" name="cantidad<%= productoEnCurso.getId()%>" value="1" min="1">
				<br>
				<button type="submit" name="id" value="<%= productoEnCurso.getId()%>">Añadir al carrito</button>
			</form>
		<%
		}
		%>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>