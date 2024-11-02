package com.unu.blog.models;

import java.util.List;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.unu.blog.beans.post;

public class modelodeposts extends ConexionBDD {
	CallableStatement ejecutarconsulta;
	ResultSet contenidobd;
	
	public List<post> obtenerlistadeposts(){
		try {
			List<post> listaretornar = new ArrayList<>();
			this.abrirconexionBDD();
			ejecutarconsulta = ConexionBDD.prepareCall("select * from post");
			contenidobd = ejecutarconsulta.executeQuery();
			while (contenidobd.next()) {
				post posti = new post();
				posti.setName(contenidobd.getString("postname"));
				posti.setPostcontenido(contenidobd.getString("postcont"));
				posti.setId(contenidobd.getInt("idpost"));
				listaretornar.add(posti);
			}
			this.cerrarconexionBDD();
			return listaretornar;
		} catch (Exception e) {
			return null;
		}
	}
	
	public void nuevopost(post newpost) {
		try {
			this.abrirconexionBDD();
			ejecutarconsulta = ConexionBDD.prepareCall("insert into post(postname, postcont) values ('"+newpost.getName()+"', '"+newpost.getPostcontenido()+"')");
			ejecutarconsulta.execute();
			this.cerrarconexionBDD();
		} catch (Exception e) {
			e.getMessage();
		}
	}
	
	public void eliminarpost(int ideliminar) {
		try {
			this.abrirconexionBDD();
			ejecutarconsulta = ConexionBDD.prepareCall("call sp_eliminarpost(?)");
			ejecutarconsulta.setInt(1, ideliminar);
			ejecutarconsulta.execute();
			this.cerrarconexionBDD();
		} catch (Exception e) {
			e.getMessage();
		}
	}
}
