package curso.java.controlador;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.Producto;
import curso.java.modelo.ProductoDB;
import curso.java.servicio.ProductoServicio;

/**
 * Servlet implementation class ServletInicial
 */

@WebServlet("")
public class ServletInicial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletInicial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String busqueda=(String) request.getAttribute("busqueda");
		HashMap<Integer,Producto> catalogo;
		if(busqueda!=null) {
			int categoria=Integer.parseInt((String)request.getAttribute("categoria"));
			catalogo=ProductoServicio.mostrarCatalogo(busqueda, categoria);
		}
		else {
			catalogo=ProductoServicio.mostrarCatalogo("",0);
		}
		HashMap<Integer,DetallePedido> carrito=null;
		if(request.getSession().getAttribute("carrito")==null) {
			carrito=new HashMap<Integer,DetallePedido>();
		}
		else {
			carrito = (HashMap)request.getSession().getAttribute("carrito");
		}
		
		if(request.getSession().getAttribute("totalCarrito")==null) {
			request.getSession().setAttribute("totalCarrito", 0.0);
		}
		
		request.setAttribute("catalogo", catalogo);
		request.setAttribute("categorias", ProductoServicio.mostrarTodasLasCategorias());
		request.getSession().setAttribute("carrito", carrito);
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
