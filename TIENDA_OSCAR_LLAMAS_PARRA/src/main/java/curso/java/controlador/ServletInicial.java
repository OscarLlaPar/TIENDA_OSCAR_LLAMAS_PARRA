package curso.java.controlador;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.DetallePedido;
import curso.java.modelo.Producto;
import curso.java.modelo.ProductoDB;
import curso.java.servicio.ProductoServicio;
import curso.java.util.IdiomaUtil;
import curso.java.util.LogUtil;
import curso.java.util.TipoLog;

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
		int categoria;
		int orden;
		String local;
		String busqueda=(String) request.getAttribute("busqueda");
		LinkedHashMap<Integer,Producto> catalogo;
		if(busqueda!=null) {
			categoria=Integer.parseInt((String)request.getAttribute("categoria"));
			orden=Integer.parseInt((String)request.getAttribute("orden"));
			request.setAttribute("busqueda",busqueda);
			request.setAttribute("orden",orden);
			LogUtil.registrarInfo(getClass(), TipoLog.INFO, "Buscando productos cuyo nombre contenga '"+busqueda+"' con el orden "+orden);
		}
		else {
			busqueda="";
			categoria=0;
			orden=0;
			LogUtil.registrarInfo(getClass(), TipoLog.INFO, "Mostrando catálogo sin búsqueda");
		}
		
		catalogo=ProductoServicio.mostrarCatalogo(busqueda, categoria,orden);
		
		
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
		
		if(request.getSession().getAttribute("idioma")==null) {
			request.getSession().setAttribute("idioma","es");
		}
		if(request.getParameter("idioma")!=null) {
			request.getSession().setAttribute("idioma",request.getParameter("idioma"));
		}
		local=(String) request.getSession().getAttribute("idioma");
		request.setAttribute("contenido", IdiomaUtil.contenidoIdioma(new Locale(local)));
		
		request.setAttribute("catalogo", catalogo);
		request.setAttribute("categorias", ProductoServicio.mostrarTodasLasCategorias());
		request.getSession().setAttribute("carrito", carrito);
		request.getRequestDispatcher("inicio.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
