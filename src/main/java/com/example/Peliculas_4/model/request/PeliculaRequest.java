package com.example.Peliculas_4.model.request;

import lombok.Data;

@Data
public class PeliculaRequest {
	
	private Integer idpelicula;
	
	private String titulopelicula;
	private String duracion;
	private String sinopsis;
	
	private Integer iddirector;
	
	private Integer idgenero;
}
