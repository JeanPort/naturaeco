package com.jean.naturaeco.dto.request;

public class ItemPeditoDTO {

    private Integer qtdItem;
    private ProdutoDTO produto;

    public Integer getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(Integer qtdItem) {
        this.qtdItem = qtdItem;
    }

    public ProdutoDTO getProduto() {
        return produto;
    }

    public void setProduto(ProdutoDTO produto) {
        this.produto = produto;
    }
}
