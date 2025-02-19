package com.jean.naturaeco.repo;

import com.jean.naturaeco.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepo extends JpaRepository<Categoria, Integer> {

    Categoria findByNome(String nome);
}
