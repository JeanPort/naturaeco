package com.jean.naturaeco.dto.request;

public record ProdutoPutRequest(
        Integer id,
        String nome,
        String detalhe,
        String linkFoto,
        Double preco,
        Integer idCategoria) {
}
