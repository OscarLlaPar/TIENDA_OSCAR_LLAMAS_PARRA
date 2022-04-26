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
			<h2>Pedido</h2>
		</div>
		<a href="<%=request.getContextPath()%>/ServletPedido">Volver</a>
		<%
			Pedido p=(Pedido)request.getAttribute("pedidoEnCurso");
		%>
			<div class="d-flex flex-row">
				<p><%= p.getNumFactura() %> </p>
				<p><%= p.getFecha() %> </p>
				<p><%= p.getMetodoPago().getMetodoPago() %></p>
				<p><%= p.getEstado().name() %></p>
				<h3><%= p.getTotal() %> </h3>
			</div>
		<%
			HashMap<Integer, DetallePedido> detalles=p.getDetallesPedido();
	
			for (Map.Entry<Integer, DetallePedido> dp : detalles.entrySet()){
		%>
					<div>
						<ul>
							<li><strong>Producto: </strong><%= dp.getValue().getProducto().getNombre() %></li>
							<li><strong>Precio ud.:</strong><%= dp.getValue().getPrecioUnidad() %> &euro;</li>
							<li><strong>Unidades: </strong><%= dp.getValue().getUnidades() %></li>
							<li><strong>Total: <%= dp.getValue().getTotal() %> &euro;</strong></li>
						</ul>
					</div>
		<%
			}
		
		%>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>