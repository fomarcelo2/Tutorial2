package co.com.tutorial2.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



import co.com.tutorial2.dao.UsuarioDao;
import co.com.tutorial2.model.Usuario;


/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/UsuarioController")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	UsuarioDao usuarioDao;
	
	public void init() {
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		
		try {
			usuarioDao = new UsuarioDao(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsuarioController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = 0;
		
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		int edad = Integer.parseInt(request.getParameter("edad"));
		String correo = request.getParameter("correo");
		String usuario = request.getParameter("usuario");
		String clave = request.getParameter("clave");
		
		if (!nombre.equalsIgnoreCase("")&& !apellido.equalsIgnoreCase("") && !correo.equalsIgnoreCase("")
				&& !usuario.equalsIgnoreCase("") && !clave.equalsIgnoreCase("")) {
			Usuario usuarioIn = new Usuario(id,nombre, apellido, edad, correo, usuario, clave);
			
			try {
				boolean sw = usuarioDao.insertarUsuario(usuarioIn);
				
				if (sw) {
					request.getRequestDispatcher("/jsp/Mensaje.jsp").forward(request, response);
				}else {
					PrintWriter out = response.getWriter();
					out.println("No se pudo agregar usuario.");
				}
			} catch (SQLException e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}
			
			
			
		}
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	


}
