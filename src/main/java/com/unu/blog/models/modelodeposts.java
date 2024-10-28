package com.unu.blog.models;

import java.util.List;
import java.util.ArrayList;
import com.unu.blog.beans.post;

public class modelodeposts {
	
	public List<post> obtenerlistadeposts(){
		ArrayList<post> listadeposts = new ArrayList<>();
		listadeposts.add(new post("Hoy estoy cansado...","Hoy estoy cansado, la verdad, estoy contento de "
				+ "haber llegado a casa otro dia mas, ire a dormir y para mañana lo que sigue."));
		listadeposts.add(new post("Hoy fue un dia espectacular!","Hoy fue un dia increible!, la verdad estoy"
				+ " muy contento hoy, ojala mañana fuera igual, en fin, hora de dormir."));
		return listadeposts;
	}
}
