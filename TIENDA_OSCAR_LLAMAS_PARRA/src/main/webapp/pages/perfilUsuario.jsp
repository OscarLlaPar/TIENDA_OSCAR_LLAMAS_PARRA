<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="curso.java.modelo.Usuario" %>
<!DOCTYPE html>
<html>
<%
    	Usuario usuario=(Usuario)request.getSession().getAttribute("usuarioTienda");
    %>
<head>
<meta charset="ISO-8859-1">
<title><%=usuario.getNombre() %> - Tienda Óscar Llamas Parra</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
	<main>
		<h2>Perfil de <%=usuario.getNombre()+" "+usuario.getApellido1()+" "+usuario.getApellido2()%>  </h2>
		<div>
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>