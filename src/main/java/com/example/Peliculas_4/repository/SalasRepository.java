package com.example.Peliculas_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Peliculas_4.model.bd.Salas;

@Repository
public interface SalasRepository extends JpaRepository<Salas, Integer>{

}
