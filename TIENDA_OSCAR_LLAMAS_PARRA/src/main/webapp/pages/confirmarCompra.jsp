<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.DetallePedido" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Confirmar compra - Tienda Óscar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Confirmar compra</h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
			<a class="btn btn-secondary" href="<%=request.getContextPath()%>/pages/carrito.jsp">Volver</a>
			<table class="table">
				<thead>
					<tr>
						<th>Producto</th>
						<th>Unidades</th>
						<th>Total</th>
					</tr>
				</thead>
				<tbody>
					<%
		                   HashMap<Integer, DetallePedido> carrito = (HashMap) request.getSession().getAttribute("carrito");
		
		                   for (Map.Entry<Integer, DetallePedido> dp : carrito.entrySet()) {
		            %>
		            	<tr>
		            		<td><%= dp.getValue().getProducto().getNombre() %></td>
		            		<td><%= dp.getValue().getUnidades()%></td>
		            		<td><%= String.format("%.2f", dp.getValue().getTotal() )%> &euro;</td>
		            	</tr>
	                <%
		                    }
		            %>
				</tbody>
			</table>
			<p class="h2" id="total">Total: <%=String.format("%.2f", request.getSession().getAttribute("totalCarrito"))%> &euro;</p>
			<form action="<%=request.getContextPath()%>/ServletPedido" method="post">
				<div >
					<p class="h3">Método de pago</p>
					<div class="my-3">
						<input id="mTarjeta" type="radio" name="metodoPago" value="1" checked>
						<label for="mTarjeta">Tarjeta</label>
						<input id="mPaypal" type="radio" name="metodoPago" value="2">
						<label for="mPaypal">Paypal</label>
					</div>
					<input class="btn btn-primary" type="submit" name="comprar" value="Confirmar pedido">
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>