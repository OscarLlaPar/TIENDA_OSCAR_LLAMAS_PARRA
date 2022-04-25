<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.DetallePedido, curso.java.modelo.Usuario" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito - Tienda Óscar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>	
		<div class="bg-dark py-3 text-center text-white">
			<h2>Carrito</h2>
		</div>	
		
		
	 	<a href="<%=request.getContextPath()%>">Volver</a>
		<form action="<%=request.getContextPath()%>/ServletCarrito" method="post">
			<table>
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Precio</th>
						<th>Cantidad</th>
						<th>Cantidad quitar</th>
						<th>Acción</th>
					</tr>
				</thead>
				<tbody id="contenidoCarrito">
					<%
	                    HashMap<Integer, DetallePedido> carrito = (HashMap) request.getSession().getAttribute("carrito");
	
	                    for (Map.Entry<Integer, DetallePedido> dp : carrito.entrySet()) {
	                %>
	                <tr>
	                    <td><%= dp.getValue().getProducto().getNombre() %></td>
	                    <td><%= String.format("%.2f", dp.getValue().getTotal())%> &euro;</td>
	                    <td><%= dp.getValue().getUnidades() %></td>
	                    <td><input type="number" name="cantidad<%= dp.getKey()%>" value="1" min="1"></td>
	                    <td><button type="submit" name="idEliminar" value="<%=dp.getKey()%>">Eliminar del carro</button></td>
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
				Usuario usuario=(Usuario)request.getSession().getAttribute("usuarioTienda");
				if(usuario!=null && usuario.getRol().getId()==1){
					%>
					<a href="<%=request.getContextPath()%>/pages/confirmarCompra.jsp">Efectuar compra</a>
					<%
				}
				else if(usuario==null){
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