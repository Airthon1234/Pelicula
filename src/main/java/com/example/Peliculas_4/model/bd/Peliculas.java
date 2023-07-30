package com.example.Peliculas_4.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="peliculas")
public class Peliculas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idpelicula")
	private Integer idpelicula;
	@Column(name="titulopelicula")
	private String titulopelicula;
	@Column(name="duracion")
	private Integer duracion;
	@Column(name="sinopsis")
	private String sinopsis;
	
	@ManyToOne
	@JoinColumn(name="iddirector")
	private Directores directores;
	
	@ManyToOne
	@JoinColumn(name="idgenero")
	private Generos generos;
}
