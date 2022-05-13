package curso.java.controlador;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.Descuento;
import curso.java.modelo.DetallePedido;
import curso.java.modelo.EstadoPedido;
import curso.java.modelo.MetodoPagoDB;
import curso.java.modelo.Pedido;
import curso.java.modelo.PedidoDB;
import curso.java.modelo.Producto;
import curso.java.modelo.Usuario;
import curso.java.servicio.DescuentoServicio;
import curso.java.servicio.DetallePedidoServicio;
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
		if(request.getParameter("codigo")!=null) {
			String codigo=(String) request.getParameter("codigo");
			
			LocalDate fechaActual = LocalDate.now();
			
			Descuento d = DescuentoServicio.obtenerPorCodigo(codigo);
			if(d!=null && fechaActual.compareTo(d.getFechaInicio())>=0 && fechaActual.compareTo(d.getFechaFin())<=0) {
				request.setAttribute("descuento", d);
				request.setAttribute("mensajeDescuento", "Descuento válido");
				double totalCarrito=(double)request.getSession().getAttribute("totalCarrito");
				request.getSession().setAttribute("totalCarrito", totalCarrito - totalCarrito*(d.getDescuento()/100) );
			}
			else {
				request.setAttribute("mensajeDescuento", "Descuento no válido");
			}
			request.getRequestDispatcher("pages/confirmarCompra.jsp").forward(request, response);
		}
		else {
			doPost(request,response);
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuarioTienda")==null) {
    		request.getRequestDispatcher("").forward(request,response);
    	}
		/*LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);*/
		
		Usuario usuarioActual=(Usuario)request.getSession().getAttribute("usuarioTienda");
		
		if(request.getParameter("comprar")!=null) {
			
			int idMetodoPago=Integer.parseInt(request.getParameter("metodoPago"));
			double totalCarrito=(double)request.getSession().getAttribute("totalCarrito");
			Descuento descuento=null;
			if(!request.getParameter("idDescuento").equals("")) {
				int idDescuento=Integer.parseInt(request.getParameter("idDescuento"));
				descuento= DescuentoServicio.obtenerPorId(idDescuento);
			}
			
			
			Pedido pedido=new Pedido(usuarioActual, PedidoServicio.obtenerMetodoPago(idMetodoPago),EstadoPedido.PE,null,totalCarrito, descuento);
			HashMap<Integer, DetallePedido> carrito=(HashMap) request.getSession().getAttribute("carrito");
			pedido.setDetallesPedido(carrito);
			for (Map.Entry<Integer, DetallePedido> dp : carrito.entrySet()) {
				dp.getValue().getProducto().setStock(dp.getValue().getProducto().getStock()-dp.getValue().getUnidades());
				int idProducto=dp.getValue().getProducto().getId();
				int stockProducto=dp.getValue().getProducto().getStock();
				ProductoServicio.actualizarStock(idProducto,stockProducto);
			}
			PedidoServicio.insertarPedido(pedido);
			carrito.clear();
			request.getSession().setAttribute("totalCarrito", 0.0);
			request.setAttribute("mensajeCompra", "¡Muchas gracias por su compra! El pedido está en marcha.");
		}
		request.setAttribute("pedidos", PedidoServicio.obtenerPedidos(usuarioActual.getId()));
		
		request.getRequestDispatcher("pages/pedidos.jsp").forward(request, response);
		
		
	}

}
