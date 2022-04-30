package curso.java.controlador;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.EstadoPedido;
import curso.java.modelo.MetodoPagoDB;
import curso.java.modelo.Pedido;
import curso.java.modelo.PedidoDB;
import curso.java.modelo.Producto;
import curso.java.modelo.Usuario;
import curso.java.servicio.PedidoServicio;
import curso.java.servicio.ProductoServicio;

/**
 * Servlet implementation class ServletPedido
 */
@WebServlet("/ServletPedido")
public class ServletPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);*/
		
		Usuario usuarioActual=(Usuario)request.getSession().getAttribute("usuarioTienda");
		
		if(request.getParameter("comprar")!=null) {
			
			int idMetodoPago=Integer.parseInt(request.getParameter("metodoPago"));
			double totalCarrito=(double)request.getSession().getAttribute("totalCarrito");
			Pedido pedido=new Pedido(usuarioActual, PedidoServicio.obtenerMetodoPago(idMetodoPago),EstadoPedido.PE,null,totalCarrito);
			HashMap<Integer, DetallePedido> carrito=(HashMap) request.getSession().getAttribute("carrito");
			pedido.setDetallesPedido(carrito);
			
			PedidoServicio.insertarPedido(pedido);
			carrito.clear();
			request.getSession().setAttribute("totalCarrito", 0.0);
		}
		request.setAttribute("pedidos", PedidoServicio.obtenerPedidos(usuarioActual.getId()));
		
		request.getRequestDispatcher("pages/pedidos.jsp").forward(request, response);
		
		
	}

}
