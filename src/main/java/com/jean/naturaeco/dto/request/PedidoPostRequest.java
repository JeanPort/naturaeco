package com.jean.naturaeco.dto.request;

import java.time.LocalDate;
import java.util.List;

public class PedidoPostRequest {


    private LocalDate date;

    private String observacoes;

    private Integer idCliente;

    private List<ItemPeditoDTO> itensPedido;

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public List<ItemPeditoDTO> getItensPedido() {
        return itensPedido;
    }

    public void setItensPedido(List<ItemPeditoDTO> itensPedido) {
        this.itensPedido = itensPedido;
    }
}
