<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.HashSet, curso.java.modelo.OpcionMenu, java.util.Iterator, curso.java.modelo.Usuario"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/bootstrap.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css"
	rel="stylesheet" />
</head>
<body>
	
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container px-4 px-lg-5">
			<a class="navbar-brand" href="<%=request.getContextPath()%>">Tienda
				Orfeon</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav me-auto mb-2 mb-lg-0 ms-lg-4">
					<%
					if (request.getSession().getAttribute("menuUsuario") != null) {
						HashSet<OpcionMenu> menu = (HashSet) request.getSession().getAttribute("menuUsuario");
						Iterator it = menu.iterator();
						while (it.hasNext()) {
							OpcionMenu om = (OpcionMenu) it.next();
					%>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded"
						href="<%=request.getContextPath() + "/" + om.getUrl()%>"><%=om.getNombre()%></a></li>
					<%
					}
					}
					Usuario usuario = (Usuario) request.getSession().getAttribute("usuarioTienda");
					if (usuario == null || usuario.getRol().getId() == 1) {
					%>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded"
						href="<%=request.getContextPath()%>/pages/carrito.jsp"><i class="bi bi-cart4"></i> Ver
							carrito</a></li>
					<%
					}
					if (usuario == null) {
					%>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded"
						href="<%=request.getContextPath()%>/pages/login.jsp"><i class="bi bi-person"></i> Iniciar
							sesión</a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded"
						href="<%=request.getContextPath()%>/ServletRegistro">Registrarse</a></li>
					<%
					} else {
					%>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded"
						href="<%=request.getContextPath()%>/ServletEditarPerfil"><i class="bi bi-person"></i> <%=usuario.getNombre() + " " + usuario.getApellido1()%></a></li>
					<li class="nav-item mx-0 mx-lg-1"><a
						class="nav-link py-3 px-0 px-lg-3 rounded"
						href="<%=request.getContextPath()%>/ServletLogin">Cerrar
							sesión</a></li>
					<%
					}
					%>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>