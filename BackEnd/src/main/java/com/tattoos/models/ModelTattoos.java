package com.tattoos.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@Entity
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
}
