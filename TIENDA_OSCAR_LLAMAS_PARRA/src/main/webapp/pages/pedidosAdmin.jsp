<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashSet, curso.java.modelo.Usuario, curso.java.modelo.Pedido, curso.java.modelo.DetallePedido" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cancelaci�n de pedidos - Tienda �scar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Pedidos</h2>
		</div>
		<table>
			<thead>
				<tr>
					<th>Usuario</th>
					<th>Fecha</th>
					<th>M�todo de pago</th>
					<th>Estado</th>
					<th>N�mero de factura</th>
					<th>Total</th>
				</tr>
			</thead>
			<tbody>
				<%
				HashSet<Pedido> pedidos = (HashSet)request.getAttribute("pedidos");
				for(Pedido p:pedidos){
					Usuario u=p.getUsuario();
					%>
					<tr>
						<td><%= u.getNombre()+" "+u.getApellido1()+" "+u.getApellido2() %></td>
						<td><%= p.getFecha() %></td>
						<td><%= p.getMetodoPago().getMetodoPago() %></td>
						<td><%= p.getEstado().name() %></td>
						<td><%= p.getNumFactura() %></td>
						<td><%= p.getTotal() %></td>
						<td><a href="<%=request.getContextPath()%>/ServletCancelarPedido?idAdmin=<%= p.getId()%>">Confirmar cancelaci�n</a></td>
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