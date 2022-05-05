package curso.java.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.Usuario;
import curso.java.modelo.Valoracion;
import curso.java.servicio.ProductoServicio;
import curso.java.servicio.ValoracionServicio;

/**
 * Servlet implementation class ServletValorar
 */
@WebServlet("/ServletValorar")
public class ServletValorar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletValorar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getSession().getAttribute("usuarioTienda")==null) {
    		request.getRequestDispatcher("").forward(request,response);
    	}
		
		System.out.println("Valorar");
		request.setAttribute("idProducto", request.getParameter("id"));
		request.getRequestDispatcher("pages/valorarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuarioTienda")==null) {
    		request.getRequestDispatcher("").forward(request,response);
    	}
		
		int idProducto=Integer.parseInt(request.getParameter("id"));
		int valoracion=Integer.parseInt(request.getParameter("valoracion"));
		String comentario=request.getParameter("comentario");
		Usuario usuarioActual=(Usuario)request.getSession().getAttribute("usuarioTienda");
		
		Valoracion v=new Valoracion(0, ProductoServicio.obtenerProducto(idProducto) ,usuarioActual,valoracion,comentario);
		ValoracionServicio.insertarValoracion(v);
		request.getRequestDispatcher("/ServletProducto?id="+idProducto).forward(request, response);
	}

}
