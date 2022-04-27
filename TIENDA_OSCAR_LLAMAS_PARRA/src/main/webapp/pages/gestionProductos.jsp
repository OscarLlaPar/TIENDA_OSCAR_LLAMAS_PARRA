<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.Producto, curso.java.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestión de productos - Tienda Óscar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Gestión de productos</h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
			<form action="<%=request.getContextPath()%>/ServletGestionProductos" method="post">
					<table>
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Descripción</th>
								<th>Categoría</th>
								<th>Stock</th>
								<th>Precio</th>
								<th>Impuesto</th>
								<th>Fecha alta</th>
								<th>Fecha baja</th>
							</tr>
						</thead>
						<tbody>
							<%
								Usuario usuarioActual=(Usuario) request.getSession().getAttribute("usuarioTienda");
								HashMap<Integer, Producto> productos = (HashMap) request.getAttribute("productos");	
								for (Map.Entry<Integer, Producto> producto : productos.entrySet()) {
										%>
											<tr>
												
												<td><input type="text" name="nombre<%= producto.getKey()%>" value="<%= producto.getValue().getNombre() %>"></td>
												<td><input type="text" name="descripcion<%= producto.getKey() %>" value="<%= producto.getValue().getDescripcion() %>"></td>
												<td><%= producto.getValue().getCategoria().getNombre() %></td>
												<td><input type="number" name="stock<%= producto.getKey() %>"  value="<%= producto.getValue().getStock() %>"></td>
												<td><input type="number" step="any" name="precio<%= producto.getKey() %>" value="<%= producto.getValue().getPrecio() %>"></td>
												<td><input type="number" step="any" name="impuesto<%= producto.getKey() %>" value="<%= producto.getValue().getImpuesto() %>"></td>
												<td><%= producto.getValue().getFechaAlta() %></td>
												<td><%= producto.getValue().getFechaBaja()!=null?producto.getValue().getFechaBaja():"-" %></td>
												<td><button type="submit" name="editar" value="<%= producto.getKey() %>">Editar</button></td>
												<%
													if(usuarioActual.getRol().getRol().equals("Administrador")&&producto.getValue().getFechaBaja()==null){
														%>
															<td><button type="submit" name="baja" value="<%= producto.getKey() %>">Dar de baja</button></td>
														<%
													}
												%>
												
											</tr>
										<%
									}
								%>
						</tbody>
					</table>
			</form>
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>