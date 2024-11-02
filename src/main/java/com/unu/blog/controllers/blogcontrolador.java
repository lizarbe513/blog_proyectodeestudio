package com.unu.blog.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import com.unu.blog.beans.post;
import com.unu.blog.models.modelodeposts;

public class blogcontrolador extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	modelodeposts modelo = new modelodeposts();

    public blogcontrolador() {
        super();
    }
    
    protected void processRequest (HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	if (request.getParameter("tipooperacion") == null) {
    		obtenerlista(request, response);
			return;
		}
    	
		String tipooperacion = request.getParameter("tipooperacion");
		System.err.println("esta es la operacion: "+tipooperacion);
		switch (tipooperacion) {

		case "obtenerlista":
			obtenerlista(request, response);
			break;

		case "enviarnuevopost":
			enviarnuevopost(request, response);
			break;
			
		case "eliminarpost":
			eliminarpost(request, response);
			break;

		}
    }
    
    private void obtenerlista(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.setAttribute("lista", modelo.obtenerlistadeposts());
		request.getRequestDispatcher("/posts/listadeposts.jsp").forward(request, response);
	}
    
    public void enviarnuevopost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String postname = request.getParameter("postname");
        String postcont = request.getParameter("postcont");
        post nuevoPost = new post(postname, postcont);
    	if (nuevoPost != null) {
            modelo.nuevopost(nuevoPost);
            obtenerlista(request, response);
        }
	}
    
    public void eliminarpost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException{
    	int ideliminar = Integer.parseInt(request.getParameter("idposteliminar"));
    	if(ideliminar > 0) {
    		modelo.eliminarpost(ideliminar);
    		obtenerlista(request, response);
    	}
    }
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	

}
