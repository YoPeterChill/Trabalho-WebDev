package com.tattoos.DTOs;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.tattoos.models.Artista;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
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
	@NotBlank
		private String senha;
	@NotBlank
		private String photoURL;
	@NotBlank
	    private String nome;
	@NotBlank
	    private String cpf;
	@NotBlank
	    private Date data;
	@NotBlank
	    private String email;
	@NotBlank
	    private String escolaridade;
	@NotBlank
	    private String profissao;
	@NotBlank
	    private String telefone;
		
		public ArtistaDTO(Artista obj) {
			this.id = obj.getId();
			this.senha = obj.getSenha();
			this.nome = obj.getNome();
			this.cpf = obj.getCpf();
			this.data = obj.getData();
			this.email = obj.getEmail();
			this.escolaridade = obj.getEscolaridade();
			this.profissao = obj.getProfissao();
			this.telefone = obj.getTelefone();
			

		}
}
