package com.jean.naturaeco.repo;

import com.jean.naturaeco.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepo extends JpaRepository<Cliente, Integer> {
}
