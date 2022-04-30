package curso.java.controlador;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import curso.java.modelo.RolDB;
import curso.java.modelo.Usuario;
import curso.java.modelo.UsuarioDB;
import curso.java.servicio.UsuarioServicio;
import curso.java.util.ValidacionFormularios;

/**
 * Servlet implementation class ServletRegistro
 */
@WebServlet("/ServletRegistro")
public class ServletRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletRegistro() {
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
		String email=request.getParameter("email");
		String nombre=request.getParameter("nombre");
		String apellido1=request.getParameter("apellido1");
		String apellido2=request.getParameter("apellido2");
		String direccion=request.getParameter("direccion");
		String provincia=request.getParameter("provincia");
		String localidad=request.getParameter("localidad");
		String telefono=request.getParameter("telefono");
		String dni=request.getParameter("dni");
		String password=request.getParameter("password");
		String confirmarPassword=request.getParameter("confirmarPassword");
		
		HashMap<String, String> errores=new HashMap<>();
		errores.put("email", ValidacionFormularios.validarEmail(email, true));
		errores.put("nombre", ValidacionFormularios.comprobarAlfabetico(nombre, true));
		errores.put("apellido1", ValidacionFormularios.comprobarAlfabetico(apellido1, true));
		errores.put("apellido2", ValidacionFormularios.comprobarAlfabetico(apellido2, true));
		errores.put("direccion", ValidacionFormularios.comprobarObligatorio(direccion));
		errores.put("provincia", ValidacionFormularios.comprobarAlfabetico(provincia, true));
		errores.put("localidad", ValidacionFormularios.comprobarAlfabetico(localidad, true));
		errores.put("telefono", ValidacionFormularios.validarTelefono(telefono, true));
		errores.put("dni", ValidacionFormularios.validarDni(dni, true));
		errores.put("password",ValidacionFormularios.comprobarObligatorio(password));
		errores.put("confirmarPassword", confirmarPassword.equals(password)?null:"Las contraseñas no coinciden");
		
		
		
		
		
		if(!ValidacionFormularios.hayErrores(errores)) {
			Usuario usuarioValido= new Usuario(email, UsuarioServicio.obtenerRol(1),password,nombre,apellido1,apellido2,direccion,provincia,localidad,telefono,dni);
			UsuarioServicio.altaUsuario(usuarioValido);
			request.getSession().setAttribute("usuarioTienda",usuarioValido);
			request.getRequestDispatcher("").forward(request, response);
		}
		else {
			request.setAttribute("errores", errores);
			request.getRequestDispatcher("pages/registro.jsp").forward(request, response);
		}
		
	}

}
