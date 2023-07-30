package com.example.Peliculas_4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String Redirecthome() {
		return "redirect:/home";
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
