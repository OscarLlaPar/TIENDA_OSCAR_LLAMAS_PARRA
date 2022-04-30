<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.Pedido, curso.java.modelo.DetallePedido" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedido - Tienda Óscar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Detalles del pedido</h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
		<a class="btn btn-secondary my-2" href="<%=request.getContextPath()%>/ServletPedido">Volver a mis pedidos</a>
		
		
		
		<%
			Pedido p=(Pedido)request.getAttribute("pedidoEnCurso");
		%>
			<div class=" card p-3 d-flex flex-row justify-content-between">
				<p><strong>Núm de factura:</strong> <%= p.getNumFactura()!=null?p.getNumFactura():"-" %> </p>
				<p><strong>Fecha:</strong>  <%= p.getFecha() %> </p>
				<p><strong>Método de pago:</strong>  <%= p.getMetodoPago().getMetodoPago() %></p>
				<p><strong>Estado:</strong> <%= p.getEstado().name() %></p>
				<p class="h4">Total: <%= String.format("%.2f", p.getTotal()) %> &euro; </p>
			</div>
			<p class="h3 my-3">Productos</p>
			<div class="container">
				<div class="list-group">
		<%
			HashMap<Integer, DetallePedido> detalles=p.getDetallesPedido();
	
			for (Map.Entry<Integer, DetallePedido> dp : detalles.entrySet()){
		%>
					<div class="list-group-item">
						<p class="h4"> <%= dp.getValue().getProducto().getNombre() %> </p>
						<div class="d-flex justify-content-between">
							<p class="h6"><%= dp.getValue().getUnidades() %> unidad(es)</p>
							<p class="h6"><%= dp.getValue().getPrecioUnidad() %> &euro;/ud. </p>
							<p class="h5">Total: <%=String.format("%.2f", dp.getValue().getTotal())  %> &euro; </p>
						</div>
						<% if(p.getEstado().name().equals("E")){
							%>
							<a class="btn btn-primary" href="<%=request.getContextPath()%>/ServletValorar?id=<%=dp.getValue().getProducto().getId() %>">Valorar producto</a>
							<%
						}
						%>
					</div>
		<%
			}
		
		%>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>