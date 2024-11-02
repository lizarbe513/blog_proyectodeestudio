<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="com.unu.blog.beans.post"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>blog punto com</title>
</head>
<body>
	<div>
		<h1>BLOG PUNTO COM</h1>
		<%
		List<post> listaconlospost = (List<post>) request.getAttribute("lista");
		%>
		<h3>Posts recientes:</h3>
		<%
		if (listaconlospost != null) {
			for (post posti : listaconlospost) {
		%>
		
		<h3>(<%=posti.getId()%>)<%=posti.getName()%></h3>
		<p><%=posti.getPostcontenido()%></p>
		<%
		}
		} else {
		%>
		<h4>No hay nada</h4>
		<%
		}
		%>
	</div>
	<div>
	<a href="posts/nuevopost.jsp" class="boton">Agregar nuevo post</a>
	<a href="posts/eliminarpost.jsp" class="boton">Eliminar post</a>
	</div>
</body>
</html>