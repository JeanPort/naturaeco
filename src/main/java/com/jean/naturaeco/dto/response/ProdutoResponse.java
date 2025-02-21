package com.jean.naturaeco.dto.response;

public record ProdutoResponse(
        Integer id,
        String nome,
        String detalhe,
        String linkFoto,
        Double preco,
        CategoriaResponse categoria) {
}
