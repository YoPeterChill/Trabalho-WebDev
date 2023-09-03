package com.tattoos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tattoos.models.Artista;

public interface ArtistaDAO extends JpaRepository<Artista, Integer> {

}
