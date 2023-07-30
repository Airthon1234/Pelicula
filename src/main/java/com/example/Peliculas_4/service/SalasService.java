package com.example.Peliculas_4.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Peliculas_4.model.bd.Salas;
import com.example.Peliculas_4.repository.SalasRepository;

@Service
public class SalasService {

	@Autowired
	private SalasRepository salasRepository;
	
	public List<Salas> listarSalas(){
		return salasRepository.findAll();
	}
	public void registrarSalas(Salas salas) {
		salasRepository.save(salas);
	}
	public void eliminarSalas(Integer idsala) {
		salasRepository.deleteById(idsala);
	}
}
