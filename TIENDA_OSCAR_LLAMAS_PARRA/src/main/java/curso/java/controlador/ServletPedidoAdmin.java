package curso.java.controlador;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.EstadoPedido;
import curso.java.modelo.Pedido;
import curso.java.servicio.PedidoServicio;

/**
 * Servlet implementation class ServletPedidoAdmin
 */
@WebServlet("/ServletPedidoAdmin")
public class ServletPedidoAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletPedidoAdmin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HashSet<Pedido> pedidos=PedidoServicio.obtenerPedidos(EstadoPedido.PC);
		request.setAttribute("pedidos", pedidos);
		request.getRequestDispatcher("pages/pedidosAdmin.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
