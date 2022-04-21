<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.Producto" %>
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
		<h2>Confirmar compra</h2>
		<a href="<%=request.getContextPath()%>/pages/carrito.jsp">Volver</a>
		<table>
			<tbody>
				<%
	                   HashMap<Integer, Producto> carrito = (HashMap) request.getSession().getAttribute("carrito");
	
	                   for (Map.Entry<Integer, Producto> producto : carrito.entrySet()) {
	            %>
	            	<tr>
	            		<td><%= producto.getValue().getNombre()%></td>
	            		<td><%= producto.getValue().getStock()%></td>
	            		<td><%= String.format("%.2f", producto.getValue().getPrecio())%> &euro;</td>
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
				<input id="mTarjeta" type="radio" name="metodoPago" value="1" default>
				<label for="mTarjeta">Tarjeta</label>
				<br>
				<input id="mPaypal" type="radio" name="metodoPago" value="2">
				<label for="mPaypal">Paypal</label>
				<br>
				<input type="submit" value="Confirmar pedido">
			</div>
		</form>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>