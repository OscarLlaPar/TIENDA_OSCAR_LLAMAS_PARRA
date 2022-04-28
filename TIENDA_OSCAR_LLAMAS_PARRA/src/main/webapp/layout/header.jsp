<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashSet, curso.java.modelo.OpcionMenu, java.util.Iterator, curso.java.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/bootstrap.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.5.0/font/bootstrap-icons.css" rel="stylesheet" />
</head>
<body>
	<header class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container px-4 px-lg-5">
                <a class="navbar-brand" href="<%= request.getContextPath() %>">Tienda �scar Llamas Parra</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <nav class="collapse navbar-collapse" id="navbarResponsive">
                    <ul class="navbar-nav ms-auto">
                        <%
					if(request.getSession().getAttribute("usuarioTienda")==null){
						%>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<%=request.getContextPath()%>/pages/login.jsp">Iniciar sesi�n</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<%= request.getContextPath() %>/pages/registro.jsp">Registrarse</a></li>
						<%
					}
					else{
						%>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<%= request.getContextPath()%>/pages/perfilUsuario.jsp">Ver perfil</a></li>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded"  href="<%= request.getContextPath()%>/ServletLogin">Cerrar sesi�n</a></li>
						<%
					}
				%>
                        <%
			if(request.getSession().getAttribute("menuUsuario")!=null){
				HashSet<OpcionMenu> menu=(HashSet)request.getSession().getAttribute("menuUsuario");
				Iterator it=menu.iterator();
				while(it.hasNext()){
					OpcionMenu om=(OpcionMenu)it.next();
					%>
						<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<%= request.getContextPath()+"/"+om.getUrl()%>"><%= om.getNombre() %></a></li>
					<%
				}
			}
			Usuario usuario=(Usuario)request.getSession().getAttribute("usuarioTienda");	
			if(usuario==null || usuario.getRol().getId()==1){
				%>
					<li class="nav-item mx-0 mx-lg-1"><a class="nav-link py-3 px-0 px-lg-3 rounded" href="<%= request.getContextPath()%>/pages/carrito.jsp">Ver carrito</a></li>
				<%
			}
		%>
                    </ul>
                </nav>
            </div>
        </header>
</body>
</html>