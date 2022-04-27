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
 * Servlet implementation class ServletGestionProductos
 */
@WebServlet("/ServletGestionProductos")
public class ServletGestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionProductos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HashMap<Integer, Producto> productos = ProductoServicio.mostrarTodosLosProductos();
		request.setAttribute("productos", productos);
		request.getRequestDispatcher("pages/gestionProductos.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("baja")!=null) {
			int idProducto=Integer.parseInt(request.getParameter("baja"));
			ProductoServicio.bajaProducto(idProducto);
		}
		if(request.getParameter("editar")!=null) {
			int idProducto=Integer.parseInt(request.getParameter("editar"));
			String nombre=request.getParameter("nombre"+idProducto);
			String descripcion=request.getParameter("descripcion"+idProducto);
			int stock=Integer.parseInt(request.getParameter("stock"+idProducto));
			double precio=Double.parseDouble(request.getParameter("precio"+idProducto));
			float impuesto=Float.parseFloat(request.getParameter("impuesto"+idProducto));
			
			ProductoServicio.editarProducto(idProducto, nombre, descripcion, stock, precio, impuesto);
		}
		
		
		doGet(request, response);
	}

}
