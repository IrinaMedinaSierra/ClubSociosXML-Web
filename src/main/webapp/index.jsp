<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Club de Socios WEB</title>
</head>
<body>
	<h1>Club de Socios Web</h1>
	
	<form action="ControllerWeb" method="post"  enctype="multipart/form-data">
	
	<label for="archivo">Archivo XML</label>
	<input type="file" accept=".xml" name="archivo" id="archivo">
	
	<input type="submit" name="enviar" value="enviar">
	
	
	
	
	
	
	</form>
</body>
</html>