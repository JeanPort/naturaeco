package com.jean.naturaeco.mapper;

import com.jean.naturaeco.dto.request.CategoriaPostRequest;
import com.jean.naturaeco.dto.request.CategoriaPutRequest;
import com.jean.naturaeco.dto.response.CategoriaResponse;
import com.jean.naturaeco.entity.Categoria;

import java.util.List;

public class CategoriaMapper {

    public static Categoria toCategoria(CategoriaPostRequest data){
        if (data == null) return null;

        var categoria = new Categoria();
        categoria.setId(null);
        categoria.setNome(data.nome());
        return categoria;
    }

    public static Categoria toCategoria(CategoriaPutRequest data){
        if (data == null) return null;

        var categoria = new Categoria();
        categoria.setId(data.id());
        categoria.setNome(data.nome());
        return categoria;
    }

    public static CategoriaResponse toCategoriaResponse(Categoria categoria) {
        if (categoria == null) return null;

        return new CategoriaResponse(categoria.getId(), categoria.getNome());
    }

    public static List<CategoriaResponse> toListCategoriaResponse(List<Categoria> categorias) {
        if (categorias == null) return null;

        return categorias.stream().map(CategoriaMapper::toCategoriaResponse).toList();
    }
}
