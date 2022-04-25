<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashSet, curso.java.modelo.Pedido, curso.java.modelo.DetallePedido" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mis pedidos - Tienda Óscar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Mis pedidos</h2>
		</div>
		<form>
			<table>
				<thead>
					<tr>
						<th></th>
						<th>Factura</th>
						<th>Fecha</th>
						<th>Método de pago</th>
						<th>Estado</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>
					<%
						HashSet<Pedido> pedidos = (HashSet)request.getAttribute("pedidos");
						for(Pedido p:pedidos){
							%>
							<tr>
								<td><%= p.getId() %> </td>
								<td><%= p.getNumFactura() %></td>
								<td><%= p.getFecha() %> </td>
								<td><%= p.getMetodoPago().getMetodoPago() %></td>
								<td><%= p.getEstado().name() %></td>
								<td><%= p.getTotal() %> </td>
								<td><button type="submit">Ver detalle</button></td>
								<td><button type="submit">Cancelar pedido</button></td>
							</tr>
							<%
						}
					%>
				</tbody>
			</table>
		</form>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>