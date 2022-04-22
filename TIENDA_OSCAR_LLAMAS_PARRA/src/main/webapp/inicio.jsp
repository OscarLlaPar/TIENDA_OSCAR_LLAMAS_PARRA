<%@ page import="java.util.HashMap, java.util.Map, curso.java.modelo.Producto, curso.java.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf8">
	<title>Inicio - Tienda Óscar Llamas Parra</title>
	
</head>
<body>
	<jsp:include page="layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
				<%
				Usuario usuario=(Usuario)request.getSession().getAttribute("usuarioTienda");	
				if(usuario!=null){
						
						%>
							<h4>¡Bienvenido <%= usuario.getNombre() %>!</h4>
						<%
					}
				%>
				<h2>Catálogo</h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
			<form action="ServletAnadir" method="post">
				<div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
					<%
					HashMap<Integer, Producto> catalogo = (HashMap) request.getAttribute("catalogo");	
					for (Map.Entry<Integer, Producto> producto : catalogo.entrySet()) {
							%>
							<div class="col mb-5">
		                        <div class="card h-100">
		                            <!-- Product image-->
		                            <img class="card-img-top" src="https://dummyimage.com/450x300/dee2e6/6c757d.jpg" alt="..." />
		                            <!-- Product details-->
		                            <div class="card-body p-4">
		                                <div class="text-center">
		                                    <!-- Product name-->
		                                    <h5 class="fw-bolder"><a href="<%=request.getContextPath()%>/ServletProducto?id=<%= producto.getKey()%>"><%= producto.getValue().getNombre()%></a></h5>
		                                    <!-- Product price-->
		                                    <%= producto.getValue().getPrecio()%> &euro;</td>
		                                </div>
		                            </div>
		                            <!-- Product actions-->
		                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
		                            	
		                                <div class="text-center">
		                                	<input class="w-25 m-2" type="number" name="cantidad<%= producto.getKey()%>" value="1" min="1">
		                               		<button class="btn btn-outline-dark mt-auto" type="submit" name="id" value="<%= producto.getKey()%>">Añadir al carrito</button>
	                               		</div>
		                            </div>
		                        </div>
		                    </div>
							<%
						}
					%>
				</div>
			</form>
		</div>
	</main>
	<jsp:include page="layout/footer.jsp" />
</body>
</html>
