package curso.java.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.EstadoPedido;
import curso.java.modelo.Pedido;
import curso.java.servicio.DetallePedidoServicio;
import curso.java.servicio.PedidoServicio;

/**
 * Servlet implementation class ServletCancelarDetalle
 */
@WebServlet("/ServletCancelarDetalle")
public class ServletCancelarDetalle extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCancelarDetalle() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int idDetalle=Integer.parseInt(request.getParameter("id"));
		DetallePedido dp=DetallePedidoServicio.obtenerDetalle(idDetalle);
		DetallePedidoServicio.actualizarEstado(dp, EstadoPedido.PC);
		Pedido p=dp.getPedido();
		
		if(DetallePedidoServicio.buscarDetallesPorEstado(p.getId(), EstadoPedido.PE).size()==0) {
			PedidoServicio.actualizarEstado(p.getId(), EstadoPedido.PC);
		}
		else {
			PedidoServicio.actualizarEstado(p.getId(), EstadoPedido.PCD);
		}
		
		
		request.getRequestDispatcher("ServletDetallePedido?id="+dp.getPedido().getId()).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
