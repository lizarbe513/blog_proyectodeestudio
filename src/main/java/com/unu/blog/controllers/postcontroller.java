package com.unu.blog.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.unu.blog.models.postmodel;

@WebServlet("/postcontroller")
public class postcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	postmodel modelodeposts = new postmodel();
	

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//---
		response.setContentType("text/html;charset=UTF-8");
		//---
		
		try (PrintWriter out = response.getWriter()) {
			if (request.getParameter("op") == null) {
				listar(request, response);
				return;
			}
			String operation = request.getParameter("op");
			switch (operation) {
			case "listar":
				listar(request, response);
				break;
			}
		}

	}

	private void listar(HttpServletRequest request, HttpServletResponse response) {
		try {
			request.setAttribute("listapost", modelodeposts.listarpost());
			request.getRequestDispatcher("/posts/listadeposts.jsp").forward(request, response);
		} catch (ServletException | IOException ex) {
			System.out.println("algo malio sal en el metodo listar en la clase postcontroller");
		}
	}

	public postcontroller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
