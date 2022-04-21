<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.Producto" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito - Tienda Óscar Llamas Parra</title>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>		
		<h2>Carrito</h2>
		
	 	<a href="<%=request.getContextPath()%>">Volver</a>
		<form action="<%=request.getContextPath()%>/ServletCarrito" method="post">
			<table>
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Descripcion</th>
						<th>Precio</th>
						<th>Cantidad</th>
						<th>Cantidad quitar</th>
						<th>Acción</th>
					</tr>
				</thead>
				<tbody id="contenidoCarrito">
					<%
	                    HashMap<Integer, Producto> carrito = (HashMap) request.getSession().getAttribute("carrito");
	
	                    for (Map.Entry<Integer, Producto> producto : carrito.entrySet()) {
	                %>
	                <tr>
	                    <td><%= producto.getValue().getNombre()%></td>
	                    <td><%= producto.getValue().getDescripcion()%></td>
	                    <td><%= String.format("%.2f", producto.getValue().getPrecio())%> &euro;</td>
	                    <td><%= producto.getValue().getStock()%></td>
	                    <td><input type="number" name="cantidad<%= producto.getKey()%>" value="1" min="1"></td>
	                    <td><button type="submit" name="idEliminar" value="<%=producto.getKey()%>">Eliminar del carro</button></td>
	                </tr>
	                <%
	                    }
	                %>	
				</tbody>
			</table>
			<%
				if(request.getSession().getAttribute("totalCarrito")!=null){
					%>
					<p id="total">Total: <%=String.format("%.2f", request.getSession().getAttribute("totalCarrito"))%> &euro;</p>
					<%
				}
			%>
			
			<%
				if(request.getSession().getAttribute("usuarioTienda")!=null){
					%>
					<a href="<%=request.getContextPath()%>/pages/confirmarCompra.jsp">Efectuar compra</a>
					<%
				}
				else{
					%>
					<p>Regístrate o inicia sesión para poder efectuar la compra.</p>
					<%
				}
			%>
		</form>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>