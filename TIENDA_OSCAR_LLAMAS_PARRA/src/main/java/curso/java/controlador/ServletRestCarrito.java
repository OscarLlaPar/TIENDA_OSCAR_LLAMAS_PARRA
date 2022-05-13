package curso.java.controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.servicio.DetallePedidoServicio;

/**
 * Servlet implementation class ServletRestCarrito
 */
@WebServlet("/ApiCarrito")
public class ServletRestCarrito extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRestCarrito() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/plain");
		
		//int idProducto= Integer.parseInt(request.getParameter("idProducto"));
		int idUsuario= Integer.parseInt(request.getParameter("idUsuario"));
		
		PrintWriter out = response.getWriter();
		
		ArrayList<Integer> productos=DetallePedidoServicio.obtenerProductosCarritoPorUsuario(idUsuario);
		System.out.println(productos);
		ArrayList<String> mensajes = new ArrayList <>();
		
		for(int producto: productos) {
			System.out.println(DetallePedidoServicio.comprobarCarrito(producto));
			if(!DetallePedidoServicio.comprobarCarrito(producto)) {
				mensajes.add("Hay otros usuarios con el producto " + producto + " en su carrito. Si no terminas tu compra podrías quedarte sin él." );
			}
		}
		
		out.print(mensajes);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
