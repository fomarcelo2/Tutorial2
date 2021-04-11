package co.com.tutorial2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import co.com.tutorial2.model.Usuario;
import co.com.tutorial2.utils.Conexion;

public class UsuarioDao {
	
	
	private Conexion con;
	private Connection connection;
	
	public UsuarioDao(String jdbcURL, String jdbcUsername, String jdbcPassword) {
		System.out.println();
		con = new Conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	
	
	//insert usuario
	public boolean insertarUsuario(Usuario usuario) throws SQLException {
		
		String sql = "insert into usuario(id_usuario,nombre,apellido,edad,correo,usuario,clave) values (?,?,?,?,?,?,?)";
		
		con.conectar();
		
		connection = con.getJdbcConnection();
		
		PreparedStatement statement = connection.prepareStatement(sql);
		
		statement.setString(1, null);
		statement.setString(2, usuario.getNombre());
		statement.setString(3, usuario.getApellido());
		statement.setInt(4, usuario.getEdad());
		statement.setString(5, usuario.getCorreo());
		statement.setString(6, usuario.getUsuario());
		statement.setString(7, usuario.getClave());
		
		
		boolean rowInserted = statement.executeUpdate() > 0;
		
		statement.close();
		con.desconectar();
		
		return rowInserted;
		
	}
	
	
	//listar usuario
	
	public List<Usuario> listarUsuario() throws SQLException{
		
		
		List<Usuario> listarUsuarios = new ArrayList<Usuario>();
		
		
		
		String sql = "Select * from usuario";
		
		con.conectar();
		
		
		
		connection = con.getJdbcConnection();
		
		Statement statement = connection.createStatement();
		
		ResultSet resulSet = statement.executeQuery(sql);
		
		while (resulSet.next()) {
			int id = resulSet.getInt("id_usuario");
			
			String nombre = resulSet.getString("nombre");
			String apellido = resulSet.getString("apellido");
			int edad = resulSet.getInt("edad");
			
			String correo = resulSet.getString("correo");
			String usuarioBD = resulSet.getString("usuario");
			String clave = resulSet.getString("clave");
			
			Usuario usuario = new Usuario(id, nombre, apellido, edad, correo, usuarioBD, clave);
			
			listarUsuarios.add(usuario);
			
		}
		
		con.desconectar();
		return listarUsuarios;
		
	}
	
	

}
