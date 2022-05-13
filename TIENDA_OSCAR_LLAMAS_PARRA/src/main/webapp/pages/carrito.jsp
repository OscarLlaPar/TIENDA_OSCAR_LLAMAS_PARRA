<%@ page
	import="java.util.HashMap, java.util.Map, curso.java.modelo.DetallePedido, curso.java.modelo.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Carrito - Tienda Óscar Llamas Parra</title>
</head>
<body  class="min-vh-100">
	<jsp:include page="../layout/header.jsp" />
	
		<div class="bg-dark py-3 text-center text-white">
			<h2>Carrito</h2>
		</div>
		
		<div class="container px-4 px-lg-5 mt-5">
			<div id="contenedorMensaje">
		
			</div>
			
			<a class="btn btn-secondary my-2" href="<%=request.getContextPath()%>"> <i class="bi bi-arrow-left"></i>Seguir comprando</a>
			<form action="<%=request.getContextPath()%>/ServletCarrito"
				method="post">
				<div class="card p-3">
					<table class="table">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Precio ud.</th>
								<th>Impuesto</th>
								<th>Cantidad</th>
								<th>Precio total</th>
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
								<td><%=dp.getValue().getProducto().getNombre()%></td>
								<td><%=dp.getValue().getPrecioUnidad() %> &euro;</td>
								<td><%=dp.getValue().getImpuesto() %>%</td>
								<td><%=dp.getValue().getUnidades()%></td>
								<td><%=String.format("%.2f", dp.getValue().getTotal())%>
									&euro;</td>
								<td><input type="number" name="cantidad<%=dp.getKey()%>"
									value="1" min="1"></td>
								<td><button class="btn btn-danger" type="submit" name="idEliminar"
										value="<%=dp.getKey()%>">Eliminar del carrito</button></td>
							</tr>
							<%
							}
							%>
						</tbody>
					</table>
				</div>
				
				<%
				if (request.getSession().getAttribute("totalCarrito") != null) {
				%>
				<p class="h2" id="total">
					Total:
					<%=String.format("%.2f", request.getSession().getAttribute("totalCarrito"))%>
					&euro;
				</p>
				<%
				}
				%>

				<%
				Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioTienda");
				if (usuario != null && usuario.getRol().getId() == 1 && carrito.size()!=0) {
				%>
				<a class="btn btn-primary" href="<%=request.getContextPath()%>/pages/confirmarCompra.jsp"><i class="bi bi-cart-check"></i> Efectuar
					compra</a>
				<%
				} else if (usuario == null) {
				%>
				<p>Regístrate o inicia sesión para poder efectuar la compra.</p>
				<%
				}
				%>
				<input type="hidden" id="idUsuario" name="idUsuario" value="<%= usuario!=null?usuario.getId():0 %>">
			</form>

		</div>

	<script src="<%=request.getContextPath()%>/js/comprobacionCarrito.js"></script>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>