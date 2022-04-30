<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashSet, curso.java.modelo.Producto, curso.java.modelo.Usuario, curso.java.modelo.Valoracion" %>
<%
	Producto productoEnCurso=(Producto)request.getAttribute("productoEnCurso");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%= productoEnCurso.getNombre() %> - Tienda �scar Llamas Parra</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2><%= productoEnCurso.getNombre() %></h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
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
				<button class="btn btn-primary" type="submit" name="id" value="<%= productoEnCurso.getId()%>">A�adir al carrito</button>
			</form>
			<div class="list-group">
		<%
		}
		HashSet<Valoracion> valoraciones = (HashSet) request.getAttribute("valoraciones");
		for(Valoracion v: valoraciones){
			%>
				<div class="list-group-item">
					<div class="d-flow flow-row">
						<span class="h5"><%= v.getUsuario().getNombre() + " " + v.getUsuario().getApellido1() + " " + v.getUsuario().getApellido2() %> </span>
						<span class="h6 mx-3"><%= v.getValoracion() %>/10 </span> 
					</div>
					
					<p class="mx-5"><%= v.getComentario() %> <p>
				</div>
			<%
		}
		%>
			</div>
	</div>		
	<div class="h-25 w-100">
	</div>		
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>