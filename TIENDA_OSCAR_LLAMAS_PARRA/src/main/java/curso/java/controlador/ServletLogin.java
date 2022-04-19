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
			request.getRequestDispatcher("").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idUsuario =Integer.parseInt(request.getParameter("id"));
		String password=request.getParameter("password");
		Usuario usuario=UsuarioServicio.verificarUsuario(idUsuario, password);
		if(usuario!=null) {
			request.getSession().setAttribute("usuarioTienda", usuario);
			request.getRequestDispatcher("").forward(request, response);
		}
		else {
			request.setAttribute("errorLogin", "ID o usuario incorrectos.");
			request.getRequestDispatcher("pages/login.jsp").forward(request, response);
		}
	}

}
