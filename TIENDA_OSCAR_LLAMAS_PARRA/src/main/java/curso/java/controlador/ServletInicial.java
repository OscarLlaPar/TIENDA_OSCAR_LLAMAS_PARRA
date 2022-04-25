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
		// TODO Auto-generated method stub
		ProductoDB modelo=new ProductoDB();
		HashMap<Integer,Producto> catalogo=modelo.mostrarCatalogo();
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
		request.getSession().setAttribute("carrito", carrito);
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
