package com.jean.naturaeco.service.produto;

import com.jean.naturaeco.dto.request.ProdutoPostRequest;
import com.jean.naturaeco.dto.request.ProdutoPutRequest;
import com.jean.naturaeco.dto.response.ProdutoResponse;
import com.jean.naturaeco.entity.Produto;

import java.util.List;

public interface IProdutoService {

    List<ProdutoResponse> findAll();
    List<ProdutoResponse> findByNome(String nome);
    ProdutoResponse findById(Integer id);
    void delete(Integer id);
    ProdutoResponse create(ProdutoPostRequest request);
    ProdutoResponse update(ProdutoPutRequest request);
    List<ProdutoResponse> findByCategoria(Integer idCategoria);
    List<ProdutoResponse> findByDisponiveis();
}
