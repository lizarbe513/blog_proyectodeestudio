package com.unu.blog.beans;

public class post {
	private String name;
	private String postcontenido;
	
	public post() {
	}
	
	public post(String name, String postcontenido) {
		this.name = name;
		this.postcontenido = postcontenido;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPostcontenido() {
		return postcontenido;
	}

	public void setPostcontenido(String postcontenido) {
		this.postcontenido = postcontenido;
	}

	
	
}
