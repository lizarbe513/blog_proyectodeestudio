<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.unu.blog.controllers.blogcontrolador"%>
<%@ page import="com.unu.blog.beans.post"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function validarFormulario (){
		 const nombre = document.getElementById('postname').value.trim();
		 const postcont = document.getElementById('postcont').value.trim();
		 
		 if(nombre === ''){
			 alert('Ingrese nombre del post');
			 document.getElementById('postname').focus();
			 return false;
		 }
		 
		 return true;
	}
</script>

</head>
<body>
<%
	String url="http://localhost:8080/blog/"; 
	if(request.getParameter("respuesta")!=null){
		boolean respuesta=(boolean) request.getAttribute("respuesta");
		if(respuesta){
			List<String> listadeerrores = (List<String>) request.getAttribute("listadeerrores");
			for(String errori: listadeerrores){
				%>
				<span><%=errori %></span>
				<br>
				<%
			}
		}
	}
%>

<h3>Agregar nuevo post:</h3>

<form action="<%=url%>blogcontrolador" method="post" onsubmit="return validarFormulario()">
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