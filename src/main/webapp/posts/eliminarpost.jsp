<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url="http://localhost:8080/blog/";
%>
<h3>Elimina un post:</h3>

<form action="<%=url%>blogcontrolador" method="post">
	<input type="hidden" name="tipooperacion" value="eliminarpost">
	
	<label for="eliminar">Elimina Post: </label>
	<input type="text" id="eliminar" name="idposteliminar" required>
	
	<input type="submit" value="enviareliminar">
</form>
</body>
</html>