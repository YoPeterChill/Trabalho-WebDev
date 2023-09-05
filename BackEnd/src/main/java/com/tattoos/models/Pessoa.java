package com.tattoos.models;



import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "Pessoa")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)

public class Pessoa implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "codigo_pessoa")
    private int Id;
    
    @Column(name = "nome_pessoa")
    private String nome;
    
    @Column(name = "cpf_pessoa")
    private String cpf;
    
    @Column(name = "dataNascimento_pessoa")
    private Date data;
    
    @Column(name = "email_pessoa")
    private String email;
  
    @Column(name = "escolaridade_pessoa")
    private String escolaridade;
    
    @Column(name = "profissao_pessoa")
    private String profissao;
    
    @Column(name = "telefone_pessoa")
    private String telefone;
    
    @Column(name = "senha")
    private String senha;
    
    

}
