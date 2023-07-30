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
@Table(name="salas")
public class Salas {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idsala")
	private Integer idsala;
	@Column(name="nombresala")
	private String nombresala;
	@Column(name="capacidad")
	private Integer capacidad;

}
