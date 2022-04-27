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
								<td><a href="<%=request.getContextPath()%>/ServletDetallePedido?id=<%= p.getId()%>">Ver detalle</a></td>
								<% 
									if(p.getEstado().name().equals("PE")){
								%>
								<td><a href="<%=request.getContextPath()%>/ServletCancelarPedido?id=<%= p.getId()%>">Cancelar pedido</a></td>
								<% 
									}
									if(p.getEstado().name().equals("E")){
								%>
								<td><a href="<%=request.getContextPath()%>/ServletFactura?id=<%= p.getId()%>">Ver factura</a></td>		
								<%
									}
								%>
								
							</tr>
							<%
						}
					%>
				</tbody>
			</table>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>