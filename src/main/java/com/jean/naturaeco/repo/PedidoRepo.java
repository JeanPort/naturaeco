package com.jean.naturaeco.repo;

import com.jean.naturaeco.entity.Cliente;
import com.jean.naturaeco.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepo extends JpaRepository<Pedido, Integer> {

    List<Pedido> findAllByCliente(Cliente cliente);
}
