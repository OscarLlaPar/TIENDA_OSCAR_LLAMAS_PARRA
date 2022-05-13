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
import curso.java.modelo.Usuario;
import curso.java.servicio.DetallePedidoServicio;
import curso.java.servicio.ProductoServicio;

/**
 * Servlet implementation class ServletAnadir
 */
@WebServlet("/ServletAnadir")
public class ServletAnadir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletAnadir() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<Integer,DetallePedido> carrito = (HashMap)request.getSession().getAttribute("carrito");
		if(request.getParameter("id")!=null) {
			int idProducto=Integer.parseInt(request.getParameter("id"));
			Producto p=ProductoServicio.obtenerProducto(idProducto);
			int cantidadIntroducida=Integer.parseInt(request.getParameter("cantidad"+idProducto));
			Usuario u=(Usuario) request.getSession().getAttribute("usuarioTienda");
            DetallePedidoServicio.anadirAlCarrito(carrito, p, cantidadIntroducida, u);
            request.getSession().setAttribute("totalCarrito", DetallePedidoServicio.totalCarrito(carrito));
		}
		
		request.getSession().setAttribute("carrito", carrito);
		request.getRequestDispatcher("pages/carrito.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
