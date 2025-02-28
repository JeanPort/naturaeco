package com.jean.naturaeco.service.pedido;

import com.jean.naturaeco.dto.request.PedidoPostRequest;
import com.jean.naturaeco.entity.Pedido;
import com.jean.naturaeco.exception.NotFoundException;
import com.jean.naturaeco.mapper.PedidoMapper;
import com.jean.naturaeco.repo.ClienteRepo;
import com.jean.naturaeco.repo.PedidoRepo;

public class PedidoServiceImpl implements IPedidoService{

    private final PedidoRepo repo;
    private final ClienteRepo clienteRepo;

    public PedidoServiceImpl(PedidoRepo repo, ClienteRepo clienteRepo) {
        this.repo = repo;
        this.clienteRepo = clienteRepo;
    }

    @Override
    public Pedido create(PedidoPostRequest request) {

        var cliente = clienteRepo.findById(request.getIdCliente()).orElseThrow(() -> new NotFoundException("Não encontrado"));
        var pedido = PedidoMapper.toPedido(request, cliente);
        pedido = repo.save(pedido);
        return pedido;
    }
    
}
