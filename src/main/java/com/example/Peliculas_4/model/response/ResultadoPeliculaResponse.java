package com.example.Peliculas_4.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultadoPeliculaResponse {
	
	private Boolean respuesta;
	private String mensaje;

}
