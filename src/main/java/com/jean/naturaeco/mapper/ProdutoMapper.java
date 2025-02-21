package com.jean.naturaeco.mapper;

import com.jean.naturaeco.dto.request.ProdutoPostRequest;
import com.jean.naturaeco.dto.request.ProdutoPutRequest;
import com.jean.naturaeco.dto.response.ProdutoResponse;
import com.jean.naturaeco.entity.Categoria;
import com.jean.naturaeco.entity.Produto;

import java.util.List;

public class ProdutoMapper {

    public static Produto toProduto(ProdutoPostRequest data, Categoria categoria) {
        if(data == null) return null;

        Produto produto = new Produto();
        produto.setNome(data.nome());
        produto.setCategoria(categoria);
        produto.setDetalhe(data.detalhe());
        produto.setLinkFoto(data.linkFoto());
        produto.setPreco(data.preco());
        return produto;
    }

    public static Produto toProduto(ProdutoPutRequest data, Categoria categoria) {
        if(data == null) return null;

        Produto produto = new Produto();
        produto.setNome(data.nome());
        produto.setCategoria(categoria);
        produto.setDetalhe(data.detalhe());
        produto.setLinkFoto(data.linkFoto());
        produto.setPreco(data.preco());
        return produto;
    }

    public static ProdutoResponse toProdutoResponse(Produto produto) {
        if(produto == null) return null;

        return new ProdutoResponse(produto.getId(), produto.getNome(), produto.getDetalhe(), produto.getLinkFoto(), produto.getPreco());
    }

    public static List<ProdutoResponse> toListProdutoResponse(List<Produto> produtos){

        if (produtos == null) return null;
        return produtos.stream().map(ProdutoMapper::toProdutoResponse).toList();
    }

}
