<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.Producto" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf8">
	<title>Tienda �scar Llamas Parra - Inicio</title>
	<link rel="stylesheet" href="<%= request.getContextPath() %>/css/estilos.css">
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<a>Iniciar sesi�n</a>
	<a>Ver carrito</a>
	<div>
		<h2>Cat�logo</h2>
		<form>
			<table>
				<thead>
					<tr>
						<th>Nombre</th>
						<th>Descripci�n</th>
						<th>Precio</th>
						<th>Stock</th>
						<th>Cantidad a�adir</th>
						<th>Acci�n</th>
					</tr>
				</thead>
				<tbody>
					 <%
                            HashMap<Integer, Producto> catalogo = (HashMap) request.getAttribute("catalogo");

                            for (Map.Entry<Integer, Producto> producto : catalogo.entrySet()) {
                        %>
                        <tr id="">
                            <td><%= producto.getValue().getNombre()%></td>
                            <td><%= producto.getValue().getDescripcion()%></td>
                            <td><%= producto.getValue().getPrecio()%></td>
                            <td><%= producto.getValue().getStock()%></td>
                            <td><input type="number" name="cantidad<%= producto.getKey()%>" value="1" min="1"></td>
                            <td><button type="submit" name="id" value="<%= producto.getKey()%>">A�adir al carro</button></td>
                        </tr>
                        <%
                            }
                        %>	
				</tbody>
			</table>
		</form>
	</div>
	<jsp:include page="layout/footer.jsp" />
</body>
</html>
