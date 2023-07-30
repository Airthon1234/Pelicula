package com.example.Peliculas_4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Peliculas_4.model.bd.Generos;
import com.example.Peliculas_4.repository.GenerosRepository;

@Service
public class GenerosService {

	@Autowired
	private GenerosRepository generosRepository;
	
	public List<Generos> listarGeneros(){
		return generosRepository.findAll();
	}
	public void registrarGenero(Generos generos) {
		generosRepository.save(generos);
	}
	public void eliminarGenero(Integer idgenero) {
		generosRepository.deleteById(idgenero);
	}
}
