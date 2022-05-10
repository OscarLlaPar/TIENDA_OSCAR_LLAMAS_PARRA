let botonDescuento=document.getElementById("mostrarDescuento");
botonDescuento.addEventListener("click", function(event){
	let formDescuento=document.getElementById("formDescuento");
	formDescuento.classList.remove("d-none");
	botonDescuento.classList.add("d-none");
})