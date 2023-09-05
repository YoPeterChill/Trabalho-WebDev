package com.tattoos.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table(name="tattoos")
public class ModelTattoos implements Serializable{
	private static final long serialVersionUID = 1L;
public enum Status{
	ANDAMENTO,PAGO, CANCELADO
}


@Id
@EqualsAndHashCode.Include
@GeneratedValue(strategy = GenerationType.IDENTITY)
@Column(name="id")	
private int id;
@Column(name="local")
	private String local ;
@Column(name="espec")
	private String especificacoes ;
@Column(name="ref")
	private String referenciasURL ;
@Column(name="height")
	private Float altura ;
@Column(name="width")
	private Float largura ;
@Column(name="status")
	private Status status;

@OneToMany(mappedBy = "tattoos")
private List<Artista> artista = new ArrayList<>();

public ModelTattoos(int id, String local, String especificacoes, String referenciasURL, Float altura, Float largura,
		Status status) {
	super();
	this.id = id;
	this.local = local;
	this.especificacoes = especificacoes;
	this.referenciasURL = referenciasURL;
	this.altura = altura;
	this.largura = largura;
	this.status = status;
}

}
