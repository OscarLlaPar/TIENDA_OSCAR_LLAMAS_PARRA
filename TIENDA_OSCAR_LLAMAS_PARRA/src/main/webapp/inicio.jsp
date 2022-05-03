<%@ page
	import="java.util.LinkedHashMap, java.util.HashMap, java.util.Map, java.util.HashSet, curso.java.modelo.Producto, curso.java.modelo.Usuario, curso.java.modelo.Categoria"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf8">
<title>Inicio - Tienda Óscar Llamas Parra</title>

</head>
<body  class="min-vh-100 d-flex flex-column justify-content-between">
	<jsp:include page="layout/header.jsp" />
	
		<div class="bg-dark py-3 text-center text-white">
			<%
			String[] contenido=(String[]) request.getAttribute("contenido");
			Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioTienda");
			if (usuario != null) {
			%>
			<h4>
				¡Bienvenido
				<%=usuario.getNombre()%>!
			</h4>
			<%
			}
			%>
			<h2><%= contenido[0] %></h2>
		</div>
		<div class="container px-4 px-lg-5 mt-5">
			<div class="card mb-4">
				<div class="card-body">
					<form action="<%= request.getContextPath() %>/ServletBusqueda" method="post">
						<div class="input-group">
								<input type="search" id="form1" class="form-control" name="busqueda" placeholder="<%= contenido[1] %>" value="<%= request.getAttribute("busqueda")!=null?request.getAttribute("busqueda"):"" %>"/>
							<select name="orden">
								<option value="0"><%= contenido[2] %></option>
								<option value="1">Más baratos</option>
								<option value="2">Mejor valorados</option>
							</select>
							<select name="categoria">
								<option value="0"><%= contenido[3] %></option>
								<%
									HashSet<Categoria> categorias=(HashSet) request.getAttribute("categorias");
									for (Categoria categoria: categorias){
										%>
										<option value="<%= categoria.getId() %>"><%= categoria.getNombre() %> </option>
										<%
									}
								%>
							</select>
							<button type="submit" class="btn btn-primary">
								<%= contenido[4] %>
							</button>
						</div>
					</form>
					<a href="<%= request.getContextPath() %>?idioma=es">Español</a>
					<a href="<%= request.getContextPath() %>?idioma=en">English</a>
				</div>
			</div>
			<form action="ServletAnadir" method="post">
				<div
					class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
					<%
					LinkedHashMap<Integer, Producto> catalogo = (LinkedHashMap) request.getAttribute("catalogo");
					for (Map.Entry<Integer, Producto> producto : catalogo.entrySet()) {
					%>
					<div class="col mb-5">
						<div class="card h-100">
							<!-- Product image-->
							<img class="card-img-top"
								src="<%=request.getContextPath() + "/" + producto.getValue().getImagen() %>" height="300" alt="..." />
							<!-- Product details-->
							<div class="card-body p-4">
								<div class="text-center">
									<!-- Product name-->
									<h5 class="fw-bolder">
										<a class="nav-link text-dark"
											href="<%=request.getContextPath()%>/ServletProducto?id=<%=producto.getKey()%>"><%=producto.getValue().getNombre()%></a>
									</h5>
									<!-- Product price-->
									<%= String.format("%.2f",producto.getValue().getPrecioConImpuesto())%>
									&euro;
									</td>
								</div>
							</div>
							<!-- Product actions-->
							<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">

								<div class="text-center">
									<input class="w-25 m-2" type="number"
										name="cantidad<%=producto.getKey()%>" value="1" min="1">
									<button class="btn btn-outline-dark mt-auto" type="submit"
										name="id" value="<%=producto.getKey()%>"><%= contenido[5] %></button>
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
	
	<jsp:include page="layout/footer.jsp" />
	
</body>
</html>
