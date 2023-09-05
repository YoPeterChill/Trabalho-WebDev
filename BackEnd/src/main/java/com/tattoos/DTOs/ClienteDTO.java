package com.tattoos.DTOs;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.RepresentationModel;

import com.tattoos.models.Cliente;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper = false)
public class ClienteDTO extends RepresentationModel<ClienteDTO> implements Serializable {
	private static final long serialVersionUID = 1L;
	@EqualsAndHashCode.Include
		private int id;	
		private String senha;
	    private String nome;
	    private String cpf;
	    private Date data;
	    private String email;
	    private String escolaridade;
	    private String profissao;
	    private String telefone;
		
		public ClienteDTO(Cliente obj) {
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
