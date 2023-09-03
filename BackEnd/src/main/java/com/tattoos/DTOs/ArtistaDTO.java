package com.tattoos.DTOs;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;

import com.tattoos.models.Artista;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ArtistaDTO extends RepresentationModel <ArtistaDTO> implements Serializable {
	private static final long serialVersionUID = 1L;
	@EqualsAndHashCode.Include
		private int id;	
		private String nome ;
		private String photoURL ;
		private String endereco ;
		public ArtistaDTO(Artista obj) {
			id = obj.getId();
			nome = obj.getNome();
			photoURL = obj.getPhotoURL();
			endereco = obj.getEndereco();
		}
}
