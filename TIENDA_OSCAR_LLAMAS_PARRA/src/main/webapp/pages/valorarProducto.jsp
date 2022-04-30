<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../layout/header.jsp" />
		<div class="bg-dark py-3 text-center text-white">
			<h2>Valorar producto</h2>
		</div>
		<div class="container px-4 px-lg-5">
			<div class="row justify-content-center">
				<div class="col-lg-5">
					<div class="card shadow-lg border-0 rounded-lg my-5">
						<div class="card-body">
							<form action="<%=request.getContextPath()%>/ServletValorar" method="post">
								<div class="form-group mb-3">
									<label for="inputValoracion">Valoración</label>
									<input class="col-xs-1 mx-2" id="inputValoracion" type="number"
										name="valoracion" value="10" min="0" max="10" size="2" /> 
								</div>
								<div class="form-group mb-3">
									<label for="inputComentario">Comentario</label>
									<textArea class="form-control" name="comentario" id="inputComentario">
									</textArea>
								</div>
								<div class="d-flex align-items-center mt-4 mb-0">
									<button type="submit" class="btn btn-primary" name="id" value="<%= request.getAttribute("idProducto") %>">Enviar valoración</button>
									<a class="btn btn-secondary mx-2">Volver</a>
								</div>
							</form>
						</div>
					</div>
				</div>

			</div>
		</div>
	<jsp:include page="../layout/footer.jsp" />
</body>
</html>