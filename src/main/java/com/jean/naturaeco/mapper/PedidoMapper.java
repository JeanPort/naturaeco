package com.jean.naturaeco.mapper;

import com.jean.naturaeco.dto.request.PedidoPostRequest;
import com.jean.naturaeco.entity.Cliente;
import com.jean.naturaeco.entity.ItemPedido;
import com.jean.naturaeco.entity.Pedido;

public class PedidoMapper {

    public static Pedido toPedido(PedidoPostRequest request, Cliente cliente) {

        if (request == null) return null;

        var pedido = new Pedido();
        pedido.setCliente(cliente);
        pedido.setDate(request.getDate());
        pedido.setStatus(0);
        pedido.setObservacoes(request.getObservacoes());
        pedido.setItensPedido(request.getItensPedido().stream().map(dto -> ItemPedidoMapper.toItemPedido(dto, pedido)).toList());
        pedido.setValorTotal(pedido.getItensPedido().stream().mapToDouble(ItemPedido::getPrecoTotal).sum());
        return  pedido;
    }
}
