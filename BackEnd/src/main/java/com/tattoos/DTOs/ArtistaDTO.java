package com.tattoos.DTOs;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.tattoos.models.Artista;

import jakarta.persistence.Column;
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
		private String photoURL ;
	    private String nome;
	    private String cpf;
	    private Date data;
	    private String email;
	    private String escolaridade;
	    private String profissao;
	    private String telefone;
		
		public ArtistaDTO(Artista obj) {
			id = obj.getId();
			nome = obj.getNome();
			photoURL = obj.getPhotoURL();
			cpf = obj.getCpf();
			data = obj.getData();
			email = obj.getEmail();
			escolaridade = obj.getEscolaridade();
			profissao = obj.getProfissao();
			telefone = obj.getTelefone();
			

		}
}
