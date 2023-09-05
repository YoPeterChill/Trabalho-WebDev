package com.tattoos.DTOs;


import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.tattoos.models.Pessoa;

import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
@NoArgsConstructor
public class PessoaDTO extends RepresentationModel<PessoaDTO> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	private int Id;
	
	@NotBlank
	private String senha;
	
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

	public PessoaDTO(Pessoa obj) {
		this.Id = obj.getId();
		this.senha= obj.getSenha();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.data = obj.getData();
		this.email = obj.getEmail();
		this.escolaridade = obj.getEscolaridade();
		this.profissao = obj.getProfissao();
		this.telefone = obj.getTelefone();
	}
	
}
