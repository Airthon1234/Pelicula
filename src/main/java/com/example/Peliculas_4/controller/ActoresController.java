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

import com.example.Peliculas_4.model.bd.Actores;
import com.example.Peliculas_4.model.request.ActoresRequest;
import com.example.Peliculas_4.model.response.ResultadoActoresResponse;
import com.example.Peliculas_4.service.ActoresService;

@Controller
@RequestMapping("/actor")
public class ActoresController {

	@Autowired
	private ActoresService actoresService;
	
	@GetMapping("/frmactor")
	public String frmMantActor(Model model) {
		model.addAttribute("listaractor", actoresService.listarActores());
		return "actor/frmactor";
	}
	
	@PostMapping("/registraractor")
	@ResponseBody
	public ResultadoActoresResponse registrarActores(@RequestBody ActoresRequest actoresRequest) {
		String mensaje="Registro de actor con exito!!!";
		Boolean respuesta=true;
		try {
			Actores objactores= new Actores();
			if (actoresRequest.getIdactor() !=null && actoresRequest.getIdactor() > 0) {
				objactores.setIdactor(actoresRequest.getIdactor());
			}
			objactores.setNombreactor(actoresRequest.getNombreactor());
			objactores.setApellidoactor(actoresRequest.getApellidoactor());
			actoresService.registrarActores(objactores);
		} catch (Exception e) {
			mensaje="registro de actor sin exito error!!!";
			respuesta=false;
		}
		return ResultadoActoresResponse
				.builder()
				.respuesta(respuesta)
				.mensaje(mensaje)
				.build();
	}
	
	@DeleteMapping("/eliminaractor")
	@ResponseBody
	public ResultadoActoresResponse eliminarActor(@RequestBody ActoresRequest actoresRequest) {
		String mensaje="Registro de Actor Eliminado!!!";
		Boolean respuesta=true;
		try {
			actoresService.eliminarActores(actoresRequest.getIdactor());
		} catch (Exception e) {
			mensaje="Registro de eliminacion error!!";
			respuesta=false;
		}
		return ResultadoActoresResponse
				.builder()
				.respuesta(respuesta)
				.mensaje(mensaje)
				.build();
	}
	
	@GetMapping("/listarActores")
	@ResponseBody
	public List<Actores> listarActores(){
		return actoresService.listarActores();
	}
}
