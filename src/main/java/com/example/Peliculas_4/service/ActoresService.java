package com.example.Peliculas_4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Peliculas_4.model.bd.Actores;
import com.example.Peliculas_4.repository.ActoresRepository;

@Service
public class ActoresService {

	@Autowired
	private ActoresRepository actoresRepository;
	
	public List<Actores> listarActores(){
		return actoresRepository.findAll();
	}
	public void registrarActores(Actores actores) {
		actoresRepository.save(actores);
	}
	public void eliminarActores(Integer idactor) {
		actoresRepository.deleteById(idactor);
	}
}
