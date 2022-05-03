<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Iniciar sesión - Tienda Óscar Llamas Parra</title>
<body  class="d-flex flex-column min-vh-100">
	<jsp:include page="../layout/header.jsp" />
	<main>
		<div class="bg-dark py-3 text-center text-white">
			<h2>Iniciar sesión</h2>
		</div>
		<div class="container px-4 px-lg-5">
			<div class="row justify-content-center">
				<div class="col-lg-5">
					<div class="card shadow-lg border-0 rounded-lg my-5">
						<div class="card-body">
							<form action="<%=request.getContextPath()%>/ServletLogin"
								method="post">
								<%
									if(request.getAttribute("errorLogin")!=null){
										%>
										<p class="text-danger text-center"><%=request.getAttribute("errorLogin") %> </p>
										<%
									}
								%>
								
								<div class="form-floating mb-3">
									<input class="form-control" id="inputEmail" type="email"
										name="email" placeholder="name@example.com" /> <label
										for="inputEmail">Email</label>
								</div>
								<div class="form-floating mb-3">
									<input class="form-control" id="inputPassword" type="password"
										name="password" placeholder="Password" /> <label
										for="inputPassword">Contraseña</label>
								</div>
								<div class="d-flex align-items-center justify-content-between mt-4 mb-0">
									<a href="<%=request.getContextPath()%>"
										class="btn btn-secondary">Volver</a>
									<button type="submit" class="btn btn-primary">Iniciar
										sesión</button>
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