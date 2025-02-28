package com.jean.naturaeco.service.pedido;

import com.jean.naturaeco.dto.request.PedidoPostRequest;
import com.jean.naturaeco.entity.Pedido;

public interface IPedidoService {

    Pedido create(PedidoPostRequest request);
}
