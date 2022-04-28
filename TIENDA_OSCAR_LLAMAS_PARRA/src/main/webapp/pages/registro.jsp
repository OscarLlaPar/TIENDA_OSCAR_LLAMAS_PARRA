<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.HashMap"%>
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
	%>
	<div class="wrapper pb-5">
		<form action="<%=request.getContextPath()%>/ServletRegistro"
			method="post">
			<div class="container">
				<div class="row py-2">
					<div class="col-sm">
						<label for="email">Email</label> <input class="form-control"
							type="email" name="email" placeholder="ejemplo@mail.com"
							id="email" required> <span><%=errores != null ? errores.get("email") : ""%>
						</span>
					</div>
					<div class="col-sm">
						<label for="nombre">Nombre</label> <input class="form-control"
							type="text" name="nombre" placeholder="Nombre de pila"
							id="nombre" required> <span><%=errores != null ? errores.get("nombre") : ""%>
						</span>
					</div>
				</div>
				<div class="row py-2">
					<div class="col-sm">
						<label for="apellido1">Primer apellido</label> <input
							class="form-control" type="text" name="apellido1"
							placeholder="Primer apellido" id="apellido1" required> <span><%=errores != null ? errores.get("apellido1") : ""%>
						</span>
					</div>
					<div class="col-sm">
						<label for="apellido2">Segundo apellido</label> <input
							class="form-control" type="text" name="apellido2"
							placeholder="Segundo apellido" id="apellido2" required> <span><%=errores != null ? errores.get("apellido2") : ""%>
						</span>
					</div>
				</div>

				<div class="form-group py-2">
					<label for="direccion">Dirección</label> <input
						class="form-control" type="text" name="direccion"
						placeholder="C/ Calle, nº 1" id="direccion" required> <span><%=errores != null ? errores.get("direccion") : ""%>
					</span>
				</div>
				<div class="row py-3">
					<div class="col-sm">
						<label for="provincia">Provincia</label> <input
							class="form-control" type="text" name="provincia"
							placeholder="Provincia" id="provincia" required> <span><%=errores != null ? errores.get("provincia") : ""%>
						</span>
					</div>
					<div class="col-sm">
						<label for="localidad">Localidad</label> <input
							class="form-control" type="text" name="localidad"
							placeholder="Localidad" id="localidad" required> <span><%=errores != null ? errores.get("localidad") : ""%>
						</span>
					</div>
				</div>
				<div class="row py-3">
					<div class="col-sm">
						<label for="telefono">Teléfono</label> <input class="form-control"
							type="text" name="telefono" placeholder="Teléfono" id="telefono"
							required> <span><%=errores != null ? errores.get("telefono") : ""%>
						</span>
					</div>
					<div class="col-sm">
						<label for="dni">DNI</label> <input class="form-control"
							type="text" name="dni" placeholder="DNI" id="dni" required>
						<span><%=errores != null ? errores.get("dni") : ""%> </span>
					</div>
				</div>
				<div class="row">
					<div class="col-sm">
						<label for="password">Contraseña</label> <input
							class="form-control" type="password" name="password"
							placeholder="" id="password" required> <span><%=errores != null ? errores.get("password") : ""%>
						</span>
					</div>
					<div class="col-sm">
						<label for="confirmarPassword">Confirmar contraseña</label> <input
							class="form-control" type="password" name="confirmarPassword"
							placeholder="" id="confirmarPassword" required> <span><%=errores != null ? errores.get("email") : ""%>
						</span>
					</div>
				</div>
				<div class="form-group py-3">
					<input class="btn btn-primary" type="submit" name="registro" value="Registrarse"
					id="registro">
				</div>
				
			</div>


		</form>
	</div>
	<jsp:include page="../layout/footer.jsp" />
	<script src="<%=request.getContextPath()%>/js/registro.js"></script>
</body>
</html>