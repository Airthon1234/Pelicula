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
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Peliculas_4.model.bd.Generos;
import com.example.Peliculas_4.model.request.GenerosRequest;
import com.example.Peliculas_4.model.response.ResultadoGenerosResponse;
import com.example.Peliculas_4.service.GenerosService;

@Controller
@RequestMapping("/genero")
public class GenerosController {

	@Autowired
	private GenerosService generosService;
	
	@GetMapping("/frmgenero")
	public String frmMantGenero(Model model) {
		model.addAttribute("listargeneros", generosService.listarGeneros());
		return "genero/frmgenero";
	}
	
	@PostMapping("/registrargenero")
	@ResponseBody
	public ResultadoGenerosResponse registrarGenero(@RequestBody GenerosRequest generosRequest) {
		String mensaje="Registro de genero Exito!!";
		Boolean respuesta=true;
		try {
			Generos objgeneros= new Generos();
			if (generosRequest.getIdgenero() !=null && generosRequest.getIdgenero() > 0) {
				objgeneros.setIdgenero(generosRequest.getIdgenero());
			}
			objgeneros.setNombregenero(generosRequest.getNombregenero());
			generosService.registrarGenero(objgeneros);
		} catch (Exception e) {
			mensaje="registro genero sin exito!!";
			respuesta=false;
		}
		return ResultadoGenerosResponse
				.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	
	@DeleteMapping("/eliminarGenero")
	@ResponseBody
	public ResultadoGenerosResponse eliminarGenero(@RequestBody GenerosRequest generosRequest) {
		String mensaje="Eliminar Genero Exitoso!!";
		Boolean respuesta=true;
		try {
			generosService.eliminarGenero(generosRequest.getIdgenero());
		} catch (Exception e) {
			mensaje="Eliminar Genero sin exito error!!!";
			respuesta=false;
		}
		return ResultadoGenerosResponse
				.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarGeneros")
	@ResponseBody
	public List<Generos> listarGeneros(){
		return generosService.listarGeneros();
	}
}
