package com.example.Peliculas_4.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Peliculas_4.model.bd.Directores;
import com.example.Peliculas_4.model.bd.Generos;
import com.example.Peliculas_4.model.bd.Peliculas;
import com.example.Peliculas_4.model.request.PeliculaRequest;
import com.example.Peliculas_4.model.response.ResultadoPeliculaResponse;
import com.example.Peliculas_4.service.PeliculasService;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private PeliculasService peliculasService;
	
	@GetMapping("/frmpelicula")
	public String frmMantPeliculas(Model model) {
		model.addAttribute("listarpelicula", peliculasService.listarPelicula());
		return "pelicula/frmpelicula";
	}
	
	@PostMapping("/registrarpelicula")
	@ResponseBody
	public ResultadoPeliculaResponse registrarPelicula(@RequestBody PeliculaRequest peliculaRequest) {
		String mensaje="Registro de pelicula exitoso !!!!";
		Boolean respuesta=true;
		try {
			Peliculas objPeliculas=new Peliculas();
			if (peliculaRequest.getIdpelicula() !=null && peliculaRequest.getIdpelicula() > 0) {
				objPeliculas.setIdpelicula(peliculaRequest.getIdpelicula());
			}
			objPeliculas.setTitulopelicula(peliculaRequest.getTitulopelicula());
			objPeliculas.setDuracion(peliculaRequest.getDuracion());
			objPeliculas.setSinopsis(peliculaRequest.getSinopsis());
			Directores objDirectores = new Directores();
			objDirectores.setIddirector(peliculaRequest.getIddirector());
			objPeliculas.setDirectores(objDirectores);
			Generos objGeneros = new Generos();
			objGeneros.setIdgenero(peliculaRequest.getIdgenero());
			objPeliculas.setGeneros(objGeneros);
			peliculasService.registrarPelicula(objPeliculas);
		} catch (Exception e) {
			mensaje="Registro de la pelicula error sin exito!!!!";
			respuesta=false;
		}
		return ResultadoPeliculaResponse
				.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarpelicula")
	@ResponseBody
	public ResultadoPeliculaResponse eliminarPelicula(@RequestBody PeliculaRequest peliculaRequest) {
		String mensaje="Eliminado Con Exito!!!";
		Boolean respuesta=true;
		try {
			peliculasService.eliminarPelicula(peliculaRequest.getIdpelicula());
		} catch (Exception e) {
			mensaje="Eliminado Fallido Error!!!";
			respuesta=false;
		}
		return ResultadoPeliculaResponse
				.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@GetMapping("/listarPelicula")
	@ResponseBody
	public List<Peliculas> listarPelicula(){
		return peliculasService.listarPelicula();
	}
	
	@GetMapping("/listarPeliculaPorDirector")
	@ResponseBody
	public List<Peliculas> listarPeliculaPorIdentidad(@RequestParam("iddirector") Integer iddirector){
		System.out.print(iddirector);
		return peliculasService.listarPeliculasPorDirectores(iddirector);
	}
	@GetMapping("/listarPeliculaPorGenero")
	@ResponseBody
	public List<Peliculas> listarPeliculaPorIdgenero(@RequestParam("idgenero") Integer idgenero){
		System.out.print(idgenero);
		return peliculasService.listarPeliculasPorGeneros(idgenero);
	}
}
