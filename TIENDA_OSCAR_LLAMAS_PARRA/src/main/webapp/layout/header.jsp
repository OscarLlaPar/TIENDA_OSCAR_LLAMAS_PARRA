<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashSet, curso.java.modelo.OpcionMenu, java.util.Iterator, curso.java.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<header>
		<h1>Tienda Óscar Llamas Parra</h1>
		<%
		if(request.getSession().getAttribute("usuarioTienda")==null){
			%>
			<a href="pages/login.jsp">Iniciar sesión</a>
			<a href="pages/registro.jsp">Registrarse</a>
			<%
		}
		else{
			%>
			<a href="<%= request.getContextPath()%>/pages/perfilUsuario.jsp">Ver perfil</a>
			<a href="<%= request.getContextPath()%>/ServletLogin">Cerrar sesión</a>
			<%
		}
		%>
		<nav>
		<%
			if(request.getSession().getAttribute("menuUsuario")!=null){
				HashSet<OpcionMenu> menu=(HashSet)request.getSession().getAttribute("menuUsuario");
				Iterator it=menu.iterator();
				while(it.hasNext()){
					OpcionMenu om=(OpcionMenu)it.next();
					%>
						<a href="<%= request.getContextPath()+"/"+om.getUrl()%>"><%= om.getNombre() %></a>
					<%
				}
			}
			Usuario usuario=(Usuario)request.getSession().getAttribute("usuarioTienda");	
			if(usuario==null || usuario.getRol().getId()==1){
				%>
					<a href="<%= request.getContextPath()%>/pages/carrito.jsp">Ver carrito</a>
				<%
			}
		%>
		</nav>
	</header>
</body>
</html>