package com.jean.naturaeco.mapper;

import com.jean.naturaeco.dto.request.ItemPeditoDTO;
import com.jean.naturaeco.entity.ItemPedido;
import com.jean.naturaeco.entity.Pedido;
import com.jean.naturaeco.entity.Produto;

public class ItemPedidoMapper {

    public static ItemPedido toItemPedido(ItemPeditoDTO dto,  Pedido pedido){
        if (dto == null) return null;

        var produto = new Produto();
        produto.setId(dto.getProduto().getId());
        produto.setPreco(produto.getPreco());
        var item = new ItemPedido();
        item.setQtdItem(dto.getQtdItem());
        item.setProduto(produto);
        item.setPrecoUnitario(produto.getPreco());
        item.setPrecoTotal(produto.getPreco() * dto.getQtdItem());
        item.setPedido(pedido);
        return item;
    }
}
