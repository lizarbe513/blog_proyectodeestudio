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

    public blogcontrolador() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		modelodeposts modelo = new modelodeposts();
		List<post> posts = modelo.obtenerlistadeposts();
		System.out.println("tamaño de la lista: "+posts.size());
		request.setAttribute("lista", posts);
		request.getRequestDispatcher("posts/listadeposts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
