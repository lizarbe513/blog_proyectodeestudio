<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.unu.blog.controllers.blogcontrolador"%>
<%@ page import="com.unu.blog.beans.post"%>
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

<h3>Agregar nuevo post:</h3>

<form action="<%=url%>blogcontrolador" method="post">
	<input type="hidden" name="tipooperacion" value="enviarnuevopost">
	
    <label for="name">name:</label>
    <input type="text" id="name" name="postname" required><br>
    
    <label for="content">Contenido:</label>
    <textarea id="content" name="postcont" required></textarea><br>
    
    <input type="submit" value="Guardar">
</form>

<a href="<%=url %>blogcontrolador?tipooperacion=obtenerlista">Retornar</a>
	
</body>
</html>