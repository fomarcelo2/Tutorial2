package co.com.tutorial2.model;

public class Usuario {
	
	private int idUsuario;
	
	private String nombre;
	private String apellido;
	private int edad;
	private String correo;
	private String usuario;
	private String clave;
	
	
	
	
	
	public Usuario(int idUsuario, String nombre, String apellido, int edad, String correo, String usuario,
			String clave) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.correo = correo;
		this.usuario = usuario;
		this.clave = clave;
	}





	public int getIdUsuario() {
		return idUsuario;
	}





	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getApellido() {
		return apellido;
	}





	public void setApellido(String apellido) {
		this.apellido = apellido;
	}





	public int getEdad() {
		return edad;
	}





	public void setEdad(int edad) {
		this.edad = edad;
	}





	public String getCorreo() {
		return correo;
	}





	public void setCorreo(String correo) {
		this.correo = correo;
	}





	public String getUsuario() {
		return usuario;
	}





	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}





	public String getClave() {
		return clave;
	}





	public void setClave(String clave) {
		this.clave = clave;
	}
	
	
	
	


}
