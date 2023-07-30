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

import com.example.Peliculas_4.model.bd.Salas;
import com.example.Peliculas_4.model.request.SalasRequest;
import com.example.Peliculas_4.model.response.ResultadoSalasResponse;
import com.example.Peliculas_4.service.SalasService;

@Controller
@RequestMapping("/sala")
public class SalasController {

	@Autowired
	private SalasService salasService;
	
	@GetMapping("/frmsala")
	public String frmMantSala(Model model) {
		model.addAttribute("listarsala", salasService.listarSalas());
		return "sala/frmsala";
	}
	@PostMapping("/registrarSalas")
	@ResponseBody
	public ResultadoSalasResponse registrarSalas(@RequestBody SalasRequest salasRequest) {
		String mensaje="Registro de Sala exito!!";
		Boolean respuesta=true;
		try {
			Salas objsalas= new Salas();
			if(salasRequest.getIdsala() !=null && salasRequest.getIdsala() > 0);{
			objsalas.setIdsala(salasRequest.getIdsala());
			}
			objsalas.setNombresala(salasRequest.getNombresala());
			objsalas.setCapacidad(salasRequest.getCapacidad());
		} catch (Exception e) {
			mensaje="Registro de Sala sin exito error!!!";
			respuesta=false;
		}
		return ResultadoSalasResponse
				.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@DeleteMapping("/eliminarSalas")
	@ResponseBody
	public ResultadoSalasResponse eliminarSalas(@RequestBody SalasRequest salasRequest) {
		String mensaje="Registrar sala exito!!";
		Boolean respuesta=true;
		try {
			salasService.eliminarSalas(salasRequest.getIdsala());
		} catch (Exception e) {
			mensaje="eliminar sala sin exito error!!!";
			respuesta=false;
		}
		return ResultadoSalasResponse
				.builder()
				.mensaje(mensaje)
				.respuesta(respuesta)
				.build();
	}
	@GetMapping("/listarsalas")
	@ResponseBody
	public List<Salas> listarSalas(){
		return salasService.listarSalas();
	}
	
}
