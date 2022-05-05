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
		if(request.getSession().getAttribute("usuarioTienda")==null) {
    		request.getRequestDispatcher("").forward(request,response);
    	}
		
		Usuario usuarioActual=(Usuario) request.getSession().getAttribute("usuarioTienda");
		String mensajePassword="";
		String passwordActual=UsuarioUtil.obtenerSha2(request.getParameter("passwordActual"));
		String passwordNueva=request.getParameter("passwordNueva");
		String confirmarPassword=request.getParameter("confirmarPassword");
		if(!passwordActual.equals(usuarioActual.getClave())) {
			mensajePassword="Contraseña incorrecta.";
		}
		if(!passwordNueva.equals(confirmarPassword) && mensajePassword.equals("")) {
			mensajePassword="Las contraseñas no coinciden.";
		}
		if(mensajePassword.equals("")) {
			String passwordValida=UsuarioUtil.obtenerSha2(passwordNueva);
			UsuarioServicio.cambiarPassword(usuarioActual.getEmail(), passwordValida);
			mensajePassword="Contraseña cambiada.";
		}
		
			request.setAttribute("mensajePassword", mensajePassword);
		
		request.getRequestDispatcher("pages/cambiarPassword.jsp").forward(request, response);
	}

}
