package com.jean.naturaeco.dto.request;

import java.util.Objects;

public record CategoriaPutRequest(Integer id, String nome) {

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CategoriaPutRequest that = (CategoriaPutRequest) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
