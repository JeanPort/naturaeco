package com.jean.naturaeco.repo;

import com.jean.naturaeco.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepo extends JpaRepository<Produto, Integer> {

    List<Produto> findAllByNomeContaining(String nome);
}
