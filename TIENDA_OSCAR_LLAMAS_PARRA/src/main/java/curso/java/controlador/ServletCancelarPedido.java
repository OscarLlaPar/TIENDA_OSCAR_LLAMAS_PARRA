package curso.java.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.EstadoPedido;
import curso.java.servicio.PedidoServicio;

/**
 * Servlet implementation class ServletCancelarPedido
 */
@WebServlet("/ServletCancelarPedido")
public class ServletCancelarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCancelarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("id")!=null) {
			int idPedido=Integer.parseInt(request.getParameter("id"));
			PedidoServicio.actualizarEstado(idPedido, EstadoPedido.PC);

			request.getRequestDispatcher("ServletPedido").forward(request, response);
		}
		if(request.getParameter("idAdmin")!=null) {
			int idPedido=Integer.parseInt(request.getParameter("idAdmin"));
			PedidoServicio.actualizarEstado(idPedido, EstadoPedido.C);

			request.getRequestDispatcher("ServletPedidoAdmin").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
