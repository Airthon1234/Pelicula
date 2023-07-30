package com.example.Peliculas_4.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Peliculas_4.model.bd.Peliculas;

@Repository
public interface PeliculasRepository extends JpaRepository<Peliculas, Integer>{

	List<Peliculas> findByDirectoresIddirector(Integer iddirector);
	
	List<Peliculas> findByGenerosIdgenero(Integer idgenero);

}
