package com.example.Peliculas_4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
