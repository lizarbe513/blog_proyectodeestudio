package com.unu.blog.models;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexionBDD {
	
	private String url = "jdbc:mysql://localhost:3306/blogsdatabase";
	private String usuario = "root";
	private String password = "123456";
	protected Connection ConexionBDD;
	
	public void abrirconexionBDD (){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			ConexionBDD = DriverManager.getConnection(url, usuario, password);
			System.out.println("CONEXION EXITOSA!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void cerrarconexionBDD () {
		try {
			if (ConexionBDD != null && !ConexionBDD.isClosed()) {
				ConexionBDD.close();
				System.out.println("CERRO SU CONEXION EXITOSAMENTE!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}