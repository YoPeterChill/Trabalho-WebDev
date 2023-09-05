package com.tattoos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tattoos.models.Cliente;

public interface ClienteDAO extends JpaRepository<Cliente, Integer> {

}
