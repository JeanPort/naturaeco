package com.jean.naturaeco.repo;

import com.jean.naturaeco.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepo extends JpaRepository<Produto, Integer> {
}
