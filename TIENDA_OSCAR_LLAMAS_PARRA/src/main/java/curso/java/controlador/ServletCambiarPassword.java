package curso.java.controlador;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.Usuario;
import curso.java.servicio.UsuarioServicio;
import curso.java.util.UsuarioUtil;

/**
 * Servlet implementation class ServletCambiarPassword
 */
@WebServlet("/ServletCambiarPassword")
public class ServletCambiarPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCambiarPassword() {
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
		// TODO Auto-generated method stub
		Usuario usuarioActual=(Usuario) request.getSession().getAttribute("usuarioTienda");
		String passwordActual=UsuarioUtil.obtenerSha2(usuarioActual.getNombre()+request.getParameter("passwordActual"));
		String passwordNueva=request.getParameter("passwordNueva");
		String confirmarPassword=request.getParameter("confirmarPassword");
		if(passwordActual.equals(usuarioActual.getClave()) && passwordNueva.equals(confirmarPassword)) {
			String passwordValida=UsuarioUtil.obtenerSha2(usuarioActual.getNombre()+passwordNueva);
			UsuarioServicio.cambiarPassword(usuarioActual.getEmail(), passwordValida);
			request.setAttribute("mensajePassword", "Contraseña cambiada");
		}
		else {
			request.setAttribute("mensajePassword", "Contraseña incorrecta");
		}
		request.getRequestDispatcher("pages/cambiarPassword.jsp").forward(request, response);
	}

}
