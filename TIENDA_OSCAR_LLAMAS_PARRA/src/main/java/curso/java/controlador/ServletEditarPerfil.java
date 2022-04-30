package curso.java.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.Usuario;
import curso.java.servicio.UsuarioServicio;

/**
 * Servlet implementation class ServletEditarPerfil
 */
@WebServlet("/ServletEditarPerfil")
public class ServletEditarPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEditarPerfil() {
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
		int id=Integer.parseInt(request.getParameter("id"));
		String nombre=request.getParameter("nombre");
		String apellido1=request.getParameter("apellido1");
		String apellido2=request.getParameter("apellido2");
		String email=request.getParameter("email");
		String direccion=request.getParameter("direccion");
		String provincia=request.getParameter("provincia");
		String localidad=request.getParameter("localidad");
		String telefono=request.getParameter("telefono");
		String dni=request.getParameter("dni");
		Usuario usuarioActual=(Usuario) request.getSession().getAttribute("usuarioTienda");
		Usuario usuarioNuevo=new Usuario(id, email, usuarioActual.getRol(), usuarioActual.getClave(), nombre, apellido1, apellido2, direccion, provincia, localidad, telefono, dni);
		
		if (UsuarioServicio.editarUsuario(usuarioActual, usuarioNuevo)) {
			request.getSession().setAttribute("usuarioTienda", usuarioNuevo);
		}
		
		request.getRequestDispatcher("pages/perfilUsuario.jsp").forward(request, response);
	}

}
