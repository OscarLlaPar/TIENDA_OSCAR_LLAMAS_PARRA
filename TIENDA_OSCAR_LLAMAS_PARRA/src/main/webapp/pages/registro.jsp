<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap, java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registro - Tienda Óscar Llamas Parra</title>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/estilos.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/css/registro.css">
</head>
<body  class="d-flex flex-column min-vh-100">
	<jsp:include page="../layout/header.jsp" />
	<div class="bg-dark py-3 text-center text-white">
		<h2>Registro</h2>
	</div>
	<%
	HashMap<String, String> errores = (HashMap) request.getAttribute("errores");
	HashMap<String, String> respuestas = (HashMap) request.getAttribute("respuestas");
	%>
	<div class="container px-4 px-lg-5 mt-5 pb-5">
		<form action="<%=request.getContextPath()%>/ServletRegistro"
			method="post">
			<div class="container">
				<div class="row py-2">
					<div class="col-sm">
						<label for="email">Email</label> <input class="form-control"
							type="email" name="email" placeholder="ejemplo@mail.com"
							id="email" value="<%= respuestas!=null?respuestas.get("email"):"" %>"  required> 
							<div class="text-danger"><small><%=errores != null ? errores.get("email") : ""%>
						</small> </div>
					</div>
					<div class="col-sm">
						<label for="nombre">Nombre</label> <input class="form-control"
							type="text" name="nombre" placeholder="Nombre de pila"
							id="nombre" value="<%= respuestas!=null?respuestas.get("nombre"):"" %>"  required>
							 <div class="text-danger"><small><%=errores != null ? errores.get("nombre") : ""%>
						</small></div>
					</div>
				</div>
				<div class="row py-2">
					<div class="col-sm">
						<label for="apellido1">Primer apellido</label> <input
							class="form-control" type="text" name="apellido1"
							placeholder="Primer apellido" id="apellido1" value="<%= respuestas!=null?respuestas.get("apellido1"):"" %>"  required> 
							<div class="text-danger"><small><%=errores != null ? errores.get("apellido1") : ""%>
						</small></div>
					</div>
					<div class="col-sm">
						<label for="apellido2">Segundo apellido</label> <input
							class="form-control" type="text" name="apellido2"
							placeholder="Segundo apellido" id="apellido2" value="<%= respuestas!=null?respuestas.get("apellido2"):"" %>"  required> 
							<div class="text-danger"><small><%=errores != null ? errores.get("apellido2") : ""%>
						</small></div>
					</div>
				</div>

				<div class="form-group py-2">
					<label for="direccion">Dirección</label> <input
						class="form-control" type="text" name="direccion"
						placeholder="C/ Calle, nº 1" id="direccion" value="<%= respuestas!=null?respuestas.get("direccion"):"" %>"  required> 
						<div class="text-danger"><small><%=errores != null ? errores.get("direccion") : ""%>
					</small></div>
				</div>
				<div class="row py-3">
					<div class="col-sm">
						<label for="provincia">Provincia</label> 
						<select class="form-select" name="provincia">
						<% 
						ArrayList<String> provincias =(ArrayList) request.getAttribute("provincias");
						for(String provincia: provincias){
							%>
							<option value="<%= provincia %>" <% if (respuestas!=null && respuestas.get("provincia").equals(provincia)) out.println("selected"); %> ><%= provincia %></option>
							<%
						}
								%>
						
						
						</select>
							 <div class="text-danger"><small><%=errores != null ? errores.get("provincia") : ""%>
						</small></div>
					</div>
					<div class="col-sm">
						<label for="localidad">Localidad</label> <input
							class="form-control" type="text" name="localidad"
							placeholder="Localidad" id="localidad" value="<%= respuestas!=null?respuestas.get("localidad"):"" %>"  required>
							 <div class="text-danger"><small><%=errores != null ? errores.get("localidad") : ""%>
						</small></div>
					</div>
				</div>
				<div class="row py-3">
					<div class="col-sm">
						<label for="telefono">Teléfono</label> <input class="form-control"
							type="text" name="telefono" placeholder="Teléfono" id="telefono"
							value="<%= respuestas!=null?respuestas.get("telefono"):"" %>"  required> <div class="text-danger"><small><%=errores != null ? errores.get("telefono") : ""%>
						</small></div>
					</div>
					<div class="col-sm">
						<label for="dni">DNI</label> <input class="form-control"
							type="text" name="dni" placeholder="DNI" id="dni" value="<%= respuestas!=null?respuestas.get("dni"):"" %>"  required>
						<div class="text-danger"><small><%=errores != null ? errores.get("dni") : ""%> </small></div>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<label for="password">Contraseña</label> <input
							class="form-control" type="password" name="password"
							placeholder="" id="password" required> <div class="text-danger"><small><%=errores != null ? errores.get("password") : ""%>
						</small></div>
					</div>
					<div class="col-sm">
						<label for="confirmarPassword">Confirmar contraseña</label> <input
							class="form-control" type="password" name="confirmarPassword"
							placeholder="" id="confirmarPassword" required> <div class="text-danger"><small><%=errores != null ? errores.get("confirmarPassword") : ""%>
						</small></div>
					</div>
				</div>
				<div class="form-group py-3">
					<input class="btn btn-primary" type="submit" name="registro" value="Registrarse"
					id="registro">
				</div>
				
			</div>


		</form>
	</div>
	<div class="h-50 w-100 pb-5 ">
	</div>
	<jsp:include page="../layout/footer.jsp" />
	<script src="<%=request.getContextPath()%>/js/registro.js"></script>
</body>
</html>