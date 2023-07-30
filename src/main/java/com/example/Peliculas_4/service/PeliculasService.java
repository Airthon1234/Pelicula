package com.example.Peliculas_4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Peliculas_4.model.bd.Peliculas;
import com.example.Peliculas_4.repository.PeliculasRepository;

@Service
public class PeliculasService {

	@Autowired
	private PeliculasRepository peliculasRepository;
	
	// CRUD DE PELICULAS
	public List<Peliculas> listarPelicula(){
		return peliculasRepository.findAll();
	}
	public void registrarPelicula(Peliculas peliculas) {
		peliculasRepository.save(peliculas);
	}
	public void eliminarPelicula(Integer idpelicula) {
		peliculasRepository.deleteById(idpelicula);
	}
	
	//listar directores y generos
	public List<Peliculas> listarPeliculasPorDirectores(Integer iddirector){
		return peliculasRepository.findByDirectoresIddirector(iddirector);
	}
	
	public List<Peliculas> listarPeliculasPorGeneros(Integer idgenero){
		return peliculasRepository.findByGenerosIdgenero(idgenero);
	}
}
