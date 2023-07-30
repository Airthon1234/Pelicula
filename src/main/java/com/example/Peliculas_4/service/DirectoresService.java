package com.example.Peliculas_4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Peliculas_4.model.bd.Directores;
import com.example.Peliculas_4.repository.DirectoresRepository;

@Service
public class DirectoresService {

	@Autowired
	private DirectoresRepository directoresRepository;
	
	public List<Directores> listarDirectores(){
		return directoresRepository.findAll();
	}
	public void registrarDirector(Directores directores) {
		directoresRepository.save(directores);
	}
	
	public void eliminarDirector(Integer iddirector) {
		directoresRepository.deleteById(iddirector);
	}
	
	
}
