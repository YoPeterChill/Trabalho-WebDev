package com.tattoos.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Entity
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name="artista")
public class Artista implements Serializable{
	private static final long serialVersionUID = 1L;


@Id
@EqualsAndHashCode.Include
@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
@Column(name="nome")
	private String nome ;
@Column(name="photoURL")
	private String photoURL ;
@Column(name="endereco")
	private String endereco ;



}
