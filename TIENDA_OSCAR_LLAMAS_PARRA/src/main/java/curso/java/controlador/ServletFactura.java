package curso.java.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.Pedido;
import curso.java.modelo.Usuario;
import curso.java.servicio.PedidoServicio;
import curso.java.util.PedidoUtil;

/**
 * Servlet implementation class ServletFactura
 */
@WebServlet("/ServletFactura")
public class ServletFactura extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletFactura() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idPedido=Integer.parseInt(request.getParameter("id"));
		Pedido p=PedidoServicio.obtenerPedido(idPedido);
		Usuario u=(Usuario)request.getSession().getAttribute("usuarioTienda");
		System.out.println(request.getServletContext().getRealPath(""));
		if(PedidoUtil.generarFactura(p, request.getServletContext().getRealPath(""),u)) {
			request.setAttribute("mensajeFactura", "Factura creada");
		}
		else {
			request.setAttribute("mensajeFactura", "Error al crear la factura");
		}
		
		request.getRequestDispatcher(p.getNumFactura()+".pdf").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
