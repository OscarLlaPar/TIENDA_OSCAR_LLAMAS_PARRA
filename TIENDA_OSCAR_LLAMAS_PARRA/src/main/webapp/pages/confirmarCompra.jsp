<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.HashMap, java.util.Map, curso.java.modelo.DetallePedido, curso.java.modelo.Descuento"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Confirmar compra - Tienda Óscar Llamas Parra</title>
</head>
<body class="min-vh-100">
	<jsp:include page="../layout/header.jsp" />

	<div class="bg-dark py-3 text-center text-white">
		<h2>Confirmar compra</h2>
	</div>
	<div class="container px-4 px-lg-5 mt-5 py-5">
		<a class="btn btn-secondary"
			href="<%=request.getContextPath()%>/pages/carrito.jsp"><i
			class="bi bi-arrow-left"></i> Volver</a>
		<table class="table">
			<thead>
				<tr>
					<th>Producto</th>
					<th>Precio ud.</th>
					<th>Impuesto</th>
					<th>Unidades</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<%
				Descuento d=(Descuento) request.getAttribute("descuento");
				
				HashMap<Integer, DetallePedido> carrito = (HashMap) request.getSession().getAttribute("carrito");

				for (Map.Entry<Integer, DetallePedido> dp : carrito.entrySet()) {
				%>
				<tr>
					<td><%=dp.getValue().getProducto().getNombre()%></td>
					<td><%=dp.getValue().getPrecioUnidad()%> &euro;</td>
					<td><%=dp.getValue().getImpuesto()%>%</td>
					<td><%=dp.getValue().getUnidades()%></td>
					<td><%=String.format("%.2f", dp.getValue().getTotal())%>
						&euro;</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
		<p class="h2" id="total">
			Total:
			<%=String.format("%.2f", request.getSession().getAttribute("totalCarrito"))%>
			&euro;
		</p>
		
			<div class="card">
				<div class="card-body container">
				<% if(request.getAttribute("mensajeDescuento")!=null && !request.getAttribute("mensajeDescuento").equals("")){ %>
				<div class="alert alert-<%= d!=null?"success":"danger" %> alert-dismissible fade show" role="alert">	
						 	<span><%= request.getAttribute("mensajeDescuento") %></span>
						 	 <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
						</div>
				<% } %>
					<div class="row">
						<div class="col-sm">
						<form action="<%=request.getContextPath()%>/ServletPedido"
			method="post">
							<p class="h3">Método de pago</p>
							<div class="my-3">
								<input id="mTarjeta" type="radio" name="metodoPago" value="1"
									checked> <label for="mTarjeta">Tarjeta</label> <input
									id="mPaypal" type="radio" name="metodoPago" value="2">
								<label for="mPaypal">Paypal</label>
								<input type="hidden" name="idDescuento" value="<%= d!=null?d.getId():"" %>">
							</div>
							<input class="btn btn-primary" type="submit" name="comprar"
								value="Confirmar pedido">
						</form>
						</div>
						<div class="col-sm">
							<% if(d==null){ %>
							<a id="mostrarDescuento" class="link-primary" href="#">Tengo un código de descuento</a>
							<form id="formDescuento" class="d-none" action="<%= request.getContextPath() %>/ServletPedido" method="get">
								<input class="form-control w-50" type="text" name="codigo" placeholder="Código de descuento...">
								<button type="submit" class="btn btn-primary my-2">Aceptar</button>
							</form>
							<% }
								else{
								
								%>
								<p class="text-success"> Descuento del <%= d.getDescuento() %>%</p>
								<%} %>
						</div>
					</div>
				</div>
			</div>
		
	</div>

	<jsp:include page="../layout/footer.jsp" />
	<script src="<%=request.getContextPath()%>/js/confirmarCompra.js"></script>
</body>
</html>