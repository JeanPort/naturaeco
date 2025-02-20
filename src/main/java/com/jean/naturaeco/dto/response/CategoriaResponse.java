package com.jean.naturaeco.dto.response;

import java.util.Objects;

public record CategoriaResponse(Integer id, String nome) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaResponse response = (CategoriaResponse) o;
        return Objects.equals(id, response.id) && Objects.equals(nome, response.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
