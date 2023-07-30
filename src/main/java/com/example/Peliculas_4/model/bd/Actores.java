package com.example.Peliculas_4.model.bd;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="actores")
public class Actores {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idactor")
	private Integer idactor;
	@Column(name="nombreactor")
	private String nombreactor;
	@Column(name="apellidoactor")
	private String apellidoactor;

}
