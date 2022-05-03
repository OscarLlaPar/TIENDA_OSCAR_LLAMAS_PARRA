package curso.java.controlador;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.OpcionMenu;
import curso.java.modelo.OpcionMenuDB;
import curso.java.modelo.Usuario;
import curso.java.servicio.OpcionMenuServicio;
import curso.java.servicio.UsuarioServicio;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getSession().getAttribute("usuarioTienda")!=null) {
			request.getSession().removeAttribute("usuarioTienda");
			request.getSession().removeAttribute("menuUsuario");
			request.getRequestDispatcher("").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String emailUsuario =request.getParameter("email");
		String password=request.getParameter("password");
		Usuario usuario=UsuarioServicio.verificarUsuario(emailUsuario, password);
		if(usuario!=null && usuario.getRol().getRol().equals("Cliente")) {
			
			HashSet<OpcionMenu> menu=OpcionMenuServicio.mostrarOpciones(usuario.getRol());
			request.getSession().setAttribute("usuarioTienda", usuario);
			request.getSession().setAttribute("menuUsuario", menu);
			request.getRequestDispatcher("").forward(request, response);
		}
		else {
			request.setAttribute("errorLogin", "Login incorrecto.");
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		}
	}

}
