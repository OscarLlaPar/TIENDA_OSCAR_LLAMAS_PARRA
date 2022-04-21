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
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);*/
		// TODO Ver cómo puedo mejorar esto o pasarlo a servicios
		MetodoPagoDB modeloMP = new MetodoPagoDB();
		Usuario usuarioActual=(Usuario)request.getSession().getAttribute("usuarioTienda");
		int idMetodoPago=Integer.parseInt(request.getParameter("metodoPago"));
		double totalCarrito=(double)request.getSession().getAttribute("totalCarrito");
		Pedido pedido=new Pedido(usuarioActual, modeloMP.obtenerMetodoPago(idMetodoPago),EstadoPedido.Pendiente,"123",totalCarrito);
		HashMap<Integer,DetallePedido> detallesPedido=pedido.getDetallesPedido();
		HashMap<Integer, Producto> carrito = (HashMap) request.getSession().getAttribute("carrito");
		
		
		PedidoDB modeloPedido = new PedidoDB();
		modeloPedido.insertarPedido(pedido);
		
		request.getRequestDispatcher("pages/pedidos.jsp").forward(request, response);
		
		
	}

}