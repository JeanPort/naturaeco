package com.jean.naturaeco.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

@Entity
@Table(name = "tbl_itempedido")
public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "num_sec")
    private Integer numSec;
    @Column(name = "qtd_item")
    private Integer qtdItem;
    @Column(name = "preco_unitario")
    private Double precoUnitario;
    @Column(name = "preco_total")
    private Double precoTotal;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    @JsonIgnoreProperties("itensPedido")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    public Integer getNumSec() {
        return numSec;
    }

    public void setNumSec(Integer numSec) {
        this.numSec = numSec;
    }

    public Integer getQtdItem() {
        return qtdItem;
    }

    public void setQtdItem(Integer qtdItem) {
        this.qtdItem = qtdItem;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(Double precoTotal) {
        this.precoTotal = precoTotal;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
