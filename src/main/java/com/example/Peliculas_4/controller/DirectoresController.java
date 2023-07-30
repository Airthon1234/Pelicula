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

import com.example.Peliculas_4.model.bd.Directores;
import com.example.Peliculas_4.model.request.DirectoresRequest;
import com.example.Peliculas_4.model.response.ResultadoDirectoresResponse;
import com.example.Peliculas_4.service.DirectoresService;

@Controller
@RequestMapping("/directores")
public class DirectoresController {

	@Autowired
	private DirectoresService directoresService;
	
	@GetMapping("/frmdirector")
	public String frmMantDirector(Model model) {
		model.addAttribute("listardirectores", directoresService.listarDirectores());
		return "director/frmdirector";
	}
	
	@PostMapping("/registrardirector")
	@ResponseBody
	public ResultadoDirectoresResponse registrarDirector(@RequestBody DirectoresRequest directoresRequest) {
		String mensaje="Registro de Director exitoso!!";
		Boolean respuesta=true;
		
		try {
			Directores objdirector = new Directores();
			if (directoresRequest.getIddirector() !=null && directoresRequest.getIddirector() > 0) {
				objdirector.setIddirector(directoresRequest.getIddirector());
			}
			objdirector.setNombredirector(directoresRequest.getNombredirector());
			objdirector.setApellidodirector(directoresRequest.getApellidodirector());
			directoresService.registrarDirector(objdirector);
			
		} catch (Exception e) {
			mensaje="Registro director sin exito!!";
			respuesta=false;
		}
		return ResultadoDirectoresResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
		
	}
	
	
	
	@DeleteMapping("/eliminarDirector")
	@ResponseBody
	public ResultadoDirectoresResponse eliminarDirector(@RequestBody DirectoresRequest directoresRequest) {
		String mensaje="Eliminar Director exitoso!!";
		Boolean respuesta=true;
		try {
			directoresService.eliminarDirector(directoresRequest.getIddirector());
		} catch (Exception e) {
			mensaje="Eliminar Directores sin Exito!!";
			respuesta= false;
		}
		return ResultadoDirectoresResponse.builder().mensaje(mensaje).respuesta(respuesta).build();
	}
	
	@GetMapping("/listarDirectors")
	@ResponseBody
	public List<Directores> listarDirectores(){
		return directoresService.listarDirectores();
	}
}
