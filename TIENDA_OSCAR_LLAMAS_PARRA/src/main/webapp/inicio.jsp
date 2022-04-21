<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.Producto, curso.java.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf8">
	<title>Inicio - Tienda Óscar Llamas Parra</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<main>
		<div>
			<%
			Usuario usuario=(Usuario)request.getSession().getAttribute("usuarioTienda");	
			if(usuario!=null){
					
					%>
						<h2>¡Bienvenido <%= usuario.getNombre() %>!</h2>
						<a href="<%= request.getContextPath()%>/ServletLogin">Cerrar sesión</a>
					<%
				}
			%>
			<h2>Catálogo</h2>
			<form action="ServletAnadir" method="post">
				<table>
					<thead>
						<tr>
							<th>Nombre</th>
							<th>Descripción</th>
							<th>Precio</th>
							<th>Stock</th>
							<%
							if(usuario==null || usuario.getRol().getId()==1){
							%>
								<th>Cantidad añadir</th>
								<th>Acción</th>
							<%
							}
							%>
						</tr>
					</thead>
					<tbody>
						 <%
	                            HashMap<Integer, Producto> catalogo = (HashMap) request.getAttribute("catalogo");
	
	                            for (Map.Entry<Integer, Producto> producto : catalogo.entrySet()) {
	                        %>
	                        <tr id="">
	                            <td><a href="<%=request.getContextPath()%>/ServletProducto?id=<%= producto.getKey()%>"><%= producto.getValue().getNombre()%></a></td>
	                            <td><%= producto.getValue().getDescripcion()%></td>
	                            <td><%= producto.getValue().getPrecio()%> &euro;</td>
	                            <td><%= producto.getValue().getStock()%></td>
	                            <%
								if(usuario==null || usuario.getRol().getId()==1){
								%>
		                            <td><input type="number" name="cantidad<%= producto.getKey()%>" value="1" min="1"></td>
		                            <td><button type="submit" name="id" value="<%= producto.getKey()%>">Añadir al carrito</button></td>
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
	<jsp:include page="layout/footer.jsp" />
</body>
</html>
