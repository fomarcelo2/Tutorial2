<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="UsuarioController" method="post">
		<label>Nombre: </label> <input type="text" name="nombre"> <br><br>
		<label>Apellido: </label> <input type="text" name="apellido"><br><br>
		<label>Edad: </label> <input type="text" name="edad"><br><br>
		<label>Correo: </label> <input type="text" name="correo"><br><br>
		<label>Usuario: </label> <input type="text" name="usuario"><br><br>
		<label>Clave: </label> <input type="text" name="clave"><br><br>
		<input type="submit" value="Enviar">
	</form>
</body>
</html>