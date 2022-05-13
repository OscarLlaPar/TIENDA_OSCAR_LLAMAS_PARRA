let mensajeMostrado=false;


function comprobarCarrito(){
let elementoIdUsuario=document.getElementById("idUsuario");
let idUsuario=elementoIdUsuario.value;
console.log(idUsuario);

fetch("http://localhost:8080/TIENDA_OSCAR_LLAMAS_PARRA/ApiCarrito?idUsuario="+idUsuario,
	{
        headers: {"Content-Type": "text/html; charset=UTF-8"}
    }
)
	.then(response => response.arrayBuffer())
	.then(buffer =>{
		console.log(buffer);
		console.log(buffer.length);
		
		let decoder = new TextDecoder("iso-8859-1")
   		 let text = decoder.decode(buffer)
		
		console.log(text);
		
		if(text.length>2 && !mensajeMostrado){
			var regExp = /\[[^\[\]]+\]/g
			var resultado = text.match(regExp)
			
			for(i in resultado) {
			    resultado[i] = resultado[i].replace(/[\[\]]/g,'') //sanitiza el resultado
			}
			
			
			console.log("Hay mensaje");
			//alert(result);
			let contenedorMensaje=document.getElementById("contenedorMensaje");
			let alerta= document.createElement("div");
			alerta.classList.add("alert");
			alerta.classList.add("alert-warning");
			alerta.classList.add("alert-dismissible");
			alerta.classList.add("fade");
			alerta.classList.add("show");
			contenedorMensaje.appendChild(alerta);
			
			let textoAlerta=document.createElement("span");
			textoAlerta.innerHTML=resultado;
			alerta.appendChild(textoAlerta);
			
			let botonAlerta=document.createElement("button");
			botonAlerta.setAttribute("type", "button");
			botonAlerta.setAttribute("data-bs-dismiss", "alert");
			botonAlerta.classList.add("btn-close");
			alerta.appendChild(botonAlerta);
			
			mensajeMostrado=true;
		}
	})
	.catch(err => console.log(err))
}


comprobarCarrito();
setInterval(comprobarCarrito, 5000);