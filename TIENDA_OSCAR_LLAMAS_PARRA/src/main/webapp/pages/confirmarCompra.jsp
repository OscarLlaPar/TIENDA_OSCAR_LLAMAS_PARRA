<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.DetallePedido" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Confirmar compra - Tienda Óscar Llamas Parra</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Confirmar compra</h2>
		</div>
		
		<a href="<%=request.getContextPath()%>/pages/carrito.jsp">Volver</a>
		<table>
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
		<p id="total">Total: <%=String.format("%.2f", request.getSession().getAttribute("totalCarrito"))%> &euro;</p>
		<form action="<%=request.getContextPath()%>/ServletPedido" method="post">
			<div>
				<p>Método de pago</p>
				<input id="mTarjeta" type="radio" name="metodoPago" value="1" checked>
				<label for="mTarjeta">Tarjeta</label>
				<br>
				<input id="mPaypal" type="radio" name="metodoPago" value="2">
				<label for="mPaypal">Paypal</label>
				<br>
				<input type="submit" name="comprar" value="Confirmar pedido">
			</div>
		</form>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>