<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import= "com.vaadin.LoginFields" %> 
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>FCJP inc.</title>
</head>
<body>
		<li><b><a style="FONT-SIZE: xx-large;">Bienvenidos.</a></b></li>>
		<li><a style="FONT-SIZE: large;">Pagina de inicio donde se montará nuestra aplicación.</a></li>>
		
		<li>
			<input id="username" name="username" placeholder="Usuario"
			title="Email" type="text" value="" size="40"/>
			<input id="password" name="password" placeholder="Constraseña"
			title="password" type="text" value="" size="40"/>
			<%LoginFields campoUsuario = new LoginFields(); %>
		</li>
	
		
</body>
</html>