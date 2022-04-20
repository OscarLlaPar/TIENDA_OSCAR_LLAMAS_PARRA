package curso.java.controlador;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.Producto;
import curso.java.servicio.ProductoServicio;


/**
 * Servlet implementation class ServletCarrito
 */
@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashMap<Integer,Producto> carrito=(HashMap)request.getSession().getAttribute("carrito");
		
		if(request.getParameter("idEliminar")!=null) {
			int idProducto=Integer.parseInt(request.getParameter("idEliminar"));
			Producto productoEnCurso=carrito.get(idProducto);
			int cantidadEliminar=Integer.parseInt(request.getParameter("cantidad"+idProducto));
            
			double totalCarrito=(double) request.getSession().getAttribute("totalCarrito");
			
			
			ProductoServicio.eliminarDelCarrito(carrito, productoEnCurso, idProducto, cantidadEliminar);
			
		}
		request.getSession().setAttribute("totalCarrito", ProductoServicio.totalCarrito(carrito));
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
