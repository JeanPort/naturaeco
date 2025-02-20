package com.jean.naturaeco.repo;

import com.jean.naturaeco.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {

    Optional<Categoria> findByNome(String nome);
}
