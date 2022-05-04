<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Cambiar contraseña - Tienda Óscar Llamas Parra</title>
</head>
<body  class="min-vh-100">
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Cambiar contraseña</h2>
		</div>
		<div class="container px-4 px-lg-5">
			<div class="row justify-content-center">
				<div class="col-lg-5">
					<div class="card shadow-lg border-0 rounded-lg my-5">
						
						<div class="card-body">
							<form
								action="<%=request.getContextPath()%>/ServletCambiarPassword"
								method="post">
								<%
								if (request.getAttribute("mensajePassword") != null) {
								%>
								<p class="m-2 text-secondary"><%=request.getAttribute("mensajePassword")%></p>
								<%
								}
								%>
								<div class="form-floating mb-3">
									<input class="form-control"
										type="password" name="passwordActual">
										<label for="nombre">Contraseña actual</label> 
								</div>
								<div class="form-floating mb-3">
									<input class="form-control"
										type="password" name="passwordNueva" required>
									<label for="nombre">Contraseña nueva</label> 
								</div>
								<div class="form-floating mb-3">
									<input class="form-control"
										type="password" name="confirmarPassword" required>
									<label for="nombre">Confirmar contraseña</label> 
								</div>
								<div class="d-flex align-items-center justify-content-between mt-4 mb-0">
									<input class="btn btn-primary" type="submit" name="cambiarPassword"
										value="Cambiar contraseña">
								</div>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>