package com.example.Peliculas_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Peliculas_4.model.bd.Directores;

@Repository
public interface DirectoresRepository extends JpaRepository<Directores, Integer>{

}
