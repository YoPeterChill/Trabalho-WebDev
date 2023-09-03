package com.tattoos.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tattoos.models.Pessoa;

public interface PessoaDAO extends JpaRepository<Pessoa, Integer> {

	Optional<Pessoa> findByCpf(String cpf);
	
}
