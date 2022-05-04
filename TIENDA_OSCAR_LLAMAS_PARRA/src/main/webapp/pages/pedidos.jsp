<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.LinkedHashSet, curso.java.modelo.Pedido, curso.java.modelo.DetallePedido" %>
<!DOCTYPE html>
<html>
<head>
<title>Mis pedidos - Tienda Óscar Llamas Parra</title>
</head>
<body class="min-vh-100"> 
	<jsp:include page="../layout/header.jsp" />
	
		<div class="bg-dark py-3 text-center text-white">
			<h2>Mis pedidos</h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
		<a class="btn btn-secondary my-2" href="<%=request.getContextPath()%>"><i class="bi bi-arrow-left"></i> Volver al catálogo</a>
		<div class="card p-5">
			<table class="table">
				<thead>
					<tr>
						
						<th>Fecha</th>
						<th>Método de pago</th>
						<th>Estado</th>
						<th>Núm. de factura</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>
					<%
						LinkedHashSet<Pedido> pedidos = (LinkedHashSet)request.getAttribute("pedidos");
						for(Pedido p:pedidos){
							%>
							<tr>
								<td><%= p.getFecha() %> </td>
								<td><%= p.getMetodoPago().getMetodoPago() %></td>
								<td><%= p.getEstado().getEstado() %></td>
								<td><%= p.getNumFactura()!=null?p.getNumFactura():"-" %> </td>
								<td><%= String.format("%.2f", p.getTotal()) %> &euro;</td>
								<td><a class="btn btn-primary" href="<%=request.getContextPath()%>/ServletDetallePedido?id=<%= p.getId()%>">Ver detalle</a></td>
								<% 
									if(p.getEstado().name().equals("PE")){
								%>
								<td><a class="btn btn-danger" href="<%=request.getContextPath()%>/ServletCancelarPedido?id=<%= p.getId()%>" onclick="return confirm('¿Estás seguro de que deseas cancelar el pedido?')">Cancelar pedido</a></td>
								<% 
									}
									if(p.getEstado().name().equals("E")){
								%>
								<td><a class="btn btn-primary" target="__blank" href="<%=request.getContextPath()%>/ServletFactura?id=<%= p.getId()%>"><i class="bi bi-receipt"></i> Ver factura</a></td>		
								<%
									}
								%>
								
							</tr>
							<%
						}
					%>
				</tbody>
			</table>
		</div>
		</div>
	
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>