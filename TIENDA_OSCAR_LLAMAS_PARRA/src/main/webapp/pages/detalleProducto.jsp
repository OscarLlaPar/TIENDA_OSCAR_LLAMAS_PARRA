<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="java.util.HashSet, curso.java.modelo.Producto, curso.java.modelo.Usuario, curso.java.modelo.Valoracion"%>
<%
Producto productoEnCurso = (Producto) request.getAttribute("productoEnCurso");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><%=productoEnCurso.getNombre()%> - Tienda Óscar Llamas
	Parra</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/estilos.css">
</head>
<body>
	<jsp:include page="../layout/header.jsp" />

	<div class="bg-dark py-3 text-center text-white">
		<h2>Detalles del producto</h2>
	</div>
	<div class="container px-4 px-lg-5 mt-5">
		<div class="card">
			<div class="card-body container">
				<div class="row">
					<div class="col-sm-8">
						<p class="h2"><%=productoEnCurso.getNombre()%></p>
						<p class="text-muted">
							<em>Categoría: <%=productoEnCurso.getCategoria().getNombre()%></em>
						</p>
						<div class="card">
							<div class="card-header">Descripción</div>
							<div class="card-body">
								<p><%=productoEnCurso.getDescripcion()%></p>
							</div>
						</div>
						<p class="h2">
							<strong>Precio: </strong><%=String.format("%.2f", productoEnCurso.getPrecioConImpuesto())%>
							&euro;
						</p>
						<p class="text-warning">
							<small>Impuesto del <%=productoEnCurso.getImpuesto()%>%
								incluido.
							</small>
						</p>
						<p class="text-muted">
							<small>Precio sin impuesto: <%=productoEnCurso.getPrecio()%> &euro;
							</small>
						</p>
						<p>
							<strong>Proveedor: </strong><%=productoEnCurso.getProveedor().getNombre()%>
						</p>
						<p>
							<strong>Cantidad en stock: </strong><%=productoEnCurso.getStock()%></p>
						<p>
							<strong>Disponible desde: </strong><%=productoEnCurso.getFechaAlta()%></p>
						<%
						Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioTienda");
						if (usuario == null || usuario.getRol().getId() == 1) {
						%>
						<form action="<%=request.getContextPath()%>/ServletAnadir"
							method="post">
							<label for="cantidad<%=productoEnCurso.getId()%>">Cantidad
								para comprar:</label> <br> <input type="number"
								name="cantidad<%=productoEnCurso.getId()%>" value="1" min="1">
							<button class="btn btn-primary my-2" type="submit" name="id"
								value="<%=productoEnCurso.getId()%>"><i class="bi bi-cart4"></i>  Añadir al carrito</button>
						</form>
					</div>
					<div class="col-sm-4">
						<div class="card">
						<div class="card-body">
						<img class="border border-dark"
								src="<%=request.getContextPath() + "/" + productoEnCurso.getImagen() %>" height="400" width="350" alt="..." />
								<%
									if(productoEnCurso.getAudio()!=null && !productoEnCurso.getAudio().equals("")){
										%>
										
											
											<p class="my-2"><i class="bi bi-music-note-beamed"></i> Audio de ejemplo:</p>
								<audio controls>
									<source src="<%=request.getContextPath() + "/" + productoEnCurso.getAudio() %>">
								</audio>
								
								
										<%
									}
								%>
								</div>
								</div>
					</div>
				</div>
			</div>
		</div>
		<div class="list-group">

			<%
			}
			HashSet<Valoracion> valoraciones = (HashSet) request.getAttribute("valoraciones");
			for (Valoracion v : valoraciones) {
			%>
			<p class="h3">Valoraciones</p>
			<div class="list-group-item">
				<div class="d-flow flow-row">
					<span class="h5"><%=v.getUsuario().getNombre() + " " + v.getUsuario().getApellido1() + " " + v.getUsuario().getApellido2()%>
					</span> <span class="h6 mx-3"><%=v.getValoracion()%>/10 </span>
				</div>

				<p class="mx-5"><%=v.getComentario()%>
				<p>
			</div>
			<%
			}
			%>
		</div>
	</div>
	<div class="h-25 w-100"></div>

	<jsp:include page="../layout/footer.jsp" />
</body>
</html>