package curso.java.controlador;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.Producto;
import curso.java.modelo.ProductoDB;
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
		HashMap<Integer,Producto> carrito = (HashMap)request.getSession().getAttribute("carrito");
		if(request.getParameter("id")!=null) {
            ProductoDB modeloProducto=new ProductoDB();
			int idProducto=Integer.parseInt(request.getParameter("id"));
			Producto p=modeloProducto.buscarProductoPorId(idProducto);
			int cantidadIntroducida=Integer.parseInt(request.getParameter("cantidad"+idProducto));
            ProductoServicio.anadirAlCarrito(carrito, p, idProducto, cantidadIntroducida);
            request.getSession().setAttribute("totalCarrito", ProductoServicio.totalCarrito(carrito));
		}
		
		request.getSession().setAttribute("carrito", carrito);
		request.getRequestDispatcher("").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
