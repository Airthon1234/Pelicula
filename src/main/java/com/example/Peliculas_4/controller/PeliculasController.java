package com.example.Peliculas_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
