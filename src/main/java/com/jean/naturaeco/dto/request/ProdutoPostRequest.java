package com.jean.naturaeco.dto.request;

public record ProdutoPostRequest(
        String nome,
        String detalhe,
        String linkFoto,
        Double preco,
        Integer idCategoria) {
}
