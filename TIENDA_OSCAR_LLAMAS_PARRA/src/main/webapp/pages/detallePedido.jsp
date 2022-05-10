<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.Pedido, curso.java.modelo.DetallePedido" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Pedido - Tienda Óscar Llamas Parra</title>
</head>
<body  class="d-flex flex-column min-vh-100">
	<jsp:include page="../layout/header.jsp" />
	
		<div class="bg-dark py-3 text-center text-white">
			<h2>Detalles del pedido</h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
		<a class="btn btn-secondary my-2" href="<%=request.getContextPath()%>/ServletPedido"><i class="bi bi-arrow-left"></i> Volver a mis pedidos</a>
		
		
		
		<%
			Pedido p=(Pedido)request.getAttribute("pedidoEnCurso");
		%>
			<div class=" card p-3 d-flex flex-row justify-content-between">
				<p><strong>Núm de factura:</strong> <%= p.getNumFactura()!=null?p.getNumFactura():"-" %> </p>
				<p><strong>Fecha:</strong>  <%= p.getFecha() %> </p>
				<p><strong>Método de pago:</strong>  <%= p.getMetodoPago().getMetodoPago() %></p>
				<p><strong>Estado:</strong> <%= p.getEstado().getEstado() %></p>
				<p><strong>Descuento: </strong> <%= p.getDescuento()!=null?p.getDescuento().getCodigo()+" - "+p.getDescuento().getDescuento()+"%":"-" %> </p>
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
						<a class="h4 link-primary text-decoration-none" href="<%=request.getContextPath()%>/ServletProducto?id=<%=dp.getValue().getProducto().getId() %>"> <%= dp.getValue().getProducto().getNombre() %> </a>
						<div class="d-flex justify-content-between">
							<p class="h6"><%= dp.getValue().getUnidades() %> unidad(es)</p>
							<p class="h6"><%= dp.getValue().getPrecioUnidad() %> &euro;/ud. </p>
							<p class="h6"><%= dp.getValue().getEstado().getEstado() %></p>
							<p class="h5">Total: <%=String.format("%.2f", dp.getValue().getTotal())  %> &euro; </p>
						</div>
						<% if(dp.getValue().getEstado().name().equals("E")){
							%>
							<a class="btn btn-primary" href="<%=request.getContextPath()%>/ServletValorar?id=<%=dp.getValue().getProducto().getId() %>"><i class="bi bi-sticky"></i> Valorar producto</a>
							<%
						}
						if(dp.getValue().getEstado().name().equals("PE")){
							%>
							<a class="btn btn-danger" href="<%=request.getContextPath()%>/ServletCancelarDetalle?id=<%=dp.getValue().getId() %>">Cancelar detalle</a>
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
	
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>