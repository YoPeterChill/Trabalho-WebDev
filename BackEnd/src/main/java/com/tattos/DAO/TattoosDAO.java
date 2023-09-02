package com.tattos.DAO;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tattoos.models.ModelTattoos;

public interface TattoosDAO extends JpaRepository<ModelTattoos, Integer> {
}
