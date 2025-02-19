package com.jean.naturaeco.service.categoria;

import com.jean.naturaeco.dto.request.CategoriaPostRequest;
import com.jean.naturaeco.dto.request.CategoriaPutRequest;
import com.jean.naturaeco.dto.response.CategoriaResponse;

import java.util.List;

public interface ICategoriaService {

    CategoriaResponse create(CategoriaPostRequest request);
    CategoriaResponse update(CategoriaPutRequest request);
    void delete(Integer idCategoria);
    List<CategoriaResponse> findAll();
    CategoriaResponse findById(Integer idCategoria);
}
